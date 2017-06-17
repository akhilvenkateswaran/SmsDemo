package com.example.dell.otpdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{

    TextView OtpNumber;
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_receiver);
        OtpNumber = (TextView) findViewById(R.id.otpTextView);
        Intent intent = getIntent();
        String message = intent.getStringExtra("OTP");
        OtpNumber.setText(message);
    }



}