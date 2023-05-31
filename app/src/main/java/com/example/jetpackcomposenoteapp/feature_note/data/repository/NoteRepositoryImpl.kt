package com.example.jetpackcomposenoteapp.feature_note.data.repository

import kotlinx.coroutines.flow.map

/*
class NoteRepositoryImpl constructor(val noteDao: NoteDao) : NoteRepository, BaseRepository() {
    override fun insertNote(note: Note) = doReguest {
        noteDao.insertNote(note.toEntity())
    }

    override fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)?.toNote()
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
*/
//}
