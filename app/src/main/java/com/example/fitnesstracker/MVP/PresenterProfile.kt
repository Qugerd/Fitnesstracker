package com.example.fitnesstracker.MVP

import com.example.fitnesstracker.DTO.UserDTO
import com.example.fitnesstracker.Network.LoginService


class PresenterProfile {

    private var viewProfile: ViewProfile? = null
    private val loginService = LoginService()

    fun attachView(viewProfile: ViewProfile){
        this.viewProfile = viewProfile
    }

    fun detachView(){
        this.viewProfile = null
    }

    fun onLogoutClicked(){
        loginService.logout("Bearer " + viewProfile?.getToken().toString(), object : LoginService.LogoutCallback{
            override fun onSuccess() {
            }

            override fun onError() {
            }
        })
    }

    fun onViewCreated(){
        loginService.profile("Bearer " + viewProfile?.getToken().toString(), object : LoginService.ProfileCallback{
            override fun onSuccess(result: UserDTO) {
                viewProfile?.getData(result.name, result.login, viewProfile?.getToken().toString())
            }

            override fun onError(error: Throwable) {
                viewProfile?.showToast(error.toString())
            }
        })
    }

}