package com.example.cswork.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.HomeScreenActivity

class SelectEmailActivity : AppCompatActivity() {

    lateinit var email1RadioButton: RadioButton
    lateinit var email2RadioButton: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_email)

       email1RadioButton = findViewById(R.id.email1Button)
       email2RadioButton = findViewById(R.id.email2Button)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.email1Button ->

                    if(checked){
//                        email1RadioButton.setBackgroundResource(R.drawable.ic_check)
                        email1RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0);
                        email2RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unchek, 0);
                    }else{
                        email1RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unchek, 0);
                        email2RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0);
                    }

                R.id.email2Button ->
                    if(checked){
                        email2RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0);
                        email1RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unchek, 0);
                    }else{
                        email2RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unchek, 0);
                        email1RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0);
                    }
            }
        }
    }

    fun onContinueClick(view: View) {
        startActivity(Intent(this, HomeScreenActivity::class.java))
    }
}