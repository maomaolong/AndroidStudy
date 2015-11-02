/**
 * 
 */
package net.thumbshow.activity;

import net.thumbshow.adapter.ShapeView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * @author YeY
 *
 */
public class CanvasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ShapeView view = new ShapeView(this);
		setContentView(view);
	}

}
