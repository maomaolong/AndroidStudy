package net.thumbshow.activity;

import net.thumbshow.zstudy.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_dialog);  
          
        Button btn = (Button)findViewById(R.id.button1); 
        btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);  
		        builder.setIcon(R.drawable.ic_launcher);  
		        builder.setTitle("Title");  
		        builder.setMessage("Message");  
		        builder.setPositiveButton("Button1",  
		                new DialogInterface.OnClickListener() {  
		                    public void onClick(DialogInterface dialog, int whichButton) {  
		                        setTitle("点击了对话框上的Button1");  
		                    }  
		                });  
		        builder.show();
			}
        	
        });
	}
}
