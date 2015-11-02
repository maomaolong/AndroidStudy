package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class CheckBoxActivity extends Activity {
	private CheckBox checkBox1 = null;
	private CheckBox checkBox2 = null;
	private CheckBox checkBox3 = null;
	public void onCreate(Bundle savedInstanceState) {  
	      super.onCreate(savedInstanceState);  
	      setContentView(R.layout.activity_checkbox);
	      
	      checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
	      checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				Toast toast = Toast.makeText(CheckBoxActivity.this, "checkBox1", Toast.LENGTH_SHORT);
				toast.show();
			}});
	      
	      checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
	      checkBox2.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				Toast toast = Toast.makeText(CheckBoxActivity.this, "checkBox2", Toast.LENGTH_SHORT);
				toast.show();
			}});     
	      
	      checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
	      checkBox3.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				Toast toast = Toast.makeText(CheckBoxActivity.this, "checkBox3", Toast.LENGTH_SHORT);
				toast.show();
			}});
	      
	}
}
