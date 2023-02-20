package com.yrys.mykotlin5group48lesson1.data.repository

import com.yrys.mykotlin5group48lesson1.data.base.BaseRepository
import com.yrys.mykotlin5group48lesson1.data.local.NoteDao
import com.yrys.mykotlin5group48lesson1.data.mappers.toNote
import com.yrys.mykotlin5group48lesson1.data.mappers.toNoteEntity
import com.yrys.mykotlin5group48lesson1.domain.model.Note
import com.yrys.mykotlin5group48lesson1.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNotes() = doRequest {
        noteDao.getNotes().map { it.toNote() }
    }
}