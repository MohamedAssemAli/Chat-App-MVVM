package com.assem.chat_app_mvvm.data.sockets

import com.androiddevs.mvvmnewsapp.util.Resource
import com.assem.chat_app_mvvm.data.dynamic.AuthModule
import com.assem.chat_app_mvvm.data.dynamic.UsersModule
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

class SocketsUsersModule() : UsersModule {
    override suspend fun getUsers(): Resource<ArrayList<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserChats():  Resource<ArrayList<User>> {
        TODO("Not yet implemented")
    }

}