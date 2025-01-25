package com.example.roomv1.navigation

sealed class AppScreens (val ruta:String) {
    //object InvoiceListView: AppScreens ("InvoiceListView")
    object InvoiceAddView: AppScreens ("InvoiceAddView")
    //object UserUpdateView: AppScreens (UserUpdateView)
}