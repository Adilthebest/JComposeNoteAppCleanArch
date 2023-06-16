package com.example.jetpackcomposenoteapp.di

import com.example.jetpackcomposenoteapp.feature_note.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
viewModel{MainViewModel(get(),get(),get(),get())}
}