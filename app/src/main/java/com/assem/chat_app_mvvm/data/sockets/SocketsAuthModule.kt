package com.assem.chat_app_mvvm.data.sockets

import com.androiddevs.mvvmnewsapp.util.Result
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

class SocketsAuthModule() : AuthModule {
    override suspend fun login(email: String, password: String): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentUser(): Result<FirebaseUser?> {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentUserId(): Result<String?> {
        TODO("Not yet implemented")
    }

    override suspend fun isLoggedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun isUserExistedInDatabase(id: String): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun signUpUser(user: User): Result<Boolean> {
        TODO("Not yet implemented")
    }


}