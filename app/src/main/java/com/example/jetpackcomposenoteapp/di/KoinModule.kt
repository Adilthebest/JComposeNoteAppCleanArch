package com.example.jetpackcomposenoteapp.di

import org.koin.core.module.Module

val koinModules :List<Module> = listOf(
    localModule,
    appModule,
    domainModule,
    dataModule

)