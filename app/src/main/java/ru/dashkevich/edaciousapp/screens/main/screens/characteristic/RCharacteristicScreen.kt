package ru.dashkevich.edaciousapp.screens.main.screens.characteristic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.dashkevich.edaciousapp.R
import ru.dashkevich.edaciousapp.data.model.Meal
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.model.MealTabItem
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.model.RCharacteristicEvent
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.model.RCharacteristicViewState
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.tabs.DirectionTab
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.tabs.IngredientTab
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.tabs.ReviewsTab
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun RCharacteristicScreen(rCharacteristicViewModel: RCharacteristicViewModel, meal: Meal) {

    val viewState by rCharacteristicViewModel.viewState.observeAsState(RCharacteristicViewState())


    Column() {
        ScrollableTabRow(
            selectedTabIndex = viewState.tabView.ordinal,
            backgroundColor = Theme.colors.ternaryTextColor,
            contentColor = Theme.colors.secondaryTextColor,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[viewState.tabView.ordinal]),
                    color = Theme.colors.primaryColor
                )
            }

        ) {
            MealTabItem.values().forEach { tab ->
                Tab(
                    text = { Text(text = tab.name) },
                    selected = viewState.tabView == tab,
                    onClick = {
                        rCharacteristicViewModel.obtainEvent(RCharacteristicEvent.TabClicked(tab))
                    },
                    selectedContentColor = Theme.colors.primaryColor,
                    unselectedContentColor = Theme.colors.secondaryTextColor
                )
            }
        }


        // тестовая версия
        val imageHeight = 230
        Box(modifier = Modifier.fillMaxHeight()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight.dp),
                painter = painterResource(id = R.drawable.anonimus_ava),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(
                        top = (imageHeight - 20).dp,
                        start = 12.dp,
                        end = 12.dp
                    )
                    .background(color = Theme.colors.primaryBackgroundColor),
            ) {

                when (viewState.tabView) {
                    MealTabItem.DIRECTION -> {
                        DirectionTab(title = meal.title, desc = meal.longDescription)
                    }
                    MealTabItem.INGREDIENT -> {
                        IngredientTab(ingredients = meal.ingredients)
                    }
                    MealTabItem.REVIEWS -> {
                        ReviewsTab(feedbacks = meal.feedbacks)
                    }
                }
            }
        }
    }
}
