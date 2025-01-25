package com.ejecicio.roominvoicemanager.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ejecicio.roominvoicemanager.models.Invoice
import kotlinx.coroutines.flow.Flow

@Dao
interface InvoiceDatabaseDao {

    //revise query's

    @Query("SELECT * FROM invoice")
    fun getInvoices(): Flow<List<Invoice>>

    @Query("SELECT * FROM invoice WHERE id = :id")
    fun getInvoiceById(id: Int): Flow<Invoice>

    @Insert
    suspend fun addInvoice(invoice: Invoice)

    @Update
    suspend fun updateInvoice(invoice: Invoice)

    @Delete
    suspend fun deleteInvoice(invoice: Invoice)


}