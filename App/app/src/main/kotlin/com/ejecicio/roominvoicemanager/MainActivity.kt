//package com.ejecicio.roominvoicemanager
//
//import android.os.Bundle
//import android.util.Log  // Importa Log para depuración
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.room.Room
//import com.ejecicio.roominvoicemanager.navigation.AppNavigation
//import com.ejecicio.roominvoicemanager.room.InvoiceDatabase
//import com.ejecicio.roominvoicemanager.ui.theme.Roomv1Theme
//import com.ejecicio.roominvoicemanager.viewmodels.InvoiceViewModel
////import com.example.roomv1.navigation.AppNavigation
////import com.example.roomv1.ui.theme.Roomv1Theme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d("MainActivity", "onCreate started")  // Log al iniciar onCreate
//
//        // Inicialización de la base de datos antes de setContent para evitar problemas en la UI
//        val database = Room.databaseBuilder(
//            applicationContext,
//            InvoiceDatabase::class.java,
//            "db_invoices"
//        ).build()
//        Log.d("MainActivity", "Database initialized successfully")  // Log de éxito
//
//        val dao = database.invoiceDao()
//        Log.d("MainActivity", "DAO obtained")
//
//        val viewModel = InvoiceViewModel(dao)
//        Log.d("MainActivity", "ViewModel created")
//
//        setContent {
//            Log.d("MainActivity", "setContent started")  // Log al iniciar setContent
//            Roomv1Theme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Log.d("MainActivity", "Surface initialized")  // Log cuando Surface empieza
//                    AppNavigation(viewModel = viewModel)
//                    Log.d("MainActivity", "AppNavigation loaded")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Log.d("Greeting", "Greeting composable called with name: $name")  // Log cuando se llama a Greeting
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Roomv1Theme {
//        Greeting("Android")
//    }
//}

package com.ejecicio.roominvoicemanager

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.room.Room
import com.ejecicio.roominvoicemanager.navigation.AppNavigation
import com.ejecicio.roominvoicemanager.room.InvoiceDatabase
import com.ejecicio.roominvoicemanager.ui.theme.Roomv1Theme
import com.ejecicio.roominvoicemanager.viewmodels.InvoiceViewModel

import androidx.compose.ui.Modifier


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate started")

        // Initialize Room database
        val database = Room.databaseBuilder(
            applicationContext,
            InvoiceDatabase::class.java,
            "db_invoices"
        )
            .fallbackToDestructiveMigration()  // Handle database version changes
            .build()
        Log.d("MainActivity", "Database initialized successfully")

        // Get DAO and ViewModel
        val dao = database.invoiceDao()
        Log.d("MainActivity", "DAO obtained")

        val viewModel = InvoiceViewModel(dao)
        Log.d("MainActivity", "ViewModel created")

        setContent {
            Log.d("MainActivity", "setContent started")
            Roomv1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Log.d("MainActivity", "Surface initialized")
                    AppNavigation(viewModel = viewModel)
                    Log.d("MainActivity", "AppNavigation loaded")
                }
            }
        }
    }
}
