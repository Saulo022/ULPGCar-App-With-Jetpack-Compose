package com.example.ulpgcarapp.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DropdownMenuComposable(
    name: String,
    options: List<String>
) {
    var expanded by remember { mutableStateOf(false) }

    var selectedItem by remember { mutableStateOf("$name ") }

    val itemList = listOf(
        "Agaete", "Agüimes", "Artenara", "Arucas", "Firgas", "Galdar", "Ingenio",
        "La Aldea de San Nicolás", "Las Palmas de Gran Canaria"
    )

    Column {

        Box {
            Button(
                onClick = { expanded = true },
                modifier = Modifier
                    .height(80.dp)
                    .width(350.dp)
            ) {
                Row {
                    Text("$selectedItem  ", fontSize = 20.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.ArrowDropDown, "Arrow Icon")
                }
            }
            androidx.compose.material3.DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .height(200.dp)
                    .width(350.dp)
            ) {
                options.forEach {
                    DropdownMenuItem(
                        text = { Text(text = it) },
                        onClick = {
                            expanded = false
                            selectedItem = it
                        }
                    )
                }
            }
        }
    }
}
