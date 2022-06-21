package com.example.fitnesstracker.MVP

interface RegistrationView {

    fun showLoginError()

    fun showNameError()

    fun showPasswordError()

    fun showToast(message: String)

    fun saveToken(token: String)

}