package com.example.pearl.domain.usecases.app_entry

data class AppEntryUseCases(
    val readAppEntry : ReadAppEntryUseCase,
    val saveAppEntry: SaveAppEntryUseCase
)
