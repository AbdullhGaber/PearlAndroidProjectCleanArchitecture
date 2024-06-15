package com.example.pearl.domain.usecases.routine

import com.example.pearl.domain.repositories.RoutineRepository

class RemoveRoutineUseCase(
    val routineRepository: RoutineRepository
) {
    operator fun invoke(
        routineId : String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        routineRepository.removeProductFromRoutine(routineId, onSuccess, onFailure)
    }
}