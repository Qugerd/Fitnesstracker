package com.example.fitnesstracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Emptystate : AppCompatActivity(R.layout.activity_emptystate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = Adapter(this)

        TabLayoutMediator(
            TabLayout(this),
            viewPager,
            { tab, position ->
                if (position == 0) tab.setText("Моя") else tab.setText("Пользователей")

            }
        ).attach()

        val bnv = BottomNavigationView(this)
        bnv.setOnItemReselectedListener {
            when (it.itemId){
                R.id.person -> {

                }

                R.id.activity -> {

                }
            }

            true
        }
    }

}