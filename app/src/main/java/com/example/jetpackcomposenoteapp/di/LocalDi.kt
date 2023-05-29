package com.example.jetpackcomposenoteapp.di

import androidx.room.Room
import com.example.jetpackcomposenoteapp.feature_note.data.data_source.NoteDao
import com.example.jetpackcomposenoteapp.feature_note.data.data_source.NoteDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            NoteDataBase::class.java,
            "RUNNING_DATABASE_NAME"
        ).build()
    }
    single<NoteDao> {
        val database = get<NoteDataBase>()
        database.noteDao()
    }
}