package com.example.jetpackcomposenoteapp.di

import com.example.jetpackcomposenoteapp.feature_note.presentation.MainViewModel
import com.example.jetpackcomposenoteapp.feature_note.presentation.utils.DetailViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
viewModel{MainViewModel(get())}
viewModel{DetailViewModel(get(),)}
}