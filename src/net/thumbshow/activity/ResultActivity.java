package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView tv = (TextView) findViewById(R.id.TextViewResult);
		
		Bundle bundle = this.getIntent().getExtras();  
		String str1=bundle.getString("number1");
		String str2=bundle.getString("number2");
		int i1 = Integer.parseInt(str1);
		int i2 = Integer.parseInt(str2);
		int result = i1*i2;
		tv.setText(result + "");
	}
}
