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
          
        //创建一个线性布局  
        mLayout = (LinearLayout) findViewById(R.id.layout);     
        //创建一个ScrollView对象  
        mScrollView = (ScrollView) findViewById(R.id.ScrollView01);     
    
        Button button = (Button) findViewById(R.id.Button01);   
          
        button.setOnClickListener(mClickListener);      
    }  
      
    //Button事件监听  
    //当点击按钮时，增加一个TextView和Button  
    private Button.OnClickListener mClickListener = new Button.OnClickListener()   
    {     
        private int mIndex = 1;     
        public void onClick(View arg0)   
        {     
            // TODO Auto-generated method stub          
            TextView textView = new TextView(ScrollViewActivity.this);     
            textView.setText("Text View " + mIndex);  
            //这里请不要困惑这里是设置 这个textView的布局 FILL_PARENT WRAP_CONTENT 和在xml文件里边设置是一样的  
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(     
                    LinearLayout.LayoutParams.FILL_PARENT,     
                    LinearLayout.LayoutParams.WRAP_CONTENT     
            );     
            //增加一个TextView到线性布局中  
            mLayout.addView(textView, p);     
    
            Button buttonView = new Button(ScrollViewActivity.this);     
            buttonView.setText("Button " + mIndex++);  
              
          //增加一个Button到线性布局中  
            mLayout.addView(buttonView, p);      
            //投递一个消息进行滚动     
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
