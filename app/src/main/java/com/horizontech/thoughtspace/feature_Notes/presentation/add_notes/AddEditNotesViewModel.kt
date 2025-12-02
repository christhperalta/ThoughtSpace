package com.horizontech.thoughtspace.feature_Notes.presentation.add_notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horizontech.thoughtspace.feature_Notes.domain.model.InvalidNoteException
import com.horizontech.thoughtspace.feature_Notes.domain.model.Notes
import com.horizontech.thoughtspace.feature_Notes.domain.use_cases.AddNotesUseCase
import com.horizontech.thoughtspace.feature_Notes.domain.use_cases.GetCurrentNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddEditNotesViewModel @Inject constructor(
    private val addNotesUseCase: AddNotesUseCase,
    private val getCurrentNoteUseCase: GetCurrentNoteUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddEditNotesUiState())
    val uiState: StateFlow<AddEditNotesUiState> = _uiState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(events: AddEditNotesEvents) {

        when (events) {
            is AddEditNotesEvents.OnChangeText -> {
                _uiState.update { state ->
                    state.copy(text = events.text)
                }
            }

            is AddEditNotesEvents.OnChangeTitle -> {
                _uiState.update { state ->
                    state.copy(title = events.title)
                }
            }

            AddEditNotesEvents.SaveNote -> {
                viewModelScope.launch {
                    try {
                        addNotesUseCase.invoke(
                            Notes(
                                title = _uiState.value.title,
                                text = _uiState.value.text,
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)
                    } catch (e: InvalidNoteException) {
                        _eventFlow.emit(UiEvent.ShowSnackbar(e.message ?: "Couldn't save note"))
                    }
                }
            }

            is AddEditNotesEvents.OnEditNote -> {
                viewModelScope.launch {
                    try {

                    } catch (e: Exception) {

                    }
                }
            }
        }
    }


    fun getEditNote(id: Int?) {
        viewModelScope.launch {

            val result = getCurrentNoteUseCase.invoke(id!!)
            _uiState.update { state ->
                state.copy(
                    title = result.title,
                    text = result.text,
                    id = result.id
                )
            }
        }
    }


    fun clearFields() {
        _uiState.update { state ->
            state.copy(
                title = "",
                text = "",
                id = null,
            )
        }
    }
}

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
    data object SaveNote : UiEvent()
}