package cn.jiguang.union.ads.nativ.api;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.union.ads.api.JUnionAdError;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdLoadListener;
import cn.jpush.android.r.b;
import cn.jpush.android.w.a;

/* loaded from: classes.dex */
public class JNativeAdApi {
    public static final String TAG = "JNativeAdApi";
    public static volatile JNativeAdApi instance;
    public JNativeAdError nativeAdError = new JNativeAdError(2);

    public static JNativeAdApi getInstance() {
        if (instance == null) {
            synchronized (JNativeAdApi.class) {
                instance = new JNativeAdApi();
            }
        }
        return instance;
    }

    public void loadNativeAd(Context context, JNativeAdSlot jNativeAdSlot, OnNativeAdLoadListener onNativeAdLoadListener) {
        if (onNativeAdLoadListener == null) {
            b.h(TAG, "loadNativeAd nativeAdSlot can't be empty");
            return;
        }
        if (context == null) {
            onNativeAdLoadListener.onError(this.nativeAdError);
            b.h(TAG, "loadNativeAd context can't be empty");
        } else if (jNativeAdSlot == null) {
            onNativeAdLoadListener.onError(this.nativeAdError);
            b.h(TAG, "loadNativeAd nativeAdSlot can't be empty");
        } else if (!TextUtils.isEmpty(jNativeAdSlot.getAdCode())) {
            a.a().a(context.getApplicationContext(), jNativeAdSlot, onNativeAdLoadListener);
        } else {
            onNativeAdLoadListener.onError(new JUnionAdError(21002));
            b.h(TAG, "loadNativeAd ad code can't be empty");
        }
    }
}
