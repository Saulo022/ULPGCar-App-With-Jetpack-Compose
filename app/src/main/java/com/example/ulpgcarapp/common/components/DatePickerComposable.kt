package com.example.ulpgcarapp.common.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerComposable() {
    val calendarState = rememberSheetState()

    CalendarDialog(state = calendarState, selection = CalendarSelection.Date { date ->
        Log.d("SelectedDate", "$date")
    })

    val clockState = rememberSheetState()

    ClockDialog(state = clockState, selection = ClockSelection.HoursMinutes { hours, minutes ->
        Log.d("SelectedDate", "$hours:$minutes")
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { calendarState.show() }) {
            Text(text = "Date Picker")
        }
        Button(onClick = { clockState.show() }) {
            Text(text = "Time Picker")
        }
    }
}