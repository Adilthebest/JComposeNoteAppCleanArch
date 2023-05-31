package com.example.jetpackcomposenoteapp.di

import com.example.jetpackcomposenoteapp.mvvm.Repository
import org.koin.dsl.module

val dataModule = module {
   // single<NoteRepository> {NoteRepositoryImpl(get())}
   single { Repository(get()) }
}