package ru.dashkevich.edaciousapp.screens.signup.model

sealed class SignUpEvent {
    data class CountryChoice(val value1: String, val value2: Boolean): SignUpEvent()
    data class PhoneNumberChanged(val value: String): SignUpEvent()
    data class CountryDropMenuClicked(val value: Boolean) : SignUpEvent()
    object NextScreenClicked : SignUpEvent()
    object LoginActionInvoked : SignUpEvent()

    //object BackScreenClicked : SignUpEvent()
    data class CodeChanged(val value: String): SignUpEvent()

}