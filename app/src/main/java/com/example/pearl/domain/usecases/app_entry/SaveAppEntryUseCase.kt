package com.example.pearl.domain.usecases.app_entry

import com.example.pearl.domain.manger.LocalManger

class SaveAppEntryUseCase(
    val localManger: LocalManger
) {
    suspend operator fun invoke(){
        localManger.saveAppEntry()
    }
}