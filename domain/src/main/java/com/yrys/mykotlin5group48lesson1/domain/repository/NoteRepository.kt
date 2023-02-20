package com.yrys.mykotlin5group48lesson1.domain.repository

import com.yrys.mykotlin5group48lesson1.domain.model.Note
import com.yrys.mykotlin5group48lesson1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

    fun getNotes(): Flow<Resource<List<Note>>>

}
