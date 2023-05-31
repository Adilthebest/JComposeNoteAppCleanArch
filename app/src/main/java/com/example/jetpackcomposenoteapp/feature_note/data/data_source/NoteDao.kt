package com.example.jetpackcomposenoteapp.feature_note.data.data_source

import androidx.room.*
import com.example.jetpackcomposenoteapp.feature_note.data.model.NoteEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM note WHERE id = :id")
    fun getNoteById(id:Int?):NoteEntity?

    @Query("SELECT * FROM note")
     fun getNotes():Flow<List<NoteEntity>>

    @Update
   suspend fun editNote(noteEntity: NoteEntity)

    @Delete
   suspend  fun deleteNote(noteEntity: NoteEntity)
}