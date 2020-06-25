package com.assem.chat_app_mvvm.ui.activities.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.ui.viewmodels.AuthViewModel

class SplashActivity : AppCompatActivity() {

    lateinit var viewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        val authRepository =  AuthRepository
//        val viewModelProviderFactory = AuthViewModelFactory(AuthRepository::class.java)
//        viewModel = ViewModelProvider(this, viewModelProviderFactory)
//            .get(AuthViewModel::class.java)

    }
}