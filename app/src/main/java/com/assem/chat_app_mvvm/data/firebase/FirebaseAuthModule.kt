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

class FirebaseAuthModule() : AuthModule {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun login(email: String, password: String): Boolean {
//        TODO("Needs to be updated with Resource data type")
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            authResult.user != null
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun signUpWithEmailAndPassword(email: String, password: String): Boolean {
//        TODO("Needs to be updated with Resource data type")
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            authResult.user != null
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override suspend fun getCurrentUserId(): String? {
        return firebaseAuth.currentUser!!.uid
    }

    override suspend fun isLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }

    override suspend fun isUserExistedInDatabase(id: String): Boolean {
        return firestore.collection(USERS).document(id)
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