package cn.jiguang.bh;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: cn.jiguang.bh.a$a, reason: collision with other inner class name */
    public enum EnumC0138a {
        CONNECTED,
        NOT_CONNECTED,
        NO_PERMISSION,
        UNKNOWN
    }

    public static EnumC0138a a(Context context) {
        ConnectivityManager c2 = c(context);
        return c2 == null ? EnumC0138a.UNKNOWN : a(context, c2);
    }

    public static EnumC0138a a(Context context, ConnectivityManager connectivityManager) {
        if (!cn.jiguang.e.a.c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            cn.jiguang.as.d.e("ConnectivityChecker", "No permission (ACCESS_NETWORK_STATE) to check network status.");
            return EnumC0138a.NO_PERMISSION;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected() ? EnumC0138a.CONNECTED : EnumC0138a.NOT_CONNECTED;
        }
        cn.jiguang.as.d.e("ConnectivityChecker", "NetworkInfo is null, there's no active network.");
        return EnumC0138a.NOT_CONNECTED;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r6) {
        /*
            android.net.ConnectivityManager r0 = c(r6)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = cn.jiguang.e.a.c(r6, r2)
            java.lang.String r2 = "ConnectivityChecker"
            if (r6 != 0) goto L18
            java.lang.String r6 = "No permission (ACCESS_NETWORK_STATE) to check network status."
        L14:
            cn.jiguang.as.d.e(r2, r6)
            return r1
        L18:
            int r6 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            r4 = 0
            r5 = 1
            if (r6 < r3) goto L42
            android.net.Network r6 = r0.getActiveNetwork()
            if (r6 != 0) goto L29
            java.lang.String r6 = "Network is null and cannot check network status"
            goto L14
        L29:
            android.net.NetworkCapabilities r6 = r0.getNetworkCapabilities(r6)
            if (r6 != 0) goto L32
            java.lang.String r6 = "NetworkCapabilities is null and cannot check network type"
            goto L14
        L32:
            r0 = 3
            boolean r0 = r6.hasTransport(r0)
            boolean r2 = r6.hasTransport(r5)
            boolean r4 = r6.hasTransport(r4)
            r5 = r4
            r4 = r0
            goto L5f
        L42:
            android.net.NetworkInfo r6 = r0.getActiveNetworkInfo()
            if (r6 != 0) goto L4b
            java.lang.String r6 = "NetworkInfo is null, there's no active network."
            goto L14
        L4b:
            int r6 = r6.getType()
            if (r6 == 0) goto L5e
            if (r6 == r5) goto L5c
            r0 = 9
            r2 = 0
            if (r6 == r0) goto L5a
        L58:
            r5 = 0
            goto L5f
        L5a:
            r4 = 1
            goto L58
        L5c:
            r2 = 1
            goto L58
        L5e:
            r2 = 0
        L5f:
            if (r4 == 0) goto L64
            java.lang.String r6 = "ethernet"
            return r6
        L64:
            if (r2 == 0) goto L69
            java.lang.String r6 = "wifi"
            return r6
        L69:
            if (r5 == 0) goto L6e
            java.lang.String r6 = "cellular"
            return r6
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bh.a.b(android.content.Context):java.lang.String");
    }

    public static ConnectivityManager c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            cn.jiguang.as.d.e("ConnectivityChecker", "ConnectivityManager is null and cannot check network status");
        }
        return connectivityManager;
    }
}
