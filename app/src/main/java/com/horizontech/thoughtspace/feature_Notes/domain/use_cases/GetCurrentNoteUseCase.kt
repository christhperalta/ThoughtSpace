package com.horizontech.thoughtspace.feature_Notes.domain.use_cases

import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes
import com.horizontech.thoughtspace.feature_Notes.domain.repository.NoteRepository
import javax.inject.Inject


class GetCurrentNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun invoke (id : Int) : Notes {
        return repository.getCurrentNote(id)
    }
}