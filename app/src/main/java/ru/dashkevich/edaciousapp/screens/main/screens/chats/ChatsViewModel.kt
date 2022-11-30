package ru.dashkevich.edaciousapp.screens.main.screens.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dashkevich.edaciousapp.common.EventHandler
import ru.dashkevich.edaciousapp.screens.main.screens.chats.model.ChatsEvent
import ru.dashkevich.edaciousapp.screens.main.screens.chats.model.ChatsViewState

class ChatsViewModel: ViewModel(), EventHandler<ChatsEvent> {

    private val _viewState: MutableLiveData<ChatsViewState> = MutableLiveData(ChatsViewState())
    val viewState: LiveData<ChatsViewState> = _viewState

    override fun obtainEvent(event: ChatsEvent) {
        when(event){
            is ChatsEvent.TabClicked -> {
                _viewState.postValue(viewState.value?.copy(tabView = event.tab))
            }
        }
    }
}