package com.horizontech.thoughtspace.features.data.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.horizontech.thoughtspace.features.domain.model.Journal


@Database(entities = [Journal::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun journalDAO() : JournalDAO

    companion object {
        const val DATABASE_NAME = "app_db"
    }

}