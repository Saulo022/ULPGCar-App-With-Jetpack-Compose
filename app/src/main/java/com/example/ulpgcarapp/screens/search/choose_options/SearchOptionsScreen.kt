package com.example.ulpgcarapp.screens.search.choose_options


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ulpgcarapp.common.components.DropdownMenuComposable
import com.example.ulpgcarapp.ui.theme.Pink50
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockSelection


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchOptionsScreen(place: String) {

    val municipalities = listOf(
        "Agaete", "Agüimes", "Artenara", "Arucas", "Firgas", "Galdar", "Ingenio",
        "La Aldea de San Nicolás", "Las Palmas de Gran Canaria"
    )

    val campusUniversitarios = listOf(
        "Campus de Tafira",
        "Campus del Obelisco",
        "Campus de San Cristobal",
        "Campus de Montaña de Cardones"
    )

    val municipio = "Municipio"
    val campus = "Campus"

    val calendarState = rememberSheetState()

    var dateChoose by remember { mutableStateOf("") }

    CalendarDialog(state = calendarState, selection = CalendarSelection.Date { date ->
        dateChoose = date.toString()
    })

    val clockState = rememberSheetState()

    var timeChoose by remember { mutableStateOf("") }

    ClockDialog(state = clockState, selection = ClockSelection.HoursMinutes { hours, minutes ->
        timeChoose = "$hours:" + "$minutes"
    })

    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = Pink50,
        contentColor = MaterialTheme.colorScheme.surface
    )

    val location by remember { mutableStateOf(place) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DropdownMenuComposable(
            name = if (location == "Universidad") municipio else campus,
            options = if (location == "Universidad") municipalities else campusUniversitarios
        )

        Spacer(modifier = Modifier.padding(vertical = 30.dp))

        DropdownMenuComposable(
            name = if (location == "Universidad") campus else municipio,
            options = if (location == "Universidad") campusUniversitarios else municipalities)

        Spacer(modifier = Modifier.padding(vertical = 30.dp))

        Row(modifier = Modifier.padding(start = 26.dp, end = 22.dp)) {
            Button(
                onClick = { calendarState.show() },
                modifier = Modifier
                    .height(80.dp)
                    .width(150.dp)
            ) {
                Text(text = dateChoose, fontSize = 14.sp)
                Icon(
                    Icons.Default.DateRange, "Date range",
                    modifier = Modifier.padding(start = 8.dp, end = 2.dp)
                )
            }

            Spacer(modifier = Modifier.padding(horizontal = 30.dp))

            Button(
                onClick = { clockState.show() },
                modifier = Modifier
                    .height(80.dp)
                    .width(150.dp)
            ) {
                Text(text = timeChoose, fontSize = 20.sp)
                Icon(
                    Icons.Default.Timer, "Time range",
                    modifier = Modifier.padding(start = 8.dp, end = 2.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 45.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = mainButtonColor,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Buscar viaje", fontSize = 20.sp)
        }
    }
}