package com.example.fitnesstracker.MVP

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.fitnesstracker.DTO.RegisterDTO
import com.example.fitnesstracker.Network.LoginService
import com.example.fitnesstracker.R

class LoginPresenter {

    private var view: LoginView? = null
    private var navController: NavController? = null
    private val loginService = LoginService()

    fun setNavController(contr: NavController){
        this.navController = contr
    }

    fun attachView(view: LoginView){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }

    fun onLoginClicked(login: String, password: String){
        if(login.isBlank()){
            view?.showLoginError()
            return
        }

        if(password.isBlank()){
            view?.showPasswordError()
            return
        }

        loginService.login(login, password, object : LoginService.LoginCallback{
            override fun onSuccess(result: RegisterDTO) {
                view?.saveToken(result.token)
                navController?.navigate(R.id.action_login_to_activityFragment)
            }

            override fun onError(error: Throwable) {
                view?.showToast(error.toString())
            }

        })
    }

}