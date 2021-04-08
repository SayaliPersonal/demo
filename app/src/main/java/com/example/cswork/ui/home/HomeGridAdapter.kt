package com.example.cswork.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener2

class HomeGridAdapter(
    private var list: List<Home>,
    onItemClickListener: OnItemClickListener2
) :
    RecyclerView.Adapter<HomeGridAdapter.MyViewHolder>() {
    var itemClickListener: OnItemClickListener2 = onItemClickListener

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.cardView)
        private val bridgePlusCardView: CardView = itemView.findViewById(R.id.bridgePlusCardView)
        private val iconView: ImageView = itemView.findViewById(R.id.iconView)
        private val titleView: TextView = itemView.findViewById(R.id.titleView)

        fun bind(home: Home, onItemClickListener: OnItemClickListener2) {

            if (home.title == "Bridge+") {
                cardView.visibility = View.GONE
                bridgePlusCardView.visibility = View.VISIBLE
            } else {
                cardView.visibility = View.VISIBLE
                bridgePlusCardView.visibility = View.GONE
                titleView.text = home.title
                iconView.setBackgroundResource(home.icon)
            }

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_home_grid,
            parent, false
        )
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
