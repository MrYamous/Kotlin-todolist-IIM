package com.example.todokotlin.domain

import org.junit.Assert.*
import org.junit.Test

class PasswordUtilsTest {

    @Test
    fun isPasswordValid() {

        val shortpass = "Gok"
        val longpass = "GH3ç(ufbzo"

        val firstcase = PasswordUtils.isPasswordValid(shortpass)
        val secondcase = PasswordUtils.isPasswordValid(longpass)

        assertEquals(false, firstcase)
        assertEquals(true, secondcase)
    }
}