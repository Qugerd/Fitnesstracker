package com.example.fitnesstracker.MVP


import android.content.SharedPreferences
import androidx.navigation.NavController
import com.example.fitnesstracker.DTO.RegisterDTO
import com.example.fitnesstracker.Network.LoginService
import com.example.fitnesstracker.R


class PresenterRegistration {


    private var view: ViewRegistration? = null
    private var navController: NavController? = null
    private val loginService = LoginService()

    fun setNavController(contr: NavController){
        this.navController = contr
    }

    fun attachView(view: ViewRegistration){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }

    fun onRegistrationClicked(login: String, password: String, passwordRepeat: String, name: String,
        gender: Int, sharedPrefs: SharedPreferences){

        if(login.isBlank()){
            view?.showLoginError()
            return
        }

        if(password.isBlank()){
            view?.showPasswordError()
            return
        }

        if(name.isBlank()){
            view?.showNameError()
            return
        }

        if (!(gender == 0 || gender == 1 || gender == 2)){
            view?.showToast("Пол не выбран")
            return
        }

        if(password != passwordRepeat){
            view?.showToast("Пароли не совпадают")
        }

        loginService.register(login, password, name, gender, object : LoginService.LoginCallback{
            override fun onSuccess(result: RegisterDTO) {
                sharedPrefs.edit()?.putString("Token", result.token)?.apply()
                navController?.navigate(R.id.action_registrationPage_to_activityFragment)
            }

            override fun onError(error: Throwable) {
                view?.showToast(error.toString())
            }
        })
    }
}