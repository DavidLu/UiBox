package com.dreamfish.uibox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;

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

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
