package com.horizontech.thoughtspace.features.data.repository

import com.horizontech.thoughtspace.features.data.dataSource.JournalDAO
import com.horizontech.thoughtspace.features.domain.model.Journal
import com.horizontech.thoughtspace.features.domain.repository.ThoughtSpaceRepository
import javax.inject.Inject

class ThoughtSpaceRepositoryImpl @Inject constructor(
    private val journalDAO: JournalDAO
) : ThoughtSpaceRepository {
    override suspend fun getAll(): List<Journal> {
        return journalDAO.getAll()
    }

    override suspend fun deleteJournal(journal: Journal) {
        journalDAO.deleteJournal(journal = journal)
    }

    override suspend fun addJournal(journal: Journal) {
        journalDAO.insertJournal(journal = journal)
    }

    override suspend fun updateJournal(journal: Journal) {
       journalDAO.updateJournal(journal = journal)
    }
}