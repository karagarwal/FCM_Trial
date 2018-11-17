package com.agarwal.fcmtrialproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String token;
    Switch switchNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchNotification = findViewById(R.id.switchNotification);
        switchNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    FirebaseMessaging.getInstance().subscribeToTopic("RECEIVE_NOTIFICATION_UPDATES");
                    Toast.makeText(getApplicationContext(), "Notification On", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("RECEIVE_NOTIFICATION_UPDATES");
                    Toast.makeText(getApplicationContext(), "Notification Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
