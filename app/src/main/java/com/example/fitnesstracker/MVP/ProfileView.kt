package com.example.fitnesstracker.MVP

interface ProfileView {

    fun showToast(message: String)

    fun getToken():String?

    fun getData(
        name: String,
        login: String,
        token: String
    )

}