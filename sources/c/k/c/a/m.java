package c.k.c.a;

import android.content.Context;
import android.text.TextUtils;
import c.k.c.a.q0;
import c.k.d.d8;
import c.k.d.n4;
import c.k.d.x7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, q0.a> f6864a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static a f6865b;

    public static class a {
        public void a(String str, n nVar) {
            throw null;
        }

        public void b(String str, n nVar) {
            throw null;
        }
    }

    static {
        new HashMap();
    }

    public static void a(Context context, d8 d8Var) {
        n a2 = r.a(n4.COMMAND_UNREGISTER.f67a, null, d8Var.f7079a, d8Var.f7082d, null);
        String a3 = d8Var.a();
        a aVar = f6865b;
        if (aVar == null) {
            return;
        }
        aVar.b(a3, a2);
        throw null;
    }

    public static void a(Context context, x7 x7Var) {
        ArrayList arrayList;
        q0.a aVar;
        String b2 = x7Var.b();
        if (x7Var.a() == 0 && (aVar = f6864a.get(b2)) != null) {
            aVar.a(x7Var.f8019e, x7Var.f8020f);
            q0.m45a(context).a(b2, aVar);
        }
        if (TextUtils.isEmpty(x7Var.f8019e)) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(x7Var.f8019e);
            arrayList = arrayList2;
        }
        n a2 = r.a(n4.COMMAND_REGISTER.f67a, arrayList, x7Var.f121a, x7Var.f8018d, null);
        a aVar2 = f6865b;
        if (aVar2 == null) {
            return;
        }
        aVar2.a(b2, a2);
        throw null;
    }
}
