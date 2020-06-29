package com.assem.chat_app_mvvm.data.repository

import com.androiddevs.mvvmnewsapp.util.Resource
import com.assem.chat_app_mvvm.data.models.User


/**
 * Created by Mohamed Assem on 29-Jun-20.
 * mo7mad.assim@gmail.com
 */

interface UsersRepository {

    suspend fun getUsers(): Resource<ArrayList<User>>

    suspend fun getUserChats(): Resource<ArrayList<User>>

}