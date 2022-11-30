package ru.dashkevich.edaciousapp.screens.main

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import ru.dashkevich.edaciousapp.data.model.Meal
import ru.dashkevich.edaciousapp.navigaiton.model.MainNavTree
import ru.dashkevich.edaciousapp.navigaiton.model.TopMainNavTree
import ru.dashkevich.edaciousapp.screens.main.model.MainViewState
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.RCharacteristicViewModel
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.RCharacteristicScreen
import ru.dashkevich.edaciousapp.screens.main.screens.chats.ChatsScreen
import ru.dashkevich.edaciousapp.screens.main.screens.chats.ChatsViewModel
import ru.dashkevich.edaciousapp.screens.main.screens.feeds.FeedsScreen
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.RecipeScreen
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.RecipeViewModel
import ru.dashkevich.edaciousapp.ui.theme.Theme

@Composable
fun ContentMainScreen(modifier: Modifier = Modifier, viewState: MainViewState) {
    val mainNavController = rememberNavController()

    NavHost(
        modifier = modifier.background(color = Theme.colors.ternaryTextColor),
        navController = mainNavController,
        startDestination = TopMainNavTree.Recipe.route
    ) {
        composable(TopMainNavTree.Feeds.route) {
            val feedsViewModel = hiltViewModel<RecipeViewModel>()
            FeedsScreen(mainNavController = mainNavController, feedsViewModel = feedsViewModel)
        }
        composable(TopMainNavTree.Recipe.route) {
            val recipeViewModel = hiltViewModel<RecipeViewModel>()
            RecipeScreen(mainNavController = mainNavController, recipeViewModel = recipeViewModel)
        }
        composable(TopMainNavTree.Chats.route) {
            val chatsViewModel = hiltViewModel<ChatsViewModel>()
            ChatsScreen(chatsViewModel = chatsViewModel, mainNavController = mainNavController)
        }
        composable(TopMainNavTree.Favorite.route) {

        }
        composable(TopMainNavTree.Profile.route) {

        }
        composable(TopMainNavTree.Settings.route) {

        }
        composable(
            MainNavTree.RecipeCharacteristic.name + "/{recipe}",
            arguments = listOf(
                navArgument("recipe"){ type = NavType.StringType }
            )
        ) {
            val rCharacteristicViewModel = hiltViewModel<RCharacteristicViewModel>()
            it.arguments?.getString("recipe")?.let { jsonRecipe ->
                val recipe = Gson().fromJson(jsonRecipe, Meal::class.java)
                RCharacteristicScreen(
                    rCharacteristicViewModel = rCharacteristicViewModel,
                    meal = recipe
                )
            }
        }
    }

    LaunchedEffect(key1 = viewState.useMenuItems) {
        viewState.useMenuItems.forEach { item ->
            if (item.second) {
                mainNavController.navigate(item.first.route) {
                    mainNavController.popBackStack()
                }
            }
        }
    }
}

