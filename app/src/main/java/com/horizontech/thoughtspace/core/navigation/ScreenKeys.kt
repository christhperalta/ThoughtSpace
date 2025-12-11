package com.horizontech.thoughtspace.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable



@Serializable
sealed class ScreenKeys : NavKey {
    @Serializable
    data object NotesList : ScreenKeys()

    @Serializable
    data class AddEditNote(val id: Int? = null) : ScreenKeys()
}