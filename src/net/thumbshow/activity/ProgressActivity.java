package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressActivity extends Activity {
	
	int num = 0;
	private ProgressBar progress = null;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_progress);
		
		progress = (ProgressBar) findViewById(R.id.progressBar1);
		progress.setMax(100);
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				num = num + 1;
				progress.setProgress(num);
			}
			
		});
	}
}
