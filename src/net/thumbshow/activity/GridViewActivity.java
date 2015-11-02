package net.thumbshow.activity;

import net.thumbshow.adapter.ImageAdapter;
import net.thumbshow.zstudy.R;
import android.app.Activity;  
import android.os.Bundle;  
import android.view.View;  
import android.widget.AdapterView;  
import android.widget.GridView;  
import android.widget.Toast;  
import android.widget.AdapterView.OnItemClickListener;  
  
public class GridViewActivity extends Activity {  
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_gridview);  
          
        //获取GridView对象  
        GridView gridview = (GridView) findViewById(R.id.gridview);  
        //添加元素给gridview  
        gridview.setAdapter(new ImageAdapter(this));  
          
        //设置Gallery背景  
        gridview.setBackgroundResource(R.drawable.backgroud);  
          
        //事件监听  
        gridview.setOnItemClickListener(new OnItemClickListener(){  
            public void onItemClick(AdapterView<?> parent, View view,  
                    int position, long id) {  
                //此处的position为ID 所以要+1  
                Toast.makeText(GridViewActivity.this, "你选择了"+ (position + 1) + "号图片", Toast.LENGTH_SHORT).show();  
            }  
        });  
    }  
}  