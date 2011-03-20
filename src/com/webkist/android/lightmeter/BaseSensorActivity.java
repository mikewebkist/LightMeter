package com.webkist.android.lightmeter;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class BaseSensorActivity extends Activity implements SensorEventListener {
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
		String display = String.format("%.1f Si lux", event.values[0]);
		((TextView) findViewById(R.id.sensorValues)).setText(display);
	}
}