package ru.dashkevich.edaciousapp.common.udf

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import ru.dashkevich.edaciousapp.screens.main.model.MainEvent
import ru.dashkevich.edaciousapp.screens.main.model.MainViewState

class MainVM : ViewModel() {

    private val reducer = MainReducer(MainViewState())

    val state: StateFlow<MainViewState> = reducer.state

    fun reduce(event: MainEvent) {
        reducer.reduce(state.value, event)
    }

    private class MainReducer(state: MainViewState) : Reducer<MainViewState, MainEvent>(state) {
        override fun reduce(previousState: MainViewState, event: MainEvent) {
            when (event) {
                is MainEvent.ItemMenuClicked -> {

                }
                MainEvent.MapClicked -> {

                }
                MainEvent.SearchClicked -> {

                }
                MainEvent.TopMenuTriggerClicked -> {

                }
            }
        }

    }

}

fun testing() {

    val vm = MainVM()
    vm.reduce(MainEvent.MapClicked)


}