package com.example.fitnesstracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Login : Fragment(R.layout.activity_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.toolbar_login).setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            findNavController().navigate(R.id.action_login_to_activityFragment)
        }

    }
}