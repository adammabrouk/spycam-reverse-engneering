package com.hjq.permissions;

import java.util.List;

/* loaded from: classes.dex */
public interface OnPermissionCallback {
    void onDenied(List<String> list, boolean z);

    void onGranted(List<String> list, boolean z);
}
