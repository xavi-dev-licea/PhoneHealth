package com.xavidev.phonehealth.ui.activities.mainMenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xavidev.phonehealth.R
import com.xavidev.phonehealth.databinding.ActivityMainBinding
import com.xavidev.phonehealth.ui.fragments.battery.BatteryFragment
import com.xavidev.phonehealth.ui.fragments.notifications.NotificationsFragment
import com.xavidev.phonehealth.ui.fragments.reboot.RebootFragment
import com.xavidev.phonehealth.utils.Constants
import com.xavidev.phonehealth.utils.addFragment

class MainMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationListener()
    }

    private fun setupNavigationListener() {
        addFragment(
            BatteryFragment::class.java,
            Constants.BATTERY_FRAGMENT,
            binding.containerFrame,
            true,
            null
        )

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    addFragment(
                        BatteryFragment::class.java,
                        Constants.BATTERY_FRAGMENT,
                        binding.containerFrame,
                        false,
                        null
                    )
                    true
                }
                R.id.menu_statistics -> {
                    addFragment(
                        NotificationsFragment::class.java,
                        Constants.NOTIFICATIONS_FRAGMENT,
                        binding.containerFrame,
                        false,
                        null
                    )
                    true
                }
                R.id.menu_profile -> {
                    addFragment(
                        RebootFragment::class.java,
                        Constants.REBOOT_FRAGMENT,
                        binding.containerFrame,
                        false,
                        null
                    )
                    true
                }
                else -> false
            }
        }
    }
}