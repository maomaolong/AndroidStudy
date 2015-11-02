package net.thumbshow.activity;

import java.util.Calendar;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlarmActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent("android.alarm.demo.action");
				PendingIntent sender = PendingIntent.getBroadcast(AlarmActivity.this,  
				 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);  
				   
				// We want the alarm to go off 30 seconds from now.  
				Calendar calendar = Calendar.getInstance();  
				calendar.setTimeInMillis(System.currentTimeMillis());  
				calendar.add(Calendar.SECOND, 5);  
				   
				// Schedule the alarm!  
				AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);  
				am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
			}
			
		});
	}

}
