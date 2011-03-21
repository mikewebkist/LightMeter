package com.webkist.android.lightmeter;

import android.os.Bundle;

public class AvActivity extends BaseSensorActivity {
	static int shutterSpeed = 0;
	static int apertureValue = 0;
	static int isoSpeed = 0;

	public static final NumberPicker.Formatter APERTURE_FORMATTER = new NumberPicker.Formatter() {
		public String toString(int value) {
			StringBuilder mBuilder = new StringBuilder();
			AvActivity.apertureValue = value;
			return mBuilder.append("f/").append(apertures[value]).toString();
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.av);
		NumberPicker aperture = (NumberPicker) findViewById(R.id.aperturePicker);
		aperture.setFormatter(APERTURE_FORMATTER);
		aperture.setRange(0, apertures.length - 1);
		aperture.setSpeed(100);
		aperture.setIncBy(1);
		aperture.setEnabled(true);
	}
}