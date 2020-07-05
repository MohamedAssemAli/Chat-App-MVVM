package com.assem.chat_app_mvvm.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.data.repository.AuthRepositoryImpl
import com.assem.chat_app_mvvm.data.repository.UsersRepositoryImp
import com.assem.chat_app_mvvm.ui.activities.home.UsersViewModel
import com.assem.chat_app_mvvm.ui.activities.home.UsersViewModelFactory
import com.assem.chat_app_mvvm.ui.activities.start.AuthViewModel
import com.assem.chat_app_mvvm.ui.activities.start.AuthViewModelFactory

class UsersListFragment : Fragment() {

    private lateinit var viewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            UsersViewModelFactory(
                UsersRepositoryImp(1)
            )
        ).get(UsersViewModel::class.java)
    }

}