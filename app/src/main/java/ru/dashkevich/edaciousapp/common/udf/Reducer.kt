package ru.dashkevich.edaciousapp.common.udf

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class Reducer<S,E>(stateValue: S){

    private val _state: MutableStateFlow<S> = MutableStateFlow(stateValue)
    val state: StateFlow<S> = _state

    abstract fun reduce(previousState: S, event: E)
}