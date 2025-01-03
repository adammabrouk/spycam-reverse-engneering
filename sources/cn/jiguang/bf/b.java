package cn.jiguang.bf;

import android.content.Context;
import cn.jiguang.bf.a;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static a f8703a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8704b = new Object();

    public static void a(Context context) {
        synchronized (f8704b) {
            a aVar = new a(10000L, false, new a.InterfaceC0137a() { // from class: cn.jiguang.bf.b.1
                @Override // cn.jiguang.bf.a.InterfaceC0137a
                public void a(cn.jiguang.bg.a aVar2) {
                    b.b(aVar2);
                }
            }, context);
            f8703a = aVar;
            aVar.start();
        }
    }

    public static void b(cn.jiguang.bg.a aVar) {
        cn.jiguang.bg.c cVar = new cn.jiguang.bg.c();
        cVar.a("ANR");
        h.a().a(new c(cVar, aVar, aVar.a(), true));
    }
}
