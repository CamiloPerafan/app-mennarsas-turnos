package com.mennarsas.app_mennar_turnos
//estoy probando2.0
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mennarsas.app_mennar_turnos.ui.theme.AppmennarturnosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppmennarturnosTheme {
                AppNavigation()
            }
        }
    }
}
