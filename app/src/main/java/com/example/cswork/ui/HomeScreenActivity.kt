package com.example.cswork.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.cswork.R
import com.example.cswork.utils.Constants
import com.example.cswork.utils.PreferenceHelper
import com.example.cswork.utils.PreferenceHelper.set
import com.scottyab.rootbeer.Const

class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)



        var fromScreen = ""
        if (intent.extras != null) {
            fromScreen = intent.extras!!.getString(Constants.FROM_SCREEN).toString()
        }

        val prefs = PreferenceHelper.defaultPrefs(this)
        if(fromScreen == Constants.REGISTER_SCREEN) {
            prefs[Constants.IS_EMAIL_LOGIN] = true
        }

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}