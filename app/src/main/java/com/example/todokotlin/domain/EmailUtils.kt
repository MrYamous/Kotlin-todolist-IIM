package com.example.todokotlin.domain

object EmailUtils {

    fun isEmailValid(email: String): Boolean {
        return email.contains('@')
    }
}