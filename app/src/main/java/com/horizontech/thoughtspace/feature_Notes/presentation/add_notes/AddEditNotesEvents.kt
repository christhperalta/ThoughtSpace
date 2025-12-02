package com.horizontech.thoughtspace.feature_Notes.presentation.add_notes


sealed class AddEditNotesEvents {
    data class OnChangeTitle(val title : String) : AddEditNotesEvents()
    data class OnChangeText(val text : String) : AddEditNotesEvents()
    data class OnEditNote (val id : Int?) :  AddEditNotesEvents()
    object SaveNote : AddEditNotesEvents()

}