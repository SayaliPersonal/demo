package com.example.cswork.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.example.cswork.R
import com.example.cswork.ui.HomeScreenActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectEmailFragment : BottomSheetDialogFragment() {
    lateinit var email1RadioButton: RadioButton
    lateinit var email2RadioButton: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_select_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email1RadioButton = view.findViewById(R.id.email1Button)
        email2RadioButton = view.findViewById(R.id.email2Button)

       email1RadioButton.setOnClickListener{
            onRadioButtonClicked(it)
           requireActivity().startActivity(Intent(activity, StartLoginWithEmailActivity::class.java))
        }

       email2RadioButton.setOnClickListener{
            onRadioButtonClicked(it)
           requireActivity().startActivity(Intent(activity, StartLoginWithEmailActivity::class.java))
        }
    }

    private fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.email1Button ->

                    if(checked){
//                        email1RadioButton.setBackgroundResource(R.drawable.ic_check)
                        email1RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0);
                        email2RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unchek, 0);
                    }else{
                        email1RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unchek, 0);
                        email2RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0);
                    }

                R.id.email2Button ->
                    if(checked){
                        email2RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0);
                        email1RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unchek, 0);
                    }else{
                        email2RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_unchek, 0);
                        email1RadioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check, 0);
                    }
            }
        }
    }

}