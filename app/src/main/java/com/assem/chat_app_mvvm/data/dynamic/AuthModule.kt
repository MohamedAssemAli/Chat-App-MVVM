package com.assem.chat_app_mvvm.data.dynamic

import com.androiddevs.mvvmnewsapp.util.Result
import com.assem.chat_app_mvvm.data.models.User
import com.google.firebase.auth.FirebaseUser


/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

interface AuthModule {

    suspend fun login(email: String, password: String): Result<Boolean>

    suspend fun signUpWithEmailAndPassword(email: String, password: String):  Result<Boolean>

    suspend fun getCurrentUser():  Result<FirebaseUser?>

    suspend fun getCurrentUserId(): Result<String?>

    suspend fun isLoggedIn(): Boolean

    suspend fun isUserExistedInDatabase(id: String): Result<Boolean>

    suspend fun signUpUser(user: User):  Result<Boolean>
}