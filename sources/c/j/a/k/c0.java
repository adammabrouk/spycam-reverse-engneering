package c.j.a.k;

import android.content.Context;
import android.text.TextUtils;
import c.j.a.k.a0;
import com.shix.shixipc.system.ContentCommon;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: classes.dex */
public final class c0 implements a0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f6577a;

    public c0(b0 b0Var) {
        this.f6577a = b0Var;
    }

    @Override // c.j.a.k.a0.a
    public final void a() {
        Context context;
        Context context2;
        long j = c.j.a.m.m().j();
        if (j < 1400 && j != 1340) {
            c.j.a.z.v.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(j)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.f6577a.f6570b.f()));
        context = this.f6577a.f6571c.f6635a;
        context2 = this.f6577a.f6571c.f6635a;
        String b2 = c.j.a.z.f0.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("app_id", b2);
        }
        hashMap.put(ContentCommon.TYPE, "1");
        hashMap.put("dtp", "1");
        c.j.a.z.k.a(6L, hashMap);
    }

    @Override // c.j.a.k.a0.a
    public final void b() {
        Context context;
        Context context2;
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.f6577a.f6570b.f()));
        context = this.f6577a.f6571c.f6635a;
        context2 = this.f6577a.f6571c.f6635a;
        String b2 = c.j.a.z.f0.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("remoteAppId", b2);
        }
        c.j.a.z.k.a(2122L, hashMap);
    }
}
