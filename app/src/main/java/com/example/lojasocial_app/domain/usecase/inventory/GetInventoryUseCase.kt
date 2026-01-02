package com.example.lojasocial_app.domain.usecase.inventory

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.data.repository.InventoryRepository
import com.example.lojasocial_app.domain.model.inventory.Good

class GetInventoryUseCase(
    private val repository: InventoryRepository
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(): List<Good> {
        return repository.getInventory()
    }
}

