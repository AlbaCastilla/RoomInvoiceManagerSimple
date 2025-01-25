package com.ejecicio.roominvoicemanager.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ejecicio.roominvoicemanager.models.Invoice
import com.ejecicio.roominvoicemanager.room.InvoiceDatabaseDao
import com.ejecicio.roominvoicemanager.states.InvoiceState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class InvoiceViewModel(
    private val dao: InvoiceDatabaseDao
) : ViewModel() {

    var state by mutableStateOf(InvoiceState())
        private set

    init {
        viewModelScope.launch {
            dao.getInvoices().collectLatest {
                state = state.copy(
                    invoiceList = it
                )
            }
        }
    }

    fun addInvoice(invoice: Invoice) = viewModelScope.launch {
        dao.addInvoice(invoice)
    }

    fun updateInvoice(invoice: Invoice) = viewModelScope.launch {
        dao.updateInvoice(invoice)
    }

    fun deleteInvoice(invoice: Invoice) = viewModelScope.launch {
        dao.deleteInvoice(invoice)
    }
}
