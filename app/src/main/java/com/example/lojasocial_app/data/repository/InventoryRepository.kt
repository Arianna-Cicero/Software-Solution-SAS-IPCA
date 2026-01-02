package com.example.lojasocial_app.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.data.mapper.toDomain
import com.example.lojasocial_app.data.remote.api.InventoryApi
import com.example.lojasocial_app.domain.model.inventory.Good

class InventoryRepository(
    private val api: InventoryApi
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getInventory(): List<Good> =
        api.getInventory().map { it.toDomain() }
}