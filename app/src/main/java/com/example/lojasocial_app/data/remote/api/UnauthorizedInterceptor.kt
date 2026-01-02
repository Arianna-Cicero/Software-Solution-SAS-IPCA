package com.example.lojasocial_app.data.remote.api

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import com.example.lojasocial_app.data.session.AuthEventBus

class UnauthorizedInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        if (response.code == 401) {
            runBlocking {
                AuthEventBus.emitUnauthorized()
            }
        }

        return response
    }
}