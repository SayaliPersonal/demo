package com.example.cswork.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cswork.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class CalendarFragment : BottomSheetDialogFragment() {
    private var dateSelectListener: DateSelectListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setDateListener(dateSelectListener: DateSelectListener) {
        this.dateSelectListener = dateSelectListener
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val curDate = java.lang.String.valueOf(dayOfMonth)
            val Year = java.lang.String.valueOf(year)
            val Month = java.lang.String.valueOf(month+1)

            val inputText= "$Year-$Month-$curDate"
            // Note, MM is months, not mm
            // Note, MM is months, not mm
            val outputFormat: DateFormat =
                SimpleDateFormat("yyyy-MM-dd", Locale.US)
            val inputFormat: DateFormat =
                SimpleDateFormat("yyyy-MM-dd", Locale.US)

            val date = inputFormat.parse(inputText)
            val outputText = outputFormat.format(date)
            dateSelectListener!!.selectDate( outputText)
        }

//        calendarView.setOnDateChangeListener(OnDateChangeListener { _, year, month, dayOfMonth −>
//            val date = dayOfMonth.toString() + "−" + (month + 1) + "−" + year
//            dateView.text = date
//        })
    }

}
interface DateSelectListener {
    fun selectDate(date: String?)
}