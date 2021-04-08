package com.example.cswork.ui.meetingRoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cswork.R;

public class MeetingRoomDetails2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_room_details2);
        timeLineBar();
    }

    private void timeLineBar(){

        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_meeting_room_details2, null);

        LinearLayout parentLayout = (LinearLayout)findViewById(R.id.parent);
        View textView = new View(this);
        parentLayout.addView(textView);

    }
}