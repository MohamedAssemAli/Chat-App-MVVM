package com.assem.chat_app_mvvm.ui.fragments.start

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.data.models.User
import com.assem.chat_app_mvvm.ui.activities.home.HomeActivity
import com.assem.chat_app_mvvm.ui.activities.start.StartActivity
import com.assem.chat_app_mvvm.ui.activities.start.AuthViewModel
import com.assem.chat_app_mvvm.util.validateEmail
import com.assem.chat_app_mvvm.util.validatePassword
import com.assem.chat_app_mvvm.util.validateUsername
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {

    lateinit var viewModel: AuthViewModel
    lateinit var user: User

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as StartActivity).viewModel

        fragment_sign_up_sign_up_button.setOnClickListener {
            signUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    private fun signUp() {
//        requireActivity().activity_start_progress_bar.visibility = View.VISIBLE
//        if (validateInput()) {
//            user = User(
//                "Default",
//                fragment_sign_up_username_text_input_edit_text.text.toString(),
//                fragment_sign_up_email_text_input_edit_text.text.toString(),
//                fragment_sign_up_password_text_input_edit_text.text.toString(),
//                "Default"
//            )
//            user?.let {
//                lifecycleScope.launch {
//                    try {
//                        if (viewModel.signUpWithEmailAndPassword(user.email, user.password)) {
//                            user.uid = viewModel.getCurrentUser()!!.uid
//                            if (viewModel.signUpUser(user)) {
//                                Toast.makeText(
//                                    requireContext(),
//                                    "successful registration",
//                                    Toast.LENGTH_LONG
//                                )
//                                    .show()
//                                startActivity(Intent(requireActivity(), HomeActivity::class.java))
//                                requireActivity().finish()
//                            } else {
//                                Toast.makeText(
//                                    requireContext(),
//                                    "Error in registration",
//                                    Toast.LENGTH_LONG
//                                ).show()
//                                requireActivity().activity_start_progress_bar.visibility = View.GONE
//                            }
//                        } else {
//                            Toast.makeText(
//                                requireContext(),
//                                "Email is already taken",
//                                Toast.LENGTH_LONG
//                            ).show()
//                            requireActivity().activity_start_progress_bar.visibility = View.GONE
//                        }
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                    }
//                }
//            }
//        } else {
//            requireActivity().activity_start_progress_bar.visibility = View.GONE
//        }
    }

    private fun validateInput(): Boolean {
        var isValid = true
        if (!validateUsername(fragment_sign_up_username_text_input_edit_text)) {
            fragment_sign_up_username_text_input_edit_text.error =
                getString(R.string.invalid_username)
            isValid = false
        }
        if (!validateEmail(fragment_sign_up_email_text_input_edit_text)) {
            fragment_sign_up_email_text_input_edit_text.error =
                getString(R.string.invalid_email)
            isValid = false
        }
        if (!validatePassword(fragment_sign_up_password_text_input_edit_text)) {
            fragment_sign_up_password_text_input_edit_text.error =
                getString(R.string.invalid_password)
            isValid = false
        }
        return isValid
    }
}