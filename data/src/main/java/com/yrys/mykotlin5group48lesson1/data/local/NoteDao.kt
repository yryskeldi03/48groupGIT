package com.yrys.mykotlin5group48lesson1.data.local

import androidx.room.*
import com.yrys.mykotlin5group48lesson1.data.model.NoteEntity

@Dao
interface NoteDao {

    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<NoteEntity>
}