package com.example.jetpackcomposenoteapp.feature_note.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jetpackcomposenoteapp.ui.theme.*

@Entity(tableName = "note")
data class NoteEntity(
    val title: String,
    val timestamp: String,
    val isComplete: Boolean = false,
    @PrimaryKey (autoGenerate = true)
    val id: Int? = 0
)