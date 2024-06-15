package com.example.pearl.domain.usecases.routine

import com.example.pearl.domain.model.Routine
import com.example.pearl.domain.repositories.RoutineRepository

class AddRoutineUseCase (
    val routineRepository: RoutineRepository
){
    operator fun invoke(
        routine: Routine,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ){
        routineRepository.addProductToRoutine(routine , onSuccess , onFailure)
    }
}