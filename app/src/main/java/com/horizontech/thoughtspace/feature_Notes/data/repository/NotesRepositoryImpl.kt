package com.horizontech.thoughtspace.feature_Notes.data.repository

import com.horizontech.thoughtspace.feature_Notes.data.dataSource.NoteDAO
import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes
import com.horizontech.thoughtspace.feature_Notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val notesDAO: NoteDAO
) : NoteRepository {
    override fun getAll(): Flow<List<Notes>>  {
        return notesDAO.getAll()
    }

    override suspend fun getCurrentNote(id: Int): Notes {
        println("Christh desde el data $id")
        return notesDAO.getCurrentNote(noteId = id)
    }

    override suspend fun deleteNotes(note: Notes) {
        notesDAO.deleteNotes(note)
    }

    override suspend fun addNotes(note: Notes) {
        notesDAO.insertNotes(note = note)
    }

    override suspend fun updateNotes(note: Notes) {
        notesDAO.updateNotes(note = note)
    }
}