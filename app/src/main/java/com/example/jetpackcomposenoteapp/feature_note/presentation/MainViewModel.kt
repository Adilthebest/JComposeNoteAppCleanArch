package com.example.jetpackcomposenoteapp.feature_note.presentation

import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.GetAllNotesUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.utils.UiState
import com.example.jetpackcomposenoteapp.feature_note.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : BaseViewModel() {

    private val _getAllNotesUseCase = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val getAllNoteState = _getAllNotesUseCase.asStateFlow()

    private val _deleteNoteUseCase = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val deleteNoteState = _deleteNoteUseCase.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_getAllNotesUseCase)
    }

    fun deleteNote(note: Note) {
        deleteNoteUseCase(note).collectFlow(_deleteNoteUseCase)
    }

}