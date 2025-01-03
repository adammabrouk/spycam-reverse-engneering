package cn.jpush.android.w;

import android.content.Context;
import cn.jiguang.union.ads.nativ.api.JNativeAdSlot;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdLoadListener;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9917a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f9918b;

    public static a a() {
        if (f9918b == null) {
            synchronized (f9917a) {
                if (f9918b == null) {
                    f9918b = new a();
                }
            }
        }
        return f9918b;
    }

    public void a(final Context context, final JNativeAdSlot jNativeAdSlot, final OnNativeAdLoadListener onNativeAdLoadListener) {
        cn.jpush.android.l.a.c(context, "JUnionAdActionHelper", new cn.jpush.android.r.a("loadNativeAd") { // from class: cn.jpush.android.w.a.1
            @Override // cn.jpush.android.r.a
            public void a() {
                try {
                    cn.jpush.android.ag.a.a().a(context, jNativeAdSlot, onNativeAdLoadListener);
                } catch (Throwable th) {
                    cn.jpush.android.r.b.f("JUnionAdActionHelper", "loadNativeAd failed " + th.getMessage());
                }
            }
        });
    }
}
