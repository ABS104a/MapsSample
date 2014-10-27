package com.example.mapssample.geo;

import android.app.Activity;
import android.location.Location;

import com.example.mapssample.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * GPS���擾������̃R�[���o�b�N
 * @author Kouki
 *
 */
public final class OnGetGeoState implements GetGeoLocationTask.OnGetLocationCallBack{
	
	private final Activity activity;

	public OnGetGeoState(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void getGeo(Location location) {
		GoogleMap mapobj = ((MapFragment) activity.getFragmentManager().findFragmentById(R.id.map)).getMap();
		if( mapobj != null){
			//���ݒn
			LatLng position = new LatLng(location.getLatitude(), location.getLongitude());
		    // ���ݒn�Ɉړ�����
			CameraPosition nowPosition = new CameraPosition.Builder()
	        .target(position).zoom(15.5f)
	        .bearing(0).tilt(25).build();
			mapobj.animateCamera(CameraUpdateFactory.newCameraPosition(nowPosition));
			//�s���𗧂Ă�
			MarkerOptions options = new MarkerOptions();
			options.position(position);
			options.title("�^�C�g��");
			mapobj.addMarker(options);
		}
	}
}
