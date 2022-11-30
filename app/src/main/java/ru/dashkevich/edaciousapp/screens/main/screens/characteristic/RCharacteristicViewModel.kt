package ru.dashkevich.edaciousapp.screens.main.screens.characteristic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.dashkevich.edaciousapp.common.EventHandler
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.model.RCharacteristicEvent
import ru.dashkevich.edaciousapp.screens.main.screens.characteristic.model.RCharacteristicViewState
import javax.inject.Inject

@HiltViewModel
class RCharacteristicViewModel @Inject constructor() : ViewModel(),
    EventHandler<RCharacteristicEvent> {

    private val _viewState: MutableLiveData<RCharacteristicViewState> =
        MutableLiveData(RCharacteristicViewState())
    val viewState: LiveData<RCharacteristicViewState> = _viewState

    override fun obtainEvent(event: RCharacteristicEvent) {
        when (event) {
            is RCharacteristicEvent.TabClicked -> {
                _viewState.postValue(_viewState.value?.copy(tabView = event.value))
            }
        }
    }


}