package ru.dashkevich.edaciousapp.screens.signup.views.verify.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun InputCodeButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .height(42.dp)
            .border(
                color = Theme.colors.primaryTextColor,
                shape = CircleShape,
                width = 1.dp
            )
            .background(color = Theme.colors.primaryBackgroundColor, shape = CircleShape)
            .then(modifier),
    ) {

    }
}