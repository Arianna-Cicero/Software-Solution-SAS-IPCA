package com.example.lojasocial_app.data.session

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "session_prefs")

class SessionManager(
    private val context: Context
) {

    companion object {
        private val SESSION_ID = stringPreferencesKey("session_id")
    }

    suspend fun saveSession(sessionId: String) {
        context.dataStore.edit { prefs ->
            prefs[SESSION_ID] = sessionId
        }
    }

    suspend fun clearSession() {
        context.dataStore.edit { prefs ->
            prefs.remove(SESSION_ID)
        }
    }

    fun getSessionId(): Flow<String?> =
        context.dataStore.data.map { prefs ->
            prefs[SESSION_ID]
        }
}