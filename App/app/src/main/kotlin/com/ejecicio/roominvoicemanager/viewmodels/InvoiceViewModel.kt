//package com.ejecicio.roominvoicemanager.viewmodels
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.ejecicio.roominvoicemanager.models.Invoice
//import com.ejecicio.roominvoicemanager.room.InvoiceDatabaseDao
//import com.ejecicio.roominvoicemanager.states.InvoiceState
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//class InvoiceViewModel(
//    private val dao: InvoiceDatabaseDao
//) : ViewModel() {
//
//    var state by mutableStateOf(InvoiceState())
//        private set
//
//    init {
//        viewModelScope.launch {
//            dao.getInvoices().collectLatest {
//                state = state.copy(
//                    invoiceList = it
//                )
//            }
//        }
//    }
//
//    fun addInvoice(invoice: Invoice) = viewModelScope.launch {
//        dao.addInvoice(invoice)
//    }
//
//    fun updateInvoice(invoice: Invoice) = viewModelScope.launch {
//        dao.updateInvoice(invoice)
//    }
//
//    fun deleteInvoice(invoice: Invoice) = viewModelScope.launch {
//        dao.deleteInvoice(invoice)
//    }
//}

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
import android.util.Log

class InvoiceViewModel(
    private val dao: InvoiceDatabaseDao
) : ViewModel() {

    var state by mutableStateOf(InvoiceState())
        private set

    init {
        fetchInvoices()
    }

    private fun fetchInvoices() {
        viewModelScope.launch {
            try {
                dao.getInvoices().collectLatest { invoices ->
                    state = state.copy(invoiceList = invoices)
                }
            } catch (e: Exception) {
                Log.e("InvoiceViewModel", "Error fetching invoices", e)
            }
        }
    }

    fun addInvoice(invoice: Invoice) = viewModelScope.launch {
        try {
            val id = dao.addInvoice(invoice)
            Log.d("InvoiceViewModel", "Invoice added with ID: $id")
        } catch (e: Exception) {
            Log.e("InvoiceViewModel", "Error adding invoice", e)
        }
    }

    fun updateInvoice(invoice: Invoice) = viewModelScope.launch {
        try {
            dao.updateInvoice(invoice)
            Log.d("InvoiceViewModel", "Invoice updated: ${invoice.id}")
        } catch (e: Exception) {
            Log.e("InvoiceViewModel", "Error updating invoice", e)
        }
    }

    fun deleteInvoice(invoice: Invoice) = viewModelScope.launch {
        try {
            dao.deleteInvoice(invoice)
            Log.d("InvoiceViewModel", "Invoice deleted: ${invoice.id}")
        } catch (e: Exception) {
            Log.e("InvoiceViewModel", "Error deleting invoice", e)
        }
    }
}
