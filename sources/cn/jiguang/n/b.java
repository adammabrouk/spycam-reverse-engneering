package cn.jiguang.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jiguang.l.c;
import cn.jiguang.l.e;
import com.tencent.bugly.CrashModule;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends cn.jiguang.l.a {

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile b f8980c;

    /* renamed from: a, reason: collision with root package name */
    public Context f8981a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f8982b;

    /* renamed from: d, reason: collision with root package name */
    public String f8983d;

    public static class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public Context f8984a;

        public a(Context context) {
            this.f8984a = context;
            this.f8954b = "JDevice#RegisterAction";
        }

        @Override // cn.jiguang.l.e
        public void a() {
            try {
                cn.jiguang.o.a.a(this.f8984a, cn.jiguang.o.a.f(this.f8984a));
            } catch (Throwable th) {
                cn.jiguang.ai.a.d("JDevice", "RegisterAction failed:" + th.getMessage());
            }
        }
    }

    public static b a() {
        if (f8980c == null) {
            synchronized (b.class) {
                if (f8980c == null) {
                    f8980c = new b();
                }
            }
        }
        return f8980c;
    }

    private JSONObject e(Context context) {
        StringBuilder sb;
        String message;
        JSONObject a2;
        StringBuilder sb2;
        if (context == null) {
            cn.jiguang.ai.a.d("JDevice", "when getDeviceInfo, context can't be null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String str = "";
            if (cn.jiguang.h.a.a().d(1005)) {
                String a3 = cn.jiguang.o.a.a();
                if (TextUtils.isEmpty(a3)) {
                    a3 = "";
                }
                jSONObject.put("cpu_info", a3);
            }
            if (cn.jiguang.h.a.a().d(1003)) {
                jSONObject.put("cpu_count", cn.jiguang.o.a.d());
            }
            if (cn.jiguang.h.a.a().d(1006)) {
                jSONObject.put("cpu_max_freq", cn.jiguang.o.a.e());
            }
            if (cn.jiguang.h.a.a().d(CrashModule.MODULE_ID)) {
                jSONObject.put("cpu_hardware", cn.jiguang.o.a.b());
            }
            if (cn.jiguang.h.a.a().d(1016)) {
                jSONObject.put("ram", cn.jiguang.o.a.c(context));
            }
            if (cn.jiguang.h.a.a().d(1018)) {
                jSONObject.put("rom", cn.jiguang.o.a.d(context));
            }
            if (cn.jiguang.h.a.a().d(1017)) {
                String a4 = cn.jiguang.o.a.a(context);
                if (TextUtils.isEmpty(a4)) {
                    a4 = "";
                }
                jSONObject.put("resolution", a4);
            }
            if (cn.jiguang.h.a.a().d(1020)) {
                String format = String.format(Locale.ENGLISH, "%.1f", Double.valueOf(cn.jiguang.o.a.b(context)));
                if (TextUtils.isEmpty(format)) {
                    format = "";
                }
                jSONObject.put("screensize", format);
            }
            if (cn.jiguang.h.a.a().d(1014)) {
                String format2 = String.format(Locale.ENGLISH, Build.VERSION.RELEASE, new Object[0]);
                jSONObject.put("os_version", TextUtils.isEmpty(format2) ? "" : format2.trim());
            }
            if (cn.jiguang.h.a.a().d(1013)) {
                String format3 = String.format(Locale.ENGLISH, Build.MODEL, new Object[0]);
                if (TextUtils.isEmpty(format3)) {
                    format3 = "";
                }
                jSONObject.put("model", format3);
            }
            if (cn.jiguang.h.a.a().d(1002)) {
                String format4 = String.format(Locale.ENGLISH, Build.BRAND, new Object[0]);
                if (TextUtils.isEmpty(format4)) {
                    format4 = "";
                }
                jSONObject.put("brand", format4);
            }
            if (cn.jiguang.h.a.a().d(1015)) {
                String format5 = String.format(Locale.ENGLISH, Build.PRODUCT, new Object[0]);
                if (TextUtils.isEmpty(format5)) {
                    format5 = "";
                }
                jSONObject.put("product", format5);
            }
            if (cn.jiguang.h.a.a().d(1007)) {
                String format6 = String.format(Locale.ENGLISH, Build.FINGERPRINT, new Object[0]);
                if (TextUtils.isEmpty(format6)) {
                    format6 = "";
                }
                jSONObject.put("fingerprint", format6);
            }
            if (cn.jiguang.h.a.a().d(1009)) {
                String locale = context.getResources().getConfiguration().locale.toString();
                if (TextUtils.isEmpty(locale)) {
                    locale = "";
                }
                jSONObject.put("language", locale);
            }
            if (cn.jiguang.h.a.a().d(1011)) {
                String format7 = String.format(Locale.ENGLISH, c.a.f8947b, new Object[0]);
                if (TextUtils.isEmpty(format7)) {
                    format7 = "";
                }
                jSONObject.put("manufacturer", format7);
            }
            if (cn.jiguang.h.a.a().d(1026)) {
                long rawOffset = TimeZone.getDefault().getRawOffset() / JConstants.HOUR;
                if (rawOffset > 0) {
                    sb2 = new StringBuilder();
                    sb2.append("+");
                    sb2.append(rawOffset);
                } else if (rawOffset < 0) {
                    sb2 = new StringBuilder();
                    sb2.append("-");
                    sb2.append(rawOffset);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(rawOffset);
                }
                String replace = sb2.toString().replace("--", "-");
                if (TextUtils.isEmpty(replace)) {
                    replace = "";
                }
                jSONObject.put("timezone", replace);
            }
            if (cn.jiguang.h.a.a().d(1019)) {
                String a5 = cn.jiguang.o.b.a();
                if (!TextUtils.isEmpty(a5)) {
                    str = a5;
                }
                jSONObject.put("romversion", str);
            }
            if (cn.jiguang.h.a.a().d(1008) && (a2 = cn.jiguang.r.a.a(context)) != null) {
                jSONObject.put("ids", a2);
            }
            jSONObject.put("android_ver", Build.VERSION.SDK_INT);
            jSONObject.put("android_target_ver", context.getApplicationInfo().targetSdkVersion);
            return jSONObject;
        } catch (JSONException e2) {
            sb = new StringBuilder();
            sb.append("package json exception: ");
            message = e2.getMessage();
            sb.append(message);
            cn.jiguang.ai.a.d("JDevice", sb.toString());
            return null;
        } catch (Throwable th) {
            sb = new StringBuilder();
            sb.append("getDeviceInfo exception: ");
            message = th.getMessage();
            sb.append(message);
            cn.jiguang.ai.a.d("JDevice", sb.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0044 A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0007, B:12:0x004a, B:15:0x0068, B:18:0x0075, B:21:0x0082, B:24:0x008f, B:27:0x009c, B:30:0x00aa, B:35:0x0044, B:36:0x003e, B:39:0x0021), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x003e A[Catch: all -> 0x00b2, TryCatch #0 {all -> 0x00b2, blocks: (B:3:0x0007, B:12:0x004a, B:15:0x0068, B:18:0x0075, B:21:0x0082, B:24:0x008f, B:27:0x009c, B:30:0x00aa, B:35:0x0044, B:36:0x003e, B:39:0x0021), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String f(android.content.Context r11) {
        /*
            java.lang.String r0 = "JDevice"
            java.lang.String r1 = ","
            java.lang.String r2 = ""
            r3 = 0
            java.lang.String r4 = cn.jiguang.l.d.a(r11)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r5 = cn.jiguang.l.d.b(r11)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r6 = r11.getPackageName()     // Catch: java.lang.Throwable -> L1f
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch: java.lang.Throwable -> L1d
            r7 = 0
            android.content.pm.PackageInfo r11 = r11.getPackageInfo(r6, r7)     // Catch: java.lang.Throwable -> L1d
            goto L3a
        L1d:
            r11 = move-exception
            goto L21
        L1f:
            r11 = move-exception
            r6 = r2
        L21:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r7.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r8 = "getPackageManager failed:"
            r7.append(r8)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> Lb2
            r7.append(r11)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r11 = r7.toString()     // Catch: java.lang.Throwable -> Lb2
            cn.jiguang.ai.a.d(r0, r11)     // Catch: java.lang.Throwable -> Lb2
            r11 = r3
        L3a:
            if (r11 != 0) goto L3e
            r7 = r2
            goto L40
        L3e:
            java.lang.String r7 = r11.versionName     // Catch: java.lang.Throwable -> Lb2
        L40:
            if (r11 != 0) goto L44
            r11 = r2
            goto L4a
        L44:
            int r11 = r11.versionCode     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> Lb2
        L4a:
            java.lang.String r8 = cn.jiguang.l.d.a()     // Catch: java.lang.Throwable -> Lb2
            int r9 = cn.jiguang.l.d.b()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r10.<init>()     // Catch: java.lang.Throwable -> Lb2
            r10.append(r4)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lb2
            if (r4 == 0) goto L68
            r5 = r2
        L68:
            r10.append(r5)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lb2
            if (r4 == 0) goto L75
            r7 = r2
        L75:
            r10.append(r7)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r4 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> Lb2
            if (r4 == 0) goto L82
            r11 = r2
        L82:
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r11 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Lb2
            if (r11 == 0) goto L8f
            r8 = r2
        L8f:
            r10.append(r8)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> Lb2
            if (r11 == 0) goto L9c
            r9 = r2
        L9c:
            r10.append(r9)     // Catch: java.lang.Throwable -> Lb2
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb2
            boolean r11 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Lb2
            if (r11 == 0) goto La9
            goto Laa
        La9:
            r2 = r6
        Laa:
            r10.append(r2)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r11 = r10.toString()     // Catch: java.lang.Throwable -> Lb2
            return r11
        Lb2:
            r11 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getCurrentCondition throwable: "
            r1.append(r2)
            java.lang.String r11 = r11.getMessage()
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            cn.jiguang.ai.a.d(r0, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.n.b.f(android.content.Context):java.lang.String");
    }

    @Override // cn.jiguang.l.a
    public String a(Context context) {
        this.f8981a = context;
        return "JDevice";
    }

    public void b(Context context, int i2) {
        cn.jiguang.l.d.a(new a(context), i2);
    }

    @Override // cn.jiguang.l.a
    public void b(Context context, String str) {
        if (!cn.jiguang.h.a.a().a(1000)) {
            cn.jiguang.ai.a.a("JDevice", "will not report");
            return;
        }
        JSONObject e2 = e(context);
        this.f8982b = e2;
        if (e2 == null) {
            cn.jiguang.ai.a.d("JDevice", "collect failed");
            return;
        }
        cn.jiguang.ai.a.a("JDevice", "collect success:" + this.f8982b);
        super.b(context, str);
    }

    @Override // cn.jiguang.l.a
    public boolean c(Context context, String str) {
        if (!cn.jiguang.l.b.b(context, str)) {
            return false;
        }
        JSONObject jSONObject = this.f8982b;
        if (jSONObject == null) {
            cn.jiguang.ai.a.d("JDevice", "there are no data to report");
            return false;
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return false;
        }
        this.f8983d = cn.jiguang.l.d.c(jSONObject2 + f(context));
        String h2 = cn.jiguang.l.b.h(context);
        if (TextUtils.isEmpty(this.f8983d) || TextUtils.equals(this.f8983d, h2)) {
            cn.jiguang.ai.a.a("JDevice", "device detail is not change");
            return false;
        }
        cn.jiguang.ai.a.a("JDevice", "device detail is change");
        return super.c(context, str);
    }

    @Override // cn.jiguang.l.a
    public Object d(Context context) {
        return e(context);
    }

    @Override // cn.jiguang.l.a
    public void d(Context context, String str) {
        JSONObject jSONObject = this.f8982b;
        if (jSONObject == null) {
            cn.jiguang.ai.a.a("JDevice", "there are no data to report");
            return;
        }
        cn.jiguang.l.d.a(context, jSONObject, "device_info");
        cn.jiguang.l.d.a(context, this.f8982b, new cn.jiguang.n.a(context, this.f8983d, str));
        this.f8982b = null;
    }
}
