package com.webkist.android.lightmeter;

import android.app.Activity;
import java.lang.Math;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class BaseSensorActivity extends Activity implements SensorEventListener {
	final static int speeds[] = { 1, 2, 4, 8, 15, 30, 60, 125, 250, 500, 1000,
			2000, 4000 };
	final static String apertures[] = { "1.4", "2", "2.8", "4", "5.6", "8",
			"11", "16", "22", "32", "45", "64" };

	private SensorManager sm;
	private Sensor sensor;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		sensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
	}

	protected void onResume() {
		super.onResume();
		sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onPause() {
		super.onPause();
		sm.unregisterListener(this);
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// Don't need to do anything here yet.
	}

	public void onSensorChanged(SensorEvent event) {
		// EV@100 = log2(LUX/5) + 1
		// 1 sec, f/1.4, 100 ISO = EV 1
		double ev = java.lang.Math.log((double) event.values[0] / 5.0)
				/ java.lang.Math.log(2) + 1;
		String display = String.format("%.0f lux, EV %.0f @ 100 ISO",
				event.values[0], ev);
		((TextView) findViewById(R.id.sensorValues)).setText(display);
	}
}