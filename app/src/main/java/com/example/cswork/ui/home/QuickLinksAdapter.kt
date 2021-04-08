package com.example.cswork.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.OnItemClickListener2

class QuickLinksAdapter(private var list : List<Home>,
                        onItemClickListener: OnItemClickListener2
) :
    RecyclerView.Adapter<QuickLinksAdapter.MyViewHolder>() {

    var itemClickListener: OnItemClickListener2 = onItemClickListener
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.titleView)
        fun bind(home: Home, onItemClickListener: OnItemClickListener2){
            titleView.text  = home.title
            titleView.setCompoundDrawablesWithIntrinsicBounds(home.icon, 0,0,0)

            itemView.setOnClickListener{
                onItemClickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_outline_text_icon,
            parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val meetingRoom = list[position]
        holder.bind(meetingRoom, itemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
