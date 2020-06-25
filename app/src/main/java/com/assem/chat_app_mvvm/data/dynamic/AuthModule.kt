package com.assem.chat_app_mvvm.data.dynamic

import com.assem.chat_app_mvvm.data.models.User
import com.google.firebase.auth.FirebaseUser


/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

interface AuthModule {

    fun login(email: String, password: String): Boolean

    fun getCurrentUser(): FirebaseUser?

    fun getCurrentUserId(): String?

    fun isLoggedIn(): Boolean

    suspend fun isUserExistedInDatabase(id: String): Boolean

    suspend fun signUpUser(user: User): Boolean
}