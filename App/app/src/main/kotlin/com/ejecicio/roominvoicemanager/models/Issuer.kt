package com.ejecicio.roominvoicemanager.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Issuer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val company: String,
    val taxId: String,
    val address: String
)