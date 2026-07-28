package com.example.pearl.data.manager

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.pearl.domain.manger.LocalManger
import com.example.pearl.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalManagerImpl(
    val context : Context
) : LocalManger {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKey.APP_ENTRY_KEY] = true
            Log.e("DATASTORE" , "app entry is set to true")
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
       return context.dataStore.data.map {settings ->
            Log.e("DATASTORE" , "reading app entry : ${settings[PreferencesKey.APP_ENTRY_KEY]}")
            settings[PreferencesKey.APP_ENTRY_KEY] ?: false
        }
    }
}

private val Context.dataStore by preferencesDataStore(Constants.USER_SETTINGS)

private object PreferencesKey{
    val APP_ENTRY_KEY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}
