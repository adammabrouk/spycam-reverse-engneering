package cn.jiguang.union.ads.nativ.callback;

import android.view.View;
import cn.jiguang.union.ads.api.JUnionAdError;
import cn.jiguang.union.ads.callback.OnUnionAdListener;
import cn.jiguang.union.ads.nativ.api.JNativeAd;

/* loaded from: classes.dex */
public abstract class OnNativeAdEventListener implements OnUnionAdListener {
    public abstract void onAdClicked(View view, JNativeAd jNativeAd);

    public abstract void onAdExposed(JNativeAd jNativeAd);

    @Override // cn.jiguang.union.ads.callback.OnUnionAdListener
    public void onError(JUnionAdError jUnionAdError) {
    }
}
