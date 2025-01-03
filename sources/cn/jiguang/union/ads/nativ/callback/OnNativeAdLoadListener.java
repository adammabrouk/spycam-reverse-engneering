package cn.jiguang.union.ads.nativ.callback;

import cn.jiguang.union.ads.api.JUnionAdError;
import cn.jiguang.union.ads.callback.OnUnionAdListener;
import cn.jiguang.union.ads.nativ.api.JNativeAd;
import java.util.List;

/* loaded from: classes.dex */
public abstract class OnNativeAdLoadListener implements OnUnionAdListener {
    @Override // cn.jiguang.union.ads.callback.OnUnionAdListener
    public void onError(JUnionAdError jUnionAdError) {
    }

    public abstract void onLoaded(List<JNativeAd> list);
}
