package com.ejecicio.roominvoicemanager.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invoice")
data class Invoice(
    @PrimaryKey(autoGenerate = true) val id:  Long = 0L,
    val invoiceNumber: String,
    val issueDate: Long,  // Cambiado a Long
    val issuerId: Int,
    val recipientId: Int,
    val taxableAmount: Double,
    val vat: Double,
    val total: Double
)
