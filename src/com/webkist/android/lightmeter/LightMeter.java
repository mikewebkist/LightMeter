package com.webkist.android.lightmeter;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/**
 * An example of tabs that uses labels (
 * {@link TabSpec#setIndicator(CharSequence)}) for its indicators and views by
 * id from a layout file ({@link TabSpec#setContent(int)}).
 */
public class LightMeter extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		Intent avIntent = new Intent().setClass(this, AvActivity.class);
		Intent tvIntent = new Intent().setClass(this, TvActivity.class);
//		Intent pIntent = new Intent().setClass(this, pActivity.class);
//		Intent mIntent = new Intent().setClass(this, mActivity.class);
		
		spec = tabHost.newTabSpec("Av").setIndicator("Aperture", res.getDrawable(R.drawable.ic_tab_av)).setContent(avIntent);
		tabHost.addTab(spec);
		spec = tabHost.newTabSpec("Tv").setIndicator("Shutter", res.getDrawable(R.drawable.ic_tab_tv)).setContent(tvIntent);
		tabHost.addTab(spec);
		spec = tabHost.newTabSpec("P").setIndicator("Program", res.getDrawable(R.drawable.ic_tab_p)).setContent(avIntent);
		tabHost.addTab(spec);
		spec = tabHost.newTabSpec("M").setIndicator("Manual", res.getDrawable(R.drawable.ic_tab_m)).setContent(tvIntent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(2);
	}
}
