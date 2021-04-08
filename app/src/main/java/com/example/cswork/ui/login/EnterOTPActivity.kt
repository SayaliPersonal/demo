package com.example.cswork.ui.login

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.text.*
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cswork.R
import com.example.cswork.network.AzureRetrofitService
import com.example.cswork.network.EndPoints
import com.example.cswork.ui.HomeScreenActivity
import com.example.cswork.ui.registration.RegisterActivity
import com.example.cswork.utils.Constants
import com.example.cswork.utils.PreferenceHelper
import com.example.cswork.utils.PreferenceHelper.get
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EnterOTPActivity : AppCompatActivity() {
    var fromScreen = ""
    lateinit var otp1Text: EditText
    lateinit var otp2Text: EditText
    lateinit var otp3Text: EditText
    lateinit var otp4Text: EditText
    lateinit var timerView: TextView
    lateinit var parentLayout: ConstraintLayout
    lateinit var mobileNumber : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_otp)


        otp1Text = findViewById(R.id.otp_1_text)
        otp2Text = findViewById(R.id.otp_2_text)
        otp3Text = findViewById(R.id.otp_3_text)
        otp4Text = findViewById(R.id.otp_4_text)
        timerView = findViewById(R.id.time_view)
        parentLayout = findViewById(R.id.parent_layout)


        if (intent.extras != null) {
            fromScreen = intent.extras!!.getString(Constants.FROM_SCREEN).toString()
        }

        val prefs = PreferenceHelper.defaultPrefs(this)
         mobileNumber = prefs[Constants.ENTERED_MOBILE_NUMBER]!!

        val backImageView = findViewById<ImageView>(R.id.backView)
        val editTextView = findViewById<TextView>(R.id.editTextView)
        if ((fromScreen == Constants.EMAIL_2_LOGIN) || (fromScreen == Constants.START_LOGIN)) {
            backImageView.visibility = View.VISIBLE
            editTextView.visibility = View.GONE
        } else {
            backImageView.visibility = View.GONE
            editTextView.visibility = View.VISIBLE
        }

        backImageView.setOnClickListener {
            onBackPressed()
        }

        editTextView.setOnClickListener {
            finish()
//            startActivity(Intent(this, EnterMobileNumberActivity::class.java))
        }

        val textView3 = findViewById<TextView>(R.id.textView3)
        val spannable = SpannableString("OTP has been sent to $mobileNumber ")
        spannable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.color_text_primary)),
            21, // start
            31, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        spannable.setSpan(StyleSpan(Typeface.BOLD), 21, 31, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        textView3.text = spannable

        timer()
        initOtpFields()

    }

    private fun initOtpFields() {
        otp1Text.addTextChangedListener(
            GenericTextWatcher(
                otp1Text,
                otp1Text,
                otp2Text,
                otp3Text,
                otp4Text
            )
        )
        otp2Text.addTextChangedListener(
            GenericTextWatcher(
                otp2Text,
                otp1Text,
                otp2Text,
                otp3Text,
                otp4Text
            )
        )
        otp3Text.addTextChangedListener(
            GenericTextWatcher(
                otp3Text,
                otp1Text,
                otp2Text,
                otp3Text,
                otp4Text
            )
        )
        otp4Text.addTextChangedListener(
            GenericTextWatcher(
                otp4Text,
                otp1Text,
                otp2Text,
                otp3Text,
                otp4Text
            )
        )
    }

    fun timer() {
        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerView.text = "0:" + millisUntilFinished / 1000
            }

            override fun onFinish() {
//                timeView.setText("!")
            }
        }.start()
    }

    private fun onVerifyOTPCall() {
        val endPoints: EndPoints = AzureRetrofitService.getClient().create(EndPoints::class.java)
        val authResponseCall: Call<Void> = endPoints.verifyOtp("1111", "9999999999")
        authResponseCall.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                Log.i("i", "onVerifyOTPCall")
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

    class GenericTextWatcher(
        private val view: View,
        private val et1: EditText,
        private val et2: EditText,
        private val et3: EditText,
        private val et4: EditText,
    ) : TextWatcher {
        override fun afterTextChanged(editable: Editable) {
            // TODO Auto-generated method stub
            val text = editable.toString()
            when (view.id) {
                R.id.otp_1_text -> if (text.length == 1) et2.requestFocus()
                R.id.otp_2_text -> if (text.length == 1) et3.requestFocus() else if (text.length == 0) et1.requestFocus()
                R.id.otp_3_text -> if (text.length == 1) et4.requestFocus() else if (text.length == 0) et2.requestFocus()
                R.id.otp_4_text -> if (text.length == 0) et3.requestFocus()
            }
        }

        override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {
            // TODO Auto-generated method stub
        }

        override fun onTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {
            // TODO Auto-generated method stub
        }
    }

    fun onConfirmClick(view: View) {

        val otp = otp1Text.text.toString() + otp2Text.text.toString() +
                otp3Text.text.toString() + otp4Text.text.toString()

        if (TextUtils.isEmpty(otp1Text.text.toString()) &&
            TextUtils.isEmpty(otp2Text.text.toString()) &&
            TextUtils.isEmpty(otp3Text.text.toString()) &&
            TextUtils.isEmpty(otp4Text.text.toString())) {
            Snackbar.make(parentLayout, "Enter the OTP", Snackbar.LENGTH_SHORT).show()
        } else  if(otp != "1234"){
            Snackbar.make(parentLayout, "Enter the valid OTP", Snackbar.LENGTH_SHORT).show()
        }else {

            val prefs = PreferenceHelper.defaultPrefs(this)
            val emailCount: Int? = prefs[Constants.EMAIL_COUNT]
            if ((fromScreen == Constants.START_LOGIN) && emailCount == 2) {
                startActivity(Intent(this, SelectEmailActivity::class.java))
            } else if ((fromScreen == Constants.START_LOGIN) && emailCount == 1) {
                startActivity(Intent(this, HomeScreenActivity::class.java))
            } else {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
            finish()
        }
    }

}