package com.dreamfish.uibox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		// MonthView mv =(MonthView)findViewById(R.id.monthView1);
		// ArrayList<DayItem> data = new ArrayList<DayItem>();
		// data.add(new DayItem(1,"Hi", -1));
		// data.add(new DayItem(3,"Hi", -1));
		// data.add(new DayItem(10,"Hi", -1));
		// data.add(new DayItem(17,"Hi", -1));
		// mv.setData(data, 17, 5);

		TabHost mTabHost = (TabHost) findViewById(R.id.tabhost);
		mTabHost.setup();
		mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("Tab 1")
				.setContent(R.id.tab1));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("Tab 2")
				.setContent(R.id.tab2));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test3").setIndicator("Tab 3")
				.setContent(R.id.tab3));
		mTabHost.setCurrentTab(0);

		TextView tv = (TextView) findViewById(R.id.tv1);
		tv.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				android.widget.LinearLayout.LayoutParams params = (LayoutParams) v
						.getLayoutParams();
				params.height = (int) (params.height*0.7);
				//params.width = (int) (params.width*0.8);

				v.setLayoutParams(params);
				return true;
			}

		});
		TextView tv2 = (TextView) findViewById(R.id.tv2);
		tv2.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				Animation animation = new AlphaAnimation(1.0f, 0.5f);
				animation.setDuration(50);
				animation.setFillAfter(true);
				//v.setAnimation(animation);
				v.startAnimation(animation);
				return true;
			}

		});
		
		TextView tv3 = (TextView) findViewById(R.id.tv3);
		tv3.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				//ScaleAnimation(float fromX, float toX, float fromY, float toY, float pivotX, float pivotY)
				Animation animation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f,  v.getWidth()/2f, v.getHeight()/2f);
				animation.setDuration(50);
				animation.setFillAfter(true);
				//v.setAnimation(animation);
				v.startAnimation(animation);
				return true;
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
