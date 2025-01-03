package c.k.d;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* loaded from: classes.dex */
public class q6 implements XMPushService.l {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f7771d = false;

    /* renamed from: a, reason: collision with root package name */
    public Context f7772a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7773b;

    /* renamed from: c, reason: collision with root package name */
    public int f7774c;

    public q6(Context context) {
        this.f7772a = context;
    }

    public static void a(boolean z) {
        f7771d = z;
    }

    public final String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f7772a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    public void a() {
        a(this.f7772a);
        if (this.f7773b && m427a()) {
            c.k.a.a.a.c.m6a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            u6 a2 = t6.a(this.f7772a).a();
            if (a(a2)) {
                f7771d = true;
                r6.a(this.f7772a, a2);
            } else {
                c.k.a.a.a.c.m6a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }

    public final void a(Context context) {
        this.f7773b = c.k.d.p9.m.a(context).a(a7.TinyDataUploadSwitch.a(), true);
        int a2 = c.k.d.p9.m.a(context).a(a7.TinyDataUploadFrequency.a(), 7200);
        this.f7774c = a2;
        this.f7774c = Math.max(60, a2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m427a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f7772a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f7774c);
    }

    public final boolean a(u6 u6Var) {
        if (!e0.b(this.f7772a) || u6Var == null || TextUtils.isEmpty(a(this.f7772a.getPackageName())) || !new File(this.f7772a.getFilesDir(), "tiny_data.data").exists() || f7771d) {
            return false;
        }
        return !c.k.d.p9.m.a(this.f7772a).a(a7.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || f7.m153a(this.f7772a) || f7.m156b(this.f7772a);
    }
}
