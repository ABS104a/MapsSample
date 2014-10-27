package com.example.mapssample;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	//自分自身のコンテキスト
	private final Activity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}
