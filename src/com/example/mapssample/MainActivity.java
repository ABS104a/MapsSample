package com.example.mapssample;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	//�������g�̃R���e�L�X�g
	private final Activity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}
