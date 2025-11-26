package com.horizontech.thoughtspace.features.presentation.journalNotes


sealed class JournalNotesEvents {
    data class OnChangeTitle(val title : String) : JournalNotesEvents()
    data class OnChangeText(val text : String) : JournalNotesEvents()
    object SaveJournalNote : JournalNotesEvents()
}