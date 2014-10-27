package com.example.mapssample.geo;

import com.example.mapssample.R;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * GPSからロケーション情報を取得するタスク
 * @author Kouki
 *
 */
public class GetGeoLocationTask extends AsyncTask<Void,Void,Location> {

	//アプリケーションのコンテキスト
	private final Activity activity;
	//コールバック
	private final OnGetLocationCallBack callback;
	
	/**
	 * ロケーションを取得した後のコールバック
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
		//LocationManagerの取得
		LocationManager locationManager = (LocationManager)activity.getSystemService(Context.LOCATION_SERVICE);
		//GPSから現在地の情報を取得
		return locationManager.getLastKnownLocation("gps");
	}

	@Override
	protected void onPostExecute(Location result) {
		try{
			//取得したデータをコールバックに投げる．
			callback.getGeo(result);
		}catch(NullPointerException e){
			//値の取得にFailureした時orコールバックがNullの時
			e.printStackTrace();
			Toast.makeText(activity, R.string.geo_get_failure, Toast.LENGTH_SHORT).show();
		}
		super.onPostExecute(result);
	}



}
