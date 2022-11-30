package ru.dashkevich.edaciousapp.screens.main.screens.feeds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.R
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    name: String,
    surname: String,
    foodName: String,
    foodTime: Int
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(66.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.anonimus_ava),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Column() {
                    Text(
                        text = "$name $surname is making a $foodName at her home",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Theme.colors.primaryTextColor
                        )
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "$foodTime min",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Theme.colors.secondaryTextColor
                        )
                    )
                }
            }
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                painter = painterResource(id = R.drawable.food_image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}