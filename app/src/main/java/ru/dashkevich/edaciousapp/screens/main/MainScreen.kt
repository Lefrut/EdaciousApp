package ru.dashkevich.edaciousapp.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.dashkevich.edaciousapp.screens.main.components.MainTopAppBar
import ru.dashkevich.edaciousapp.screens.main.components.MainTopMenu
import ru.dashkevich.edaciousapp.screens.main.model.MainEvent
import ru.dashkevich.edaciousapp.screens.main.model.MainViewState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, mainViewModel: MainViewModel) {

    val viewState = mainViewModel.viewState.observeAsState(MainViewState()).value
    val blur = if(viewState.expandedTopMenu) Modifier.blur(16.dp) else Modifier

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.fillMaxSize().then(blur),
            topBar = {
                MainTopAppBar(
                    onMenuClick = { mainViewModel.obtainEvent(MainEvent.TopMenuTriggerClicked)},
                    onPlanetClick = {},
                    onSearchClick = {}
                )
            },
        ) { paddingValues ->
            ContentMainScreen(modifier = Modifier.padding(paddingValues), viewState = viewState)
        }

        if (viewState.expandedTopMenu) {
            MainTopMenu(
                onExitClick = { mainViewModel.obtainEvent(MainEvent.TopMenuTriggerClicked) },
                onItemClick = { mainViewModel.obtainEvent(MainEvent.ItemMenuClicked(it)) },
                screens = viewState.useMenuItems
            )
        }
    }

}


















