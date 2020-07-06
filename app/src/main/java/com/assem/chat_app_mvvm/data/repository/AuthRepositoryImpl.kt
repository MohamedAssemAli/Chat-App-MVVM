package com.assem.chat_app_mvvm.data.repository

import com.androiddevs.mvvmnewsapp.util.Result
import com.assem.chat_app_mvvm.data.dynamic.AuthModule
import com.assem.chat_app_mvvm.data.firebase.FirebaseAuthModule
import com.assem.chat_app_mvvm.data.models.User
import com.assem.chat_app_mvvm.data.sockets.SocketsAuthModule
import com.google.firebase.auth.FirebaseUser


/**
 * Created by Mohamed Assem on 24-Jun-20.
 * mo7mad.assim@gmail.com
 */

class AuthRepositoryImpl(dataSourceFLag: Int) : AuthRepository {

    private lateinit var authModule: AuthModule

    init {
        getDataSourceImp(dataSourceFLag)
    }

    override suspend fun login(email: String, password: String): Result<Boolean> {
        return authModule.login(email, password)
    }

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Result<Boolean> {
        return authModule.signUpWithEmailAndPassword(email, password)
    }

    override suspend fun getCurrentUser(): Result<FirebaseUser?> {
        return authModule.getCurrentUser()
    }

    override suspend fun getCurrentUserId(): Result<String?> {
        return authModule.getCurrentUserId()
    }

    override suspend fun isLoggedIn(): Boolean {
        return authModule.isLoggedIn()
    }

    override suspend fun isUserExistedInDatabase(id: String): Result<Boolean> {
        return authModule.isUserExistedInDatabase(id)
    }

    override suspend fun signUpUser(user: User): Result<Boolean> {
        return authModule.signUpUser(user)
    }

    private fun getDataSourceImp(dataSourceFLag: Int) {
        when (dataSourceFLag) {
            1 -> authModule = FirebaseAuthModule()
            2 -> authModule = SocketsAuthModule()
            else -> { // Note the block
                print("No data source provided")
            }
        }
    }
}