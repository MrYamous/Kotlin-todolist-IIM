package com.example.todokotlin.presentation.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.todokotlin.R
import com.example.todokotlin.domain.EmailUtils
import com.example.todokotlin.domain.GlobalConstants
import com.example.todokotlin.domain.PasswordUtils
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_to_do_list.*

class ToDoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = activity?.getSharedPreferences(GlobalConstants.SHARED_PREF_KEY, Context.MODE_PRIVATE)
        val firstname = sharedPref?.getString(GlobalConstants.KEY_FIRSTNAME, null)
        val lastname = sharedPref?.getString(GlobalConstants.KEY_LASTNAME, null)

        todo_greetings.text = "Bonjour $firstname $lastname"
    }
}