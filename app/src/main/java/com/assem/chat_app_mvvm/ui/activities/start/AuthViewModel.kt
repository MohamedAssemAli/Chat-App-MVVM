package com.assem.chat_app_mvvm.ui.activities.start

import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.util.Result
import com.assem.chat_app_mvvm.data.models.User
import com.assem.chat_app_mvvm.data.repository.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch


/**
 * Created by Mohamed Assem on 25-Jun-20.
 * mo7mad.assim@gmail.com
 */

class AuthViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    val isLoggedIn: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessfulLogin: MutableLiveData<Result<Boolean>> = MutableLiveData()

    init {
        isUserLoggedIn()
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        isSuccessfulLogin.postValue(authRepository.login(email, password))
    }


    private fun isUserLoggedIn() = viewModelScope.launch {
        isLoggedIn.postValue(authRepository.isLoggedIn())
    }

    suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<Boolean> {
        return authRepository.signUpWithEmailAndPassword(email, password)
    }

    suspend fun isUserExistInDatabase(id: String): Result<Boolean> {
        return authRepository.isUserExistedInDatabase(id)
    }

    suspend fun getCurrentUser(): Result<FirebaseUser?> {
        return authRepository.getCurrentUser()
    }

    suspend fun signUpUser(user: User): Result<Boolean> {
        return authRepository.signUpUser(user)
    }

}