package com.mennarsas.app_mennar_turnos.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TurnerosScreen() {
    // Estado para la sede seleccionada y el turno seleccionado
    var selectedSede by remember { mutableStateOf("") }
    var selectedTurno by remember { mutableStateOf("") }

    // Opciones de sedes y turnos (puedes reemplazar estos valores con los que necesites)
    val sedes = listOf("Sede Norte", "Sede Sur", "Sede Centro")
    val turnos = mapOf(
        "Sede Norte" to listOf("Turno 1", "Turno 2"),
        "Sede Sur" to listOf("Turno A", "Turno B"),
        "Sede Centro" to listOf("Turno X", "Turno Y")
    )

    // Estados para los menús desplegables
    var sedeExpanded by remember { mutableStateOf(false) }
    var turnoExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Seleccione una Sede", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        // Selección de Sede
        Box {
            Button(onClick = { sedeExpanded = true }) {
                Text(text = if (selectedSede.isEmpty()) "Seleccionar Sede" else selectedSede)
            }
            DropdownMenu(
                expanded = sedeExpanded,
                onDismissRequest = { sedeExpanded = false }
            ) {
                sedes.forEach { sede ->
                    DropdownMenuItem(
                        text = { Text(sede) },
                        onClick = {
                            selectedSede = sede
                            selectedTurno = "" // Reinicia el turno seleccionado al cambiar la sede
                            sedeExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Selección de Turno, solo se muestra si se seleccionó una sede
        if (selectedSede.isNotEmpty()) {
            Text(text = "Seleccione un Turno para $selectedSede", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))

            Box {
                Button(onClick = { turnoExpanded = true }) {
                    Text(text = if (selectedTurno.isEmpty()) "Seleccionar Turno" else selectedTurno)
                }
                DropdownMenu(
                    expanded = turnoExpanded,
                    onDismissRequest = { turnoExpanded = false }
                ) {
                    turnos[selectedSede]?.forEach { turno ->
                        DropdownMenuItem(
                            text = { Text(turno) },
                            onClick = {
                                selectedTurno = turno
                                turnoExpanded = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Confirmación de selección
        if (selectedSede.isNotEmpty() && selectedTurno.isNotEmpty()) {
            Text(
                text = "Has seleccionado: $selectedSede - $selectedTurno",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
