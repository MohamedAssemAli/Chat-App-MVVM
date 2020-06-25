package com.assem.chat_app_mvvm.data.repository

import com.assem.chat_app_mvvm.data.dynamic.AuthModule
import com.assem.chat_app_mvvm.data.models.User
import com.google.firebase.auth.FirebaseUser


/**
 * Created by Mohamed Assem on 24-Jun-20.
 * mo7mad.assim@gmail.com
 */

class AuthRepositoryImpl(private val authModule: AuthModule) : AuthRepository {

    override fun login(email: String, password: String): Boolean {
        return authModule.login(email, password)
    }

    override fun getCurrentUser(): FirebaseUser? {
        return authModule.getCurrentUser()
    }

    override fun getCurrentUserId(): String? {
        return authModule.getCurrentUserId()
    }

    override fun isLoggedIn(): Boolean {
        return authModule.isLoggedIn()
    }

    override suspend fun isUserExistedInDatabase(id: String): Boolean {
        return authModule.isUserExistedInDatabase(id)
    }

    override suspend fun signUpUser(user: User): Boolean {
        return authModule.signUpUser(user)
    }
}