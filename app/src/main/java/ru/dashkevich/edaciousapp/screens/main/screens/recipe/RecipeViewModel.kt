package ru.dashkevich.edaciousapp.screens.main.screens.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.dashkevich.edaciousapp.common.EventHandler
import ru.dashkevich.edaciousapp.data.repository.MealRepository
import ru.dashkevich.edaciousapp.screens.main.screens.recipe.model.*
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val mealRepository: MealRepository
) : ViewModel(), EventHandler<RecipeEvent> {


    private val _viewState: MutableLiveData<RecipeViewState> = MutableLiveData(RecipeViewState())
    val viewState: LiveData<RecipeViewState> = _viewState

    init {
        getRecipes()
    }

    override fun obtainEvent(event: RecipeEvent) {
        when (event) {
            RecipeEvent.LikeClicked -> {

            }
            is RecipeEvent.CardClicked -> {
                _viewState.postValue(
                    viewState.value?.copy(recipeAction = RecipeAction.OpenCharacteristicScreen(event.recipe))
                )
            }
            RecipeEvent.CharacteristicInvoked -> {
                _viewState.postValue(
                    viewState.value?.copy(recipeAction = RecipeAction.None)
                )
            }
        }
    }

    private fun getRecipes() {
        viewModelScope.launch {
            _viewState.postValue(
                viewState.value?.copy(recipesState = ElementsState(state = ResultState.Loading))
            )
            delay(300)
            mealRepository.getMeals()
                .onSuccess { meals ->
                    Log.d("Firebase", "Recipes in ViewModel: $meals")
                    if (meals.isEmpty()) {
                        _viewState.postValue(
                            viewState.value?.copy(
                                recipesState = ElementsState(state = ResultState.EmptyResult)
                            )
                        )
                    } else {
                        _viewState.postValue(
                            viewState.value?.copy(
                                recipesState = ElementsState(meals, ResultState.Success)
                            )
                        )
                    }
                }.onFailure {
                    Log.e("Firebase", "Error in ViewModel: ${it.message}")
                    _viewState.postValue(
                        viewState.value?.copy(recipesState = ElementsState(state = ResultState.Error))
                    )
                }
        }

    }
}
