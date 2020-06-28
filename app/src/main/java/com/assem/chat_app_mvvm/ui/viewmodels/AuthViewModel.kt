package com.assem.chat_app_mvvm.ui.viewmodels

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.util.Resource
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

    val isLoggedIn: MutableLiveData<Resource<Boolean>> = MutableLiveData()

    init {
        isUserLoggedIn()
    }

    private fun isUserLoggedIn() = viewModelScope.launch {
        isLoggedIn.postValue(Resource.Loading())
        if (authRepository.isLoggedIn())
            isLoggedIn.postValue(Resource.Success(authRepository.isLoggedIn()))
        else
            isLoggedIn.postValue(Resource.Error("Error in signin"))
    }

    suspend fun isUserExistInDatabase(id: String): Boolean {
        return authRepository.isUserExistedInDatabase(id)
    }

    fun getCurrentUser(): FirebaseUser? {
        return authRepository.getCurrentUser()
    }

    suspend fun signUpUser(user: User): Boolean {
        return authRepository.signUpUser(user)
    }

}