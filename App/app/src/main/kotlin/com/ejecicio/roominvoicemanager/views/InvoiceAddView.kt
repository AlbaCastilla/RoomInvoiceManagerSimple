//package com.ejecicio.roominvoicemanager.views
//
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.runtime.Composable
//import androidx.compose.material3.Text
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.ejecicio.roominvoicemanager.models.Invoice
//import com.ejecicio.roominvoicemanager.viewmodels.InvoiceViewModel
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun InvoiceAdd(navController: NavController, viewModel: InvoiceViewModel) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Add Invoice") }
//            )
//        },
//        content = { paddingValues ->
//            Column(modifier = Modifier.padding(paddingValues)) {
//                InvoiceAddForm()
//            }
//        }
//    )
//}
//
//@Composable
//fun InvoiceAddForm() {
//    var invoiceNumber by remember { mutableStateOf("") }
//    var issueDate by remember { mutableStateOf("") }
//    var taxableAmount by remember { mutableStateOf("") }
//    var total by remember { mutableStateOf("") }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        OutlinedTextField(
//            value = invoiceNumber,
//            onValueChange = { invoiceNumber = it },
//            label = { Text("Invoice Number") }
//        )
//        OutlinedTextField(
//            value = issueDate,
//            onValueChange = { issueDate = it },
//            label = { Text("Issue Date (YYYY-MM-DD)") }
//        )
//        OutlinedTextField(
//            value = taxableAmount,
//            onValueChange = { taxableAmount = it },
//            label = { Text("Taxable Amount (€)") },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
//        )
//        OutlinedTextField(
//            value = total,
//            onValueChange = { total = it },
//            label = { Text("Total (€)") },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = { }) {
//            Text("Submit")
//        }
//    }
//}
package com.ejecicio.roominvoicemanager.views

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ejecicio.roominvoicemanager.models.Invoice
import com.ejecicio.roominvoicemanager.viewmodels.InvoiceViewModel
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.ui.platform.LocalContext



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
                InvoiceAddForm(viewModel)
            }
        }
    )
}

@Composable
fun InvoiceAddForm(viewModel: InvoiceViewModel) {
    var invoiceNumber by remember { mutableStateOf("") }
    var issueDate by remember { mutableStateOf("") }
    var taxableAmount by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }
    var issuerId by remember { mutableStateOf("") }
    var recipientId by remember { mutableStateOf("") }
    var vat by remember { mutableStateOf(0.0) }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = invoiceNumber,
            onValueChange = { invoiceNumber = it },
            label = { Text("Invoice Number") }
        )

        OutlinedTextField(
            value = issueDate,
            onValueChange = { issueDate = it },
            label = { Text("Issue Date (YYYY-MM-DD)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            value = taxableAmount,
            onValueChange = { taxableAmount = it },
            label = { Text("Taxable Amount (€)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = vat.toString(),
            onValueChange = { vat = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("VAT (%)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = total,
            onValueChange = { total = it },
            label = { Text("Total (€)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        // Add Issuer and Recipient IDs as integer input
        OutlinedTextField(
            value = issuerId,
            onValueChange = { issuerId = it },
            label = { Text("Issuer ID") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = recipientId,
            onValueChange = { recipientId = it },
            label = { Text("Recipient ID") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Ensure all fields are filled
                if (invoiceNumber.isNotEmpty() && issueDate.isNotEmpty() && taxableAmount.isNotEmpty() && total.isNotEmpty() && issuerId.isNotEmpty() && recipientId.isNotEmpty()) {
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    val issueDateLong = dateFormat.parse(issueDate)?.time ?: System.currentTimeMillis()
                    val newInvoice = Invoice(
                        invoiceNumber = invoiceNumber,
                        issueDate = issueDateLong,
                        issuerId = issuerId.toInt(),
                        recipientId = recipientId.toInt(),
                        taxableAmount = taxableAmount.toDouble(),
                        vat = vat,
                        total = total.toDouble()
                    )
                    viewModel.addInvoice(newInvoice)
                    //Toast.makeText(LocalContext.toString(), "Invoice added", Toast.LENGTH_SHORT).show()
                } else {
                    //Toast.makeText(context, "Invoice Added: $invoiceNumber", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Submit")
        }
    }
}
