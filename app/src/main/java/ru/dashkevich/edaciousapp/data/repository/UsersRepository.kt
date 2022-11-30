package ru.dashkevich.edaciousapp.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.dashkevich.edaciousapp.data.model.User
import ru.dashkevich.edaciousapp.util.USER_COLLECTION
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UsersRepository @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun getUsersQuery(): Task<QuerySnapshot> {
        return withContext(dispatcher) {
            fireStore.collection(USER_COLLECTION).get()
        }
    }
}














