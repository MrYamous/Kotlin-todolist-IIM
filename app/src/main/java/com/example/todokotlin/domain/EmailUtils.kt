package com.example.todokotlin.domain

import android.util.Log

object EmailUtils {

    fun isEmailValid(email: String): Boolean {
        return email.contains('@')
    }
}