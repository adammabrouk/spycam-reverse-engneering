package com.shix.shixipc.utils;

import a.h.b.a;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.hjq.permissions.Permission;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MyLocationUtil {
    public static final String TAG = "GPS-MyLocationUtil";
    public String bestProvider;
    public Context context;
    public LocationManager locationManager;
    public MyLocationListener myLocationListener;

    public class MyLocationListener implements LocationListener {
        public MyLocationListener() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Log.e(MyLocationUtil.TAG, "onLocationChanged");
            List<Address> arrayList = new ArrayList<>();
            try {
                arrayList = new Geocoder(MyLocationUtil.this.context).getFromLocation(location.getLatitude(), location.getLongitude(), 10);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            for (Address address : arrayList) {
                Log.e(MyLocationUtil.TAG, address.getCountryCode());
                Log.e(MyLocationUtil.TAG, address.getCountryName());
                Log.e(MyLocationUtil.TAG, address.getAdminArea());
                Log.e(MyLocationUtil.TAG, address.getLocality());
                Log.e(MyLocationUtil.TAG, address.getFeatureName());
                Log.e(MyLocationUtil.TAG, String.valueOf(address.getLatitude()));
                Log.e(MyLocationUtil.TAG, String.valueOf(address.getLongitude()));
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Log.e(MyLocationUtil.TAG, "onProviderDisabled");
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Log.e(MyLocationUtil.TAG, "onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            Log.e(MyLocationUtil.TAG, "onStatusChanged");
        }
    }

    public MyLocationUtil(Context context) {
        this.context = context;
        initLocationManager();
    }

    private void getProviders() {
        Iterator<String> it = this.locationManager.getProviders(true).iterator();
        while (it.hasNext()) {
            Log.e(TAG, it.next());
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setPowerRequirement(1);
        this.bestProvider = this.locationManager.getBestProvider(criteria, false);
        this.myLocationListener = new MyLocationListener();
    }

    private void initLocationManager() {
        LocationManager locationManager = (LocationManager) this.context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        this.locationManager = locationManager;
        if (!locationManager.isProviderEnabled("gps")) {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        }
        getProviders();
    }

    public void startLocation() {
        if (a.a(this.context, Permission.ACCESS_FINE_LOCATION) == 0 || a.a(this.context, Permission.ACCESS_COARSE_LOCATION) == 0) {
            Log.e(TAG, "startLocation: ");
            this.locationManager.requestLocationUpdates(this.bestProvider, 0L, 0.0f, this.myLocationListener);
        }
    }

    public void stopLocation() {
        Log.e(TAG, "stopLocation: ");
        this.locationManager.removeUpdates(this.myLocationListener);
    }
}
