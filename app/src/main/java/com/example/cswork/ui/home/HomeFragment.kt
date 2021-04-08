package com.example.cswork.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.*
import com.example.cswork.R
import com.example.cswork.ui.BridgePlusActivity
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.OnItemClickListener2
import com.example.cswork.ui.meetingRoom.MeetingRoom
import com.example.cswork.ui.meetingRoom.MeetingRoomListActivity
import com.example.cswork.ui.myActivity.DataClass.MyActivityData
import com.example.cswork.ui.myActivity.DataClass.MyActivityDataSegrigation
import com.example.cswork.ui.myActivity.HomeScreenMyActivityAdapter
import com.example.cswork.ui.myActivity.MyActivity
import com.example.cswork.ui.myActivity.MyActvityViewModel
import com.example.cswork.ui.quickLinks.contactUs.ContactUsActivity
import com.example.cswork.ui.userProfile.UserProfileActivity
import com.example.cswork.utils.CirclePagerIndicatorDecoration
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {
    lateinit var myActivityDataSegrigation: ArrayList<MyActivityDataSegrigation>

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var myActivityRecyclerView: RecyclerView
    private lateinit var gridRecyclerView: RecyclerView
    private lateinit var quickLinksRecyclerView: RecyclerView
    private lateinit var homeGridAdapter: HomeGridAdapter
    var myActivityDataList: ArrayList<MyActivityData.MyActivityDataList> = ArrayList<MyActivityData.MyActivityDataList>()

    private var roomList = ArrayList<MeetingRoom>()
    private var bulletinList = ArrayList<Home>()
    private var gridList = ArrayList<Home>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        roomListData()
        getGridList()
        getBulletinList()

        myActivityRecyclerView = view.findViewById(R.id.myActivityRecyclerView)
        gridRecyclerView = view.findViewById(R.id.gridRecyclerView)
        quickLinksRecyclerView = view.findViewById(R.id.quickLinksRecyclerView)

        val viewAll = view.findViewById<TextView>(R.id.viewAll)
        val userImageView = view.findViewById<ImageView>(R.id.userImageView)
        viewAll.setOnClickListener {
            startActivity(Intent(activity, MyActivity::class.java))
        }

        userImageView.setOnClickListener {
            startActivity(Intent(activity, UserProfileActivity::class.java))
        }


        gridRecyclerView.isNestedScrollingEnabled = false
        quickLinksRecyclerView.isNestedScrollingEnabled = false



        homeGridAdapter = HomeGridAdapter(gridList, object : OnItemClickListener2 {
            override fun onItemClick(position: Int) {
                when (position) {
                    0 -> {
//                        val view =
//                            layoutInflater.inflate(R.layout.upcoming_services_bridge_plus, null)
//                        val dialog = BottomSheetDialog(activity!!)
//                        view.findViewById<AppCompatButton>(R.id.updateButton).setOnClickListener {
//                            startActivity(Intent(activity, BridgePlusActivity::class.java))
//                            dialog.dismiss()
//                        }
//                        dialog.setContentView(view)
//                        dialog.show()

                        startActivity(Intent(activity, BridgePlusActivity::class.java))
                    }
                    1 -> {
                        startActivity(Intent(activity, MeetingRoomListActivity::class.java))
                    }

                    2 -> {
                        val view =
                            layoutInflater.inflate(R.layout.upcoming_services_facilities, null)
                        val dialog = BottomSheetDialog(activity!!)
                        dialog.setContentView(view)
                        dialog.show()
                    }

                    3 -> {
                        val view = layoutInflater.inflate(R.layout.upcoming_services_events, null)
                        val dialog = BottomSheetDialog(activity!!)
                        dialog.setContentView(view)
                        dialog.show()
                    }

                    4 -> {
                        val view = layoutInflater.inflate(R.layout.upcoming_services_parking, null)
                        val dialog = BottomSheetDialog(activity!!)
                        dialog.setContentView(view)
                        dialog.show()
                    }

                    5 -> {
                        val view = layoutInflater.inflate(R.layout.upcoming_services_fixit, null)
                        val dialog = BottomSheetDialog(activity!!)
                        dialog.setContentView(view)
                        dialog.show()
                    }
                }
            }
        })

        val quickLinksAdapter = QuickLinksAdapter(bulletinList, object : OnItemClickListener2 {
            override fun onItemClick(position: Int) {
                when (position) {
                    2 -> {
                        startActivity(Intent(activity, ContactUsActivity::class.java))
                    }
                }
            }
        })



        gridRecyclerView.layoutManager = GridLayoutManager(activity, 3)
        gridRecyclerView.setHasFixedSize(true)
        gridRecyclerView.itemAnimator = DefaultItemAnimator()
        gridRecyclerView.adapter = homeGridAdapter


        quickLinksRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        quickLinksRecyclerView.setHasFixedSize(true)
        quickLinksRecyclerView.itemAnimator = DefaultItemAnimator()
        quickLinksRecyclerView.adapter = quickLinksAdapter
    }

    private fun getBulletinList() {
        var bulletin = Home("Deals", R.drawable.ic_deals)
        bulletinList.add(bulletin)
        bulletin = Home("FAQs", R.drawable.ic_faqs)
        bulletinList.add(bulletin)
        bulletin = Home("Contact", R.drawable.ic_contact)
        bulletinList.add(bulletin)
    }

    private fun getGridList() {
        var grid = Home("Bridge+", 1)
        gridList.add(grid)
        grid = Home("Meeting\nRooms", R.drawable.ic_grid_meeting_room)
        gridList.add(grid)
        grid = Home("Facility\nBooking", R.drawable.ic_grid_facility_booking)
        gridList.add(grid)
        grid = Home("Events", R.drawable.ic_grid_events)
        gridList.add(grid)
        grid = Home("Parking", R.drawable.ic_grid_parking)
        gridList.add(grid)
        grid = Home("Fix It", R.drawable.ic_grid_fix_it)
        gridList.add(grid)
    }

    private fun roomListData() {
        try {
            val model: MyActvityViewModel =
                ViewModelProvider(this).get(MyActvityViewModel::class.java)
            model.getMyActivity(1)!!.observe(viewLifecycleOwner, Observer {
                Log.e("***getData", it!!.body().toString())
                myActivityDataList.addAll(it.body()!!.list)
                if (it.isSuccessful) {
                    if (it.body()!!.isValid) {
                        parsingData()

                    } else {
                        Toast.makeText(context, it.message(), Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Toast.makeText(context, it.message(), Toast.LENGTH_SHORT).show()
                }
            })

        } catch (e: Exception) {
            Log.e("EXception", e.message.toString())
        }
    }

    private fun parsingData(date: String = "-1") {
        myActivityDataSegrigation  = ArrayList<MyActivityDataSegrigation>()

        myActivityRecyclerView.isNestedScrollingEnabled = false
        val adapter = HomeScreenMyActivityAdapter(myActivityDataSegrigation, object : OnItemClickListener {
            override fun onItemClick() {
            }
        })
        myActivityRecyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        myActivityRecyclerView.setHasFixedSize(true)
        myActivityRecyclerView.itemAnimator = DefaultItemAnimator()
        myActivityRecyclerView.addItemDecoration(
            CirclePagerIndicatorDecoration()
        )

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(myActivityRecyclerView)
        myActivityRecyclerView.adapter = adapter

        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val currentDate = sdf.format(Date())

        for (i in 0 until myActivityDataList.size) {
            var data = MyActivityDataSegrigation()
            data.date = dateConverter(myActivityDataList[i].date)
            data.eventType = "Meeting Room"
            data.eventName = myActivityDataList[i].meetingRoom.name
            data.pax = "\t(" + myActivityDataList[i].meetingRoom.noOfPax.toString() + "\t Pax)"
            data.booking = dateConverter(myActivityDataList[i].createdDate)
            data.fromTime = myActivityDataList[i].fromTime
            data.toTime = myActivityDataList[i].toTime
            if (StringToDate1Conevrter(currentDate).equals(StringToDate1Conevrter(myActivityDataList[i].date.substringBefore("T")))) {
                myActivityDataSegrigation.add(data)
            }
        }
    }

    fun dateConverter(date: String): String {
        var spf = SimpleDateFormat("yyyy-MM-dd")
        val newDate: Date = spf.parse(date)
        spf = SimpleDateFormat("EEE, d MMM yyyy")
        return spf.format(newDate)
    }

    //***output is Date*******//
    fun StringToDate1Conevrter(dateS: String): Date {
        var newDate: Date? = null
        try {
            var spf = SimpleDateFormat("yyyy-MM-dd")
            val newDate: Date = spf.parse(dateS)
            return newDate
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Log.e("**DateException", e.message.toString())
        }
        return newDate!!
    }

}