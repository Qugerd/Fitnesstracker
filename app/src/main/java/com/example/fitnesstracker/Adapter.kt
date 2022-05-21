package com.example.fitnesstracker

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fitnesstracker.fargments.FragmentMy
import com.example.fitnesstracker.fargments.FragmentUsers


class Adapter(activity : AppCompatActivity) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        if (position == 0) FragmentMy() else FragmentUsers()
}
