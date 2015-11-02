package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarActivity extends Activity {
	private SeekBar seekBar = null;
	private TextView textViewValue = null;
	private TextView textViewState = null;
	public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_seekbar); 
        
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
 
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				textViewValue.setText("" + arg1);
				textViewState.setText("改变中");
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				textViewState.setText("正在调节"); 
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				textViewState.setText("停止");
				
			}
        	
        });
        
        textViewValue = (TextView) findViewById(R.id.textView1);
        
        textViewState = (TextView) findViewById(R.id.textView2);
	}
}
