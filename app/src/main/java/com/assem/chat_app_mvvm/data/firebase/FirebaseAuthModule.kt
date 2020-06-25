package com.assem.chat_app_mvvm.data.firebase

import com.assem.chat_app_mvvm.data.dynamic.AuthModule
import com.assem.chat_app_mvvm.data.models.User
import com.assem.chat_app_mvvm.util.USERS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

class FirebaseAuthModule(
    private val firebaseAuth: FirebaseAuth, private val firestore: FirebaseFirestore
) : AuthModule {

    override fun login(email: String, password: String): Boolean {
        return firebaseAuth.signInWithEmailAndPassword(email, password).isSuccessful
    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun getCurrentUserId(): String? {
        return firebaseAuth.currentUser!!.uid
    }

    override fun isLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }

    override suspend fun isUserExistedInDatabase(uid: String): Boolean {
        return firestore.collection(USERS).document(uid)
            .get().await().exists()
    }

    override suspend fun signUpUser(user: User): Boolean {
        return try {
            firestore.collection(USERS).document(user.uid).set(user).await()
            true
        } catch (e: Exception) {
            false
        }
    }
}