package com.horizontech.thoughtspace.feature_Notes.data.dataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDAO {


    @Query("SELECT * FROM notes")
    fun getAll(): Flow<List<Notes>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getCurrentNote(noteId: Int): Notes

    @Delete()
    suspend fun deleteNotes(note: Notes)

    @Insert()
    suspend fun insertNotes(note: Notes)

    @Update()
    suspend fun updateNotes(note: Notes)


}