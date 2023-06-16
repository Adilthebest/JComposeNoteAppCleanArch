package com.example.jetpackcomposenoteapp.feature_note.data.repository

import com.example.jetpackcomposenoteapp.feature_note.data.base.BaseRepository
import com.example.jetpackcomposenoteapp.feature_note.data.data_source.NoteDao
import com.example.jetpackcomposenoteapp.feature_note.data.mapper.toEntity
import com.example.jetpackcomposenoteapp.feature_note.data.mapper.toNote
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note
import com.example.jetpackcomposenoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.map


class NoteRepositoryImpl constructor(val noteDao: NoteDao) : NoteRepository, BaseRepository() {
    override fun insertNote(note: Note) = doReguest {
        noteDao.insertNote(note.toEntity())
    }

    override fun getNotes() = doReguest {
        noteDao.getNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) = doReguest {
        noteDao.editNote(note.toEntity())
    }

    override fun deleteNote(note: Note) = doReguest {
        noteDao.deleteNote(note.toEntity())
    }
}
