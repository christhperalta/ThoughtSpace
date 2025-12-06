package com.horizontech.thoughtspace.feature_Notes.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo("date") val date : Long = System.currentTimeMillis(),
    @ColumnInfo("title")val title : String?,
    @ColumnInfo("text")val text : String?
)


class InvalidNoteException(message : String) : Exception(message)