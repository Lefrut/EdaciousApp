package ru.dashkevich.edaciousapp.screens.main.model

sealed class MainEvent {
    object TopMenuTriggerClicked: MainEvent()
    object SearchClicked: MainEvent()
    object MapClicked: MainEvent()
    data class ItemMenuClicked(val index: Int = 0): MainEvent()
}