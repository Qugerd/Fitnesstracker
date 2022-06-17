package com.example.myapplication.ActivityFragmentTabs

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesstracker.Adapters.RecyclerAdapter
import com.example.fitnesstracker.R
import com.example.myapplication.Data.MyActivityDataRepository


class MyActivity: Fragment(R.layout.tabs_fragment_my_activity)  {

    private val myActivityData = MyActivityDataRepository()
    private val adapter = RecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@MyActivity.adapter
        }

        adapter.setData(myActivityData.getData())
    }


}