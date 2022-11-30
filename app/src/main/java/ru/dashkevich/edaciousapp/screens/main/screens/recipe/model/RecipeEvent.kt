package ru.dashkevich.edaciousapp.screens.main.screens.recipe.model

import ru.dashkevich.edaciousapp.data.model.Meal

sealed class RecipeEvent{
    object LikeClicked: RecipeEvent()
    class CardClicked(val recipe: Meal): RecipeEvent()
    object CharacteristicInvoked : RecipeEvent()
}
