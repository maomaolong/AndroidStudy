package net.thumbshow.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
	 //定义Context  
    private Context mContext = null;  
    //定义整型数组 即图片源  
    private Integer[] mImageIds;
      
    public ImageAdapter(Context c){  
        mContext = c;  
    } 
    
    public void setImageArray(Integer[] imgArr){
    	mImageIds = imgArr;
    }
	@Override
	public int getCount() {
		return mImageIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
        //给ImageView设置资源  
		ImageView imageView = new ImageView(mContext); 
		imageView.setImageResource(mImageIds[arg0]);
		imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));  
        return imageView;  
	}

}
