package ru.dashkevich.edaciousapp.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.navigaiton.model.TopMainNavTree
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun MainTopMenu(
    screens: List<Pair<TopMainNavTree, Boolean>>,
    onExitClick: () -> Unit,
    onItemClick: (Int) -> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Theme.colors.secondaryBackgroundColor),
            columns = GridCells.Fixed(3)
        ) {
            items(screens.size) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(20.dp))
                    ItemTopMenu(item = screens[it], onClick = onItemClick, index = it)
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        Box(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(64.dp)
                .background(color = Theme.colors.primaryBackgroundColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { onExitClick() },
                imageVector = Icons.Default.Cancel,
                contentDescription = null,
                tint = Theme.colors.primaryColor
            )

        }

    }


}

@Composable
fun ItemTopMenu(
    modifier: Modifier = Modifier,
    item: Pair<TopMainNavTree, Boolean>,
    index: Int,
    onClick: (Int) -> Unit
) {
    val backgroundColor =
        if (!item.second) Theme.colors.secondaryColor else Theme.colors.primaryColor
    val iconColor =
        if (!item.second) Theme.colors.primaryColor else Theme.colors.primaryBackgroundColor
    val textColor = if (!item.second) Theme.colors.secondaryTextColor else Theme.colors.primaryColor
    val sizeBox = 66

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = modifier
                .size(sizeBox.dp)
                .background(color = backgroundColor, shape = CircleShape)
                .clickable {
                    onClick(index)
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = item.first.icon,
                contentDescription = null,
                modifier = Modifier.size((sizeBox / 2).dp),
                tint = iconColor
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = item.first.route,
            style = TextStyle(
                color = textColor,
                fontSize = 16.sp
            )
        )
    }
}