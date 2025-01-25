package com.ejecicio.roominvoicemanager.states

import com.ejecicio.roominvoicemanager.models.Invoice

data class InvoiceState(
    val invoiceList: List<Invoice> = emptyList()
)
