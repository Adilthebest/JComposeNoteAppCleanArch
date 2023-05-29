package com.example.jetpackcomposenoteapp.feature_note.domain.use_case

import com.example.jetpackcomposenoteapp.feature_note.domain.repository.NoteRepository

class GetNotesId(
    private val repository: NoteRepository
) {
    fun getNotesId(id:Int) = repository.getNoteById(id)
}