package com.buddhikajay.AutomatedSMSapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by buddhika on 6/2/15.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Fired", Toast.LENGTH_LONG).show();
        intent = new Intent(context,MessegeService.class);
        context.startService(intent);
        context.stopService(intent);
    }

}
