//invoiceDatabaseDao
package com.ejecicio.roominvoicemanager.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ejecicio.roominvoicemanager.models.Invoice
import com.ejecicio.roominvoicemanager.models.Issuer
import kotlinx.coroutines.flow.Flow


@Dao
interface InvoiceDatabaseDao {

    @Query("SELECT * FROM invoice")
     fun getInvoices(): Flow<List<Invoice>>

    @Query("SELECT * FROM invoice WHERE id = :id")
     fun getInvoiceById(id: Int): Flow<Invoice>


//    // Add return type to indicate the number of rows affected
//    @Insert
//    suspend fun addInvoice(invoice: Invoice): Long // Returns the row ID of the inserted invoice
//
//    // Use Int as the return type to indicate the number of rows affected
//    @Update
//    suspend fun updateInvoice(invoice: Invoice): Int
//
//    // Use Int as the return type to indicate the number of rows affected
//    @Delete
//    suspend fun deleteInvoice(invoice: Invoice): Int


        @Insert
        abstract fun addInvoice(invoice: Invoice?): Long

        @Insert
        abstract fun addIssuer(issuer: Issuer?): Long

        @Delete
        abstract fun deleteInvoice(invoice: Invoice?): Int

        @Update
        abstract fun updateInvoice(invoice: Invoice?): Int

    }




//@Dao
//interface InvoiceDatabaseDao {
//
//    @Query("SELECT * FROM invoice")
//    fun getInvoices(): Flow<List<Invoice>>
//
//    @Query("SELECT * FROM invoice WHERE id = :id")
//    fun getInvoiceById(id: Int): Flow<Invoice>
//
//    @Insert
//    suspend fun addInvoice(invoice: Invoice)
//
//    @Update
//    suspend fun updateInvoice(invoice: Invoice)
//
//    @Delete
//    suspend fun deleteInvoice(invoice: Invoice)
//
//}

//@Dao
//interface InvoiceDatabaseDao {
//
//    //revise query's
//
//    @Query("SELECT * FROM invoice")
//    fun getInvoices(): Flow<List<Invoice>>
//
//    @Query("SELECT * FROM invoice WHERE id = :id")
//    fun getInvoiceById(id: Int): Flow<Invoice>
//
//    @Insert
//    suspend fun addInvoice(invoice: Invoice)
//
//    @Update
//    suspend fun updateInvoice(invoice: Invoice)
//
//    @Delete
//    suspend fun deleteInvoice(invoice: Invoice)
//
//
//}