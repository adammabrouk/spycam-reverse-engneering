package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketLoggingResult extends OSSResult {
    public boolean mLoggingEnabled = false;
    public String mTargetBucketName;
    public String mTargetPrefix;

    public String getTargetBucketName() {
        return this.mTargetBucketName;
    }

    public String getTargetPrefix() {
        return this.mTargetPrefix;
    }

    public boolean loggingEnabled() {
        return this.mLoggingEnabled;
    }

    public void setLoggingEnabled(boolean z) {
        this.mLoggingEnabled = z;
    }

    public void setTargetBucketName(String str) {
        this.mTargetBucketName = str;
    }

    public void setTargetPrefix(String str) {
        this.mTargetPrefix = str;
    }
}
