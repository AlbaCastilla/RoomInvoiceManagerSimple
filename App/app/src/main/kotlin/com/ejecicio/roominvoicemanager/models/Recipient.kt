package com.ejecicio.roominvoicemanager.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipient(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val client: String,
    val taxId: String,
    val address: String
)