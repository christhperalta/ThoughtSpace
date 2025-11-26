package com.horizontech.thoughtspace.features.presentation.journalNotes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.horizontech.thoughtspace.features.presentation.componentes.ThoughtSpaceText
import com.horizontech.thoughtspace.features.presentation.componentes.ThoughtSpaceTextField

@Composable
fun JournalNotesScreen(
    modifier: Modifier = Modifier,
    viewModel: JournalNotesViewModel = hiltViewModel()
) {

    var showAddJournal by rememberSaveable { mutableStateOf(false) }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddJournal = !showAddJournal }) {
                Icon(Icons.Default.Add, contentDescription = "Add Icon")
            }
        }
    ) { innerPadding ->

        Column(modifier = modifier.padding(innerPadding)) {
            Text("Hola mundo")

            AnimatedVisibility(showAddJournal) {
                Dialog(
                    onDismissRequest = {}, properties = DialogProperties(
                        usePlatformDefaultWidth = false
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .align(alignment = Alignment.TopCenter),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ThoughtSpaceText(
                                text = "Add Journal",
                                style = MaterialTheme.typography.headlineMedium
                            )
                            IconButton(onClick = { showAddJournal = !showAddJournal }) {
                                Icon(
                                    Icons.Default.Close, contentDescription = "Add Icon"
                                )
                            }
                        }


                        Column(modifier = Modifier.align(alignment = Alignment.Center)) {
                            ThoughtSpaceTextField(
                                value = uiState.title ?: "",
                                placeholder = "Elige un titulo"
                            ) {
                                viewModel.onEvent(JournalNotesEvents.OnChangeTitle(it))
                            }
                            ThoughtSpaceTextField(value = uiState.text ?: "", placeholder = "text") {

                                viewModel.onEvent(JournalNotesEvents.OnChangeText(it))
                            }
                        }


                    }
                }
            }
        }


    }

}

//@Preview(name = "JournalNotesScreen")
//@Composable
//private fun PreviewJournalNotesScreen() {
//    JournalNotesScreen()
//}