package com.example.cswork.ui.userProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.cswork.R
import com.example.cswork.ui.calendar.CalendarFragment

class UserProfileActivity : AppCompatActivity() {

    private lateinit var viewLayout : LinearLayout
    private lateinit var editLayout : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        viewLayout = findViewById(R.id.viewLayout)
        editLayout = findViewById(R.id.editLayout)
        val backView = findViewById<ImageView>(R.id.back_view)
        val userNameView = findViewById<TextView>(R.id.user_name_view)
        val moreView = findViewById<ImageView>(R.id.more_view)
        userNameView.text = ""

        backView.setOnClickListener{
            onBackPressed()
        }

        moreView.setOnClickListener{
            val bottomSheetFragment = MoreOptionsFragment();
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
        }
    }

    fun onEditClick(view: View) {
        viewLayout.visibility = View.GONE
        editLayout.visibility = View.VISIBLE
    }

    fun onSendOTPClick(view: View) {
        val bottomSheetFragment = MoreOptionsFragment();
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
    }

    fun onCancelClick(view: View) {
        viewLayout.visibility = View.VISIBLE
        editLayout.visibility = View.GONE
    }
}