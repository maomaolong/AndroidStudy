package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;  
import android.app.Notification;  
import android.app.NotificationManager;  
import android.app.PendingIntent;  
import android.content.Context;  
import android.content.Intent;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
  
public class NotificationActivity extends Activity {  
    private Button startBtn;  
    private Button cancelBtn;  
    private static final int HELLO_ID = 1;  
    NotificationManager mNotificationManager;  
    Notification mNotification;  
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_notification);  
          
        startBtn = (Button)findViewById(R.id.button1);  
        cancelBtn = (Button)findViewById(R.id.button2);  
          
        // ① 获取NotificationManager的引用   
        String ns = Context.NOTIFICATION_SERVICE;  
        mNotificationManager = (NotificationManager)this.getSystemService(ns);  
          
          
        // ② 初始化Notification  
        int icon = R.drawable.ic_launcher;  
        CharSequence tickerText = "Hello";  
        long when = System.currentTimeMillis();  
        mNotification = new Notification(icon,tickerText,when);  
        mNotification.defaults = Notification.DEFAULT_ALL;  
        mNotification.flags |= Notification.FLAG_NO_CLEAR;  
        mNotification.flags |= Notification.FLAG_SHOW_LIGHTS;  
        // ③ 定义notification的消息 和 PendingIntent  
        Context context = this;  
        CharSequence contentTitle ="My notification";  
        CharSequence contentText = "Hello World";  
        Intent notificationIntent = new Intent(this,MainActivity.class);  
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,0 );  
        mNotification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);  
          
        // ④ 把封装好的notification传入NotificationManager  
          
          
        // 开启通知  
        startBtn.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                mNotificationManager.notify(HELLO_ID,mNotification);  
                  
            }  
        });  
          
        // 取消通知  
        cancelBtn.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                mNotificationManager.cancel(HELLO_ID);  
                  
            }  
        });  
    }  
}  
