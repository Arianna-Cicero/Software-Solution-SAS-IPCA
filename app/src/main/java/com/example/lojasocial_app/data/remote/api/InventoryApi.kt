package com.example.lojasocial_app.data.remote.api

import InventoryItemDto
import retrofit2.http.GET

interface InventoryApi {

    @GET("inventory")
    suspend fun getInventory(): List<InventoryItemDto>
}

