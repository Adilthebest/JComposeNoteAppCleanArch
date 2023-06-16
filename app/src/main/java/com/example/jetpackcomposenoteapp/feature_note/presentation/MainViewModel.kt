package com.example.jetpackcomposenoteapp.feature_note.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.CreateNoteUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.EditNoteUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.GetAllNotesUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.utils.UiState
import com.example.jetpackcomposenoteapp.feature_note.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
) : BaseViewModel() {

    private val _getAllNotesUseCase = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val getAllNoteState = _getAllNotesUseCase.asStateFlow()

    private val _deleteNoteUseCase = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val deleteNoteState = _deleteNoteUseCase.asStateFlow()

    private val _createNoteState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteUseCase = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val editNoteState = _editNoteUseCase.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_getAllNotesUseCase)
    }

    fun deleteNote(note: Note) {
        deleteNoteUseCase(note).collectFlow(_deleteNoteUseCase)
    }

    fun editNote(note: Note) {
        editNoteUseCase(note).collectFlow(_editNoteUseCase)

    }
    fun createNote(note: Note) {
        createNoteUseCase(note).collectFlow(_createNoteState)
    }
}