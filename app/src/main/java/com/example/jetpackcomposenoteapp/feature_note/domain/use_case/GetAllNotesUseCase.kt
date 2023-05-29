package com.example.jetpackcomposenoteapp.feature_note.domain.use_case

import com.example.jetpackcomposenoteapp.feature_note.domain.repository.NoteRepository

class GetAllNotesUseCase
    (private val noteRepository: NoteRepository)
{
     operator fun invoke() = noteRepository.getNotes()

}