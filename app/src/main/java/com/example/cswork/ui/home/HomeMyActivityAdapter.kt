package com.example.cswork.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.meetingRoom.MeetingRoom

class HomeMyActivityAdapter(
    private var roomList: List<MeetingRoom>,
    onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<HomeMyActivityAdapter.MyViewHolder>() {

    var itemClickListener: OnItemClickListener = onItemClickListener

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val roomName: TextView = itemView.findViewById(R.id.roomName)
        fun bind(meetingRoom: MeetingRoom, onItemClickListener: OnItemClickListener) {
            roomName.text = meetingRoom.title + " (${meetingRoom.pax} Pax)"

            itemView.setOnClickListener {
                onItemClickListener.onItemClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.home_my_activity,
            parent, false
        )
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val meetingRoom = roomList[position]
        holder.bind(meetingRoom, itemClickListener)
    }

    override fun getItemCount(): Int {
        return roomList.size
    }
}
