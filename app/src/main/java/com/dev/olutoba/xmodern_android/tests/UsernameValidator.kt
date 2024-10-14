package com.dev.olutoba.xmodern_android.tests


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 14 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

class UsernameValidator {

    private val users = listOf("Olutoba", "Damola", "Onikoyi")

    operator fun invoke(username: String): Boolean {
        if (username.isEmpty()) {
            return false
        }

        if (username.contains(" ")) {
            return false
        }

        if (users.contains(username)) {
            return false
        }

        return true
    }

}