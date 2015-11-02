package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textview = null;
	private int mRequestCode = 1;
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
//	    setContentView(R.layout.table_layout);
	    setContentView(R.layout.activity_main);
	    
	    textview =  (TextView) findViewById(R.id.textview);
	    textview.setText("new");
	    
	    Button button = (Button) findViewById(R.id.button);
	    button.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent it = new Intent();
				it.setClass(MainActivity.this, ReturnResultActivity.class);
				startActivityForResult(it, mRequestCode);
			}
	    	
	    });
	   }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == mRequestCode && resultCode == RESULT_OK) { 
			Bundle bundle = data.getExtras();
             textview.setText(bundle.getInt("result") + "");
        }  
	}

}
