package ru.dashkevich.edaciousapp.screens.main.screens.favorite.model

import ru.dashkevich.edaciousapp.data.model.Meal
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.model.ElementsState

data class FavoriteViewState(
    val likedRecipes: ElementsState<Meal> = ElementsState(),
    val favoriteAction: FavoriteAction = FavoriteAction.None
)


