package ru.dashkevich.edaciousapp.common.udf

import kotlinx.coroutines.flow.Flow

interface FlowLoader<T> {

    fun loadNewestPage(): Flow<T>

    fun loadFirstPage(): Flow<T>

    fun loadNextPage(): Flow<T>

    fun loadProductsOfCategory(): Flow<T>

}