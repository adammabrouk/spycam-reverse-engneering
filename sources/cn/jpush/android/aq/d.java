package cn.jpush.android.aq;

/* loaded from: classes.dex */
public class d {
    public static c a(cn.jpush.android.au.c cVar, cn.jpush.android.aw.e eVar) {
        if (eVar == null) {
            return null;
        }
        int n = eVar.n();
        if (n == 1) {
            return ((cn.jpush.android.aw.b) eVar).a() ? new b(cVar, eVar) : new a(cVar, eVar);
        }
        if (n == 2) {
            return new f(cVar, eVar);
        }
        if (n != 3) {
            return null;
        }
        return new e(cVar, eVar);
    }
}
