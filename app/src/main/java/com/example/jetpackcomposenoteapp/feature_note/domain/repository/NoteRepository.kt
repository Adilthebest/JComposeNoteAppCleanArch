package com.example.jetpackcomposenoteapp.feature_note.domain.repository

import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import com.example.jetpackcomposenoteapp.feature_note.domain.utils.Resourse
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
     fun insertNote(note: Note): Flow<Resourse<Unit>>

     fun getNoteById(id: Int): Note?

     fun getNotes(): Flow<Resourse<List<Note>>>

     fun editNote(note: Note): Flow<Resourse<Unit>>

     fun deleteNote(note: Note): Flow<Resourse<Unit>>

}