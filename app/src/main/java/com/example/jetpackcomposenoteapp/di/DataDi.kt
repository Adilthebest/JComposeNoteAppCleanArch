package com.example.jetpackcomposenoteapp.di

import com.example.jetpackcomposenoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.jetpackcomposenoteapp.feature_note.domain.repository.NoteRepository
import org.koin.dsl.module

val dataModule = module {
    single<NoteRepository> {NoteRepositoryImpl(get())}
}