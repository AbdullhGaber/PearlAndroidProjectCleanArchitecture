package com.example.pearl.domain.repositories

import com.example.pearl.domain.model.Routine

interface RoutineRepository {
    fun addProductToRoutine(
        routine : Routine,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit,
    )

    suspend fun getRoutines(
        onSuccess: (List<Routine>) -> Unit,
        onFailure: (Throwable) -> Unit
    )

    fun removeProductFromRoutine(
        routineId : String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    )

}