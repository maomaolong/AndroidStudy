package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class TabHostActivity extends TabActivity {
	// ����TabHost����  
    TabHost xh_TabHost = null;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_tablehost);  
  
        // ȡ��TabHost����  
        xh_TabHost = getTabHost();  
  
        /** 
         * ΪTabHost��ӱ�ǩ �½�һ��newTabSped(newTabSpec) �������ǩ��ͼ�꣨setIndicator�� 
         * ��������(setContent) 
         */  
        // TabSpec ��TabHost���ڲ��� TabHost����� newTabSpec()��������һ��TabSpec���� �����ϵҪ�����  
        /* 
         * Դ���������ôд�� public TabSpec newTabSpec(String tag) { return new 
         * TabSpec(tag); } 
         */  
  
        xh_TabHost.addTab(xh_TabHost.newTabSpec("tab_test1")  
        // setIndicator()�˷����������ñ�ǩ��ͼ��  
                .setIndicator("TAB 1",  
                        getResources().getDrawable(R.drawable.football))  
                // ָ������Ϊһ��TextView --->public TabHost.TabSpec setContent (int  
                // viewId) �˷�����Ҫһ�� viewId ��Ϊ����  
                .setContent(R.id.textview1));  
  
        xh_TabHost.addTab(xh_TabHost.newTabSpec("tab_test2").setIndicator(  
                "TAB 2", getResources().getDrawable(R.drawable.basketball))  
                .setContent(R.id.textview2));  
  
        xh_TabHost.addTab(xh_TabHost.newTabSpec("tab_test3").setIndicator(  
                "TAB 3", getResources().getDrawable(R.drawable.volleyball))  
                .setContent(R.id.textview3));  
  
        // ����TabHost�ı�����ɫ  
        xh_TabHost.setBackgroundColor(Color.argb(150, 22, 70, 150));  
  
        // ����TabHost�ı���ͼƬ��Դ  
        xh_TabHost.setBackgroundResource(R.drawable.backgroud);  
  
        // ���õ�ǰ��ʾ��һ����ǩ �ҵ������ǵ����һ����������Ĭ����ʾ�Ǹ���ǩ ������ָ����ѡ���ID��0��ʼ  
        xh_TabHost.setCurrentTab(0);  
  
        // ��ǩ�л��¼�����setOnTabChangedListener ע���Ǳ�ǩ�л��¼����ǵ���¼�  
        // ���Ǵ�һ����ǩ�л�������һ����ǩ�ᴥ�����¼�  
        xh_TabHost.setOnTabChangedListener(new OnTabChangeListener() {  
            @Override  
            public void onTabChanged(String tabId) {  
                // ����һ������ʽ�ĶԻ���  
                Dialog dialog = new AlertDialog.Builder(TabHostActivity.this)  
                        .setTitle("��ʾ").setMessage("��ǰѡ���ˣ�" + tabId + "��ǩ")  
                        .setPositiveButton("ȷ��",  
                                new DialogInterface.OnClickListener() {  
                                    @Override  
                                    public void onClick(DialogInterface dialog,  
                                            int which) {  
                                        // ȡ���Ի���  
                                        dialog.cancel();  
                                    }  
  
                                }).create();// ������һ����ȷ������ť  
                // �����˶Ի�������ʾ����Ļ��  
                dialog.show();  
            }  
        });  
    }  
}
