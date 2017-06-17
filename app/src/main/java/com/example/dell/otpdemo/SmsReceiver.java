package com.example.dell.otpdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        final Bundle bundle = intent.getExtras();
        try
        {
            if (bundle != null)
            {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                String format = bundle.getString("format");
                for (int i = 0; i < pdusObj.length; i++)
                {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String message = currentMessage .getDisplayMessageBody();
                    Log.i("Message",  currentMessage.getMessageBody());
                    Toast.makeText(context, "SMS Received : "+currentMessage.getMessageBody(),Toast.LENGTH_LONG).show();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}