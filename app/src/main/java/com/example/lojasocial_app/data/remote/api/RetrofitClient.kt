package com.example.lojasocial_app.data.remote.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.example.lojasocial_app.data.session.SessionManager

object RetrofitClient {

    private const val BASE_URL = "http://10.0.2.2:8080/"

    /* ---------------- CLIENT SEM TOKEN (LOGIN) ---------------- */

    private fun createBaseClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    private fun createAuthClient(sessionManager: SessionManager): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(sessionManager))
            .addInterceptor(UnauthorizedInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()


    private fun createRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    /* ---------------- APIs ---------------- */

    fun createAuthApi(): AuthApi =
        createRetrofit(createBaseClient())
            .create(AuthApi::class.java)

    fun createDashboardApi(sessionManager: SessionManager): DashboardApi =
        createRetrofit(createAuthClient(sessionManager))
            .create(DashboardApi::class.java)

    fun createBeneficiaryApi(sessionManager: SessionManager): BeneficiaryApi =
        createRetrofit(createAuthClient(sessionManager))
            .create(BeneficiaryApi::class.java)

    fun createInventoryApi(sessionManager: SessionManager): InventoryApi =
        createRetrofit(createAuthClient(sessionManager))
            .create(InventoryApi::class.java)

    fun createDeliveryApi(sessionManager: SessionManager): DeliveryApi =
        createRetrofit(createAuthClient(sessionManager))
            .create(DeliveryApi::class.java)
}