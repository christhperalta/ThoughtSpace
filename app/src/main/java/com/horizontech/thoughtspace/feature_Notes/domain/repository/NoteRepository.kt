package com.horizontech.thoughtspace.feature_Notes.domain.repository

import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
     fun getAll() : Flow<List<Notes>>
    suspend fun getCurrentNote(id : Int) : Notes
    suspend fun deleteNotes(note: Notes)
    suspend fun addNotes(note: Notes)
    suspend fun updateNotes(note: Notes)
}