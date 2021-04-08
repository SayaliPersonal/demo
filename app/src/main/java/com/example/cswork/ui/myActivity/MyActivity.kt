package com.example.cswork.ui.myActivity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.calendar.CalendarFragment
import com.example.cswork.ui.calendar.DateSelectListener
import com.example.cswork.ui.home.FeedBackFragment
import com.example.cswork.ui.myActivity.DataClass.MyActivityData.MyActivityDataList
import com.example.cswork.ui.myActivity.DataClass.MyActivityDataSegrigation
import kotlinx.android.synthetic.main.activity_my.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MyActivity : AppCompatActivity(), DateSelectListener {
    private lateinit var myActivityAdapter: MyActivityAdapter
    val today = "2021-04-06";

    var myActivityDataList: ArrayList<MyActivityDataList> = ArrayList<MyActivityDataList>()
    lateinit var myActivityDataSegrigation: ArrayList<MyActivityDataSegrigation>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        progress_bar.visibility == View.VISIBLE

        val calenderView: ImageView = findViewById(R.id.calenderView)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()

        myActivityDataSegrigation = ArrayList<MyActivityDataSegrigation>()

        myActivityAdapter =
            MyActivityAdapter(myActivityDataSegrigation, object : OnItemClickListener {
                override fun onItemClick() {
                    val bottomSheetFragment = FeedBackFragment();
                    bottomSheetFragment.show(
                        supportFragmentManager,
                        bottomSheetFragment.tag
                    );
                }
            })
        recyclerView.adapter = myActivityAdapter

        calenderView.setOnClickListener {
            val bottomSheetFragment = CalendarFragment();
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
            bottomSheetFragment.setDateListener(this)

        }

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            parsingData("-1", "all")
        }
        roomListData()
    }

    private fun roomListData() {

        try {
            val model: MyActvityViewModel =
                ViewModelProvider(this).get(MyActvityViewModel::class.java)
            model.getMyActivity(1)!!.observe(this, Observer {
                Log.e("***getData", it!!.body().toString())
                myActivityDataList.addAll(it.body()!!.list)
                if (it.isSuccessful) {
                    if (it.body()!!.isValid) {
                        progress_bar.visibility == View.GONE
                        parsingData()

                    } else {
                        progress_bar.visibility == View.GONE
                        Toast.makeText(this, it.message(), Toast.LENGTH_SHORT).show()
                    }

                } else {
                    progress_bar.visibility == View.GONE
                    Toast.makeText(this, it.message(), Toast.LENGTH_SHORT).show()
                }
            })

        } catch (e: Exception) {
            Log.e("EXception", e.message.toString())
        }
    }

    private fun parsingData(date: String = "-1", key: String = "normal") {
        myActivityDataSegrigation.clear()

        for (i in 0 until myActivityDataList.size) {
            var data = MyActivityDataSegrigation()
            data.date = dateConverter(myActivityDataList[i].date)
            data.eventType = "Meeting Room"
            data.eventName = myActivityDataList[i].meetingRoom.name
            data.pax = "\t(" + myActivityDataList[i].meetingRoom.noOfPax.toString() + "\t Pax)"
            data.booking = dateConverter(myActivityDataList[i].createdDate)
            data.fromTime = myActivityDataList[i].fromTime
            data.toTime = myActivityDataList[i].toTime

            when (key) {
                "normal" -> {
                    val sdf = SimpleDateFormat("yyyy-MM-dd")
                    val currentDate: Date = StringToDate1Conevrter(sdf.format(Date()))
                    val date =   StringToDate1Conevrter(myActivityDataList[i].date.substringBefore("T"))
                    if (date.equals(currentDate) || date.after(currentDate))
                        {
                            myActivityDataSegrigation.add(data)
                        }
                }
                "calendar" -> {
                    if (StringToDate1Conevrter(date).equals(
                            StringToDate1Conevrter(myActivityDataList[i].date.substringBefore("T"))
                        )
                    ) {
                        myActivityDataSegrigation.add(data)
                    }
                }
                "all" -> {
                    myActivityDataSegrigation.add(data)
                }
            }

        }
        if ( myActivityDataSegrigation.isEmpty())
        {
            no_data_found.visibility=View.VISIBLE
        }else
        {
            no_data_found.visibility=View.GONE
        }
        recyclerView.adapter!!.notifyDataSetChanged()
    }


    fun onBackClick(view: View) {
        onBackPressed()
    }


    //***output is String value*******//
    fun StringToDateConevrter(dateS: String): String {
        var formateDate: String? = null
        try {
            var spf = SimpleDateFormat("yyyy-MM-dd")
            val newDate: Date = spf.parse(dateS)
            formateDate = dateS.format(newDate)
            Log.e("**convert", formateDate)
            return formateDate
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Log.e("**DateException", e.message.toString())
        }
        return formateDate!!
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

    //****covesrion of date into one fromat
    fun dateConverter(date: String): String {
        var spf = SimpleDateFormat("yyyy-MM-dd")
        val newDate: Date = spf.parse(date)
        spf = SimpleDateFormat("EEE, d MMM yyyy")
        return spf.format(newDate)
    }

    override fun selectDate(date: String?) {
        parsingData(date!!, "calendar")
//        Toast.makeText(this, date, Toast.LENGTH_SHORT).show()
    }
}


