package net.thumbshow.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MyViewFactory implements ViewFactory {
	Context mContext = null;
	public MyViewFactory(Context c){
		mContext = c;
	}
	
	@Override
	public View makeView() {
		return new ImageView(mContext);
	}

}
