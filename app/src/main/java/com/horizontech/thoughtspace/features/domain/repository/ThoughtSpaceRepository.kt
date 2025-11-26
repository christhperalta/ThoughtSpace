package com.horizontech.thoughtspace.features.domain.repository

import com.horizontech.thoughtspace.features.domain.model.Journal

interface ThoughtSpaceRepository {

    suspend fun getAll() : List<Journal>
    suspend fun deleteJournal(journal: Journal)
    suspend fun addJournal(journal: Journal)
    suspend fun updateJournal(journal: Journal)

}