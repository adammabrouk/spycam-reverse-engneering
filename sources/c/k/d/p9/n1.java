package c.k.d.p9;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import c.k.d.l5;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, byte[]> f7658a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<Pair<String, byte[]>> f7659b = new ArrayList<>();

    public static void a(Context context, int i2, String str) {
        synchronized (f7658a) {
            for (String str2 : f7658a.keySet()) {
                a(context, str2, f7658a.get(str2), i2, str);
            }
            f7658a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i2, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i2);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, w1.a(str));
    }

    public static void a(XMPushService xMPushService) {
        try {
            synchronized (f7658a) {
                for (String str : f7658a.keySet()) {
                    w1.a(xMPushService, str, f7658a.get(str));
                }
                f7658a.clear();
            }
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            xMPushService.a(10, e2);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (f7658a) {
            f7658a.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f7659b) {
                arrayList = f7659b;
                f7659b = new ArrayList<>();
            }
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                w1.a(xMPushService, (String) next.first, (byte[]) next.second);
            }
        } catch (l5 e2) {
            c.k.a.a.a.c.a(e2);
            xMPushService.a(10, e2);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (f7659b) {
            f7659b.add(new Pair<>(str, bArr));
            if (f7659b.size() > 50) {
                f7659b.remove(0);
            }
        }
    }
}
