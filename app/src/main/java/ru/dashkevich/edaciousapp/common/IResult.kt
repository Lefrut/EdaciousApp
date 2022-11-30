package ru.dashkevich.edaciousapp.common

sealed class IResult<TD>() {
    data class Success<TD>(val data: TD, val message: String) : IResult<TD>()
    data class Error<TD>(val message: String) : IResult<TD>()
}