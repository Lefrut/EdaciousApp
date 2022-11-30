package ru.dashkevich.edaciousapp.screens.main.screens.chats.model

sealed class ChatTabs(val title: String, number: Int) {
    object PopularAuthor : ChatTabs("POPULAR AUTHOR", 0)
    object RecentPeople : ChatTabs("RECENT PEOPLE", 1)
    object OtherAuthor : ChatTabs("OTHER AUTHOR", 2)


}

fun chatTabsValues(): List<ChatTabs> {
    return listOf(
        ChatTabs.PopularAuthor,
        ChatTabs.OtherAuthor,
        ChatTabs.RecentPeople
    )
}
