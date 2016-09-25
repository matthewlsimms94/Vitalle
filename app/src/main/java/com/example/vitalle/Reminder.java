package com.example.vitalle;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;

/**
 * Created by samsung on 9/24/2016.
 */
public class Reminder {

    public static void scheduleNotification(Notification notification, int delay, Context context) {

        Intent notificationIntent = new Intent(context, MedicineNotification.class);
        notificationIntent.putExtra(MedicineNotification.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(MedicineNotification.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    public static Notification getNotification(String title, String content, Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.icon_test);
        return builder.build();
    }
}
