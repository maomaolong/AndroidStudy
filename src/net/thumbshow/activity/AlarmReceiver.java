package net.thumbshow.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		if ("android.alarm.demo.action".equals(arg1.getAction())) {
			 //第1步中设置的闹铃时间到，这里可以弹出闹铃提示并播放响铃
			 //可以继续设置下一次闹铃时间;
			Toast.makeText(arg0, "闹铃时间到啦", 1).show();
			 return;
		}
	}

}
