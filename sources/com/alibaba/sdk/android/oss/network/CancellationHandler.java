package com.alibaba.sdk.android.oss.network;

import h.e;

/* loaded from: classes.dex */
public class CancellationHandler {
    public volatile e call;
    public volatile boolean isCancelled;

    public void cancel() {
        if (this.call != null) {
            this.call.cancel();
        }
        this.isCancelled = true;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCall(e eVar) {
        this.call = eVar;
    }
}
