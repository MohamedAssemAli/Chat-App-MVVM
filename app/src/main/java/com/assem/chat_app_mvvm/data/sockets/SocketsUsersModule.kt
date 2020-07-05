package com.assem.chat_app_mvvm.data.sockets

import com.androiddevs.mvvmnewsapp.util.Result
import com.assem.chat_app_mvvm.data.dynamic.UsersModule
import com.assem.chat_app_mvvm.data.models.User

/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

class SocketsUsersModule() : UsersModule {
    override suspend fun getUsers(): Result<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserChats(): Result<List<User>> {
        TODO("Not yet implemented")
    }

}