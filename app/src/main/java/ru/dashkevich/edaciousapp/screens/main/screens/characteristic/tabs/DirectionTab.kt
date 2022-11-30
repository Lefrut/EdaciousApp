package ru.dashkevich.edaciousapp.screens.main.screens.characteristic.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.components.RatingBar
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun DirectionTab(title: String, desc: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(13.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = Theme.colors.defaultTextColor,
                fontSize = 24.sp
            )
        )
        RatingBar(rating = 4)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = desc,
            style = TextStyle(
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp
            )
        )
    }
}

