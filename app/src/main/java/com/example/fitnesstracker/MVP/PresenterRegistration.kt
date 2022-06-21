package com.example.fitnesstracker.MVP


import androidx.navigation.NavController
import com.example.fitnesstracker.DTO.RegisterDTO
import com.example.fitnesstracker.Network.LoginService
import com.example.fitnesstracker.R


class PresenterRegistration {

    private var viewRegistration: ViewRegistration? = null
    private var navController: NavController? = null
    private val loginService = LoginService()

    fun setNavController(contr: NavController){
        this.navController = contr
    }

    fun attachView(viewRegistration: ViewRegistration){
        this.viewRegistration = viewRegistration
    }

    fun detachView(){
        this.viewRegistration = null
    }

    fun onRegistrationClicked(
        login: String,
        password: String,
        name: String,
        gender: Int
    ){
        if(login.isBlank()){
            viewRegistration?.showLoginError()
            return
        }

        if(name.isBlank()){
            viewRegistration?.showNameError()
            return
        }

        if(password.isBlank()){
            viewRegistration?.showPasswordError()
            return
        }

        if (!(gender == 0 || gender == 1 || gender == 2)){
            viewRegistration?.showToast("Выберите пол")
            return
        }

        loginService.register(login, password, name, gender, object : LoginService.LoginCallback{
            override fun onSuccess(result: RegisterDTO) {
                viewRegistration?.saveToken(result.token)
                navController?.navigate(R.id.action_registrationPage_to_activityFragment)
            }

            override fun onError(error: Throwable) {
                viewRegistration?.showToast(error.toString())
            }

        })
    }


}