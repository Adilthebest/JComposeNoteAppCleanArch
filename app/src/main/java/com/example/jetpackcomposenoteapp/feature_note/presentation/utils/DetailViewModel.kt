package com.example.jetpackcomposenoteapp.feature_note.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.mvvm.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class DetailViewModel(
    val repository: Repository,
    ):ViewModel() {
    private val todoText = MutableStateFlow("")
    private val todoTime = MutableStateFlow("")
    private val selectId = MutableStateFlow(-1)

    private val _state = MutableStateFlow(DetailViewState())
    val state: StateFlow<DetailViewState>
        get() = _state

    init {
        viewModelScope.launch {
            combine(todoText, todoTime, selectId) { text, time, id ->
                DetailViewState(text, time, id)
            }.collect {
                _state.value = it
            }
        }
    }

    init {
        viewModelScope.launch {
            repository.getNoteData.collect { todo ->
                todo.find {
                    it.id == selectId.value
                }.also {
                    selectId.value = it?.id ?: -1
                    if (selectId.value != -1) {
                        todoText.value = it?.title ?: ""
                        todoTime.value = it?.timestamp ?: ""
                    }
                }
            }
        }

    }

    fun onTextChange(newText: String) {
        todoText.value = newText
    }

    fun onTimeChange(newText: String) {
        todoTime.value = newText
    }

    fun insert(note: NoteEntity) = viewModelScope.launch {
        repository.insert(note)
    }

}

data class DetailViewState(
    val todo: String = "",
    val time: String = "",
    val selectId: Int = -1,
)

