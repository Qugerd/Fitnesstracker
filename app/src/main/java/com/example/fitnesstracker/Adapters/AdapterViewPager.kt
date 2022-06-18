package com.example.fitnesstracker.Adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ActivityFragmentTabs.RVFragmentMy
import com.example.myapplication.ActivityFragmentTabs.RVFragmentUsers

public const val ARG_OBJECT = "object"

class ViewPageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) RVFragmentMy() else RVFragmentUsers()
    }
}