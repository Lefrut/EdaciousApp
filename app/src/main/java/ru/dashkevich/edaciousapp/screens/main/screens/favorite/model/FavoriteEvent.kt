package ru.dashkevich.edaciousapp.screens.main.screens.favorite.model

import ru.dashkevich.edaciousapp.data.model.Meal

sealed class FavoriteEvent{
    class CardClicked(val recipe: Meal): FavoriteEvent()
    object HeartIconClicked : FavoriteEvent()
}
