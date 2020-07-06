package com.assem.chat_app_mvvm.ui.activities.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.util.Result
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.data.repository.AuthRepositoryImpl
import com.assem.chat_app_mvvm.ui.activities.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    private val TAG = "SplashActivity"

    lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = ViewModelProvider(
            this,
            AuthViewModelFactory(
                AuthRepositoryImpl(1)
            )
        ).get(AuthViewModel::class.java)

        viewModel.isLoggedIn.observe(this, Observer { isLoggedIn ->
            if (isLoggedIn) {

                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, StartActivity::class.java))
                finish()
            }
        })

    }
}