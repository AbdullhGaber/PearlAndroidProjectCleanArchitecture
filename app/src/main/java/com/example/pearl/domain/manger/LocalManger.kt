package com.example.pearl.domain.manger

import kotlinx.coroutines.flow.Flow

interface LocalManger {
   suspend fun saveAppEntry()

    fun readAppEntry() : Flow<Boolean>
}