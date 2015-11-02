package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ReturnResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_return_result);
		
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent it = new Intent();
				Bundle bundle = new Bundle();
				bundle.putInt("result", 8);
				it.putExtras(bundle);
				setResult(RESULT_OK,it);
				finish();
			}
			
		});
	}

}
