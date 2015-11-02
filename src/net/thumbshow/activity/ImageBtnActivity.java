package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class ImageBtnActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imagebtn);
		ImageButton btn = (ImageButton) findViewById(R.id.imageButton1);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Toast toast = Toast.makeText(ImageBtnActivity.this, "°´ÏÂImageButton", 1);
				toast.show();
			}});
	}

}
