package com.example.jetpackcomposenoteapp.feature_note.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jetpackcomposenoteapp.ui.theme.*

@Entity(tableName = "note")
data class NoteEntity(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}