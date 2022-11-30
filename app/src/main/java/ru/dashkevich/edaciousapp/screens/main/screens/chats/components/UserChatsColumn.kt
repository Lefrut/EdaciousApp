package ru.dashkevich.edaciousapp.screens.main.screens.chats.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.dashkevich.edaciousapp.data.model.User
import ru.dashkevich.edaciousapp.ui.theme.EdaciousAppTheme
import ru.dashkevich.edaciousapp.util.bigUsersConst

@Composable
fun UserChatsColumn(modifier: Modifier = Modifier, users: List<User>) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ){
        items(users.size){ index: Int ->
            UserChatDie(user = users[index], numberRecipes = 7200, onClick = {})
        }
    }
}

@Preview
@Composable
fun PreviewUserChatsColumn() {
    EdaciousAppTheme {
        UserChatsColumn(users = bigUsersConst)
    }
}