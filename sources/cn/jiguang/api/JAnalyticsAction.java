package cn.jiguang.api;

import android.content.Context;

/* loaded from: classes.dex */
public interface JAnalyticsAction {
    void dispatchPause(Context context);

    void dispatchResume(Context context);

    void dispatchStatus(Context context, String str);
}
