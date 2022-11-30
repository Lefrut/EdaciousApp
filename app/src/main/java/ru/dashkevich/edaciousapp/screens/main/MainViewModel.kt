package ru.dashkevich.edaciousapp.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.dashkevich.edaciousapp.common.EventHandler
import ru.dashkevich.edaciousapp.navigaiton.model.clearItemsMenu
import ru.dashkevich.edaciousapp.screens.main.model.MainEvent
import ru.dashkevich.edaciousapp.screens.main.model.MainViewState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel(), EventHandler<MainEvent> {

    private val _viewState: MutableLiveData<MainViewState> = MutableLiveData(MainViewState())
    val viewState: LiveData<MainViewState> = _viewState

    override fun obtainEvent(event: MainEvent) {
        when (event) {
            MainEvent.MapClicked -> {
                TODO("Create map clicked")
            }
            MainEvent.SearchClicked -> {
                TODO("Search recipe")
            }
            MainEvent.TopMenuTriggerClicked -> {
                _viewState.postValue(
                    _viewState.value?.expandedTopMenu?.let {
                        _viewState.value?.copy(expandedTopMenu = !it)
                    }
                )
            }
            is MainEvent.ItemMenuClicked -> {
                val newItemsMenu = clearItemsMenu.toMutableList()
                val newItem = Pair(newItemsMenu[event.index].first, true)
                newItemsMenu[event.index] = newItem
                _viewState.postValue(
                    _viewState.value?.copy(useMenuItems = newItemsMenu, expandedTopMenu = false)
                )
            }
        }
    }


}