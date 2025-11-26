package com.horizontech.thoughtspace.features.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal")
data class Journal(
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "date") val date : Long,
    @ColumnInfo(name = "title") val title : String?,
    @ColumnInfo(name = "text") val text : String?,
)



