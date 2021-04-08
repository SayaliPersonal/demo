package com.example.cswork.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cswork.R
import com.example.cswork.ui.login.EnterMobileNumberActivity
import com.example.cswork.ui.login.StartLoginActivity
import com.example.cswork.utils.Constants
import com.example.cswork.utils.PreferenceHelper
import com.example.cswork.utils.PreferenceHelper.get
import com.scottyab.rootbeer.RootBeer

/**This is the launch activity of the application*/
class SplashActivity : AppCompatActivity() {
    lateinit var handler: Handler
    lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()
        handler.postDelayed(runnable, 3000);

        val rootBeer = RootBeer(this)
        if (rootBeer.isRooted)
            Log.d("SPLASH", "!!! Rooted Device !!! Application won't work")
        else
            Log.d("SPLASH", "<<< Proceed >>>")
    }

    private fun init() {
        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            //TODO navigate to proper SCREEN during API integration.

            val prefs = PreferenceHelper.defaultPrefs(this)
            val isEmailLogin: Boolean? = prefs[Constants.IS_EMAIL_LOGIN]

            if (isEmailLogin!!) {
                startActivity(Intent(this, StartLoginActivity::class.java))
            } else {
                startActivity(Intent(this, EnterMobileNumberActivity::class.java))
            }

//            startActivity(Intent(this, HomeScreenActivity::class.java))
            finish()
        }
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
        handler.removeMessages(0)
    }
}