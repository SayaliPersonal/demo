package com.example.cswork.ui.calendar

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.CalendarView
import androidx.annotation.RequiresApi

class CalendarCustom : CalendarView {
    constructor(context: Context) : super(context) {}
    constructor(context: Context,
                attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context,
                attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun setOnDateChangeListener(listener: OnDateChangeListener) {
        super.setOnDateChangeListener(listener)
    }

    interface OnDateSelect{

    }
}