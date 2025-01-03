package cn.jpush.android.al;

import android.os.Looper;
import android.view.View;
import cn.jiguang.union.ads.api.JUnionAdError;
import cn.jiguang.union.ads.nativ.api.JNativeAd;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdEventListener;
import cn.jpush.android.af.c;

/* loaded from: classes.dex */
public class a extends OnNativeAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    public OnNativeAdEventListener f9129a;

    public a(OnNativeAdEventListener onNativeAdEventListener) {
        this.f9129a = onNativeAdEventListener;
    }

    @Override // cn.jiguang.union.ads.nativ.callback.OnNativeAdEventListener
    public void onAdClicked(final View view, final JNativeAd jNativeAd) {
        if (this.f9129a != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f9129a.onAdClicked(view, jNativeAd);
            } else {
                c.b().post(new Runnable() { // from class: cn.jpush.android.al.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f9129a.onAdClicked(view, jNativeAd);
                    }
                });
            }
        }
    }

    @Override // cn.jiguang.union.ads.nativ.callback.OnNativeAdEventListener
    public void onAdExposed(final JNativeAd jNativeAd) {
        if (this.f9129a != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f9129a.onAdExposed(jNativeAd);
            } else {
                c.b().post(new Runnable() { // from class: cn.jpush.android.al.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f9129a.onAdExposed(jNativeAd);
                    }
                });
            }
        }
    }

    @Override // cn.jiguang.union.ads.nativ.callback.OnNativeAdEventListener, cn.jiguang.union.ads.callback.OnUnionAdListener
    public void onError(final JUnionAdError jUnionAdError) {
        if (this.f9129a != null) {
            if (jUnionAdError == null) {
                jUnionAdError = new JUnionAdError(1);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f9129a.onError(jUnionAdError);
            } else {
                c.b().post(new Runnable() { // from class: cn.jpush.android.al.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f9129a.onError(jUnionAdError);
                    }
                });
            }
        }
    }
}
