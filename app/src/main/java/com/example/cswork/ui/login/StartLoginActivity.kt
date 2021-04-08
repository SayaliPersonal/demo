package com.example.cswork.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cswork.R
import com.example.cswork.network.AzureRetrofitService
import com.example.cswork.network.EndPoints
import com.example.cswork.network.auth.AuthViewModel
import com.example.cswork.network.teams.TeamsResponse
import com.example.cswork.utils.Constants
import com.example.cswork.utils.PreferenceHelper
import com.example.cswork.utils.PreferenceHelper.get
import com.example.cswork.utils.PreferenceHelper.set
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class StartLoginActivity : AppCompatActivity() {
    private lateinit var viewModel: AuthViewModel
    lateinit var token: String
    lateinit var teamsResponse: TeamsResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_login)

        val prefs = PreferenceHelper.defaultPrefs(this)
        val emailCount: Int? = prefs[Constants.EMAIL_COUNT]

        val connectEmailView = findViewById<TextView>(R.id.connectEmailView)
        val infoView = findViewById<ImageView>(R.id.info_view)

        connectEmailView.visibility = View.VISIBLE
        infoView.visibility = View.VISIBLE

        if(emailCount ==2 ){
            connectEmailView.visibility = View.GONE
            infoView.visibility = View.GONE
        }

    }

    fun onContinueWithEmail(view: View) {
        val prefs = PreferenceHelper.defaultPrefs(this)
        val emailCount: Int? = prefs[Constants.EMAIL_COUNT]

        if (emailCount == 1) {
            startActivity(Intent(this, StartLoginWithEmailActivity::class.java))
        }else if(emailCount == 2){
            val bottomSheetFragment = SelectEmailFragment();
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
        }
    }

    fun onAnotherEmailClick(view: View) {
        val prefs = PreferenceHelper.defaultPrefs(this)
        val emailCount: Int? = prefs[Constants.EMAIL_COUNT]

        if (emailCount == 1) {
            startActivity(Intent(this, EnterMobileNumberWithEmailActivity::class.java))
        } else if (emailCount == 2) {
            val bottomSheetFragment = SelectEmailFragment();
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
        }
    }

    fun onInfoClick(view: View) {
        val bottomSheetFragment = AnotherEmailInfoFragment();
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
    }

    fun onSignUpClick(view: View) {
        startActivity(Intent(this, EnterMobileNumberActivity::class.java))
    }

    fun onEnterOTPClick(view: View) {
        val prefs = PreferenceHelper.defaultPrefs(this)
        var intent = Intent(this, EnterOTPActivity::class.java)
        intent.putExtra(Constants.FROM_SCREEN, Constants.START_LOGIN)
        startActivity(intent)
    }

    private fun onEmailsRegisteredCall() {
        val endPoints: EndPoints = AzureRetrofitService.getClient().create(EndPoints::class.java)
        val authResponseCall: Call<Void> = endPoints.emailsRegistered("Android007",
            "9999999999",
            "test@test.com",
            "String1234",
            "String1234")
        authResponseCall.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                Log.i("i", "onEmailsRegisteredCall")
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