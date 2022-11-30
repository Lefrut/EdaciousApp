package ru.dashkevich.edaciousapp.screens.main.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.dashkevich.edaciousapp.common.EventHandler
import ru.dashkevich.edaciousapp.screens.main.screens.favorite.model.FavoriteAction
import ru.dashkevich.edaciousapp.screens.main.screens.favorite.model.FavoriteEvent
import ru.dashkevich.edaciousapp.screens.main.screens.favorite.model.FavoriteViewState
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor() : ViewModel(), EventHandler<FavoriteEvent> {

    private val _viewState: MutableLiveData<FavoriteViewState> =
        MutableLiveData(FavoriteViewState())
    val viewState: LiveData<FavoriteViewState> = _viewState


    override fun obtainEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.HeartIconClicked -> {

            }
            is FavoriteEvent.CardClicked -> {
                _viewState.postValue(
                    viewState.value?.copy(
                        favoriteAction = FavoriteAction.OpenCharacteristicScreen(recipe = event.recipe)
                    )
                )
            }
        }
    }
}