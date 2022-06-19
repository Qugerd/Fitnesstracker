package com.example.fitnesstracker.MVP

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.fitnesstracker.DTO.UserDTO
import com.example.fitnesstracker.Network.LoginService


class ProfilePresenter {

    private var view: ProfileView? = null
    private val loginService = LoginService()

    fun attachView(view: ProfileView){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }

    fun onLogoutClicked(){
        loginService.logout("Bearer " + view?.getToken().toString(), object : LoginService.LogoutCallback{
            override fun onSuccess() {
            }

            override fun onError() {
            }
        })
    }

    fun onViewCreated(){
        loginService.profile("Bearer " + view?.getToken().toString(), object : LoginService.ProfileCallback{
            override fun onSuccess(result: UserDTO) {
                view?.getData(result.name, result.login, view?.getToken().toString())
            }

            override fun onError(error: Throwable) {
                view?.showToast(error.toString())
            }
        })
    }

}