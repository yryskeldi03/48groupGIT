package com.yrys.mykotlin5group48lesson1.di

import android.content.Context
import androidx.room.Room
import com.yrys.mykotlin5group48lesson1.data.local.NoteDao
import com.yrys.mykotlin5group48lesson1.data.local.NoteDatabase
import com.yrys.mykotlin5group48lesson1.data.repository.NoteRepositoryImpl
import com.yrys.mykotlin5group48lesson1.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "note_db"
        ).allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)

}