package com.example.jetpackcomposenoteapp.di

import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.GetAllNotesUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.CreateNoteUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.jetpackcomposenoteapp.feature_note.domain.use_case.EditNoteUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { CreateNoteUseCase(get()) }
    factory { DeleteNoteUseCase(get()) }
    factory { GetAllNotesUseCase(get()) }
    factory { EditNoteUseCase(get()) }
}