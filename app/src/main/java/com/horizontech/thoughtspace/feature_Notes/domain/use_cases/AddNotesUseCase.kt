package com.horizontech.thoughtspace.feature_Notes.domain.use_cases


import com.horizontech.thoughtspace.feature_Notes.domain.model.InvalidNoteException
import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes
import com.horizontech.thoughtspace.feature_Notes.domain.repository.NoteRepository

import javax.inject.Inject


class AddNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Notes) {


        if (note.title.isNullOrBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }

        if (note.text.isNullOrBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }

        repository.addNotes(note = note)
    }
}