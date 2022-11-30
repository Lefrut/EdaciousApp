package ru.dashkevich.edaciousapp.screens.main.screens.chats

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.dashkevich.edaciousapp.screens.main.screens.chats.components.UserChatsColumn
import ru.dashkevich.edaciousapp.screens.main.screens.chats.model.ChatTabs
import ru.dashkevich.edaciousapp.screens.main.screens.chats.model.ChatsEvent
import ru.dashkevich.edaciousapp.screens.main.screens.chats.model.ChatsViewState
import ru.dashkevich.edaciousapp.screens.main.screens.chats.model.chatTabsValues
import ru.dashkevich.edaciousapp.ui.theme.Theme
import ru.dashkevich.edaciousapp.util.bigUsersConst
import ru.dashkevich.edaciousapp.util.usersConst

@Composable
fun ChatsScreen(chatsViewModel: ChatsViewModel, mainNavController: NavHostController) {


    //TODO(Create different get requests)
    val tabs = chatTabsValues()
    val viewState by chatsViewModel.viewState.observeAsState(ChatsViewState())
    val numberTab = tabs
        .mapIndexed { index, chatTabs -> Pair(index, chatTabs) }
        .first { it.second == viewState.tabView }.first

    Column {
        ScrollableTabRow(
            selectedTabIndex = numberTab,
            backgroundColor = Theme.colors.ternaryTextColor,
            contentColor = Theme.colors.secondaryTextColor,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[numberTab]),
                    color = Theme.colors.primaryColor
                )
            }

        ) {
            tabs.forEach { tab ->
                Tab(
                    text = { Text(text = tab.title) },
                    selected = viewState.tabView == tab,
                    onClick = {
                        chatsViewModel.obtainEvent(ChatsEvent.TabClicked(tab))
                    },
                    selectedContentColor = Theme.colors.primaryColor,
                    unselectedContentColor = Theme.colors.secondaryTextColor
                )
            }
        }
        UserChatsColumn(users = bigUsersConst)
    }

}