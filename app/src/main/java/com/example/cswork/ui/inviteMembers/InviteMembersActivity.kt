package com.example.cswork.ui.inviteMembers

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cswork.R
import com.example.cswork.ui.OnItemClickListener
import com.example.cswork.ui.calendar.CalendarFragment
import com.example.cswork.ui.login.StartLoginActivity
import com.example.cswork.ui.login.StartLoginActivity2
import com.example.cswork.ui.login.StartLoginWithEmailActivity

class InviteMembersActivity : AppCompatActivity() {

    private var members = ArrayList<InviteMember>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_members)

        inviteMembersList()

        val recyclerView: RecyclerView = findViewById(R.id.inviteMembersRecyclerView)
        val searchView: SearchView = findViewById(R.id.search_view)
        val inviteMembersAdapter = InviteMembersAdapter(members, object : OnItemClickListener {
            override fun onItemClick() {

            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = inviteMembersAdapter

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                inviteMembersAdapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun inviteMembersList() {
        var member = InviteMember("Aman Kumar", "aman@gmail.com", 1, false)
        members.add(member)
        member = InviteMember("Arun Jain", "arun@gmail.com", 1, false)
        members.add(member)
        member = InviteMember("Bhakti Singh", "b.singh@gmail.com", 1, false)
        members.add(member)
        member = InviteMember("Chinmayi Vaerma", "cvaerma@gmail.com", 1, false)
        members.add(member)
        member = InviteMember("Sneha Singh", "sneha.s@gmail.com", 1, false)
        members.add(member)

    }

    fun onAddClick(view: View) {
            val bottomSheetFragment = AddMemberFragment();
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag);
    }

    fun onOpenQr(view: View) {
        startActivity(Intent(this, StartLoginActivity2::class.java))
    }
}