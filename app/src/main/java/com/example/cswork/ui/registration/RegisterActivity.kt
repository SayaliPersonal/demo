package com.example.cswork.ui.registration

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cswork.R
import com.example.cswork.network.AzureRetrofitService
import com.example.cswork.network.EndPoints
import com.example.cswork.network.registration.CommonResponse
import com.example.cswork.network.registration.RegistrationRequest
import com.example.cswork.ui.HomeScreenActivity
import com.example.cswork.ui.login.EnterMobileNumberActivity
import com.example.cswork.ui.login.PasswordCriteriaFragment
import com.example.cswork.ui.login.StartLoginActivity
import com.example.cswork.utils.Constants
import com.example.cswork.utils.PreferenceHelper
import com.example.cswork.utils.PreferenceHelper.get
import com.example.cswork.utils.PreferenceHelper.set
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {

    lateinit var nameText: EditText
    lateinit var emailText: EditText
    lateinit var passwordText: EditText
    lateinit var confirmPasswordText: EditText
    lateinit var termsView: RadioButton
    lateinit var parentLayout: ConstraintLayout
    private lateinit var progressBar: ProgressBar

    lateinit var mobileNumber: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val prefs = PreferenceHelper.defaultPrefs(this)
        val isEmailLogin: Boolean? = prefs[Constants.IS_EMAIL_LOGIN]
        mobileNumber = prefs[Constants.ENTERED_MOBILE_NUMBER]!!

        val emailCount: Int? = prefs[Constants.EMAIL_COUNT]

        val cancelTextView = findViewById<TextView>(R.id.cancelView)
        val editTextView = findViewById<TextView>(R.id.editTextView)

        parentLayout = findViewById(R.id.parent_layout)
        nameText = findViewById(R.id.name_text)
        emailText = findViewById(R.id.email_text)
        passwordText = findViewById(R.id.password_text)
        confirmPasswordText = findViewById(R.id.confirm_password_text)
        termsView = findViewById(R.id.terms_view)
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.GONE

        if (isEmailLogin!! && emailCount == 2) {
            cancelTextView.visibility = View.VISIBLE
            editTextView.visibility = View.GONE
        } else {
            cancelTextView.visibility = View.GONE
            editTextView.visibility = View.VISIBLE
        }

        editTextView.setOnClickListener {
            finish()
//            startActivity(Intent(this, EnterMobileNumberActivity::class.java))
        }

        val textView3 = findViewById<TextView>(R.id.label1)
        val spannable = SpannableString("Mobile Number $mobileNumber ")
        spannable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.color_text_primary)),
            14, // start
            24, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        spannable.setSpan(StyleSpan(Typeface.BOLD), 14, 24, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        textView3.text = spannable

//        val termsView = findViewById<TextView>(R.id.termsView)
        val span = SpannableString("I agree to the Terms and Conditions")
        span.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.blue_primary_dark)),
            15, // start
            35, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        span.setSpan(StyleSpan(Typeface.BOLD), 15, 35, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        termsView.text = span
        termsView.setOnClickListener {
            termsView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check, 0, 0, 0)
        }

    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    fun onPasswordCriteriaClick(view: View) {
        val bottomSheetFragment = PasswordCriteriaFragment();
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
    }

    fun onCancelClick(view: View) {
        startActivity(Intent(this, StartLoginActivity::class.java))
    }

    private fun onRegisterCall2() {
        val endPoints: EndPoints = AzureRetrofitService.getClient().create(EndPoints::class.java)
        val authResponseCall: Call<Void> = endPoints.register(
            nameText.text.toString(),
            mobileNumber,
            emailText.text.toString(),
            passwordText.text.toString(),
            confirmPasswordText.text.toString()
        )
        authResponseCall.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                Log.i("i", "onRegisterCall")
                if (response.isSuccessful) {
                    Log.i("i", "@@@@@@@@@@@@@@@@@@@@@@")
                    Log.d("D", Gson().toJson(response.body()))
                    Snackbar.make(
                        parentLayout,
                        "User registered successfully",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    val prefs = PreferenceHelper.defaultPrefs(this@RegisterActivity)
                    prefs[Constants.EMAIL_COUNT] = 1
                    prefs[Constants.EMAIL_1_LOGIN] = emailText.text.toString()
                    val intent = Intent(this@RegisterActivity, HomeScreenActivity::class.java)
                    intent.putExtra(Constants.FROM_SCREEN, Constants.REGISTER_SCREEN)
                    startActivity(intent)

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

    private fun onRegisterCall() {
        progressBar.visibility = View.VISIBLE
        val endPoints: EndPoints = AzureRetrofitService.getClient().create(EndPoints::class.java)
        val authResponseCall: Call<CommonResponse> = endPoints.register2(RegistrationRequest(
            nameText.text.toString(),
            mobileNumber,
            emailText.text.toString(),
            passwordText.text.toString(),
            confirmPasswordText.text.toString())
        )
        authResponseCall.enqueue(object : Callback<CommonResponse?> {
            override fun onResponse(call: Call<CommonResponse?>, response: Response<CommonResponse?>) {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                }
                Log.i("i", "onRegisterCall")
                if (response.isSuccessful) {
                    Log.i("i", "@@@@@@@@@@@@@@@@@@@@@@")
                    Log.d("D", Gson().toJson(response.body()))
                    var commonResponse = response.body()
                    if(commonResponse!!.isValid) {
                        Snackbar.make(
                            parentLayout,
                            "User registered successfully",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@RegisterActivity, HomeScreenActivity::class.java)
                        intent.putExtra(Constants.FROM_SCREEN, Constants.REGISTER_SCREEN)
                        startActivity(intent)
                        finish()
                    }else{
                        Snackbar.make(
                            parentLayout,
                            "Something went wrong",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }

                } else {
                    Log.d("D", " NOT (response.isSuccessful())")
                }
            }

            override fun onFailure(call: Call<CommonResponse?>, t: Throwable) {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                }
                Log.d("Error", "*****************")
                Log.d("Error", t.localizedMessage!!)
            }
        })
    }

    fun onRegisterClick(view: View) {

        if (TextUtils.isEmpty(nameText.text.toString()) &&
            TextUtils.isEmpty(emailText.text.toString()) &&
            TextUtils.isEmpty(passwordText.text.toString()) &&
            TextUtils.isEmpty(confirmPasswordText.text.toString())
        ) {
            Snackbar.make(parentLayout, "Enter all fields", Snackbar.LENGTH_SHORT).show()
        } else if (!isValidEmail(emailText.text.toString())) {
            Snackbar.make(parentLayout, "Please enter valid email", Snackbar.LENGTH_SHORT).show()
        } else if(passwordText.text.toString() != confirmPasswordText.text.toString()){
            Snackbar.make(parentLayout, "Both passwords must be same", Snackbar.LENGTH_SHORT).show()
        }
        else if (!termsView.isChecked) {
            Snackbar.make(
                parentLayout,
                "Please accept the Terms and Conditions",
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            onRegisterCall()
        }
    }
}