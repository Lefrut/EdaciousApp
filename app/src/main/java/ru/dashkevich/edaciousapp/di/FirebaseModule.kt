package ru.dashkevich.edaciousapp.di

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.dashkevich.edaciousapp.util.MEAL_COLLECTION
import ru.dashkevich.edaciousapp.util.USER_COLLECTION
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Provides
    @Singleton
    fun fireStore() : FirebaseFirestore = FirebaseFirestore.getInstance()

}