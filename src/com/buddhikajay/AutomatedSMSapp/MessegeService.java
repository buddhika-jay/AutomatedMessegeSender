package com.buddhikajay.AutomatedSMSapp;

import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;


/**
 * Created by buddhika on 6/2/15.
 */
public class MessegeService extends Service {

    String address = "0715776316";
    String[] msgPart1 = {"Good morning", "Good night"};
    String[] msgPart2 = {"sudu", "patiyo"};
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //TODO uncomment sendSMS();
        Toast.makeText(this, getSms(), Toast.LENGTH_LONG).show();
        //sendSMS();
        return START_NOT_STICKY;
    }

    private String getSms(){

        Random random = new Random();
        int msg1Index = 0;
        //Messege generation
        Calendar calendar = Calendar.getInstance();
        //if AM
        if (calendar.get(Calendar.AM_PM) == Calendar.AM){
            msg1Index = 0;
        }
        else {
            msg1Index =1;
        }
        return msgPart1[msg1Index] + msgPart2[random.nextInt(msgPart2.length)];
    }

    protected void sendSMS(){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(address, null, getSms(), null, null);
            Toast.makeText(getApplicationContext(), "SMS sent", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "SMS sending failed", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /*protected void sendSMS(){
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", address);
        smsIntent.putExtra("sms_body", getSms());

        try {
            startActivity(smsIntent);
            finalize();
            Log.i("Finished Sending SMS", "");
            Toast.makeText(this, "SMS Sent", Toast.LENGTH_LONG).show();
        }
        catch (android.content.ActivityNotFoundException exception) {;
            Toast.makeText(MessegeService.this, "SMS Failed", Toast.LENGTH_SHORT).show();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/
}
