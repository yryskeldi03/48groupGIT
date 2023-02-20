package com.yrys.mykotlin5group48lesson1.domain.usecases

import com.yrys.mykotlin5group48lesson1.domain.model.Note
import com.yrys.mykotlin5group48lesson1.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun createNote(note: Note) = noteRepository.createNote(note)

}