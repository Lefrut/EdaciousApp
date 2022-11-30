package ru.dashkevich.edaciousapp.screens.main.screens.favorite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.dashkevich.edaciousapp.navigaiton.navigateToCharacteristic
import ru.dashkevich.edaciousapp.screens.main.screens.favorite.model.FavoriteAction
import ru.dashkevich.edaciousapp.screens.main.screens.favorite.model.FavoriteEvent
import ru.dashkevich.edaciousapp.screens.main.screens.favorite.model.FavoriteViewState
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.components.RecipeCard

@Composable
fun FavoriteScreen(favoriteViewModel: FavoriteViewModel, mainNavController: NavHostController) {

    val viewState by favoriteViewModel.viewState.observeAsState(FavoriteViewState())
    val recipes = viewState.likedRecipes.value
    val recipesState = viewState.likedRecipes.state

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        items(recipes.size) { index ->
            val recipe = recipes[index]
            RecipeCard(
                modifier = Modifier.padding(top = 18.dp),
                recipe = recipe, name = "Kirill", surname = "Pizza",
                onClick = {
                    favoriteViewModel.obtainEvent(FavoriteEvent.CardClicked(recipe))
                }
            )
        }
    }

    LaunchedEffect(viewState.favoriteAction) {
        when (val favoriteAction = viewState.favoriteAction) {
            FavoriteAction.None -> {}
            is FavoriteAction.OpenCharacteristicScreen -> {
                mainNavController.navigateToCharacteristic(favoriteAction.recipe)
            }
        }
    }
}