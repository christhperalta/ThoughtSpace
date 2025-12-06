package com.horizontech.thoughtspace.di

import android.content.Context
import androidx.room.Room
import com.horizontech.thoughtspace.feature_Notes.data.dataSource.AppDataBase
import com.horizontech.thoughtspace.feature_Notes.data.repository.NotesRepositoryImpl
import com.horizontech.thoughtspace.feature_Notes.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDataBase( @ApplicationContext context : Context) : AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        ).build()
    }



    @Provides
    fun provideThoughtSpaceRepositoryImpl (db : AppDataBase) : NoteRepository{
        return NotesRepositoryImpl(db.noteDAO())
    }






}