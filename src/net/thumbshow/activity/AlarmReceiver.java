package net.thumbshow.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		if ("android.alarm.demo.action".equals(arg1.getAction())) {
			 //��1�������õ�����ʱ�䵽��������Ե���������ʾ����������
			 //���Լ���������һ������ʱ��;
			Toast.makeText(arg0, "����ʱ�䵽��", 1).show();
			 return;
		}
	}

}
