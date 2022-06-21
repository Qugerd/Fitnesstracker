package com.example.fitnesstracker.MVP


import androidx.navigation.NavController
import com.example.fitnesstracker.DTO.RegisterDTO
import com.example.fitnesstracker.Network.LoginService
import com.example.fitnesstracker.R


class RegistrationPresenter {

    private var view: RegistrationView? = null
    private var navController: NavController? = null
    private val loginService = LoginService()

    fun setNavController(contr: NavController){
        this.navController = contr
    }

    fun attachView(view: RegistrationView){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }

    fun onRegistrationClicked(
        login: String,
        password: String,
        name: String,
        gender: Int
    ){
        if(login.isBlank()){
            view?.showLoginError()
            return
        }

        if(name.isBlank()){
            view?.showNameError()
            return
        }

        if(password.isBlank()){
            view?.showPasswordError()
            return
        }

        if (!(gender == 0 || gender == 1 || gender == 2)){
            view?.showToast("Выберите пол")
            return
        }

        loginService.register(login, password, name, gender, object : LoginService.LoginCallback{
            override fun onSuccess(result: RegisterDTO) {
                view?.saveToken(result.token)
                navController?.navigate(R.id.action_registrationPage_to_activityFragment)
            }

            override fun onError(error: Throwable) {
                view?.showToast(error.toString())
            }

        })
    }


}