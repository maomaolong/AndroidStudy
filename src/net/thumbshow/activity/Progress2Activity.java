package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class Progress2Activity extends Activity {
	//声明ProgressBar对象  
    private ProgressBar xh_ProgressBar;  
    private ProgressBar xh_ProgressBar2;  
    private Button xh_Button;  
    protected static final int GUI_STOP_NOTIFIER = 0x108;  
    protected static final int GUI_THREADING_NOTIFIER = 0x109;  
    public int intCounter = 0;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        //设置窗口模式，因为需要显示进度条在标题栏  
        requestWindowFeature(Window.FEATURE_PROGRESS);  
        setProgressBarVisibility(true);  
        setContentView(R.layout.activity_progress2);  
  
        //得到ProgressBar  
        xh_ProgressBar = (ProgressBar) findViewById(R.id.ProgressBar01);  
        xh_ProgressBar2 = (ProgressBar) findViewById(R.id.ProgressBar02);  
        xh_Button = (Button) findViewById(R.id.Button01);  
  
        //设置进度条 不为 不确定模式  
        xh_ProgressBar.setIndeterminate(false);  
        xh_ProgressBar2.setIndeterminate(false);  
  
        //当按钮按下时开始执行  
        xh_Button.setOnClickListener(new Button.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                //设置ProgressBar为可见状态  
                xh_ProgressBar.setVisibility(View.VISIBLE);  
                xh_ProgressBar2.setVisibility(View.VISIBLE);  
                //设置ProgressBar的最大值  
                xh_ProgressBar.setMax(100);  
                //设置ProgressBar当前值  
                xh_ProgressBar.setProgress(0);  
                xh_ProgressBar2.setProgress(0);  
  
                //通过线程来改变ProgressBar的值  
                new Thread(new Runnable() {  
                    @Override  
                    public void run() {  
                        for (int i = 0; i < 10; i++) {  
                            try {  
                                //设置进度值  
                                intCounter = (i + 1) * 20;  
                                //睡眠1000毫秒  
                                Thread.sleep(1000);  
  
                                if (i == 4) {  
                                    Message m = new Message();  
  
                                    m.what = Progress2Activity.GUI_STOP_NOTIFIER;  
                                    Progress2Activity.this.myMessageHandler  
                                            .sendMessage(m);  
                                    break;  
                                } else {  
                                    Message m = new Message();  
                                    m.what = Progress2Activity.GUI_THREADING_NOTIFIER;  
                                    Progress2Activity.this.myMessageHandler  
                                            .sendMessage(m);  
                                }  
  
                            } catch (Exception e) {  
                                e.printStackTrace();  
                            }  
                        }  
                    }  
  
                }).start();  
            }  
  
        });  
    }  
  
    Handler myMessageHandler = new Handler() {  
        @Override  
        public void handleMessage(Message msg) {  
            switch (msg.what) {  
            //ProgressBar已经是最大值  
            case Progress2Activity.GUI_STOP_NOTIFIER:  
                xh_ProgressBar.setVisibility(View.GONE);  
                xh_ProgressBar2.setVisibility(View.GONE);  
                Thread.currentThread().interrupted();  
                break;  
            case Progress2Activity.GUI_THREADING_NOTIFIER:  
                if (!Thread.currentThread().isInterrupted()) {  
                    //改变ProgressBar的当前值  
                    xh_ProgressBar.setProgress(intCounter);  
                    xh_ProgressBar2.setProgress(intCounter);  
  
                    //设置标题栏中前景的一个进度条进度值  
                    setProgress(intCounter * 100);  
                }  
                break;  
            }  
            super.handleMessage(msg);  
        }  
    };  
}
