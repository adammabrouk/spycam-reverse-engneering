package c.k.d.p9;

import c.k.d.u6;
import c.k.d.z6;
import com.xiaomi.push.service.XMPushService;
import java.util.List;

/* loaded from: classes.dex */
public class g1 implements u6 {

    /* renamed from: a, reason: collision with root package name */
    public final XMPushService f7589a;

    public g1(XMPushService xMPushService) {
        this.f7589a = xMPushService;
    }

    public final String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f7589a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // c.k.d.u6
    public void a(List<z6> list, String str, String str2) {
        this.f7589a.a(new h1(this, 4, str, list, str2));
    }
}
