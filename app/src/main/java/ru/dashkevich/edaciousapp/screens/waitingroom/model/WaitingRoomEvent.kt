package ru.dashkevich.edaciousapp.screens.waitingroom.model



sealed class WaitingRoomEvent{
    object SignUpClicked: WaitingRoomEvent()
    object SignInClicked: WaitingRoomEvent()
    object RegistrationActionInvoked: WaitingRoomEvent()
}