package com.yrys.mykotlin5group48lesson1.presentation.ui.fragments.notes

import com.yrys.mykotlin5group48lesson1.domain.model.Note
import com.yrys.mykotlin5group48lesson1.domain.usecases.DeleteNoteUseCase
import com.yrys.mykotlin5group48lesson1.domain.usecases.GetNotesUseCase
import com.yrys.mykotlin5group48lesson1.presentation.base.BaseViewModel
import com.yrys.mykotlin5group48lesson1.presentation.ui.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : BaseViewModel() {

    private val _getNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getNotesState = _getNotesState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun getNotes() {
        getNotesUseCase().collectFlow(_getNotesState)
    }

    fun deleteNote(note: Note) {
        deleteNoteUseCase.deleteNote(note).collectFlow(_deleteNoteState)
    }

}