package com.shix.shixipc.utils;

import android.content.Context;
import c.g.a.a;
import c.g.a.c.d;
import c.g.a.f.m;
import c.g.a.f.p;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.lookcam.R;
import com.shix.shixipc.utilcode.ToastUtils;
import java.util.List;

/* loaded from: classes.dex */
public class PermissionXUtils {
    public static PermissionXUtils mInstance;

    public interface OnPermissionCallback {
        void onResult(boolean z);
    }

    public static PermissionXUtils getInstance() {
        if (mInstance == null) {
            synchronized (PermissionXUtils.class) {
                if (mInstance == null) {
                    mInstance = new PermissionXUtils();
                }
            }
        }
        return mInstance;
    }

    public void initPermission(final Context context, a aVar, String[] strArr, final OnPermissionCallback onPermissionCallback) {
        p a2 = aVar.a(strArr);
        a2.a(new c.g.a.c.a() { // from class: com.shix.shixipc.utils.PermissionXUtils.2
            @Override // c.g.a.c.a
            public void onExplainReason(m mVar, List<String> list) {
                mVar.a(list, context.getResources().getString(R.string.permission_request_description), context.getResources().getString(R.string.allow), context.getResources().getString(R.string.disagree));
            }
        });
        a2.a(new d() { // from class: com.shix.shixipc.utils.PermissionXUtils.1
            @Override // c.g.a.c.d
            public void onResult(boolean z, List<String> list, List<String> list2) {
                onPermissionCallback.onResult(z);
                if (z) {
                    return;
                }
                ToastUtils.showLong(context.getResources().getString(R.string.not_authorized_properly) + OSSUtils.NEW_LINE + list2.toString());
            }
        });
    }
}
