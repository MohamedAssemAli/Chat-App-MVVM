package com.assem.chat_app_mvvm.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assem.chat_app_mvvm.data.repository.UsersRepository

class UsersListViewModelFactory(private val usersRepository: UsersRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersListViewModel(
            usersRepository
        ) as T
    }
}