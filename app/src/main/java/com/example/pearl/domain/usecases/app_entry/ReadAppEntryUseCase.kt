package com.example.pearl.domain.usecases.app_entry

import com.example.pearl.domain.manger.LocalManger
import kotlinx.coroutines.flow.Flow


class ReadAppEntryUseCase(
    val localManger: LocalManger
) {
    operator fun invoke() : Flow<Boolean> {
        return localManger.readAppEntry()
    }
}