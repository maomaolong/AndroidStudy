package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;  
import android.os.Bundle;  
import android.os.Handler;  
import android.view.View;  
import android.widget.Button;  
import android.widget.LinearLayout;  
import android.widget.ScrollView;  
import android.widget.TextView;  
  
public class ScrollViewActivity extends Activity  
{  
    private LinearLayout mLayout;     
    private ScrollView  mScrollView;     
    private final Handler mHandler = new Handler();    
      
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_scrollview);  
          
        //����һ�����Բ���  
        mLayout = (LinearLayout) findViewById(R.id.layout);     
        //����һ��ScrollView����  
        mScrollView = (ScrollView) findViewById(R.id.ScrollView01);     
    
        Button button = (Button) findViewById(R.id.Button01);   
          
        button.setOnClickListener(mClickListener);      
    }  
      
    //Button�¼�����  
    //�������ťʱ������һ��TextView��Button  
    private Button.OnClickListener mClickListener = new Button.OnClickListener()   
    {     
        private int mIndex = 1;     
        public void onClick(View arg0)   
        {     
            // TODO Auto-generated method stub          
            TextView textView = new TextView(ScrollViewActivity.this);     
            textView.setText("Text View " + mIndex);  
            //�����벻Ҫ�������������� ���textView�Ĳ��� FILL_PARENT WRAP_CONTENT ����xml�ļ����������һ����  
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(     
                    LinearLayout.LayoutParams.FILL_PARENT,     
                    LinearLayout.LayoutParams.WRAP_CONTENT     
            );     
            //����һ��TextView�����Բ�����  
            mLayout.addView(textView, p);     
    
            Button buttonView = new Button(ScrollViewActivity.this);     
            buttonView.setText("Button " + mIndex++);  
              
          //����һ��Button�����Բ�����  
            mLayout.addView(buttonView, p);      
            //Ͷ��һ����Ϣ���й���     
            mHandler.post(mScrollToBottom);     
        }            
    };     
      
      
    private Runnable mScrollToBottom = new Runnable()   
    {     
        public void run()  
        {     
            // TODO Auto-generated method stub     
              
            int off = mLayout.getMeasuredHeight() - mScrollView.getHeight();     
            if (off > 0)   
            {     
                mScrollView.scrollTo(0, off);     
            }                            
        }     
    };      
}  
