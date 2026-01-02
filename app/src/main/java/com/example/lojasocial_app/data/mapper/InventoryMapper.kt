package com.example.lojasocial_app.data.mapper

import InventoryItemDto
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lojasocial_app.domain.model.inventory.Good
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun InventoryItemDto.toDomain(): Good =
    Good(
        id = id_good,
        name = name,
        category = category,
        quantity = quantity,
        intakeDate = LocalDate.parse(intake_date),
        validUntil = LocalDate.parse(valid_until),
        status = status
    )

