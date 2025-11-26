package com.horizontech.thoughtspace.features.data.dataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.horizontech.thoughtspace.features.domain.model.Journal


@Dao
interface JournalDAO {


    @Query("SELECT * FROM journal")
    fun getAll() : List<Journal>

    @Delete()
    fun deleteJournal(journal: Journal)

    @Insert()
    fun insertJournal(journal: Journal)

    @Update()
    fun updateJournal(journal: Journal)



}