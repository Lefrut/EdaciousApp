package ru.dashkevich.edaciousapp.screens.main.screens.feeds

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.dashkevich.edaciousapp.screens.main.screens.feeds.components.NewsCard
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.RecipeViewModel

@Composable
fun FeedsScreen(mainNavController: NavHostController, feedsViewModel: RecipeViewModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 18.dp, start = 18.dp, end = 18.dp)
    ) {
        // Доделать с нормальными данными
        items(20) { index ->
            NewsCard(
                modifier = Modifier.padding(top = 18.dp),
                name = "Kirill",
                surname = "Dashkevitch",
                foodName = "Panini",
                foodTime = index
            )
        }
    }
}