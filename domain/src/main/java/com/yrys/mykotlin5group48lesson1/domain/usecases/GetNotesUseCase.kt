package com.yrys.mykotlin5group48lesson1.domain.usecases

import com.yrys.mykotlin5group48lesson1.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    operator fun invoke() = noteRepository.getNotes()

}