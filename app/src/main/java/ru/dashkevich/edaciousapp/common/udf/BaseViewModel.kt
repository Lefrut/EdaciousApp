package ru.dashkevich.edaciousapp.common.udf

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

abstract class BaseViewModel<S,E> : ViewModel() {

    abstract val state: Flow<S>



}

interface UiEvent {

}

interface UiState {

}
