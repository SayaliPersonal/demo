package com.example.cswork.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cswork.R
import com.example.cswork.network.AzureRetrofitService
import com.example.cswork.network.EndPoints
import com.example.cswork.network.auth.AuthViewModel
import com.example.cswork.network.login.LoginRequest
import com.example.cswork.network.login.LoginResponse
import com.example.cswork.network.teams.TeamsResponse
import com.example.cswork.ui.HomeScreenActivity
import com.example.cswork.utils.Constants
import com.example.cswork.utils.PreferenceHelper
import com.example.cswork.utils.PreferenceHelper.get
import com.example.cswork.utils.PreferenceHelper.set
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class StartLoginWithEmailActivity : AppCompatActivity() {

    private lateinit var viewModel: AuthViewModel
    private lateinit var parentLayout: ConstraintLayout
    private lateinit var password_text: EditText
    private lateinit var progressBar: ProgressBar
    private var emailCount: Int = 0
    lateinit var token: String
    lateinit var teamsResponse: TeamsResponse
    lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_email_login)

        val prefs = PreferenceHelper.defaultPrefs(this)
        emailCount = prefs[Constants.EMAIL_COUNT]!!
        email = prefs[Constants.EMAIL_1_LOGIN]!!

        val switchTextView = findViewById<TextView>(R.id.switchTextView)
        val connectEmailView = findViewById<TextView>(R.id.connectEmailView)
        val infoView = findViewById<ImageView>(R.id.infoView)
        val emailView = findViewById<TextView>(R.id.emailView)
        parentLayout = findViewById(R.id.parent_layout)
        password_text = findViewById(R.id.password_text)
        emailView.text = email
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.GONE

        if (emailCount == 2) {
            switchTextView.visibility = View.VISIBLE
            connectEmailView.visibility = View.GONE
            infoView.visibility = View.GONE

        } else {
            switchTextView.visibility = View.GONE
        }

        switchTextView.setOnClickListener {
            onLoginCall()

        }

    }

    fun onLoginClick(view: View) {

        if (TextUtils.isEmpty(password_text.text.toString())) {
            Snackbar.make(parentLayout, "Please enter the password", Snackbar.LENGTH_SHORT).show()
        } else {
            startActivity(Intent(this, HomeScreenActivity::class.java))
        }
    }

    fun onAnotherEmailClick(view: View) {
        startActivity(Intent(this, SelectEmailActivity::class.java))
    }

    fun onInfoClick(view: View) {
        val bottomSheetFragment = AnotherEmailInfoFragment();
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
    }

    fun onSignUpClick(view: View) {
//        val prefs = PreferenceHelper.defaultPrefs(this)
//        prefs[Constants.IS_EMAIL_LOGIN] = false
//        prefs[Constants.EMAIL_1_LOGIN] = 1
        startActivity(Intent(this, EnterMobileNumberActivity::class.java))
    }

    private fun onLoginCall() {
        progressBar.visibility = View.VISIBLE
        val endPoints: EndPoints = AzureRetrofitService.getClient().create(EndPoints::class.java)
        val authResponseCall: Call<LoginResponse> = endPoints.login2(
            LoginRequest("test@gmail.com", password_text.text.toString())
        )
        authResponseCall.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                }
                Log.i("i", "onLoginCall")
                if (response.isSuccessful) {
                    Log.i("i", "@@@@@@@@@@@@@@@@@@@@@@")
                    Log.d("D", Gson().toJson(response.body()))
                    var loginResponse = response.body()
                    if (loginResponse!!.isValid) {

                        val prefs = PreferenceHelper.defaultPrefs(this@StartLoginWithEmailActivity)
                        prefs[Constants.TOKEN] = loginResponse.data
                        val intent =
                            Intent(this@StartLoginWithEmailActivity, HomeScreenActivity::class.java)
                        startActivity(intent)

                        finish()
                    } else {
                        Snackbar.make(
                            parentLayout, loginResponse.data,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }

                } else {
                    Log.d("D", " NOT (response.isSuccessful())")
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                }
                Log.d("Error", "*****************")
                Log.d("Error", t.localizedMessage!!)
            }
        })
    }


}