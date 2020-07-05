package com.assem.chat_app_mvvm.data.firebase

import com.androiddevs.mvvmnewsapp.util.Result
import com.assem.chat_app_mvvm.data.dynamic.UsersModule
import com.assem.chat_app_mvvm.data.models.User
import com.assem.chat_app_mvvm.util.USERS
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

class FirebaseUsersModule() : UsersModule {

    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun getUsers(): Result<List<User>> =
        suspendCoroutine { cont ->
            firestore.collection(USERS)
                .get()
                .addOnSuccessListener {
                    try {
                        cont.resume(Result.Success(it.toObjects()))
                    } catch (e: Exception) {
                        cont.resume(Result.Error(e))
                    }
                }.addOnFailureListener {
                    cont.resume(Result.Error(it))
                }
        }


    override suspend fun getUserChats(): Result<List<User>> {
        TODO("Not yet implemented")
    }


}