package com.assem.chat_app_mvvm.data.repository

import com.androiddevs.mvvmnewsapp.util.Resource
import com.assem.chat_app_mvvm.data.dynamic.UsersModule
import com.assem.chat_app_mvvm.data.firebase.FirebaseUsersModule
import com.assem.chat_app_mvvm.data.models.User
import com.assem.chat_app_mvvm.data.sockets.SocketsUsersModule


/**
 * Created by Mohamed Assem on 29-Jun-20.
 * mo7mad.assim@gmail.com
 */

class UsersRepositoryImp(dataSourceFLag: Int) : UsersRepository {

    private lateinit var usersModule: UsersModule

    init {
        getDataSourceImp(dataSourceFLag)
    }

    override suspend fun getUsers(): Resource<ArrayList<User>> {
        return usersModule.getUsers()
    }

    override suspend fun getUserChats(): Resource<ArrayList<User>> {
        TODO("Not yet implemented")
    }

    private fun getDataSourceImp(dataSourceFLag: Int) {
        when (dataSourceFLag) {
            1 -> usersModule = FirebaseUsersModule()
            2 -> usersModule = SocketsUsersModule()
            else -> { // Note the block
                print("No data source provided")
            }
        }
    }
}