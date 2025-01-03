package com.shix.shixipc.utils;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.util.List;

/* loaded from: classes.dex */
public class WifiUtil {
    public static final String TAG = "WifiUtil";
    public static final WifiUtil ourInstance = new WifiUtil();
    public WifiManager mWifiManager;

    private WifiConfiguration createWifiInfo(String str, String str2) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = "\"" + str + "\"";
        wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
        wifiConfiguration.allowedAuthAlgorithms.set(0);
        wifiConfiguration.allowedGroupCiphers.set(2);
        wifiConfiguration.allowedGroupCiphers.set(3);
        wifiConfiguration.allowedKeyManagement.set(1);
        wifiConfiguration.allowedPairwiseCiphers.set(1);
        wifiConfiguration.allowedPairwiseCiphers.set(2);
        wifiConfiguration.allowedProtocols.set(1);
        wifiConfiguration.allowedProtocols.set(0);
        wifiConfiguration.status = 2;
        return wifiConfiguration;
    }

    private boolean doChange2Wifi(int i2) {
        if (!this.mWifiManager.isWifiEnabled()) {
            this.mWifiManager.setWifiEnabled(true);
        }
        if (this.mWifiManager.enableNetwork(i2, true)) {
            MyLogUtils.e(TAG, "切换到指定wifi成功");
            return true;
        }
        MyLogUtils.e(TAG, "切换到指定wifi失败");
        return false;
    }

    public static WifiUtil getIns() {
        return ourInstance;
    }

    public boolean changeToWifi(String str, String str2) {
        if (this.mWifiManager == null) {
            MyLogUtils.i(TAG, " ***** init first ***** ");
            return false;
        }
        String str3 = "\"" + str + "\"";
        printCurWifiInfo();
        List<WifiConfiguration> configuredNetworks = this.mWifiManager.getConfiguredNetworks();
        if (configuredNetworks != null && configuredNetworks.size() > 0) {
            for (int i2 = 0; i2 < configuredNetworks.size(); i2++) {
                WifiConfiguration wifiConfiguration = configuredNetworks.get(i2);
                if (str3.equals(wifiConfiguration.SSID) || str.equals(wifiConfiguration.SSID)) {
                    MyLogUtils.i(TAG, " set wifi 1 = " + wifiConfiguration.SSID);
                    return doChange2Wifi(wifiConfiguration.networkId);
                }
            }
        }
        int addNetwork = this.mWifiManager.addNetwork(createWifiInfo(str, str2));
        if (addNetwork != -1) {
            return doChange2Wifi(addNetwork);
        }
        MyLogUtils.e(TAG, "操作失败,需要您到手机wifi列表中取消对设备连接的保存");
        return false;
    }

    public void init(Context context) {
        this.mWifiManager = (WifiManager) context.getSystemService("wifi");
    }

    public void printCurWifiInfo() {
        WifiManager wifiManager = this.mWifiManager;
        if (wifiManager == null) {
            return;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        MyLogUtils.i(TAG, "cur wifi = " + connectionInfo.getSSID());
        MyLogUtils.i(TAG, "cur getNetworkId = " + connectionInfo.getNetworkId());
    }
}
