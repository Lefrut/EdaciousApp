package ru.dashkevich.edaciousapp.screens.waitingroom.model

enum class WaitRoomAction{
    SignUp, SignIn, None
}

data class WaitingRoomViewState(
    var waitRoomAction: WaitRoomAction = WaitRoomAction.None
)