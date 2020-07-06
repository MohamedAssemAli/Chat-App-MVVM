package com.assem.chat_app_mvvm.data.firebase

import com.androiddevs.mvvmnewsapp.util.Result
import com.assem.chat_app_mvvm.data.dynamic.AuthModule
import com.assem.chat_app_mvvm.data.models.User
import com.assem.chat_app_mvvm.util.USERS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

class FirebaseAuthModule() : AuthModule {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun login(email: String, password: String): Result<Boolean> =
        suspendCoroutine {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    Result.Success(true)
                }
                .addOnFailureListener {
                    Result.Error(it)
                }
        }

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Result<Boolean> =
        suspendCoroutine {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    Result.Success(true)
                }
                .addOnFailureListener {
                    Result.Error(it)
                }
        }

    override suspend fun getCurrentUser(): Result<FirebaseUser?> {
        return Result.Success(firebaseAuth.currentUser)
    }

    override suspend fun getCurrentUserId(): Result<String?> {
        return Result.Success(firebaseAuth.currentUser!!.uid)
    }

    override suspend fun isLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }

    override suspend fun isUserExistedInDatabase(id: String): Result<Boolean> {
        return Result.Success(
            firestore.collection(USERS).document(id)
                .get().await().exists()
        )
    }

    override suspend fun signUpUser(user: User): Result<Boolean> =
        suspendCoroutine { cont ->
            firestore
                .collection(USERS)
                .document(user.uid).set(user)
                .addOnSuccessListener {
                    cont.resume(Result.Success(true))
                }
                .addOnFailureListener {
                    cont.resume(Result.Error(it))
                }
        }
}