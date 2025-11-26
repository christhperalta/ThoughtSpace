package com.horizontech.thoughtspace.features.presentation.journalNotes

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class JournalNotesViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableStateFlow(JournalNotesUiState())
    val uiState: StateFlow<JournalNotesUiState> = _uiState



    fun onEvent (events: JournalNotesEvents) {
        when (events){
            is JournalNotesEvents.OnChangeText -> {
                _uiState.update { state ->
                    state.copy(text = events.text)
                }
            }
            is JournalNotesEvents.OnChangeTitle -> {
                _uiState.update { state ->
                    state.copy(title = events.title)
                }
            }
            JournalNotesEvents.SaveJournalNote -> {

            }
        }
    }

}