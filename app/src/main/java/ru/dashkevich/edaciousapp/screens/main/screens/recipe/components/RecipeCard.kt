package ru.dashkevich.edaciousapp.screens.main.screens.recipe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.R
import ru.dashkevich.edaciousapp.data.model.Meal
import ru.dashkevich.edaciousapp.screens.main.screens.chats.components.CircleIcon
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Meal,
    name: String,
    surname: String,
    onClick: () -> Unit
) {
    //TODO(LIKES)
    Card(modifier = modifier
        .fillMaxWidth()
        .clickable { onClick() }
    ) {
        Box() {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    painter = painterResource(id = R.drawable.food_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = recipe.title,
                        style = TextStyle(
                            fontSize = 21.sp,
                            color = Theme.colors.defaultTextColor
                        )
                    )
                    Text(
                        text = "$name $surname created this recipe",
                        style = TextStyle(
                            fontSize = 17.sp,
                            color = Theme.colors.secondaryTextColor
                        )
                    )
                }

            }
            val iconColor = Theme.colors.secondaryTextColor
            CircleIcon(
                icon = Icons.Default.MonitorHeart,
                iconColor = iconColor,
                circleColor = Theme.colors.ternaryTextColor
            ) {}
        }
    }

}