package com.example.todokotlin.presentation.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.todokotlin.R
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        main_button_sign_in.setOnClickListener {
            if (main_first_name.text.isNotEmpty()
                && main_last_name.text.isNotEmpty()
                && main_email.text.isNotEmpty()
                && main_password.text.isNotEmpty()) {
                (activity as MainActivity).navigateSigninToTodoList()
            } else {
                Toast.makeText(activity, "Il faut remplir tous les champs", Toast.LENGTH_SHORT).show()
            }
        }

    }
}