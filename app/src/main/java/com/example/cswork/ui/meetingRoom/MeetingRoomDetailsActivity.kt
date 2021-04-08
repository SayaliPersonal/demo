package com.example.cswork.ui.meetingRoom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.cswork.R
import com.example.cswork.ui.calendar.CalendarFragment
import com.example.cswork.ui.calendar.TimeAndDurationFragment

class MeetingRoomDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meeting_room_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<LinearLayout>(R.id.linearLayout2).setOnClickListener {
            openCalendar()
        }

        findViewById<LinearLayout>(R.id.dateAndTimeLayout).setOnClickListener {
            openTimeAndDuration()
        }

        var horizontalScrollView = findViewById<HorizontalScrollView>(R.id.horizontalScrollView)
        horizontalScrollView.animation = AnimationUtils.loadAnimation(this, R.anim.shake)

    }

    private fun openCalendar(){
        val bottomSheetFragment = CalendarFragment();
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
    }

    private fun openTimeAndDuration(){
        val timeAndDurationFragment = TimeAndDurationFragment();
        timeAndDurationFragment.show(supportFragmentManager, timeAndDurationFragment.tag);
    }

    fun onBookMeetingRoomClick(view: View) {
        startActivity(Intent(this, ConfirmMeetingRoomActivity::class.java))
    }

    private fun timeLineBar(){
        
    }

    fun onBackClick(view: View) {
        onBackPressed()
    }
}