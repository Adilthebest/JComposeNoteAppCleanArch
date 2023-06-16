package com.example.jetpackcomposenoteapp.feature_note.data.mapper

import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import com.example.jetpackcomposenoteapp.feature_note.domain.model.Note

fun Note.toEntity()=NoteEntity(
    title, timestamp, id
)
fun NoteEntity.toNote()= Note(
    title, timestamp ,id
)
