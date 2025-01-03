package cn.jpush.android.aq;

import android.content.Context;
import android.view.View;
import cn.jpush.android.aq.c;

/* loaded from: classes.dex */
public class f extends c {
    public f(cn.jpush.android.au.c cVar, cn.jpush.android.aw.e eVar) {
        super(cVar, eVar);
    }

    @Override // cn.jpush.android.aq.c
    public void a(Context context) {
    }

    @Override // cn.jpush.android.aq.c
    public void d(Context context) {
        super.d(context);
        View d2 = d();
        c.a aVar = this.f9229b;
        if (aVar == null || d2 == null) {
            return;
        }
        aVar.a(context, d2);
    }
}
