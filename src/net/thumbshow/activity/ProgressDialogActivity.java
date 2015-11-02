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
    // �����������Ի���  
    ProgressDialog xh_pDialog;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_progressdialog);  
  
        // �õ���ť����  
        xhButton01 = (Button) findViewById(R.id.Button01);  
        xhButton02 = (Button) findViewById(R.id.Button02);  
  
        // ����xhButton01���¼�����  
        xhButton01.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                // ����ProgressDialog����  
                xh_pDialog = new ProgressDialog(ProgressDialogActivity.this);  
  
                // ���ý�������񣬷��ΪԲ�Σ���ת��  
                xh_pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);  
  
                // ����ProgressDialog ����  
                xh_pDialog.setTitle("��ʾ");  
  
                // ����ProgressDialog��ʾ��Ϣ  
                xh_pDialog.setMessage("����һ��Բ�ν������Ի���");  
  
                // ����ProgressDialog����ͼ��  
                xh_pDialog.setIcon(R.drawable.football);  
  
                // ����ProgressDialog �Ľ������Ƿ���ȷ false ���ǲ�����Ϊ����ȷ  
                xh_pDialog.setIndeterminate(false);  
  
                // ����ProgressDialog �Ƿ���԰��˻ؼ�ȡ��  
                xh_pDialog.setCancelable(true);  
  
                // ����ProgressDialog ��һ��Button  
                xh_pDialog.setButton("ȷ��", new DialogInterface.OnClickListener() {  
                    @Override  
                    public void onClick(DialogInterface dialog, int which) {  
                        // �����ȷ������ťȡ���Ի���  
                        dialog.cancel();  
                    }  
                });  
  
                // ��ProgressDialog��ʾ  
                xh_pDialog.show();  
            }  
  
        });  
  
        // ����xhButton02���¼�����  
        xhButton02.setOnClickListener(new Button.OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
  
                xh_count = 0;  
  
                // ����ProgressDialog����  
                xh_pDialog = new ProgressDialog(ProgressDialogActivity.this);  
  
                // ���ý�������񣬷��ΪԲ�Σ���ת��  
                xh_pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  
  
                // ����ProgressDialog ����  
                xh_pDialog.setTitle("��ʾ");  
  
                // ����ProgressDialog��ʾ��Ϣ  
                xh_pDialog.setMessage("����һ�����ν������Ի���");  
  
                // ����ProgressDialog����ͼ��  
                xh_pDialog.setIcon(R.drawable.football);  
  
                // ����ProgressDialog �Ľ������Ƿ���ȷ false ���ǲ�����Ϊ����ȷ  
                xh_pDialog.setIndeterminate(false);  
  
                // ����ProgressDialog ����������  
                xh_pDialog.setProgress(100);  
  
                // ����ProgressDialog �Ƿ���԰��˻ؼ�ȡ��  
                xh_pDialog.setCancelable(true);  
  
                // ��ProgressDialog��ʾ  
                xh_pDialog.show();  
  
                new Thread() {  
                    @Override  
                    public void run() {  
                        try {  
                            while (xh_count <= 100) {  
                                // ���߳������ƽ���  
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
