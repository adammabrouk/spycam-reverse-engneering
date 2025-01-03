package com.shix.shixipc.utils;

import android.content.Context;
import android.location.LocationManager;
import com.alibaba.sdk.android.oss.common.RequestParameters;

/* loaded from: classes.dex */
public class GpsUtil {
    public static final boolean isOPen(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }
}
