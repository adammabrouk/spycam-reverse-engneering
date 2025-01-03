package com.shix.shixipc.he;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utils.StringUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class NetWorkUtil {
    public static final int NETWORKTYPE_2G = 2;
    public static final int NETWORKTYPE_3G = 3;
    public static final int NETWORKTYPE_INVALID = 0;
    public static final int NETWORKTYPE_WAP = 1;
    public static final int NETWORKTYPE_WIFI = 4;

    public enum netType {
        wifi,
        CMNET,
        CMWAP,
        noneNet
    }

    public static netType getAPNType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return netType.noneNet;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (StringUtils.isNotEmpty(extraInfo)) {
                return extraInfo.toLowerCase().equals("cmnet") ? netType.CMNET : netType.CMWAP;
            }
        } else if (type == 1) {
            return netType.wifi;
        }
        return netType.noneNet;
    }

    @SuppressLint({"DefaultLocale"})
    public static String getAPNTypeString(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "";
        }
        int type = activeNetworkInfo.getType();
        return type == 0 ? activeNetworkInfo.getExtraInfo().toLowerCase() : type == 1 ? "wifi" : "";
    }

    public static int getConnectedType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static String getIPAddress(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        if (activeNetworkInfo.getType() != 0) {
            if (activeNetworkInfo.getType() == 1) {
                return intIP2StringIP(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
            }
            return null;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        String typeName = activeNetworkInfo.getTypeName();
        if (typeName.equalsIgnoreCase("WIFI")) {
            return 4;
        }
        if (!typeName.equalsIgnoreCase("MOBILE")) {
            return 0;
        }
        if (TextUtils.isEmpty(Proxy.getDefaultHost())) {
            return isFastMobileNetwork(context) ? 3 : 2;
        }
        return 1;
    }

    public static String intIP2StringIP(int i2) {
        return (i2 & ViewfinderView.OPAQUE) + "." + ((i2 >> 8) & ViewfinderView.OPAQUE) + "." + ((i2 >> 16) & ViewfinderView.OPAQUE) + "." + ((i2 >> 24) & ViewfinderView.OPAQUE);
    }

    public static boolean isFastMobileNetwork(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 4:
            case 7:
            case 11:
            default:
                return false;
        }
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo networkInfo;
        return (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0)) == null || networkInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) ? false : true;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo;
        if (context != null && (allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo()) != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo.State state = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState();
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }
}
