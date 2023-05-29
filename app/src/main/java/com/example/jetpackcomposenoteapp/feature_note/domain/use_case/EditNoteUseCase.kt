package com.example.jetpackcomposenoteapp.feature_note.domain.use_case

import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import com.example.jetpackcomposenoteapp.feature_note.domain.repository.NoteRepository

class EditNoteUseCase  (private val noteRepository: NoteRepository)
{
     operator fun invoke(note: Note) = noteRepository.editNote(note)
}