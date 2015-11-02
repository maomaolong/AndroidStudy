package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class RadioGroupActivity extends Activity {
	private RadioGroup radiogroup = null;
	  public void onCreate(Bundle savedInstanceState) {  
	      super.onCreate(savedInstanceState);  
	      setContentView(R.layout.activity_radiogroup);
	      
	      radiogroup = (RadioGroup) findViewById(R.id.radioGroup1);
	      radiogroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				if(R.id.radio0 == arg1){
					Toast toast = Toast.makeText(RadioGroupActivity.this, getResources().getString(R.string.boy), Toast.LENGTH_SHORT); 
					toast.show(); 
				}
				else if(R.id.radio1 == arg1){
					Toast toast = Toast.makeText(RadioGroupActivity.this, getResources().getString(R.string.girl), Toast.LENGTH_SHORT); 
					toast.show(); 
				}
			}});
	  }
}
