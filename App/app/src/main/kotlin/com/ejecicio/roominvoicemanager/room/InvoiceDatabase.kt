//package com.ejecicio.roominvoicemanager.room
//
//import androidx.room.Database
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import androidx.room.RoomDatabase
//import com.ejecicio.roominvoicemanager.models.Invoice
//
//
//
////@Database(
////    entities = [Invoice::class],
////    version = 1,
////    exportSchema = false
////)
//
//@Entity(tableName = "invoice")
//data class Invoice(
//    @PrimaryKey(autoGenerate = true) val id: Int,
//    val description: String,
//    val amount: Double
//)
//
//abstract class InvoiceDatabase: RoomDatabase() {
//    abstract fun invoiceDao(): InvoiceDatabaseDao
//}

//invoiceDatabase
package com.ejecicio.roominvoicemanager.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ejecicio.roominvoicemanager.models.Invoice

@Database(
    entities = [Invoice::class],
    version = 1,
    exportSchema = false
)
abstract class InvoiceDatabase : RoomDatabase() {
    abstract fun invoiceDao(): InvoiceDatabaseDao
}
