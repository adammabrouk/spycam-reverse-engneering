package c.k.d.p9;

import android.content.Context;
import c.k.d.d5;
import c.k.d.p9.r;
import c.k.d.q9;
import com.xiaomi.push.service.XMPushService;
import java.util.Locale;

/* loaded from: classes.dex */
public class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f7606a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7607b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7608c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7609d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7610e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7611f;

    /* renamed from: g, reason: collision with root package name */
    public final int f7612g;

    public i1(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.f7606a = str;
        this.f7607b = str2;
        this.f7608c = str3;
        this.f7609d = str4;
        this.f7610e = str5;
        this.f7611f = str6;
        this.f7612g = i2;
    }

    public static boolean a() {
        try {
            return q9.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public r.b a(r.b bVar, Context context, b1 b1Var, String str) {
        bVar.f7677a = context.getPackageName();
        bVar.f7678b = this.f7606a;
        bVar.f7685i = this.f7608c;
        bVar.f7679c = this.f7607b;
        bVar.f7684h = "5";
        bVar.f7680d = "XMPUSH-PASS";
        bVar.f7681e = false;
        bVar.f7682f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s", "sdk_ver", 39, "cpvn", "3_7_6", "cpvc", 30706, "aapn", b(context) ? d5.b(context) : "", "country_code", a.a(context).b(), "region", a.a(context).a());
        bVar.f7683g = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", "appid", b(context) ? "1000271" : this.f7609d, "locale", Locale.getDefault().toString(), "miid", q9.a(context));
        if (a(context)) {
            bVar.f7683g += String.format(",%1$s:%2$s", "ab", str);
        }
        bVar.k = b1Var;
        return bVar;
    }

    public r.b a(XMPushService xMPushService) {
        r.b bVar = new r.b(xMPushService);
        a(bVar, xMPushService, xMPushService.b(), "c");
        return bVar;
    }
}
