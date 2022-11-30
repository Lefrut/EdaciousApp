package ru.dashkevich.edaciousapp.screens.main.screens.chats.model

sealed class ChatsEvent {
    class TabClicked(val tab: ChatTabs) : ChatsEvent()
}
