package com.example.cswork.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cswork.R
import com.example.cswork.network.AzureRetrofitService
import com.example.cswork.network.EndPoints
import com.example.cswork.utils.Constants
import com.example.cswork.utils.PreferenceHelper
import com.example.cswork.utils.PreferenceHelper.set
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnterMobileNumberActivity : AppCompatActivity() {

    lateinit var mobileNumberText: EditText
    lateinit var parentLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_mobile_number)

        mobileNumberText = findViewById(R.id.mobileNumberText)
        parentLayout = findViewById(R.id.parent_layout)
    }

    fun onGetOTPClick(view: View) {
        //TODO just bypass OTP later integrate API when SMS gateway integrated at backend
        val prefs = PreferenceHelper.defaultPrefs(this)
//        prefs[Constants.EMAIL_COUNT] = 1
        if (TextUtils.isEmpty(mobileNumberText.text) || mobileNumberText.text.length < 10 )
            Snackbar.make(parentLayout, "Enter 10 digit mobile number", Snackbar.LENGTH_SHORT).show()
        else {
            prefs[Constants.ENTERED_MOBILE_NUMBER] = mobileNumberText.text.toString()
            startActivity(Intent(this, EnterOTPActivity::class.java))
        }

    }

    private fun onGetOTPCall() {
        val endPoints: EndPoints = AzureRetrofitService.getClient().create(EndPoints::class.java)
        val authResponseCall: Call<Void> = endPoints.getOtp("9999999999")
        authResponseCall.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                Log.i("i", "onGetOTPCall")
                if (response.isSuccessful) {
                    Log.i("i", "@@@@@@@@@@@@@@@@@@@@@@")
                    Log.d("D", Gson().toJson(response.body()))
                } else {
                    Log.d("D", " NOT (response.isSuccessful())")
                }
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                Log.d("Error", "*****************")
                Log.d("Error", t.localizedMessage!!)
            }
        })
    }
}