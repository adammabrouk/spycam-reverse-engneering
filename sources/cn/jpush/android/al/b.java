package cn.jpush.android.al;

import android.os.Looper;
import cn.jiguang.union.ads.api.JUnionAdError;
import cn.jiguang.union.ads.nativ.api.JNativeAd;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdLoadListener;
import cn.jpush.android.af.c;
import java.util.List;

/* loaded from: classes.dex */
public class b extends OnNativeAdLoadListener {

    /* renamed from: a, reason: collision with root package name */
    public OnNativeAdLoadListener f9137a;

    public b(OnNativeAdLoadListener onNativeAdLoadListener) {
        this.f9137a = onNativeAdLoadListener;
    }

    @Override // cn.jiguang.union.ads.nativ.callback.OnNativeAdLoadListener, cn.jiguang.union.ads.callback.OnUnionAdListener
    public void onError(final JUnionAdError jUnionAdError) {
        if (this.f9137a != null) {
            if (jUnionAdError == null) {
                jUnionAdError = new JUnionAdError(1);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f9137a.onError(jUnionAdError);
            } else {
                c.b().post(new Runnable() { // from class: cn.jpush.android.al.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f9137a.onError(jUnionAdError);
                    }
                });
            }
        }
    }

    @Override // cn.jiguang.union.ads.nativ.callback.OnNativeAdLoadListener
    public void onLoaded(final List<JNativeAd> list) {
        if (this.f9137a != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f9137a.onLoaded(list);
            } else {
                c.b().post(new Runnable() { // from class: cn.jpush.android.al.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f9137a.onLoaded(list);
                    }
                });
            }
        }
    }
}
