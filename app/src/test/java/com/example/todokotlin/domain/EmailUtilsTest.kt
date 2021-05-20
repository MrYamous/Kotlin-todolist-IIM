package com.example.todokotlin.domain

import org.junit.Test
import org.junit.Assert.*

class EmailUtilsTest {

    @Test
    fun isEmailValid() {

        val correctmail = "mail@exemple.com"
        val wrongmail = "mail.fr"

        val firstcase = EmailUtils.isEmailValid(correctmail)
        val secondcase = EmailUtils.isEmailValid(wrongmail)

        assertEquals(true, firstcase)
        assertEquals(false, secondcase)
    }
}