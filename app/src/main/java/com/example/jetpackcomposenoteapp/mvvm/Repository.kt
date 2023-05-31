package com.example.jetpackcomposenoteapp.mvvm

import com.example.jetpackcomposenoteapp.feature_note.data.data_source.NoteDao
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.Dispatchers

class Repository (val noteDao: NoteDao){
    val getNoteData = noteDao.getNotes()
    suspend fun insert(note: NoteEntity){
        Dispatchers.IO.apply {
            noteDao.insertNote(note)
        }
    }

    suspend fun delete(note: NoteEntity){
        Dispatchers.IO.apply {
            noteDao.deleteNote(note)
        }
    }
    suspend fun update(note: NoteEntity){
        Dispatchers.IO.apply {
            noteDao.editNote(note)
        }
    }
    suspend fun getId(note: Int?){
        Dispatchers.IO.apply {
            noteDao.getNoteById(note)
        }
    }

}