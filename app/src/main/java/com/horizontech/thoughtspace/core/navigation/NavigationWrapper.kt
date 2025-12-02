package com.horizontech.thoughtspace.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.horizontech.thoughtspace.feature_Notes.presentation.add_notes.AddEditNotesScreen
import com.horizontech.thoughtspace.feature_Notes.presentation.notes.NotesScreen


data object NotesList
data class AddEditNote(val id: Int? = null)

@Composable
fun NavigationWrapper() {
    val backStack = remember { mutableStateListOf<Any>(NotesList) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is NotesList -> NavEntry(key) {
                    NotesScreen(
                        onNavigatesToAddEditNotes = { noteId ->
                            backStack.add(AddEditNote(id = noteId))
                        }
                    )
                }

                is AddEditNote -> NavEntry(key) {
                    AddEditNotesScreen(
                        noteId = key.id,
                        onBack = { backStack.removeLastOrNull() }
                    )
                }


                else -> NavEntry(Unit) { Text("Unknown route") }
            }

        },

        )


}

