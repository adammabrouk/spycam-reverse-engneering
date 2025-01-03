package c.k.d;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class z2 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    public static String f8058c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f8059d = "";

    public z2(Context context, int i2) {
        super(context, i2);
    }

    @Override // c.k.d.j.a
    public int a() {
        return 12;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public x6 mo92a() {
        return x6.BroadcastAction;
    }

    @Override // c.k.d.a3
    /* renamed from: a */
    public String mo67a() {
        String str;
        if (TextUtils.isEmpty(f8058c)) {
            str = "";
        } else {
            str = "" + a(q2.f7758b, f8058c);
            f8058c = "";
        }
        if (TextUtils.isEmpty(f8059d)) {
            return str;
        }
        String str2 = str + a(q2.f7759c, f8059d);
        f8059d = "";
        return str2;
    }

    public final String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String[] split = str2.split(",");
        if (split.length <= 10) {
            return str2;
        }
        int length = split.length;
        while (true) {
            length--;
            if (length < split.length - 10) {
                return str;
            }
            str = str + split[length];
        }
    }
}
