package cn.jiguang.af;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.e.f;
import com.hjq.permissions.Permission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public Context f8153a;

    public d(Context context) {
        this.f8153a = context;
    }

    private String a(Context context) {
        String str;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
        } catch (Throwable unused) {
            str = "";
        }
        if (Build.VERSION.SDK_INT < 29 || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        str = connectionInfo.getSupplicantState() == SupplicantState.COMPLETED ? connectionInfo.getSSID() : "";
        try {
            int networkId = connectionInfo.getNetworkId();
            for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                if (wifiConfiguration.networkId == networkId) {
                    str = wifiConfiguration.SSID;
                }
            }
        } catch (Throwable unused2) {
        }
        cn.jiguang.ai.a.a("JLocationWifi", "ssid is " + str);
        return str.replace("\"", "");
    }

    public List<cn.jiguang.ag.c> a(int i2) {
        String str;
        if (!cn.jiguang.l.d.m(this.f8153a)) {
            return null;
        }
        WifiManager wifiManager = (WifiManager) this.f8153a.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            cn.jiguang.ai.a.d("JLocationWifi", "get wifiManager failed");
            return null;
        }
        if (!wifiManager.isWifiEnabled()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        cn.jiguang.ag.c cVar = new cn.jiguang.ag.c();
        cVar.f8171a = cn.jiguang.l.d.i(this.f8153a);
        cVar.f8172b = f.b((TextUtils.isEmpty(connectionInfo.getSSID()) || "<unknown ssid>".equals(connectionInfo.getSSID())) ? a(this.f8153a) : connectionInfo.getSSID());
        cn.jiguang.l.b.s(this.f8153a, cVar.f8172b);
        cVar.f8173c = "connect";
        cVar.f8174d = connectionInfo.getRssi();
        cVar.f8175e = connectionInfo.getBSSID();
        cn.jiguang.ai.a.a("JLocationWifi", "connectingWifi:" + cVar.toString());
        arrayList.add(cVar);
        if (Build.VERSION.SDK_INT < 23 || cn.jiguang.l.d.a(this.f8153a, Permission.ACCESS_COARSE_LOCATION) || cn.jiguang.l.d.a(this.f8153a, Permission.ACCESS_FINE_LOCATION)) {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null && scanResults.size() != 0) {
                cn.jiguang.ai.a.a("JLocationWifi", "scan wifi list success:" + scanResults);
                ArrayList<ScanResult> arrayList2 = new ArrayList(scanResults);
                for (ScanResult scanResult : arrayList2) {
                    if (!(cVar.f8172b.equals(cn.jiguang.l.d.d(scanResult.SSID)) && cVar.f8175e.equals(scanResult.BSSID)) && scanResult.level >= -200) {
                        for (ScanResult scanResult2 : arrayList2) {
                            if (scanResult2 != scanResult && scanResult.SSID.equals(scanResult2.SSID) && scanResult.BSSID.equals(scanResult2.BSSID)) {
                                scanResults.remove(scanResult);
                            }
                        }
                    } else {
                        scanResults.remove(scanResult);
                    }
                }
                arrayList2.clear();
                Collections.sort(scanResults, new Comparator<ScanResult>() { // from class: cn.jiguang.af.d.1
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(ScanResult scanResult3, ScanResult scanResult4) {
                        return scanResult4.level - scanResult3.level;
                    }
                });
                for (int i3 = 0; i3 < scanResults.size() && i3 != i2 - 1; i3++) {
                    ScanResult scanResult3 = scanResults.get(i3);
                    String d2 = cn.jiguang.l.d.d(scanResult3.SSID);
                    cn.jiguang.ag.c cVar2 = new cn.jiguang.ag.c();
                    cVar2.f8171a = cn.jiguang.l.d.i(this.f8153a);
                    cVar2.f8172b = d2;
                    cVar2.f8173c = null;
                    if (i3 == 0) {
                        cVar2.f8173c = "strongest";
                    }
                    cVar2.f8174d = scanResult3.level;
                    cVar2.f8175e = scanResult3.BSSID;
                    arrayList.add(cVar2);
                }
                return arrayList;
            }
            str = "scan wifi list failed";
        } else {
            str = "scan wifi list failed because has no Manifest.permission.LOCATION";
        }
        cn.jiguang.ai.a.d("JLocationWifi", str);
        return arrayList;
    }
}
