package ru.dashkevich.edaciousapp.screens.waitingroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.dashkevich.edaciousapp.common.EventHandler
import ru.dashkevich.edaciousapp.screens.waitingroom.model.WaitRoomAction
import ru.dashkevich.edaciousapp.screens.waitingroom.model.WaitingRoomEvent
import ru.dashkevich.edaciousapp.screens.waitingroom.model.WaitingRoomViewState
import javax.inject.Inject

@HiltViewModel
class WaitingRoomViewModel @Inject constructor() : ViewModel(), EventHandler<WaitingRoomEvent> {

    // После доработки подумать над Flow
    private val _viewState = MutableLiveData(WaitingRoomViewState())
    val viewState: LiveData<WaitingRoomViewState> = _viewState

    override fun obtainEvent(event: WaitingRoomEvent) {
        when(event){
            is WaitingRoomEvent.SignInClicked -> signInClicked()
            is WaitingRoomEvent.SignUpClicked -> signUpClicked()
            WaitingRoomEvent.RegistrationActionInvoked -> registrationActionInvoked()
        }
    }



    private fun signInClicked(){
        _viewState.postValue(_viewState.value?.copy(waitRoomAction = WaitRoomAction.SignIn))
    }

    private fun signUpClicked(){
        _viewState.postValue(_viewState.value?.copy(waitRoomAction = WaitRoomAction.SignUp))
    }

    private fun registrationActionInvoked() {
        _viewState.postValue(_viewState.value?.copy(waitRoomAction = WaitRoomAction.None))
    }



}