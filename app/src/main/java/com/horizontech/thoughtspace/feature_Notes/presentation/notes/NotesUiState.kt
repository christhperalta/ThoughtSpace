package com.horizontech.thoughtspace.feature_Notes.presentation.notes

import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes


data class NotesUiState(
    val notes : List<Notes> = emptyList(),
    val isProcessing : Boolean = false
)