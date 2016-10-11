package com.salim3dd.alertreceiver;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TextView TextView_Time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView_Time= (TextView) findViewById(R.id.TextView_Time);

    }

    public void btn_set_alarm(View view) {

        showDialog(1);

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 4);
//        calendar.set(Calendar.MINUTE, 34);
//        calendar.set(Calendar.SECOND, 0);
//
//        Intent alertIntent = new Intent(getApplicationContext(), AlertReceiver.class);
//        AlarmManager alarmManager = (AlarmManager) getSystemService( ALARM_SERVICE );
//
////        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), PendingIntent.getBroadcast(getApplicationContext(), 0, alertIntent,
////                PendingIntent.FLAG_UPDATE_CURRENT ));
//
//        /////
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY , PendingIntent.getBroadcast(getApplicationContext(), 0, alertIntent,
//                PendingIntent.FLAG_UPDATE_CURRENT ));

//        alarmManager.cancel(PendingIntent.getBroadcast(getApplicationContext(),0,alertIntent,PendingIntent.FLAG_UPDATE_CURRENT));

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar c = Calendar.getInstance();
        if (id == 1)
        return new TimePickerDialog(MainActivity.this, TimeMap, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false);
        return null;

    }

    protected TimePickerDialog.OnTimeSetListener TimeMap =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker TimeP, int hourOfDay, int minute) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute);
                    calendar.set(Calendar.SECOND, 0);

                    Intent alertIntent = new Intent(getApplicationContext(), AlertReceiver.class);
                    AlarmManager alarmManager = (AlarmManager) getSystemService( ALARM_SERVICE );

                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), PendingIntent.getBroadcast(getApplicationContext(), 0, alertIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT ));

                    TextView_Time.setText(hourOfDay + ":" + minute);

                }
            };
}
