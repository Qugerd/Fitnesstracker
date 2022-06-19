package com.example.fitnesstracker.MVP

interface LoginView {

    fun showLoginError()

    fun showPasswordError()

    fun showToast(message: String)

    fun saveToken(token: String)

}