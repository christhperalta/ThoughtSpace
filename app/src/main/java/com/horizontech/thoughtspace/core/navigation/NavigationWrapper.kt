package com.horizontech.thoughtspace.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.horizontech.thoughtspace.features.presentation.home.HomeScreen
import com.horizontech.thoughtspace.features.presentation.journalNotes.JournalNotesScreen


data object Home
data object Journal
data object QuickNotes
data object Goal

@Composable
fun NavigationWrapper() {
    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    HomeScreen(onNavigateToJournal = {backStack.add(Journal)})
                }

                is Journal -> NavEntry(key) {
                    JournalNotesScreen()
                }

                else -> NavEntry(Unit) { Text("Unknown route") }
            }

        }
    )


}

