package ru.dashkevich.edaciousapp.common

interface EventHandler<E> {
    fun obtainEvent(event: E)
}