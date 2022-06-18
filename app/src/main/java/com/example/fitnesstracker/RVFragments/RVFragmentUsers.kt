package com.example.myapplication.ActivityFragmentTabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.Adapters.RecyclerAdapter
import com.example.fitnesstracker.R
import com.example.myapplication.Data.UsersActivityDataRepository

class RVFragmentUsers: Fragment(R.layout.tabs_fragment_users_activity)  {

    private val usersActivityData = UsersActivityDataRepository()
    private val adapter = RecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@RVFragmentUsers.adapter
        }
        adapter.setData(usersActivityData.getData())
    }
}