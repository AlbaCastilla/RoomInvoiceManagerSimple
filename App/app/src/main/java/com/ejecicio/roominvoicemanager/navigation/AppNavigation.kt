package com.example.roomv1.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ejecicio.roominvoicemanager.viewmodels.InvoiceViewModel
import com.ejecicio.roominvoicemanager.views.InvoiceAdd
import com.ejecicio.roominvoicemanager.views.InvoiceList
//import com.example.roomv1.viewmodels.UsersViewModel
//import com.example.roomv1.views.UserUpdateView
//import com.example.roomv1.views.UserAddView
//import com.example.roomv1.views.UserListView

@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation(viewModel: InvoiceViewModel) {

    val navController = rememberNavController()


        NavHost(navController = navController, startDestination = "InvoiceAddView") {
            composable("InvoiceListView") {
                InvoiceList(navController, viewModel)
            }

            composable("InvoiceAddView") {
                InvoiceAdd(navController, viewModel)
            }

            /*
        composable("InvoiceUpdateView/{id}/{usuario}/{email}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("usuario") { type = NavType.StringType },
            navArgument("email") { type = NavType.StringType }
        )) {
            InvoiceUpdateView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("usuario"),
                it.arguments?.getString("email")
            )

        }*/
    }
}

