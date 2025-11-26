package com.horizontech.thoughtspace.di

import android.content.Context
import androidx.room.Room
import com.horizontech.thoughtspace.features.data.dataSource.AppDataBase
import com.horizontech.thoughtspace.features.data.repository.ThoughtSpaceRepositoryImpl
import com.horizontech.thoughtspace.features.domain.repository.ThoughtSpaceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDataBase(app : Context) : AppDataBase {
        return Room.databaseBuilder(
            app,
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        ).build()
    }



    @Provides
    fun provideThoughtSpaceRepositoryImpl (db : AppDataBase) : ThoughtSpaceRepository{
        return ThoughtSpaceRepositoryImpl(db.journalDAO())
    }






}