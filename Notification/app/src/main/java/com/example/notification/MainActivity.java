package com.example.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify (View v) {
        Intent[] resultIntent = { new Intent(this, MainActivity.class) };
        PendingIntent resultPendingIntent = PendingIntent.getActivities(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        long[] vt = { 2, 3, 5, 6 };

        int id = new Random().nextInt();

        System.out.println(id);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("大风蓝色预警")
                .setContentText("北京市海淀区将临八级大风")
                .setAutoCancel(true)
                .setNumber(3)
                .setVibrate(vt)
                .setContentIntent(resultPendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(id, builder.build());
    }
}
