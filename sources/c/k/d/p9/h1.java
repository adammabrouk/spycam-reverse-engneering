package c.k.d.p9;

import android.text.TextUtils;
import c.k.d.h8;
import c.k.d.j7;
import c.k.d.s7;
import c.k.d.v6;
import c.k.d.v7;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h1 extends XMPushService.i {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7600b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f7601c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7602d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g1 f7603e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(g1 g1Var, int i2, String str, List list, String str2) {
        super(i2);
        this.f7603e = g1Var;
        this.f7600b = str;
        this.f7601c = list;
        this.f7602d = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public void mo224a() {
        String a2;
        XMPushService xMPushService;
        a2 = this.f7603e.a(this.f7600b);
        ArrayList<v7> a3 = l0.a(this.f7601c, this.f7600b, a2, 32768);
        if (a3 == null) {
            c.k.a.a.a.c.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<v7> it = a3.iterator();
        while (it.hasNext()) {
            v7 next = it.next();
            next.a("uploadWay", "longXMPushService");
            s7 a4 = w1.a(this.f7600b, a2, next, v6.Notification);
            if (!TextUtils.isEmpty(this.f7602d) && !TextUtils.equals(this.f7600b, this.f7602d)) {
                if (a4.a() == null) {
                    j7 j7Var = new j7();
                    j7Var.a("-1");
                    a4.a(j7Var);
                }
                a4.a().b("ext_traffic_source_pkg", this.f7602d);
            }
            byte[] a5 = h8.a(a4);
            xMPushService = this.f7603e.f7589a;
            xMPushService.a(this.f7600b, a5, true);
        }
    }
}
