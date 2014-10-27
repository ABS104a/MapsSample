package com.example.mapssample.geo;

import com.example.mapssample.R;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * GPS���烍�P�[�V���������擾����^�X�N
 * @author Kouki
 *
 */
public class GetGeoLocationTask extends AsyncTask<Void,Void,Location> {

	//�A�v���P�[�V�����̃R���e�L�X�g
	private final Activity activity;
	//�R�[���o�b�N
	private final OnGetLocationCallBack callback;
	
	/**
	 * ���P�[�V�������擾������̃R�[���o�b�N
	 * @author Kouki
	 *
	 */
	public interface OnGetLocationCallBack{
		void getGeo(Location location);
	}

	public GetGeoLocationTask(Activity activity,OnGetLocationCallBack callback ){
		this.activity = activity;
		this.callback = callback;
	}
	
	@Override
	protected Location doInBackground(Void... params) {
		//LocationManager�̎擾
		LocationManager locationManager = (LocationManager)activity.getSystemService(Context.LOCATION_SERVICE);
		//GPS���猻�ݒn�̏����擾
		return locationManager.getLastKnownLocation("gps");
	}

	@Override
	protected void onPostExecute(Location result) {
		try{
			//�擾�����f�[�^���R�[���o�b�N�ɓ�����D
			callback.getGeo(result);
		}catch(NullPointerException e){
			//�l�̎擾��Failure������or�R�[���o�b�N��Null�̎�
			e.printStackTrace();
			Toast.makeText(activity, R.string.geo_get_failure, Toast.LENGTH_SHORT).show();
		}
		super.onPostExecute(result);
	}



}
