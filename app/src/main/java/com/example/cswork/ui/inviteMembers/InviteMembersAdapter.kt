package com.example.cswork.ui.inviteMembers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener

class InviteMembersAdapter(
    private var members: ArrayList<InviteMember>,
    onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<InviteMembersAdapter.MyViewHolder>(), Filterable {
    var itemClickListener: OnItemClickListener = onItemClickListener

    var membersList = ArrayList<InviteMember>()

    init {
        membersList = members
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val parentLayout: ConstraintLayout = itemView.findViewById(R.id.parentLayout)
        private val nameView: TextView = itemView.findViewById(R.id.nameView)
        private val emailView: TextView = itemView.findViewById(R.id.emailView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val selectionView: ImageView = itemView.findViewById(R.id.selectionView)

        fun bind(inviteMember: InviteMember, onItemClickListener: OnItemClickListener) {
            nameView.text = inviteMember.name
            emailView.text = inviteMember.email
//            selectionView.setBackgroundResource(R.drawable.ic_unchek)
            parentLayout.setOnClickListener{
                inviteMember.isSelected = !inviteMember.isSelected
                if(inviteMember.isSelected){
                    selectionView.setBackgroundResource(R.drawable.ic_check)
                }else{
                    selectionView.setBackgroundResource(R.drawable.ic_unchek)
                }
            }

//            itemView.setOnClickListener {
//                onItemClickListener.onItemClick()
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_invite_member_row, parent, false
        )
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val member: InviteMember = membersList[position]
        holder.bind(member, itemClickListener)
    }

    override fun getItemCount(): Int {
        return membersList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    membersList = members
                } else {
                    val resultList = ArrayList<InviteMember>()
                    for (row in members) {
                        if (row.name.toLowerCase().contains(charSearch.toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    membersList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = membersList
                return filterResults
            }

            //            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                membersList = results?.values as ArrayList<InviteMember>
                notifyDataSetChanged()
            }

        }
    }
}
