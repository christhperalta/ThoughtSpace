package com.horizontech.thoughtspace.feature_Notes.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horizontech.thoughtspace.feature_Notes.domain.use_cases.DeleteNoteUseCase
import com.horizontech.thoughtspace.feature_Notes.domain.use_cases.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow(NotesUiState())
    val uiState: StateFlow<NotesUiState> = _uiState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    init {
        getNotesUseCase.invoke()
            .onEach { notes ->
                _uiState.update { state ->
                    state.copy(notes = notes)
                }
            }
            .launchIn(viewModelScope)
    }


    fun deleteNote(id: Int?) {
        if (_uiState.value.isProcessing) return

        viewModelScope.launch {
            _uiState.update { state -> state.copy(isProcessing = true) }
            val currentNote = _uiState.value.notes.find { it.id == id }!!
            deleteNoteUseCase.invoke(note = currentNote)
        }


    }


    fun showSnackBar() {
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.ShowSnackbar("An item will be removed"))
        }
    }

    fun completeProcess() {
        _uiState.update { state -> state.copy(isProcessing = false) }
    }


}


sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
}