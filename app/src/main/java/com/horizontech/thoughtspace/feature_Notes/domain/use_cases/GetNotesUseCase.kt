package com.horizontech.thoughtspace.feature_Notes.domain.use_cases

import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes
import com.horizontech.thoughtspace.feature_Notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
     operator fun invoke() : Flow<List<Notes>> {
        return repository.getAll()
    }
}