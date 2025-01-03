package c.k.d.p9;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import c.k.d.c6;
import c.k.d.g3;
import c.k.d.i3;
import c.k.d.n6;
import c.k.d.o4;
import c.k.d.p6;
import c.k.d.p9.h0;
import c.k.d.q9;
import c.k.d.u1;
import c.k.d.z4;
import cn.jiguang.internal.JConstants;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class w extends h0.a implements u1.a {

    /* renamed from: a, reason: collision with root package name */
    public XMPushService f7726a;

    /* renamed from: b, reason: collision with root package name */
    public long f7727b;

    public static class a implements u1.b {
        @Override // c.k.d.u1.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(39));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", c6.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(q9.a()));
            String builder = buildUpon.toString();
            c.k.a.a.a.c.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = c.k.d.e0.a(q9.m432a(), url);
                p6.a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return a2;
            } catch (IOException e2) {
                p6.a(url.getHost() + ":" + port, -1, e2);
                throw e2;
            }
        }
    }

    public static class b extends c.k.d.u1 {
        public b(Context context, c.k.d.t1 t1Var, u1.b bVar, String str) {
            super(context, t1Var, bVar, str);
        }

        @Override // c.k.d.u1
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (n6.m307a().m312a()) {
                    str2 = h0.m381a();
                }
                return super.a(arrayList, str, str2, z);
            } catch (IOException e2) {
                p6.a(0, o4.GSLB_ERR.a(), 1, null, c.k.d.e0.b(c.k.d.u1.f7913h) ? 1 : 0);
                throw e2;
            }
        }
    }

    public w(XMPushService xMPushService) {
        this.f7726a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        w wVar = new w(xMPushService);
        h0.a().a(wVar);
        synchronized (c.k.d.u1.class) {
            c.k.d.u1.a(wVar);
            c.k.d.u1.a(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    @Override // c.k.d.u1.a
    public c.k.d.u1 a(Context context, c.k.d.t1 t1Var, u1.b bVar, String str) {
        return new b(context, t1Var, bVar, str);
    }

    @Override // c.k.d.p9.h0.a
    public void a(g3 g3Var) {
    }

    @Override // c.k.d.p9.h0.a
    public void a(i3 i3Var) {
        c.k.d.p1 b2;
        if (i3Var.m216b() && i3Var.m215a() && System.currentTimeMillis() - this.f7727b > JConstants.HOUR) {
            c.k.a.a.a.c.m6a("fetch bucket :" + i3Var.m215a());
            this.f7727b = System.currentTimeMillis();
            c.k.d.u1 a2 = c.k.d.u1.a();
            a2.m492a();
            a2.m495b();
            z4 m586a = this.f7726a.m586a();
            if (m586a == null || (b2 = a2.b(m586a.m542a().c())) == null) {
                return;
            }
            ArrayList<String> m327a = b2.m327a();
            boolean z = true;
            Iterator<String> it = m327a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m586a.mo543a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m327a.isEmpty()) {
                return;
            }
            c.k.a.a.a.c.m6a("bucket changed, force reconnect");
            this.f7726a.a(0, (Exception) null);
            this.f7726a.a(false);
        }
    }
}
