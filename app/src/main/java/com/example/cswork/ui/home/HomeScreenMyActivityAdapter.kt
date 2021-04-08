package com.example.cswork.ui.myActivity

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.myActivity.DataClass.MyActivityDataSegrigation
import kotlinx.android.synthetic.main.layout_my_activity.view.eventType
import kotlinx.android.synthetic.main.layout_my_activity.view.timeView
import kotlinx.android.synthetic.main.layout_my_activity_home.view.*
import java.text.SimpleDateFormat
import java.util.*

class HomeScreenMyActivityAdapter(
    private var myActivityDataSegrigation: List<MyActivityDataSegrigation>,
    onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<HomeScreenMyActivityAdapter.MyViewHolder>() {

    //    var itemClickListener: OnItemClickListener = onItemClickListener
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventType: TextView
        val timeView: TextView
        val dateView_day: TextView
        val dateView_mon: TextView
        init {
            eventType = itemView.eventType
            timeView = itemView.timeView
            dateView_day = itemView.dateView_day
            dateView_mon = itemView.dateView_mon
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_my_activity_home, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val input_date = myActivityDataSegrigation.get(position).date
        val format1 = SimpleDateFormat("EEE, dd MMM yyyy")
        val dt1: Date = format1.parse(input_date)

        val day = DateFormat.format("dd",dt1 )
        val monthString = DateFormat.format("MMM", dt1)

        holder.dateView_day.text =day
        holder.dateView_mon.text =monthString
        holder.eventType.text = myActivityDataSegrigation.get(position).eventType+myActivityDataSegrigation.get(position).pax
        holder.timeView.text = myActivityDataSegrigation.get(position).fromTime+" - "+myActivityDataSegrigation.get(position).toTime
    }

    override fun getItemCount(): Int {
        return myActivityDataSegrigation.size
    }
}
