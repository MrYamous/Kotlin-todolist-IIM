package com.example.todokotlin.domain

import android.util.Log

object EmailUtils {

    fun isEmailValid(email: String): Boolean {
        Log.i("email", email.contains('@').toString())
        return email.contains('@')
    }
}