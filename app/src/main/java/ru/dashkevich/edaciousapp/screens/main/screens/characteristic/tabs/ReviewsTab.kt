package ru.dashkevich.edaciousapp.screens.main.screens.characteristic.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.dashkevich.edaciousapp.R
import ru.dashkevich.edaciousapp.data.model.Feedback
import ru.dashkevich.edaciousapp.data.model.User
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun ReviewsTab(modifier: Modifier = Modifier, feedbacks: List<Feedback>) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(feedbacks.size) { index ->
            ReviewCard(
                feedBack = feedbacks[index]
            )
        }
        item {
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}


@Composable
fun ReviewCard(feedBack: Feedback) {
    Column(modifier = Modifier.padding(start = 10.dp)) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (feedBack.user.photo == null) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.anonimus_ava),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            } else {
                feedBack.user.photo?.let {
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        bitmap = it.asImageBitmap(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop

                    )
                }
            }
            Text(
                text = feedBack.user.name + " " + feedBack.user.surname,
                fontSize = 20.sp,
                color = Theme.colors.defaultTextColor,
                modifier = Modifier.padding(horizontal = 6.dp)
            )
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(0xFFFFD700)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = feedBack.rate.toString(),
                fontSize = 14.sp,
                color = Theme.colors.secondaryTextColor
            )
        }
        Text(
            text = feedBack.comment,
            color = Theme.colors.secondaryTextColor,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider(modifier = Modifier.height(2.dp), color = Theme.colors.ternaryTextColor)
    }
}









