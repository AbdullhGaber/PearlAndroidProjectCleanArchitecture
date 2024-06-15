package com.example.pearl.domain.usecases.routine

data class RoutineUseCases(
    val addRoutineUseCase: AddRoutineUseCase,
    val getRoutinesUseCase: GetRoutinesUseCase,
    val removeRoutineUseCase: RemoveRoutineUseCase
)
