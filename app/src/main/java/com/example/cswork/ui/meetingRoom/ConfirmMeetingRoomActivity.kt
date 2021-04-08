package com.example.cswork.ui.meetingRoom

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cswork.R
import com.example.cswork.ui.calendar.CalendarFragment
import com.example.cswork.ui.inviteMembers.InviteMembersActivity

class ConfirmMeetingRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_meeting_room)

        findViewById<ImageView>(R.id.inviteMemberView).setOnClickListener {
            startActivity(Intent(this, InviteMembersActivity::class.java))
        }
        findViewById<TextView>(R.id.cancelBookingView).setOnClickListener {
            openCancelBooking()
        }
    }

    private fun openCancelBooking(){
        val bottomSheetFragment = CancelBookingFragment();
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
    }
}