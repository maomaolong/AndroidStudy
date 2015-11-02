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
	//����ProgressBar����  
    private ProgressBar xh_ProgressBar;  
    private ProgressBar xh_ProgressBar2;  
    private Button xh_Button;  
    protected static final int GUI_STOP_NOTIFIER = 0x108;  
    protected static final int GUI_THREADING_NOTIFIER = 0x109;  
    public int intCounter = 0;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        //���ô���ģʽ����Ϊ��Ҫ��ʾ�������ڱ�����  
        requestWindowFeature(Window.FEATURE_PROGRESS);  
        setProgressBarVisibility(true);  
        setContentView(R.layout.activity_progress2);  
  
        //�õ�ProgressBar  
        xh_ProgressBar = (ProgressBar) findViewById(R.id.ProgressBar01);  
        xh_ProgressBar2 = (ProgressBar) findViewById(R.id.ProgressBar02);  
        xh_Button = (Button) findViewById(R.id.Button01);  
  
        //���ý����� ��Ϊ ��ȷ��ģʽ  
        xh_ProgressBar.setIndeterminate(false);  
        xh_ProgressBar2.setIndeterminate(false);  
  
        //����ť����ʱ��ʼִ��  
        xh_Button.setOnClickListener(new Button.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                //����ProgressBarΪ�ɼ�״̬  
                xh_ProgressBar.setVisibility(View.VISIBLE);  
                xh_ProgressBar2.setVisibility(View.VISIBLE);  
                //����ProgressBar�����ֵ  
                xh_ProgressBar.setMax(100);  
                //����ProgressBar��ǰֵ  
                xh_ProgressBar.setProgress(0);  
                xh_ProgressBar2.setProgress(0);  
  
                //ͨ���߳����ı�ProgressBar��ֵ  
                new Thread(new Runnable() {  
                    @Override  
                    public void run() {  
                        for (int i = 0; i < 10; i++) {  
                            try {  
                                //���ý���ֵ  
                                intCounter = (i + 1) * 20;  
                                //˯��1000����  
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
            //ProgressBar�Ѿ������ֵ  
            case Progress2Activity.GUI_STOP_NOTIFIER:  
                xh_ProgressBar.setVisibility(View.GONE);  
                xh_ProgressBar2.setVisibility(View.GONE);  
                Thread.currentThread().interrupted();  
                break;  
            case Progress2Activity.GUI_THREADING_NOTIFIER:  
                if (!Thread.currentThread().isInterrupted()) {  
                    //�ı�ProgressBar�ĵ�ǰֵ  
                    xh_ProgressBar.setProgress(intCounter);  
                    xh_ProgressBar2.setProgress(intCounter);  
  
                    //���ñ�������ǰ����һ������������ֵ  
                    setProgress(intCounter * 100);  
                }  
                break;  
            }  
            super.handleMessage(msg);  
        }  
    };  
}
