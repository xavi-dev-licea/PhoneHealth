package com.xavidev.phonehealth.ui.activities.mainMenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xavidev.phonehealth.R
import com.xavidev.phonehealth.databinding.ActivityMainBinding

class MainMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}