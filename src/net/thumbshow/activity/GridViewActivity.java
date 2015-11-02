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
          
        //��ȡGridView����  
        GridView gridview = (GridView) findViewById(R.id.gridview);  
        //���Ԫ�ظ�gridview  
        gridview.setAdapter(new ImageAdapter(this));  
          
        //����Gallery����  
        gridview.setBackgroundResource(R.drawable.backgroud);  
          
        //�¼�����  
        gridview.setOnItemClickListener(new OnItemClickListener(){  
            public void onItemClick(AdapterView<?> parent, View view,  
                    int position, long id) {  
                //�˴���positionΪID ����Ҫ+1  
                Toast.makeText(GridViewActivity.this, "��ѡ����"+ (position + 1) + "��ͼƬ", Toast.LENGTH_SHORT).show();  
            }  
        });  
    }  
}  