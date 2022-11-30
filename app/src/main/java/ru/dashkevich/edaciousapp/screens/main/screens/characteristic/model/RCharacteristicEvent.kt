package ru.dashkevich.edaciousapp.screens.main.screens.characteristic.model

sealed class RCharacteristicEvent {
    data class TabClicked(val value: MealTabItem) : RCharacteristicEvent()
}