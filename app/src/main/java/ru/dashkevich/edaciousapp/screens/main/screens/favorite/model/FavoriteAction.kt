package ru.dashkevich.edaciousapp.screens.main.screens.favorite.model

import ru.dashkevich.edaciousapp.data.model.Meal

sealed class FavoriteAction{
    object None: FavoriteAction()
    data class OpenCharacteristicScreen(val recipe: Meal) : FavoriteAction()
}
