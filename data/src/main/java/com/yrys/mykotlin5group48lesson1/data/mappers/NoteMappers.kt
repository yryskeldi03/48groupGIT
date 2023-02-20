package com.yrys.mykotlin5group48lesson1.data.mappers

import com.yrys.mykotlin5group48lesson1.data.model.NoteEntity
import com.yrys.mykotlin5group48lesson1.domain.model.Note

fun NoteEntity.toNote() = Note(
    id,
    title,
    description,
    createdAt
)

fun Note.toNoteEntity() = NoteEntity(
    id,
    title,
    description,
    createdAt
)