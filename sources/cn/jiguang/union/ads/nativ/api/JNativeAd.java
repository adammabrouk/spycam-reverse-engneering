package cn.jiguang.union.ads.nativ.api;

import android.view.View;
import cn.jiguang.union.ads.api.JUnionAdImage;
import cn.jiguang.union.ads.nativ.callback.OnNativeAdEventListener;
import java.util.List;

/* loaded from: classes.dex */
public interface JNativeAd {
    String getContent();

    List<JUnionAdImage> getImageList();

    String getTitle();

    void setOnNativeAdEventListener(View view, OnNativeAdEventListener onNativeAdEventListener);

    void setOnNativeAdEventListener(View view, List<View> list, OnNativeAdEventListener onNativeAdEventListener);
}
