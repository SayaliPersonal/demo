package com.example.cswork.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cswork.R
import com.example.cswork.utils.Constants
import com.example.cswork.utils.PreferenceHelper
import com.example.cswork.utils.PreferenceHelper.set

class EnterMobileNumberWithEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_mobile_number_with_email)
    }

    fun onGetOTPClick(view: View) {
        val prefs = PreferenceHelper.defaultPrefs(this)
        prefs[Constants.EMAIL_COUNT] = 2
        var intent = Intent(this, EnterOTPActivity::class.java)
        intent.putExtra(Constants.FROM_SCREEN, Constants.EMAIL_2_LOGIN)
        startActivity(intent)
    }

    fun onSignUpClick(view: View) {

        startActivity(Intent(this, EnterMobileNumberActivity::class.java))
    }
}