package ru.dashkevich.edaciousapp.screens.main.screens.recipe.model

import ru.dashkevich.edaciousapp.data.model.Meal

data class RecipeViewState(
    val likeFood: Boolean = false,
    val seeRecipe: Boolean = false,
    val recipesState: ElementsState<Meal> = ElementsState(),
    val errorMessage: String = "",
    val recipeAction: RecipeAction = RecipeAction.None,
    val recipeCharacteristic: Meal = Meal()
)

sealed class RecipeAction {
    object None: RecipeAction()
    class OpenCharacteristicScreen(val recipe: Meal): RecipeAction()
}



data class ElementsState<T>(
    val value: List<T> = emptyList(),
    val state: ResultState = ResultState.Waiting
)

enum class ResultState {
    Waiting, Loading, Success, Error, EmptyResult
}
