package com.horizontech.thoughtspace.feature_Notes.data.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun noteDAO() : NoteDAO

    companion object {
        const val DATABASE_NAME = "app_db"
    }

}