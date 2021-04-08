package com.example.cswork.ui.meetingRoom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.calendar.CalendarFragment
import com.example.cswork.ui.calendar.TimeAndDurationFragment
import com.example.cswork.ui.inviteMembers.InviteMembersActivity

class MeetingRoomListActivity : AppCompatActivity() {

    private var roomList = ArrayList<MeetingRoom>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meeting_room_list)

        findViewById<LinearLayout>(R.id.linearLayout2).setOnClickListener{
            openCalendar()
        }

        findViewById<LinearLayout>(R.id.dateAndTimeLayout).setOnClickListener {
            openTimeAndDuration()
        }

        roomListData()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val meetingRoomAdapter = MeetingRoomAdapter(roomList, object : OnItemClickListener{
           override fun onItemClick() {
               startActivity(Intent(applicationContext, MeetingRoomDetailsActivity::class.java))
           }
       })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = meetingRoomAdapter
    }
    private fun roomListData(){
        var room = MeetingRoom("Adventurer", "4")
        roomList.add(room)
        room = MeetingRoom("Utopia", "6")
        roomList.add(room)
        room = MeetingRoom("Momentum", "8")
        roomList.add(room)
        room = MeetingRoom("Utopia", "6")
        roomList.add(room)
        room = MeetingRoom("Momentum", "8")
        roomList.add(room)

    }

    private fun openCalendar(){
        val bottomSheetFragment = CalendarFragment();
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
    }

    private fun openTimeAndDuration(){
        val timeAndDurationFragment = TimeAndDurationFragment();
        timeAndDurationFragment.show(supportFragmentManager, timeAndDurationFragment.tag);
    }

    fun onBackClick(view: View) {
        onBackPressed()
    }

}