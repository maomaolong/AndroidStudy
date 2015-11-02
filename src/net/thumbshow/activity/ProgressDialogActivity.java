package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProgressDialogActivity extends Activity {
    private Button xhButton01, xhButton02;  
    
    int xh_count = 0;  
    // 声明进度条对话框  
    ProgressDialog xh_pDialog;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_progressdialog);  
  
        // 得到按钮对象  
        xhButton01 = (Button) findViewById(R.id.Button01);  
        xhButton02 = (Button) findViewById(R.id.Button02);  
  
        // 设置xhButton01的事件监听  
        xhButton01.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                // 创建ProgressDialog对象  
                xh_pDialog = new ProgressDialog(ProgressDialogActivity.this);  
  
                // 设置进度条风格，风格为圆形，旋转的  
                xh_pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);  
  
                // 设置ProgressDialog 标题  
                xh_pDialog.setTitle("提示");  
  
                // 设置ProgressDialog提示信息  
                xh_pDialog.setMessage("这是一个圆形进度条对话框");  
  
                // 设置ProgressDialog标题图标  
                xh_pDialog.setIcon(R.drawable.football);  
  
                // 设置ProgressDialog 的进度条是否不明确 false 就是不设置为不明确  
                xh_pDialog.setIndeterminate(false);  
  
                // 设置ProgressDialog 是否可以按退回键取消  
                xh_pDialog.setCancelable(true);  
  
                // 设置ProgressDialog 的一个Button  
                xh_pDialog.setButton("确定", new DialogInterface.OnClickListener() {  
                    @Override  
                    public void onClick(DialogInterface dialog, int which) {  
                        // 点击“确定”按钮取消对话框  
                        dialog.cancel();  
                    }  
                });  
  
                // 让ProgressDialog显示  
                xh_pDialog.show();  
            }  
  
        });  
  
        // 设置xhButton02的事件监听  
        xhButton02.setOnClickListener(new Button.OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
  
                xh_count = 0;  
  
                // 创建ProgressDialog对象  
                xh_pDialog = new ProgressDialog(ProgressDialogActivity.this);  
  
                // 设置进度条风格，风格为圆形，旋转的  
                xh_pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  
  
                // 设置ProgressDialog 标题  
                xh_pDialog.setTitle("提示");  
  
                // 设置ProgressDialog提示信息  
                xh_pDialog.setMessage("这是一个长形进度条对话框");  
  
                // 设置ProgressDialog标题图标  
                xh_pDialog.setIcon(R.drawable.football);  
  
                // 设置ProgressDialog 的进度条是否不明确 false 就是不设置为不明确  
                xh_pDialog.setIndeterminate(false);  
  
                // 设置ProgressDialog 进度条进度  
                xh_pDialog.setProgress(100);  
  
                // 设置ProgressDialog 是否可以按退回键取消  
                xh_pDialog.setCancelable(true);  
  
                // 让ProgressDialog显示  
                xh_pDialog.show();  
  
                new Thread() {  
                    @Override  
                    public void run() {  
                        try {  
                            while (xh_count <= 100) {  
                                // 由线程来控制进度  
                                xh_pDialog.setProgress(xh_count++);  
                                Thread.sleep(100);  
                            }  
                            xh_pDialog.cancel();  
                        } catch (Exception e) {  
                            xh_pDialog.cancel();  
                        }  
                    }  
                }.start();  
  
            }  
  
        });  
    }  
}
