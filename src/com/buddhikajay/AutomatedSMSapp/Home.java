package com.buddhikajay.AutomatedSMSapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Home extends Activity {
    /**
     * Called when the activity is first created.
     */

    Button buttonSingleMessege, buttonScheduledMesseges;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        buttonSingleMessege = (Button)findViewById(R.id.buttonSingle);
        buttonScheduledMesseges = (Button)findViewById(R.id.buttonSchedule);

        buttonSingleMessege.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Home.this, SingleMessege.class);
                    startActivity(intent);
                }
        });

        buttonScheduledMesseges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, ScheduledMesseges.class);
                startActivity(intent);
            }
        });
    }

}
