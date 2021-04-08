package com.example.cswork.ui.meetingRoom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.inviteMembers.InviteMember

class MeetingRoomAdapter(private var roomList : List<MeetingRoom>,
                         onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<MeetingRoomAdapter.MyViewHolder>() {

    var itemClickListener: OnItemClickListener = onItemClickListener
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomName: TextView = itemView.findViewById(R.id.roomNameView)
        fun bind(meetingRoom: MeetingRoom, onItemClickListener: OnItemClickListener){
//            roomName.text  = meetingRoom.title

            itemView.setOnClickListener{
                onItemClickListener.onItemClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_meeting_room, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val meetingRoom = roomList[position]
        holder.bind(meetingRoom, itemClickListener)
    }

    override fun getItemCount(): Int {
        return 5
    }
}
