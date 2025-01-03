package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class OSSRequest {
    public boolean isAuthorizationRequired = true;
    public Enum CRC64 = CRC64Config.NULL;

    public enum CRC64Config {
        NULL,
        YES,
        NO
    }

    public Enum getCRC64() {
        return this.CRC64;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public void setCRC64(Enum r1) {
        this.CRC64 = r1;
    }

    public void setIsAuthorizationRequired(boolean z) {
        this.isAuthorizationRequired = z;
    }
}
