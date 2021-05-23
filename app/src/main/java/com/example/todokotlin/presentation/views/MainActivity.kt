package com.example.todokotlin.presentation.views

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.todokotlin.R
import com.example.todokotlin.domain.GlobalConstants

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        sharedPref = getSharedPreferences(GlobalConstants.SHARED_PREF_KEY, Context.MODE_PRIVATE)
        val firstname = sharedPref.getString(GlobalConstants.KEY_FIRSTNAME, null)
        val lastname = sharedPref.getString(GlobalConstants.KEY_LASTNAME, null)
        if (firstname != null && lastname != null) {
            navigateMainToTodoList()
        }
    }

    fun navigateMainToSignin() {
        navController.navigate(R.id.action_mainFragment_to_signinFragment)
    }

    fun navigateMainToTodoList() {
        navController.navigate(R.id.action_mainFragment_to_todoFragment)
    }

    fun navigateSigninToTodoList() {
        navController.navigate(R.id.action_signinFragment_to_todoFragment)
    }
}