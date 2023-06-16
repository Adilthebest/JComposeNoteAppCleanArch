package com.example.jetpackcomposenoteapp.feature_note.data.data_source

import androidx.room.*
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM note")
    suspend fun getNotes():List<NoteEntity>

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}