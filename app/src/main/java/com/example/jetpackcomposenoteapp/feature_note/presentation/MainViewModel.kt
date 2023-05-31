package com.example.jetpackcomposenoteapp.feature_note.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.presentation.base.BaseViewModel
import com.example.jetpackcomposenoteapp.mvvm.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class MainViewModel(
    val repository: Repository
  /*  private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,*/
) : ViewModel() {

    /*private val _getAllNotesUseCase = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
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
    }*/
    private val _state = MutableStateFlow (HomeViewState())
    val state: StateFlow<HomeViewState>
        get() = _state
    val todolist = repository.getNoteData
    val selected = MutableStateFlow(_state.value.selected)
init {
    viewModelScope.launch {
        combine(todolist, selected) { todoList: List<NoteEntity>, selected: Boolean ->
            HomeViewState(todoList, selected)
        }.collect {
            _state.value = it
        }
    }
}

    fun update(note: NoteEntity) = viewModelScope.launch {
        repository.update(note)
    }

    fun insert(note: NoteEntity) = viewModelScope.launch {
        repository.insert(note)
    }
    fun delete(note: NoteEntity) = viewModelScope.launch {
        repository.delete(note)
    }
    fun update(note: Int?) = viewModelScope.launch {
        repository.getId(note)
    }
    data class HomeViewState(
        val todolist: List<NoteEntity> = emptyList(),
    val selected: Boolean = false,
    )
}