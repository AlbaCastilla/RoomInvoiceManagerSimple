package com.ejecicio.roominvoicemanager.views

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ejecicio.roominvoicemanager.models.Invoice
import com.ejecicio.roominvoicemanager.viewmodels.InvoiceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvoiceAdd(navController: NavController, viewModel: InvoiceViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Invoice") }
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                InvoiceAddForm()
            }
        }
    )
}

@Composable
fun InvoiceAddForm() {
    var invoiceNumber by remember { mutableStateOf("") }
    var issueDate by remember { mutableStateOf("") }
    var taxableAmount by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = invoiceNumber,
            onValueChange = { invoiceNumber = it },
            label = { Text("Invoice Number") }
        )
        OutlinedTextField(
            value = issueDate,
            onValueChange = { issueDate = it },
            label = { Text("Issue Date (YYYY-MM-DD)") }
        )
        OutlinedTextField(
            value = taxableAmount,
            onValueChange = { taxableAmount = it },
            label = { Text("Taxable Amount (€)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = total,
            onValueChange = { total = it },
            label = { Text("Total (€)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { }) {
            Text("Submit")
        }
    }
}
