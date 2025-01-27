package com.ejecicio.roominvoicemanager.views


import androidx.compose.runtime.Composable

import androidx.compose.material3.Text
import androidx.navigation.NavController
import com.ejecicio.roominvoicemanager.viewmodels.InvoiceViewModel

@Composable
fun InvoiceDelete(navController: NavController, viewModel: InvoiceViewModel) {
    Text(text = "Invoice Delete")
}