package ru.dashkevich.edaciousapp.screens.main.screens.feeds

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.dashkevich.edaciousapp.common.EventHandler
import ru.dashkevich.edaciousapp.screens.main.screens.feeds.model.FeedsEvent
import ru.dashkevich.edaciousapp.screens.main.screens.feeds.model.FeedsViewState
import javax.inject.Inject


@HiltViewModel
class FeedsViewModel @Inject constructor(): ViewModel(), EventHandler<FeedsEvent> {

    private val _viewState: MutableLiveData<FeedsViewState> = MutableLiveData(FeedsViewState())
    val viewState: LiveData<FeedsViewState> = _viewState

    override fun obtainEvent(event: FeedsEvent) {

    }

}