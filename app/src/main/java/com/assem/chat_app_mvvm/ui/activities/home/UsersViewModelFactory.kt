package com.assem.chat_app_mvvm.ui.activities.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assem.chat_app_mvvm.data.repository.UsersRepositoryImp

class UsersViewModelFactory(private val usersRepository: UsersRepositoryImp) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel(
            usersRepository
        ) as T
    }
}