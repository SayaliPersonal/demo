package com.example.cswork.ui.changePassword

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cswork.R
import com.example.cswork.utils.PasswordStrength
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPassword : AppCompatActivity(), TextWatcher {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        edit_password.addTextChangedListener(this)

        help_icon.setOnClickListener {
            val view: View = layoutInflater.inflate(R.layout.layout_password_criteria, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        updatePasswordStrengthView(s.toString())
    }

    private fun updatePasswordStrengthView(password: String) {


        if (TextView.VISIBLE != rpt_pass_status.visibility) return
        if (password.isEmpty()) {
            rpt_pass_status.text = ""
            progress_arp_pass_len.progress = 0
            return
        }
        val str: PasswordStrength = PasswordStrength.calculateStrength(password)
        rpt_pass_status.setText(str.getText(this))
        rpt_pass_status.setTextColor(str.getColor())

        progress_arp_pass_len.progressDrawable.setColorFilter(
            str.color,
            android.graphics.PorterDuff.Mode.SRC_IN
        )

        if (str.getText(this).equals("Weak")) {
            progress_arp_pass_len.progress = 25
        } else if (str.getText(this).equals("Medium")) {
            progress_arp_pass_len.progress = 50
        } else if (str.getText(this).equals("Strong")) {
            progress_arp_pass_len.progress = 75
        } else {
            progress_arp_pass_len.progress = 100
        }
    }
}



