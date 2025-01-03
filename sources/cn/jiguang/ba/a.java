package cn.jiguang.ba;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.as.d;
import cn.jiguang.internal.JConstants;

@TargetApi(21)
/* loaded from: classes.dex */
public class a extends ConnectivityManager.NetworkCallback {

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f8621b;

    /* renamed from: a, reason: collision with root package name */
    public NetworkRequest f8622a;

    public a() {
        try {
            this.f8622a = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
        } catch (Throwable th) {
            d.g("ConnectionStateMonitor", "init network request error, " + th.getMessage());
        }
    }

    public static a a() {
        if (f8621b == null) {
            synchronized (a.class) {
                if (f8621b == null) {
                    f8621b = new a();
                }
            }
        }
        return f8621b;
    }

    public void a(Context context) {
        if (context == null || this.f8622a == null) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(this.f8622a, this);
                d.c("ConnectionStateMonitor", "start network listen...");
            }
        } catch (Throwable th) {
            d.g("ConnectionStateMonitor", "enable connectivity error, " + th.getMessage());
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        String str = "";
        if (network != null) {
            try {
                str = network.toString();
            } catch (Throwable th) {
                d.g("ConnectionStateMonitor", "[onAvailable] error, " + th.getMessage());
                return;
            }
        }
        d.c("ConnectionStateMonitor", "[onAvailable] network is connected, netId: " + str);
        Context appContext = JConstants.getAppContext(null);
        if (appContext == null) {
            d.c("ConnectionStateMonitor", "[onAvailable] context is null, can not handle network change event");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("connected", true);
        JCoreManager.onEvent(appContext, "", 80, null, bundle, new Object[0]);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str = "";
        if (network != null) {
            try {
                str = network.toString();
            } catch (Throwable th) {
                d.g("ConnectionStateMonitor", "[onLost] error, " + th.getMessage());
                return;
            }
        }
        d.h("ConnectionStateMonitor", "[onLost] network is disconnected, netId: " + str);
        Context appContext = JConstants.getAppContext(null);
        if (appContext == null) {
            d.c("ConnectionStateMonitor", "[onLost] context is null, can not handle network change event");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("connected", false);
        JCoreManager.onEvent(appContext, "", 80, null, bundle, new Object[0]);
    }
}
