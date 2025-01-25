package com.ejecicio.roominvoicemanager.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ejecicio.roominvoicemanager.models.Invoice



@Database(
    entities = [Invoice::class],
    version = 1,
    exportSchema = false
)

abstract class InvoiceDatabase: RoomDatabase() {
    abstract fun usersDao(): InvoiceDatabaseDao
}