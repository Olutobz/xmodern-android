package com.dev.olutoba.xmodern_android.tests

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 14 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

class UsernameValidatorTest {

    private val usernameValidator = UsernameValidator()

    @Test
    fun `validate username with a valid username, returns true`() {
        val isValid = usernameValidator.invoke("Android")
        assertThat(isValid).isTrue()
    }

    @Test
    fun `validate username with a empty username, returns false`() {
        val isValid = usernameValidator.invoke("")
        assertThat(isValid).isFalse()
    }

    @Test
    fun `validate username with a username that has space, return false`() {
        val isValid = usernameValidator.invoke("Damola Onikoyi")
        assertThat(isValid).isFalse()
    }

    @Test
    fun `validate username with already used username, return false`() {
        val isValid = usernameValidator.invoke("Damola")
        assertThat(isValid).isFalse()
    }

}