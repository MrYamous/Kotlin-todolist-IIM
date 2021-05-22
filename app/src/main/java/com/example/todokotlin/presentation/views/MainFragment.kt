package com.example.todokotlin.presentation.views

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.todokotlin.R
import com.example.todokotlin.domain.EmailUtils
import com.example.todokotlin.domain.PasswordUtils
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        main_button_sign_in.setOnClickListener {
            (activity as MainActivity).navigateMainToSignin()
        }

        main_button_login.setOnClickListener {
            val mail: String = main_email.text.toString()
            val password: String = main_password.text.toString()
            if (EmailUtils.isEmailValid(mail) && PasswordUtils.isPasswordValid(password)) {
                (activity as MainActivity).navigateMainToTodoList()
            } else {
                Toast.makeText(activity, "Les informations de connexion sont incorrectes", Toast.LENGTH_SHORT).show()
            }
        }
    }
}