package com.example.jetpackcomposenoteapp.feature_note.domain.use_case

import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import com.example.jetpackcomposenoteapp.feature_note.domain.repository.NoteRepository

class CreateNoteUseCase (private val noteRepository: NoteRepository) {
     suspend operator fun invoke(note: Note) = noteRepository.insertNote(note)
}