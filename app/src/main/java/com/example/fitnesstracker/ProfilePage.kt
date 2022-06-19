package com.example.fitnesstracker

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.fitnesstracker.MVP.ProfilePresenter
import com.example.fitnesstracker.MVP.ProfileView

class ProfilePage: Fragment(R.layout.activity_fragment_profile), ProfileView {

    private val presenter = ProfilePresenter()
    private var navController: NavController? = null

    private val sharedPrefs by lazy {
        requireContext().getSharedPreferences("Tokens", Context.MODE_PRIVATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController = parentFragment?.parentFragment?.findNavController()

        presenter.attachView(this)

        presenter.onViewCreated()

        view.findViewById<Button>(R.id.logoutButton).setOnClickListener {
            presenter.onLogoutClicked()
            deleteToken(navController!!)
        }

    }

    fun deleteToken(navController: NavController) {
        sharedPrefs.edit().remove("Token").apply()
        navController.navigate(R.id.action_activityFragment_to_welcomePage)
    }

    override fun getToken(): String? {
        return sharedPrefs.getString("Token", "")
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun getData(name: String, login: String, token: String) {
        view?.findViewById<TextView>(R.id.name)?.text = name
        view?.findViewById<TextView>(R.id.login)?.text = login

    }
}