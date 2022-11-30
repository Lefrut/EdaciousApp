package ru.dashkevich.edaciousapp.screens.splash.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.dashkevich.edaciousapp.R
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun LogoImage(
    modifier: Modifier = Modifier,
    paddingEnd: Dp = 74.dp,
    heightIcon: Dp = 100.dp,
    widthIcon: Dp = 120.dp,
    colorCircle: Color = Theme.colors.primaryColor,
    colorIcon: Color = Theme.colors.primaryBackgroundColor
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawCircle(
                color = colorCircle,
                radius = size.minDimension / 2,
                center = Offset(size.width / 2, size.height / 2)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.trident),
            contentDescription = null,
            tint = colorIcon,
            modifier = Modifier
                .padding(end = paddingEnd)
                .size(height = heightIcon, width = widthIcon)
        )
    }
}