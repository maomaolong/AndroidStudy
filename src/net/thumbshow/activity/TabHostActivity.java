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
	// 声明TabHost对象  
    TabHost xh_TabHost = null;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_tablehost);  
  
        // 取得TabHost对象  
        xh_TabHost = getTabHost();  
  
        /** 
         * 为TabHost添加标签 新建一个newTabSped(newTabSpec) 设置其标签和图标（setIndicator） 
         * 设置内容(setContent) 
         */  
        // TabSpec 是TabHost的内部类 TabHost对象的 newTabSpec()方法返回一个TabSpec对象 这个关系要搞清楚  
        /* 
         * 源码里边是这么写的 public TabSpec newTabSpec(String tag) { return new 
         * TabSpec(tag); } 
         */  
  
        xh_TabHost.addTab(xh_TabHost.newTabSpec("tab_test1")  
        // setIndicator()此方法用来设置标签和图表  
                .setIndicator("TAB 1",  
                        getResources().getDrawable(R.drawable.football))  
                // 指定内容为一个TextView --->public TabHost.TabSpec setContent (int  
                // viewId) 此方法需要一个 viewId 作为参数  
                .setContent(R.id.textview1));  
  
        xh_TabHost.addTab(xh_TabHost.newTabSpec("tab_test2").setIndicator(  
                "TAB 2", getResources().getDrawable(R.drawable.basketball))  
                .setContent(R.id.textview2));  
  
        xh_TabHost.addTab(xh_TabHost.newTabSpec("tab_test3").setIndicator(  
                "TAB 3", getResources().getDrawable(R.drawable.volleyball))  
                .setContent(R.id.textview3));  
  
        // 设置TabHost的背景颜色  
        xh_TabHost.setBackgroundColor(Color.argb(150, 22, 70, 150));  
  
        // 设置TabHost的背景图片资源  
        xh_TabHost.setBackgroundResource(R.drawable.backgroud);  
  
        // 设置当前显示哪一个标签 我的理解就是当你第一次启动程序默认显示那个标签 这里是指定的选项卡的ID从0开始  
        xh_TabHost.setCurrentTab(0);  
  
        // 标签切换事件处理，setOnTabChangedListener 注意是标签切换事件不是点击事件  
        // 就是从一个标签切换到另外一个标签会触发的事件  
        xh_TabHost.setOnTabChangedListener(new OnTabChangeListener() {  
            @Override  
            public void onTabChanged(String tabId) {  
                // 定义一个弹出式的对话框  
                Dialog dialog = new AlertDialog.Builder(TabHostActivity.this)  
                        .setTitle("提示").setMessage("当前选中了：" + tabId + "标签")  
                        .setPositiveButton("确定",  
                                new DialogInterface.OnClickListener() {  
                                    @Override  
                                    public void onClick(DialogInterface dialog,  
                                            int which) {  
                                        // 取消对话框  
                                        dialog.cancel();  
                                    }  
  
                                }).create();// 创建出一个“确定”按钮  
                // 启动此对话框并且显示在屏幕上  
                dialog.show();  
            }  
        });  
    }  
}
