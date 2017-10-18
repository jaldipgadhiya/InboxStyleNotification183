package com.android.acadgild.inboxstylenotification183;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button to show Inbox style notification
        btnNotification = (Button) findViewById(R.id.btnInboxNotification);

        //Onclick Listener for Button to generate notification
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //object of intent, it will be targeted activity where user will be redirected when click on notification.
                Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent piResult = PendingIntent.getActivity(MainActivity.this, 0, resultIntent, 0);

                //object of Notification.Builder.
                Notification.Builder builder=new Notification.Builder(getApplicationContext())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("ACADGILD Messages")
                        .setContentText("ANDROID")
                        .setContentIntent(piResult);

                // addLine() will be used to add messages,
                // while setSummaryText() will be used to show summary of your notification.
                Notification notification = new Notification.InboxStyle(builder)
                        .addLine("Hello..!")
                        .addLine("How are you?")
                        .addLine("Hiii!!")
                        .addLine("i am fine...")
                        .addLine("what about you? all is well?")
                        .addLine("Yes, every thing is all rignt..")
                        .setBigContentTitle("Here Your Messages")
                        .setSummaryText("+3 more")
                        .build();

                //to show notification in notification area
                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(121,notification);
            }
        });
    }
}
