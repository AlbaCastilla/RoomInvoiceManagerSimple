package com.ejecicio.roominvoicemanager.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Invoice(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val invoiceNumber: String,
    val issueDate: String,
    val issuerId: Int,
    val recipientId: Int,
    val taxableAmount: Double,
    val vat: Double,
    val total: Double
)