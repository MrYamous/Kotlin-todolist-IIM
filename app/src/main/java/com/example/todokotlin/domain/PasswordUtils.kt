package com.example.todokotlin.domain

import android.util.Log

object PasswordUtils {

    fun isPasswordValid(password: String): Boolean {
        return password.length > 6
    }
}