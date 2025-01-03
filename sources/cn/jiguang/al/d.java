package cn.jiguang.al;

import android.annotation.SuppressLint;
import android.content.Context;
import cn.jiguang.an.e;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class d extends cn.jiguang.l.a {

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile d f8191b;

    /* renamed from: a, reason: collision with root package name */
    public Context f8192a;

    /* renamed from: c, reason: collision with root package name */
    public cn.jiguang.am.a f8193c;

    public static d a() {
        if (f8191b == null) {
            synchronized (d.class) {
                if (f8191b == null) {
                    f8191b = new d();
                }
            }
        }
        return f8191b;
    }

    @Override // cn.jiguang.l.a
    public String a(Context context) {
        this.f8192a = context;
        e.f8225a = true;
        return "JWakeReport";
    }

    @Override // cn.jiguang.l.a
    public boolean a(Context context, String str) {
        return true;
    }

    @Override // cn.jiguang.l.a
    public void b(Context context, String str) {
        this.f8193c = cn.jiguang.an.b.b(context);
        super.b(context, str);
    }

    @Override // cn.jiguang.l.a
    public boolean c(Context context, String str) {
        return cn.jiguang.l.b.c(context, str);
    }

    @Override // cn.jiguang.l.a
    public void d(Context context, String str) {
        if (this.f8193c.t) {
            JSONArray b2 = cn.jiguang.an.c.b(context);
            if (b2 == null || b2.length() == 0) {
                cn.jiguang.ai.a.a("JWakeReport", "no report wakeData");
            } else {
                cn.jiguang.ai.a.a("JWakeReport", "report wakeData:" + b2);
                cn.jiguang.l.d.a(context, b2);
                cn.jiguang.an.c.c(context);
                super.d(context, str);
            }
        } else {
            cn.jiguang.ai.a.d("JWakeReport", "server set do not report wake data.");
        }
        if (!this.f8193c.u) {
            cn.jiguang.ai.a.d("JWakeReport", "server set do not report waked data.");
            return;
        }
        JSONArray a2 = e.a(context);
        if (a2 == null || a2.length() == 0) {
            cn.jiguang.ai.a.a("JWakeReport", "no report wakedData");
            return;
        }
        cn.jiguang.ai.a.a("JWakeReport", "report wakedData:" + a2);
        cn.jiguang.l.d.a(context, a2);
        e.b(context);
        super.d(context, str);
    }
}
