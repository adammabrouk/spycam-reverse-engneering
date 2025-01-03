package cn.jpush.android.bl;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.f;
import cn.jpush.android.local.JPushConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f9628b;

    /* renamed from: a, reason: collision with root package name */
    public Map<Byte, C0156a> f9629a = new HashMap();

    /* renamed from: cn.jpush.android.bl.a$a, reason: collision with other inner class name */
    public class C0156a {

        /* renamed from: a, reason: collision with root package name */
        public byte f9630a;

        /* renamed from: b, reason: collision with root package name */
        public String f9631b;

        /* renamed from: c, reason: collision with root package name */
        public long f9632c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f9633d;

        /* renamed from: e, reason: collision with root package name */
        public int f9634e = 0;

        public C0156a(byte b2, String str, long j, byte[] bArr) {
            this.f9630a = b2;
            this.f9631b = str;
            this.f9632c = j;
            this.f9633d = bArr;
        }

        public String toString() {
            return "PluginPlatformRegIDBean{pluginPlatformType=" + ((int) this.f9630a) + ", regid='" + this.f9631b + "', rid=" + this.f9632c + ", retryCount=" + this.f9634e + '}';
        }
    }

    private C0156a a(long j) {
        for (Map.Entry<Byte, C0156a> entry : this.f9629a.entrySet()) {
            if (entry.getValue().f9632c == j) {
                return entry.getValue();
            }
        }
        Logger.d("PluginPlatformRidUpdate", "can not find uploadBean by rid");
        return null;
    }

    public static a a() {
        if (f9628b == null) {
            synchronized (a.class) {
                if (f9628b == null) {
                    f9628b = new a();
                }
            }
        }
        return f9628b;
    }

    private synchronized void a(Context context, C0156a c0156a) {
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 27, 1, c0156a.f9632c, 10000L, c0156a.f9633d);
    }

    private void b(Context context, byte b2, String str) {
        long a2 = f.a();
        Logger.v("PluginPlatformRidUpdate", "sendUpdateRidInfo regid:" + str + ",rid:" + a2 + ",whichPlatform:" + ((int) b2));
        C0156a c0156a = new C0156a(b2, str, a2, cn.jpush.android.bi.b.a(str, b2));
        this.f9629a.put(Byte.valueOf(b2), c0156a);
        a(context, c0156a);
    }

    public synchronized void a(Context context, byte b2, String str) {
        if (b2 == 0) {
            Logger.w("PluginPlatformRidUpdate", "unknown plugin platform type");
        } else if (!JPushConstants.isTcpConnected()) {
            Logger.d("PluginPlatformRidUpdate", "tcp disconnected");
        } else {
            if (this.f9629a.containsKey(Byte.valueOf(b2)) && TextUtils.equals(this.f9629a.get(Byte.valueOf(b2)).f9631b, str)) {
                Logger.d("PluginPlatformRidUpdate", "same regid request, drop it");
                return;
            }
            b(context, b2, str);
        }
    }

    public void a(Context context, long j) {
        C0156a a2 = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidSuccess rid:" + j + " ,pluginPlatformRegIDBean:" + a2);
        if (a2 != null) {
            Sp.set(context, Key.ThirdPush_RegID(a2.f9630a).set(a2.f9631b));
            Sp.set(context, Key.ThirdPush_RegUpload(a2.f9630a).set(true));
            this.f9629a.remove(Byte.valueOf(a2.f9630a));
            c.a().a(context, (int) a2.f9630a, a2.f9631b);
        }
    }

    public void a(Context context, long j, int i2) {
        C0156a a2 = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidFailed rid:" + j + ",errorCode:" + i2 + " ,pluginPlatformRegIDBean:" + a2);
        if (a2 != null) {
            int i3 = a2.f9634e;
            if (i3 < 3) {
                a2.f9634e = i3 + 1;
                a(context, a2);
            } else {
                Logger.d("PluginPlatformRidUpdate", "updateRegId failed");
                this.f9629a.remove(Byte.valueOf(a2.f9630a));
            }
        }
    }

    public void b(Context context, long j) {
        C0156a a2 = a(j);
        Logger.ii("PluginPlatformRidUpdate", "onUpdateRidTimeout rid:" + j + " ,pluginPlatformRegIDBean:" + a2);
        if (a2 != null) {
            int i2 = a2.f9634e;
            if (i2 < 3) {
                a2.f9634e = i2 + 1;
                a(context, a2);
            } else {
                Logger.d("PluginPlatformRidUpdate", "updateRegId failed by timeout");
                this.f9629a.remove(Byte.valueOf(a2.f9630a));
            }
        }
    }
}
