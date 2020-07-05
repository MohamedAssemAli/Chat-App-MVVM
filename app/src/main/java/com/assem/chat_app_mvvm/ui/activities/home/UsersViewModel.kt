package com.assem.chat_app_mvvm.ui.activities.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assem.chat_app_mvvm.data.repository.UsersRepository
import kotlinx.coroutines.launch

class UsersViewModel(
    private val usersRepository: UsersRepository
) : ViewModel() {

    private fun getUsers() = viewModelScope.launch {
            usersRepository.getUserChats()
    }
}