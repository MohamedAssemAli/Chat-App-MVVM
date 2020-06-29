package com.assem.chat_app_mvvm.data.firebase

import com.androiddevs.mvvmnewsapp.util.Resource
import com.assem.chat_app_mvvm.data.dynamic.UsersModule
import com.assem.chat_app_mvvm.data.models.User
import com.assem.chat_app_mvvm.util.USERS
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

class FirebaseUsersModule() : UsersModule {

    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun getUsers(): Resource<ArrayList<User>> {
        val users = ArrayList<User>()
        return try {
            val productsSnapshot = firestore.collection(USERS)
                .get().await().documents
            for (productSnapshot in productsSnapshot) {
                users.add(productSnapshot.toObject(User::class.java)!!)
            }
            Resource.Success(users)
        } catch (e: Exception) {
            Resource.Error(e.toString(), null)
        }
    }

    override suspend fun getUserChats(): Resource<ArrayList<User>> {
        TODO("Not yet implemented")
    }


}