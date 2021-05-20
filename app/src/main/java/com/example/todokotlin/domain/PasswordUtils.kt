package com.example.todokotlin.domain

object PasswordUtils {

    fun isPasswordValid(password: String): Boolean {
        return password.length > 6
    }
}