package ru.dashkevich.edaciousapp.screens.main.screens.chats.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.dashkevich.edaciousapp.R
import ru.dashkevich.edaciousapp.data.model.User
import ru.dashkevich.edaciousapp.ui.theme.EdaciousAppTheme
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun UserChatDie(
    modifier: Modifier = Modifier,
    user: User,
    numberRecipes: Int,
    onClick: () -> Unit
) {
    val padding = 20.dp
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                //TODO("TAKE IMAGE FROM THE INTERNET(FIREBASE)")
                Image(
                    modifier = Modifier
                        .padding(padding)
                        .size(66.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.anonimus_ava),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "${user.name} ${user.surname}",
                        fontSize = 20.sp,
                        color = Theme.colors.defaultTextColor,
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "$numberRecipes",
                            color = Theme.colors.primaryColor,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "Recipes",
                            color = Theme.colors.secondaryTextColor,
                            fontSize = 16.sp
                        )
                    }
                }
            }
            CircleIcon(
                modifier = Modifier
                    .padding(end = padding)
                    .clickable { onClick() },
                icon = Icons.Default.Chat,
                iconColor = Theme.colors.primaryBackgroundColor,
                circleColor = Theme.colors.primaryColor,
                onClick = {}
            )
        }

        Divider(
            modifier = Modifier
                .height(1.dp)
                .padding(start = padding)
                .alpha(0.5f),
            color = Theme.colors.secondaryTextColor
        )
    }
}


@Preview
@Composable
fun PreviewUserChatDie() {
    EdaciousAppTheme {
        UserChatDie(
            user = User(
                login = "132",
                name = "Kirill",
                surname = "Topias",
                numberPhone = "12345",
                email = "zorozan21@gmail.com"
            ),
            numberRecipes = 140,
            onClick = {}
        )
    }
}