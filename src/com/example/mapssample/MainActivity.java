package com.example.mapssample;

import com.example.mapssample.geo.GetGeoLocationTask;
import com.example.mapssample.geo.OnGetGeoState;
import android.app.Activity;
import android.os.Bundle;

public final class MainActivity extends Activity {
	
	//�������g�̃R���e�L�X�g
	private final Activity activity = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		super.onResume();
		//���ݒn��GPS�����擾����D
		new GetGeoLocationTask(activity, new OnGetGeoState(activity)).execute();
	}
		
}
