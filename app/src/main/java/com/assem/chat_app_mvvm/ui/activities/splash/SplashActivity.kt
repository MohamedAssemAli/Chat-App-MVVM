package com.assem.chat_app_mvvm.ui.activities.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.util.Resource
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.data.repository.AuthRepositoryImpl
import com.assem.chat_app_mvvm.ui.activities.start.StartActivity
import com.assem.chat_app_mvvm.ui.viewmodels.AuthViewModel
import com.assem.chat_app_mvvm.ui.viewmodels.AuthViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val TAG = "SplashActivity"

    lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = ViewModelProvider(
            this,
            AuthViewModelFactory(AuthRepositoryImpl(1))
        ).get(AuthViewModel::class.java)

        viewModel.isLoggedIn.observe(this, Observer { isLoggedIn ->
            when (isLoggedIn) {
                is Resource.Loading -> {
                    splash_activity_progress_bar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    splash_activity_progress_bar.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    startActivity(Intent(this, StartActivity::class.java))
                    finish()
                }
            }
        })

    }
}