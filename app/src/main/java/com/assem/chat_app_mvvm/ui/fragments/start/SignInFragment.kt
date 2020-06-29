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
import com.assem.chat_app_mvvm.ui.activities.HomeActivity
import com.assem.chat_app_mvvm.ui.activities.StartActivity
import com.assem.chat_app_mvvm.ui.viewmodels.AuthViewModel
import com.assem.chat_app_mvvm.util.validateEmail
import com.assem.chat_app_mvvm.util.validatePassword
import com.assem.chat_app_mvvm.util.validateUsername
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.coroutines.launch

class SignInFragment : Fragment() {

    lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as StartActivity).viewModel

        fragment_sign_in_sign_in_button.setOnClickListener {
            signIn()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    private fun signIn() {
        requireActivity().activity_start_progress_bar.visibility = View.VISIBLE
        if (validateInput()) {
            lifecycleScope.launch {
                if (viewModel.login(
                        fragment_sign_in_email_text_input_edit_text.text.toString(),
                        fragment_sign_in_password_text_input_edit_text.text.toString()
                    )

                ) {
                    requireActivity().activity_start_progress_bar.visibility = View.GONE
                    startActivity(Intent(requireActivity(), HomeActivity::class.java))
                    requireActivity().finish()

                } else {
                    requireActivity().activity_start_progress_bar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Error in signin",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        } else {
            requireActivity().activity_start_progress_bar.visibility = View.GONE
        }
    }

    private fun validateInput(): Boolean {
        var isValid = true
        if (!validateEmail(fragment_sign_in_email_text_input_edit_text)) {
            fragment_sign_in_email_text_input_edit_text.error =
                getString(R.string.invalid_email)
            isValid = false
        }
        if (!validatePassword(fragment_sign_in_password_text_input_edit_text)) {
            fragment_sign_in_password_text_input_edit_text.error =
                getString(R.string.invalid_password)
            isValid = false
        }
        return isValid
    }
}