package c.j.a;

import android.content.Context;
import c.j.a.z.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PushClient.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f6493a;

    public c(Context context) {
        m.m().a(context);
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f6493a == null) {
                f6493a = new c(context.getApplicationContext());
            }
            cVar = f6493a;
        }
        return cVar;
    }

    public String b() {
        return m.m().e();
    }

    public List<String> c() {
        return m.m().b();
    }

    public void d() throws f {
        a();
        m.m().a(new c.j.a.f.e());
    }

    public void b(String str, a aVar) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        m.m().a(arrayList, aVar);
    }

    public void a() throws f {
        m.m().a();
    }

    public void a(a aVar) {
        m.m().a(aVar);
    }

    public void a(String str, a aVar) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        m.m().b(arrayList, aVar);
    }
}
