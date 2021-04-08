package com.example.cswork.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.example.cswork.R
import com.example.cswork.ui.home.Home
import com.example.cswork.ui.home.HomeGridAdapter
import com.example.cswork.ui.home.HomeMyActivityAdapter
import com.example.cswork.ui.home.QuickLinksAdapter
import com.example.cswork.ui.meetingRoom.MeetingRoom
import com.example.cswork.ui.meetingRoom.MeetingRoomListActivity
import com.example.cswork.ui.myActivity.MyActivity
import com.example.cswork.ui.quickLinks.UserGuideActivity
import com.example.cswork.ui.quickLinks.contactUs.ContactUsActivity
import com.example.cswork.ui.userProfile.UserProfileActivity
import com.example.cswork.utils.CirclePagerIndicatorDecoration
import com.google.android.material.bottomsheet.BottomSheetDialog

class BridgePlusActivity : AppCompatActivity() {

    private lateinit var myActivityRecyclerView: RecyclerView
    private lateinit var gridRecyclerView: RecyclerView
    private lateinit var quickLinksRecyclerView: RecyclerView

    private var roomList = ArrayList<MeetingRoom>()
    private var bulletinList = ArrayList<Home>()
    private var gridList = ArrayList<Home>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bridge_plus)
        roomListData()
        getGridList()
        getBulletinList()

        myActivityRecyclerView = findViewById(R.id.myActivityRecyclerView)
        gridRecyclerView = findViewById(R.id.gridRecyclerView)
        quickLinksRecyclerView = findViewById(R.id.quickLinksRecyclerView)

        myActivityRecyclerView.isNestedScrollingEnabled = false
        gridRecyclerView.isNestedScrollingEnabled = false
        quickLinksRecyclerView.isNestedScrollingEnabled = false


        val adapter = HomeMyActivityAdapter(roomList, object : OnItemClickListener {
            override fun onItemClick() {
            }
        })

        val homeGridAdapter = HomeGridAdapter(gridList, object : OnItemClickListener2 {
            override fun onItemClick(position: Int) {
                when (position) {
                    0 -> {
                        startActivity(
                            Intent(
                                this@BridgePlusActivity,
                                MeetingRoomListActivity::class.java
                            )
                        )
                    }
                    1 -> {
                        val view =
                            layoutInflater.inflate(R.layout.upcoming_services_facilities, null)
                        val dialog = BottomSheetDialog(this@BridgePlusActivity)
                        dialog.setContentView(view)
                        dialog.show()
                    }

                    2 -> {
                        val view = layoutInflater.inflate(R.layout.upcoming_services_events, null)
                        val dialog = BottomSheetDialog(this@BridgePlusActivity)
                        dialog.setContentView(view)
                        dialog.show()
                    }

                    3 -> {
                        val view = layoutInflater.inflate(R.layout.upcoming_services_parking, null)
                        val dialog = BottomSheetDialog(this@BridgePlusActivity)
                        dialog.setContentView(view)
                        dialog.show()
                    }
                }
            }
        })

        val quickLinksAdapter = QuickLinksAdapter(bulletinList, object : OnItemClickListener2 {
            override fun onItemClick(position: Int) {
                when (position) {
                    1 -> {
                        startActivity(
                            Intent(
                                this@BridgePlusActivity,
                                UserGuideActivity::class.java
                            )
                        )
                    }
                    2 -> {
                        startActivity(
                            Intent(
                                this@BridgePlusActivity,
                                ContactUsActivity::class.java
                            )
                        )
                    }
                }
            }
        })

        myActivityRecyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        myActivityRecyclerView.setHasFixedSize(true)
        myActivityRecyclerView.itemAnimator = DefaultItemAnimator()
        myActivityRecyclerView.addItemDecoration(
            CirclePagerIndicatorDecoration()
        )

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(myActivityRecyclerView)
        myActivityRecyclerView.adapter = adapter

        gridRecyclerView.layoutManager = GridLayoutManager(applicationContext, 3)
        gridRecyclerView.setHasFixedSize(true)
        gridRecyclerView.itemAnimator = DefaultItemAnimator()
        gridRecyclerView.adapter = homeGridAdapter


        quickLinksRecyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        quickLinksRecyclerView.setHasFixedSize(true)
        quickLinksRecyclerView.itemAnimator = DefaultItemAnimator()
        quickLinksRecyclerView.adapter = quickLinksAdapter
    }

    private fun getBulletinList() {
        var bulletin = Home("Deals", R.drawable.ic_deals)
        bulletinList.add(bulletin)
        bulletin = Home("User Guide", R.drawable.ic_faqs)
        bulletinList.add(bulletin)
        bulletin = Home("Contact", R.drawable.ic_contact)
        bulletinList.add(bulletin)
    }

    private fun getGridList() {
        var grid = Home("Meeting\nRooms", R.drawable.ic_plus_grid_meeting_rooms)
        gridList.add(grid)
        grid = Home("Facility\nBooking", R.drawable.ic_plus_grid_facility_booking)
        gridList.add(grid)
        grid = Home("Events", R.drawable.ic_plus_grid_events)
        gridList.add(grid)
        grid = Home("Parking", R.drawable.ic_plus_grid_parking)
        gridList.add(grid)

    }

    private fun roomListData() {
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

    fun onBackClick(view: View) {
        onBackPressed()
    }

    fun onViewAllClick(view: View) {
        startActivity(Intent(applicationContext, MyActivity::class.java))
    }

    fun onUserProfileClick(view: View) {
        startActivity(Intent(applicationContext, UserProfileActivity::class.java))
    }
}