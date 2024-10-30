package com.mennarsas.app_mennar_turnos

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mennarsas.app_mennar_turnos.screens.LoginScreen
import com.mennarsas.app_mennar_turnos.screens.TurnerosScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(onLoginSuccess = {
                navController.navigate("turneros")
            })
        }
        composable("turneros") { TurnerosScreen() }
    }
}