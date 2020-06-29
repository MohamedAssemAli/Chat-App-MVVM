package com.assem.chat_app_mvvm.data.repository

import com.assem.chat_app_mvvm.data.models.User
import com.google.firebase.auth.FirebaseUser


/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

interface AuthRepository {

    suspend fun login(email: String, password: String): Boolean

    suspend fun signUpWithEmailAndPassword(email: String, password: String): Boolean

    suspend fun getCurrentUser(): FirebaseUser?

    suspend fun getCurrentUserId(): String?

    suspend fun isLoggedIn(): Boolean

    suspend fun isUserExistedInDatabase(id: String): Boolean

    suspend fun signUpUser(user: User): Boolean
}