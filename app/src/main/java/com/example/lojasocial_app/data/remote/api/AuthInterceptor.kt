package com.example.lojasocial_app.data.remote.api

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import com.example.lojasocial_app.data.session.SessionManager
import kotlinx.coroutines.flow.first

class AuthInterceptor(
    private val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val sessionId = runBlocking {
            sessionManager.getSessionId().first()
        }

        val request = if (sessionId != null) {
            chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $sessionId")
                .build()
        } else {
            chain.request()
        }

        return chain.proceed(request)
    }
}