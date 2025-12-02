package com.horizontech.thoughtspace.feature_Notes.presentation.add_notes



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.horizontech.thoughtspace.R
import com.horizontech.thoughtspace.core.presentation.ThoughtSpaceTextField
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNotesScreen(
    onBack: () -> Unit,
    noteId: Int?,
    viewModel: AddEditNotesViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    LaunchedEffect(key1 = {}) {
        if (noteId != null) {
            viewModel.getEditNote(noteId)
        } else {
            viewModel.clearFields()
        }
    }

    LaunchedEffect(true) {
        viewModel.eventFlow.collectLatest {event ->
            when(event){
                UiEvent.SaveNote -> {
                    onBack()
                }
                is UiEvent.ShowSnackbar -> {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = event.message
                        )
                    }
                }
            }
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        onBack()
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.outline_arrow_back_24),
                            contentDescription = "arrow back"
                        )
                    }
                }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (noteId == null) {
                    viewModel.onEvent(AddEditNotesEvents.SaveNote)
                } else {
                    viewModel.onEvent(AddEditNotesEvents.OnEditNote(id = noteId))
                }
            }) {
                Icon(
                    painter = painterResource(R.drawable.save_24),
                    contentDescription = "Save Icon"
                )

            }
        }
    ) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
        ) {


            Spacer(modifier = Modifier.height(20.dp))
            ThoughtSpaceTextField(
                value = uiState.title ?: "",
                placeholder = "Title",
                style = MaterialTheme.typography.headlineSmall
            ) {
                viewModel.onEvent(AddEditNotesEvents.OnChangeTitle(it))
            }
            Spacer(modifier = Modifier.height(15.dp))
            ThoughtSpaceTextField(
                value = uiState.text ?: "",
                placeholder = "texto",
            ) {
                viewModel.onEvent(AddEditNotesEvents.OnChangeText(it))
            }

        }
    }
}


