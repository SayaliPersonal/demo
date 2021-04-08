package com.example.cswork.ui.myActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.myActivity.DataClass.MyActivityData.MyActivityDataList
import com.example.cswork.ui.myActivity.DataClass.MyActivityDataSegrigation
import kotlinx.android.synthetic.main.layout_my_activity.view.*

class MyActivityAdapter(
    private var myActivityDataSegrigation: List<MyActivityDataSegrigation>,
    onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<MyActivityAdapter.MyViewHolder>() {

    //    var itemClickListener: OnItemClickListener = onItemClickListener
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventName: TextView
        val eventType: TextView
        val timeView: TextView
        val bookindDate: TextView
        val dateView: TextView
        init {
            eventName = itemView.eventName
            eventType = itemView.eventType
            timeView = itemView.timeView
            bookindDate = itemView.descriptionView
            dateView = itemView.dateView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_my_activity, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.dateView.text = myActivityDataSegrigation.get(position).date
        holder.eventType.text = myActivityDataSegrigation.get(position).eventType+myActivityDataSegrigation.get(position).pax
        holder.eventName.text = myActivityDataSegrigation.get(position).eventName
        holder.timeView.text = myActivityDataSegrigation.get(position).fromTime+" - "+myActivityDataSegrigation.get(position).toTime
        holder.bookindDate.text = "Booked on\t"+myActivityDataSegrigation.get(position).booking
    }

    override fun getItemCount(): Int {
        return myActivityDataSegrigation.size
    }
}
