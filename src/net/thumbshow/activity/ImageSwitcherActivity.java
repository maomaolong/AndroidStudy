package net.thumbshow.activity;

import net.thumbshow.adapter.ImageAdapter;
import net.thumbshow.adapter.MyViewFactory;
import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;

public class ImageSwitcherActivity extends Activity {
	// 所有要显示的图片资源索引  
    private static final Integer[] imagelist = { R.drawable.football,  
            R.drawable.backgroud, R.drawable.volleyball, };  
    private static final Integer[] thumbimagelist = { R.drawable.football,  
        R.drawable.basketball, R.drawable.volleyball, }; 
    // 创建ImageSwitcher对象  
    private ImageSwitcher m_Switcher = null;
    private Gallery gallery = null;
    
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_imageswitcher);
        
        // 创建ImageSwitcher对象  
        m_Switcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1); 
        m_Switcher.setFactory(new MyViewFactory(ImageSwitcherActivity.this));
        m_Switcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitcherActivity.this, R.anim.anim_scale_in));
        m_Switcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitcherActivity.this, R.anim.anim_scale_out));
        
        ImageAdapter imageAdapter = new ImageAdapter(ImageSwitcherActivity.this);
        imageAdapter.setImageArray(thumbimagelist);
        
        gallery = (Gallery) findViewById(R.id.gallery1);
        gallery.setAdapter(imageAdapter);
        gallery.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				m_Switcher.setImageResource(imagelist[arg2]);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
    }  
}
