package com.example.cswork.ui.userProfile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import com.example.cswork.R
import com.example.cswork.ui.changePassword.ResetPassword
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MoreOptionsFragment : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_more_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.change_password).setOnClickListener{
            requireActivity().startActivity(Intent(requireContext(), ResetPassword::class.java))
        }
        view.findViewById<TextView>(R.id.logout_view).setOnClickListener{

        }
        view.findViewById<TextView>(R.id.cancel_view).setOnClickListener{
            onDismiss(dialog!!)
        }
    }

}