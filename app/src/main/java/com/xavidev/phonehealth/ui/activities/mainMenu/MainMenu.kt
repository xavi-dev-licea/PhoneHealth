package com.xavidev.phonehealth.ui.activities.mainMenu

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xavidev.phonehealth.R
import com.xavidev.phonehealth.databinding.ActivityMainBinding
import com.xavidev.phonehealth.utils.Extensions.toast

class MainMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationListener()
    }

    private fun setupNavigationListener() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    toast("Home")
                    true
                }
                R.id.menu_statistics -> {
                    toast("Statistics")
                    true
                }
                R.id.menu_profile -> {
                    toast("Profile")
                    true
                }
                else -> false
            }
        }
    }
}