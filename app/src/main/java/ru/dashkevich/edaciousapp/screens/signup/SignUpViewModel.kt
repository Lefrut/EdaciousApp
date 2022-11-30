package ru.dashkevich.edaciousapp.screens.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.dashkevich.edaciousapp.common.EventHandler
import ru.dashkevich.edaciousapp.data.repository.CountryRepository
import ru.dashkevich.edaciousapp.screens.signup.model.LoginAction
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpEvent
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViewState
import ru.dashkevich.edaciousapp.screens.signup.model.SignUpViews
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel(), EventHandler<SignUpEvent> {

    private val _viewState = MutableLiveData(SignUpViewState())
    val viewState: LiveData<SignUpViewState> = _viewState

    init {
        getAllCountries()
    }

    override fun obtainEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.CountryChoice -> {
                _viewState.postValue(
                    _viewState.value?.copy(
                        nameCountry = event.value1,
                        expandedCountryMenu = event.value2
                    )
                )
            }
            is SignUpEvent.CountryDropMenuClicked -> {
                _viewState.postValue(_viewState.value?.copy(expandedCountryMenu = event.value))
                if (event.value) {
                    getAllCountries()
                }
            }

            is SignUpEvent.PhoneNumberChanged -> {
                _viewState.postValue(_viewState.value?.copy(phoneNumber = event.value))
            }
            is SignUpEvent.NextScreenClicked -> {
                var nextView = SignUpViews.values()[_viewState.value?.screenState!!.ordinal]
                if (nextView.ordinal + 1 < SignUpViews.values().size) {
                    nextView = SignUpViews.values()[_viewState.value?.screenState!!.ordinal + 1]
                    _viewState.postValue(
                        _viewState.value?.copy(
                            screenState = nextView
                        )
                    )
                } else {
                    _viewState.postValue(_viewState.value?.copy(loginAction = LoginAction.OpenMainScreen))
                }
            }
            is SignUpEvent.CodeChanged -> {
                _viewState.postValue(_viewState.value?.copy(code = event.value))
            }
            is SignUpEvent.LoginActionInvoked -> {
                _viewState.postValue(_viewState.value?.copy(loginAction = LoginAction.None))
            }
        }
    }


    private fun getAllCountries() {
        viewModelScope.launch {
            countryRepository.getAllCountries()
                .onSuccess {
                    _viewState.postValue(_viewState.value?.copy(countries = it))
                    it.let { list -> Log.e("InternetMessage", list.toString()) }
                }.onFailure {
                    it.message?.let { message -> Log.e("InternetMessage", message) }
                }
        }
    }

}