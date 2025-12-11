package com.horizontech.thoughtspace.core.navigation


import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.horizontech.thoughtspace.feature_Notes.presentation.add_notes.AddEditNotesScreen
import com.horizontech.thoughtspace.feature_Notes.presentation.notes.NotesScreen





@Composable
fun NavigationWrapper() {

    val backStack = rememberNavBackStack(ScreenKeys.NotesList)


    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is ScreenKeys.NotesList -> NavEntry(key) {
                    NotesScreen(
                        onNavigatesToAddEditNotes = { noteId ->
                            backStack.add(ScreenKeys.AddEditNote(id = noteId))
                        }
                    )
                }

                is ScreenKeys.AddEditNote -> NavEntry(key) {
                    AddEditNotesScreen(
                        noteId = key.id,
                        onBack = { backStack.removeLastOrNull() }
                    )
                }

                else -> NavEntry(key) {}
            }
        }
    )
}

