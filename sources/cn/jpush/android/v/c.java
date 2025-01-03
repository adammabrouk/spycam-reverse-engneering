package cn.jpush.android.v;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.union.ads.core.config.JUnionAdConfig;
import cn.jpush.android.local.JPushConstants;
import com.hjq.permissions.Permission;
import com.tencent.bugly.Bugly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    public static volatile c f9907e;

    /* renamed from: a, reason: collision with root package name */
    public long f9908a = JConstants.MIN;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f9909b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public int f9910c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9911d = false;

    public static c a() {
        if (f9907e == null) {
            synchronized (c.class) {
                f9907e = new c();
            }
        }
        return f9907e;
    }

    private String a(Map<String, Long> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, Long>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next().getKey());
            sb.append("|");
        }
        return sb.toString().substring(0, r3.length() - 1);
    }

    private Map<String, Long> a(Context context, File file) {
        if (file != null) {
            try {
                if (file.exists() && file.length() != 0) {
                    DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                    String readUTF = dataInputStream.readUTF();
                    dataInputStream.close();
                    return a(readUTF);
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("ProbesTimer", "read failed " + th.getMessage());
                return new HashMap();
            }
        }
        return new HashMap();
    }

    private Map<String, Long> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap();
        }
        String[] split = str.split("&&");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String[] split2 = str2.split("&");
            hashMap.put(split2[0], Long.valueOf(Long.parseLong(split2[1])));
        }
        return hashMap;
    }

    private void a(Context context, String str) {
        cn.jpush.android.r.b.b("ProbesTimer", "updateAppIndexByAd content:" + str);
        File i2 = i(context);
        File j = j(context);
        a(context, str, i2);
        a(context, str, j);
    }

    private void a(Context context, String str, File file) {
        if (file == null) {
            return;
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeUTF(str);
            dataOutputStream.close();
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("ProbesTimer", "write failed " + th.getMessage());
        }
    }

    private long b() {
        Integer num;
        Map<String, Object> extra = cn.jpush.android.u.a.c().getExtra();
        if (extra != null && extra.size() > 0 && (num = (Integer) extra.get(JUnionAdConfig.KEY.PROBES_INTERVAL)) != null) {
            this.f9908a = num.intValue();
        }
        return this.f9908a;
    }

    private String b(Map<String, Long> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            sb.append(key);
            sb.append("&");
            sb.append(value);
            sb.append("&&");
        }
        return sb.toString().substring(0, r4.length() - 2);
    }

    private boolean b(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.checkSelfPermission(str) == 0;
        }
        for (String str2 : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private Map<String, Long> e(Context context) {
        File i2 = i(context);
        File j = j(context);
        Map<String, Long> hashMap = new HashMap<>();
        Map<String, Long> hashMap2 = new HashMap<>();
        if (i2 != null && i2.exists()) {
            hashMap = a(context, i2);
        }
        if (j != null && j.exists()) {
            hashMap2 = a(context, j);
        }
        return (hashMap.isEmpty() && hashMap2.isEmpty()) ? new HashMap() : hashMap.isEmpty() ? hashMap2 : hashMap2.isEmpty() ? hashMap : (i2 == null || j == null) ? new HashMap() : i2.lastModified() - j.lastModified() > JConstants.MIN ? hashMap : hashMap2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private Map<String, Long> f(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 85, null, null, new Object[0]);
        if (onEvent == null) {
            return new HashMap();
        }
        String str = onEvent instanceof String ? (String) onEvent : "";
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 0) {
            switch (hashCode) {
                case 1444:
                    if (str.equals("-1")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1445:
                    if (str.equals("-2")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1446:
                    if (str.equals("-3")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
        } else if (str.equals("")) {
            c2 = 0;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
            cn.jpush.android.r.b.b("ProbesTimer", "can't getAppIndexByCore, because JCore return " + str);
            return new HashMap();
        }
        cn.jpush.android.r.b.b("ProbesTimer", "getAppIndexByCore list:" + str);
        String[] split = str.split("\\|");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(str2, Long.valueOf(System.currentTimeMillis()));
            }
        }
        cn.jpush.android.r.b.b("ProbesTimer", "getAppIndexByCore finish, content:" + b(hashMap));
        return hashMap;
    }

    private Map<String, String> g(Context context) {
        String str;
        if (!this.f9909b.isEmpty()) {
            return this.f9909b;
        }
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 84, null, null, new Object[0]);
        if (onEvent != null) {
            if (onEvent instanceof String) {
                String str2 = (String) onEvent;
                if (TextUtils.isEmpty(str2)) {
                    str = "getProbesContrastMap failed, because JCore return empty map";
                } else {
                    for (String str3 : str2.split("&&")) {
                        if (this.f9909b.size() == 20) {
                            break;
                        }
                        String[] split = str3.split("&");
                        if (split.length != 0) {
                            String str4 = split[0];
                            if (!TextUtils.isEmpty(str4)) {
                                String str5 = split[1];
                                if (!TextUtils.isEmpty(str5)) {
                                    this.f9909b.put(str4, str5);
                                }
                            }
                        }
                    }
                    cn.jpush.android.r.b.b("ProbesTimer", "getProbesContrastMap finish, map:" + this.f9909b.toString());
                }
            }
            return this.f9909b;
        }
        str = "getProbesContrastMap failed, because JCore return null map";
        cn.jpush.android.r.b.b("ProbesTimer", str);
        return this.f9909b;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2 A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:3:0x0002, B:5:0x000f, B:8:0x0015, B:9:0x001f, B:11:0x0025, B:14:0x0058, B:16:0x006e, B:23:0x0095, B:26:0x00ac, B:28:0x00b8, B:29:0x00c7, B:35:0x00c4, B:30:0x00ca, B:32:0x00d2, B:33:0x00d4), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.Long> h(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.v.c.h(android.content.Context):java.util.Map");
    }

    private File i(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 29 && b(context, Permission.WRITE_EXTERNAL_STORAGE) && b(context, Permission.READ_EXTERNAL_STORAGE)) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ".jiguang");
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(file.getAbsolutePath() + File.separator + "probes");
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                return file2;
            }
            return null;
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("ProbesTimer", "getExtraFile failed " + th.getMessage());
            return null;
        }
    }

    private File j(Context context) {
        try {
            File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + "cn_jiguang_union_ads");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file.getAbsolutePath() + File.separator + "probes");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (Throwable th) {
            th.printStackTrace();
            cn.jpush.android.r.b.f("ProbesTimer", "getInternalFile failed " + th.getMessage());
            return null;
        }
    }

    public void a(Context context) {
        long b2 = b();
        if (b2 < 0) {
            cn.jpush.android.r.b.b("ProbesTimer", "dispatchMessage can't probes, because probesInterval is " + b2);
            return;
        }
        b(context);
        if (this.f9910c >= 3) {
            cn.jpush.android.r.b.b("ProbesTimer", "stop probesTimer, because getAppIndexBySingle JCore return empty map failedCount is " + this.f9910c);
            e.a().c(context);
            return;
        }
        if (this.f9911d) {
            cn.jpush.android.r.b.b("ProbesTimer", "stop probesTimer, because probesContrastMap had detect all");
            e.a().c(context);
            return;
        }
        e.a().c(context, b2);
        cn.jpush.android.r.b.b("ProbesTimer", "dispatchMessage probes after " + b2);
    }

    public void a(Context context, String str, boolean z) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("updateAppIndexByAd the [");
            sb.append(str);
            sb.append("] state:");
            sb.append(z ? "true" : Bugly.SDK_IS_DEV);
            cn.jpush.android.r.b.b("ProbesTimer", sb.toString());
            Map<String, String> g2 = g(context);
            if (!g2.isEmpty() && g2.containsValue(str)) {
                Map<String, Long> e2 = e(context);
                for (Map.Entry<String, String> entry : g2.entrySet()) {
                    if (TextUtils.equals(entry.getValue(), str)) {
                        String key = entry.getKey();
                        if (z && !e2.containsKey(key)) {
                            cn.jpush.android.r.b.b("ProbesTimer", "add packageName:" + str + ", index:" + key);
                            e2.put(key, Long.valueOf(System.currentTimeMillis()));
                            a(context, b(e2));
                            return;
                        }
                        if (z || !e2.containsKey(key)) {
                            return;
                        }
                        cn.jpush.android.r.b.b("ProbesTimer", "remove packageName:" + str + ", index:" + key);
                        e2.remove(key);
                        a(context, b(e2));
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("ProbesTimer", "updateAppIndexByAd failed:" + th.getMessage());
        }
    }

    public void b(Context context) {
        try {
            this.f9909b = this.f9910c < 2 ? new HashMap<>() : g(context);
            if (this.f9909b.isEmpty()) {
                this.f9910c++;
                return;
            }
            Map<String, Long> f2 = f(context);
            if (f2.isEmpty()) {
                f2 = h(context);
            }
            a(context, b(f2));
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("ProbesTimer", "updateAppIndexByTimer failed:" + th.getMessage());
        }
    }

    public String c(Context context) {
        try {
            return a(e(context));
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("ProbesTimer", "queryAppIndexString failed:" + th.getMessage());
            return "";
        }
    }

    public void d(Context context) {
        StringBuilder sb;
        String str;
        this.f9910c = 0;
        this.f9911d = false;
        long b2 = b();
        if (b2 < 0) {
            sb = new StringBuilder();
            str = "onTcpConnected can't probes, because probesInterval is ";
        } else {
            b(context);
            e.a().c(context, b2);
            sb = new StringBuilder();
            str = "onTcpConnected probes after ";
        }
        sb.append(str);
        sb.append(b2);
        cn.jpush.android.r.b.b("ProbesTimer", sb.toString());
    }
}
