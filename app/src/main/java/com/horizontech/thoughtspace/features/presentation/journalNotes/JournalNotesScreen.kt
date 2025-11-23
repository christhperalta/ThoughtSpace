package com.horizontech.thoughtspace.features.presentation.journalNotes

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun JournalNotesScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "JournalNotesScreen")
    }
}

@Preview(name = "JournalNotesScreen")
@Composable
private fun PreviewJournalNotesScreen() {
    JournalNotesScreen()
}