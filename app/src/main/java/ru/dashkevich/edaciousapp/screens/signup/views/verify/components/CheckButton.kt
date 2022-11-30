package ru.dashkevich.edaciousapp.screens.signup.views.verify.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun CheckButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        modifier = modifier.size(36.dp).background(color = Theme.colors.primaryColor, shape = CircleShape),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(34.dp),
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = Theme.colors.primaryBackgroundColor
        )
    }
}