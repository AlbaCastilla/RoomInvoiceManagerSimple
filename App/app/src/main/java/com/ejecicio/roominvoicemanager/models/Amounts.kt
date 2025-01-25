package com.ejecicio.roominvoicemanager.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Amounts(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val invoiceId: Int,
    val taxableAmount: Double,
    val vat: Double,
    val total: Double
)