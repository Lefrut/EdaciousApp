package ru.dashkevich.edaciousapp.screens.main.screens.chats.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.dashkevich.edaciousapp.ui.theme.EdaciousAppTheme
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun CircleIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconColor: Color,
    circleSize: Int = 40,
    circleColor: Color,
    onClick: () -> Unit
) {
    val iconSize = circleSize*0.6

    Box(
        modifier.size(circleSize.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        ) {
            val width = size.width
            val height = size.height
            drawCircle(
                color = circleColor,
                center = Offset(x = width / 2, y = height / 2),
                radius = size.minDimension
            )
        }
        Icon(
            modifier = Modifier.size(iconSize.dp),
            imageVector = icon,
            contentDescription = null,
            tint = iconColor
        )
    }
}

@Preview
@Composable
fun PreviewCircleIcon() {
    EdaciousAppTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircleIcon(
                icon = Icons.Default.AddChart,
                iconColor = Theme.colors.primaryBackgroundColor,
                circleColor = Theme.colors.primaryColor,
                onClick = {}
            )
        }
    }
}