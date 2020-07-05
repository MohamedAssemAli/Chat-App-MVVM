package com.assem.chat_app_mvvm.data.dynamic

import com.androiddevs.mvvmnewsapp.util.Result
import com.assem.chat_app_mvvm.data.models.User


/**
 * Created by Mohamed Assem on 29-Jun-20.
 * mo7mad.assim@gmail.com
 */

interface UsersModule {

    suspend fun getUsers(): Result<List<User>>

    suspend fun getUserChats(): Result<List<User>>

}