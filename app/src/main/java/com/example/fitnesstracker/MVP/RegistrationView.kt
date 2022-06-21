package com.example.fitnesstracker.MVP

interface RegistrationView {

    fun showLoginError()

    fun showPasswordError()

    fun showNameError()

    fun showToast(message: String)

    fun saveToken(token: String)

}