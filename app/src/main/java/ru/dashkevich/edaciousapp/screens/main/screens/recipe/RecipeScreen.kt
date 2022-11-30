package ru.dashkevich.edaciousapp.screens.main.screens.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.dashkevich.edaciousapp.navigaiton.navigateToCharacteristic
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.components.RecipeCard
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.model.RecipeAction
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.model.RecipeEvent
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.model.RecipeViewState
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun RecipeScreen(mainNavController: NavHostController, recipeViewModel: RecipeViewModel) {

    val viewState by recipeViewModel.viewState.observeAsState(RecipeViewState())
    val recipes = viewState.recipesState.value
    //TODO(Internet state)
    val stateRecipes = viewState.recipesState.state

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 18.dp, start = 12.dp, end = 12.dp, top = 18.dp)
    ) {
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "All the latest recipe",
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = Theme.colors.defaultTextColor,
                        fontWeight = FontWeight.Medium
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Find all the recent & trending food recipe below",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Theme.colors.secondaryTextColor
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }


        //TODO(Подключить user)
        items(recipes.size) { index ->
            val recipe = recipes[index]
            RecipeCard(
                modifier = Modifier.padding(top = 18.dp),
                recipe = recipe, name = "Kirill", surname = "Pizza",
                onClick = {
                    recipeViewModel.obtainEvent(RecipeEvent.CardClicked(recipe))
                }
            )
        }
    }
    LaunchedEffect(key1 = viewState.recipeAction){
        when(val recipeAction = viewState.recipeAction){
            RecipeAction.None -> {}
            is RecipeAction.OpenCharacteristicScreen -> {
                mainNavController.navigateToCharacteristic(recipeAction.recipe)
            }
        }
    }


    DisposableEffect(Unit){
        onDispose {
            recipeViewModel.obtainEvent(RecipeEvent.CharacteristicInvoked)
        }
    }
}














