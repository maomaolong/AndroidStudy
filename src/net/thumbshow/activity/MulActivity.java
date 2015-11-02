package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MulActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_mul);
		
		Button btn = (Button) findViewById(R.id.equal);
		btn.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				EditText number1 = (EditText) findViewById(R.id.number1);
				EditText number2 = (EditText) findViewById(R.id.number2);
				Intent intent = new Intent();   
				Bundle bundle = new Bundle();  
				bundle.putString("number1",number1.getText().toString());
				bundle.putString("number2",number2.getText().toString()); 
                intent.putExtras(bundle);
                intent.setClass(MulActivity.this, ResultActivity.class);   
                startActivity(intent);
			}
	    	
	    });
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, "¹ØÓÚ");   
        menu.add(0, 2, 2, "ÍË³ö");   
        return super.onCreateOptionsMenu(menu);
    }
	
	public boolean onOptionsItemSelected(MenuItem item) {  
	    if(item.getItemId() == 2){  
	        finish();  
	    }  
	    return super.onOptionsItemSelected(item);  
	}  
}
