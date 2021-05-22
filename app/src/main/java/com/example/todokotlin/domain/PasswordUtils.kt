package com.example.todokotlin.domain

import android.util.Log

object PasswordUtils {

    fun isPasswordValid(password: String): Boolean {
        Log.i("password", (password.length > 6).toString())
        return password.length > 6
    }
}