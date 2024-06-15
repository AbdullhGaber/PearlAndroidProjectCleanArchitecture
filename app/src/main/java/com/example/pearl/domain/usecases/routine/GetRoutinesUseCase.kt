package com.example.pearl.domain.usecases.routine

import com.example.pearl.domain.model.Routine
import com.example.pearl.domain.repositories.RoutineRepository

class GetRoutinesUseCase(
    val routineRepository: RoutineRepository
) {
    operator suspend fun invoke(
        onSuccess : (List<Routine>) -> Unit,
        onFailure : (Throwable) -> Unit,
    ){
        routineRepository.getRoutines(onSuccess , onFailure)
    }
}