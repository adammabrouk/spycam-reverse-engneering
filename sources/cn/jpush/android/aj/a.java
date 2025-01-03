package cn.jpush.android.aj;

import android.content.Context;
import android.view.View;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdEventListener;
import cn.jpush.android.l.c;
import cn.jpush.android.r.b;

/* loaded from: classes.dex */
public class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9124a;

    /* renamed from: b, reason: collision with root package name */
    public final cn.jpush.android.ai.a f9125b;

    /* renamed from: c, reason: collision with root package name */
    public final OnNativeAdEventListener f9126c;

    public a(Context context, cn.jpush.android.ai.a aVar, OnNativeAdEventListener onNativeAdEventListener) {
        this.f9124a = context;
        this.f9125b = aVar;
        this.f9126c = onNativeAdEventListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new cn.jpush.android.al.a(this.f9126c).onAdClicked(view, this.f9125b);
        b.b("OnNativeAdClickListener", "ad clicked");
        c.a(this.f9124a, this.f9125b.e().f9950a, 24000, this.f9125b.e().al, this.f9125b.e().am);
        int a2 = cn.jpush.android.ag.a.a().a(this.f9124a, view, 4);
        if (a2 != 24999) {
            b.f("OnNativeAdClickListener", "click success but exposure is abnormal");
        }
        c.a(this.f9124a, this.f9125b.e().f9950a, a2, this.f9125b.e().al, this.f9125b.e().am);
        cn.jpush.android.l.a.c(this.f9124a, "OnNativeAdClickListener", new cn.jpush.android.r.a() { // from class: cn.jpush.android.aj.a.1
            @Override // cn.jpush.android.r.a
            public void a() {
                try {
                    cn.jpush.android.ag.a.a().a(a.this.f9124a, a.this.f9125b);
                } catch (Throwable unused) {
                }
            }
        });
    }
}
