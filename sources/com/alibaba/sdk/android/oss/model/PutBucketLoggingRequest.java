package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutBucketLoggingRequest extends OSSRequest {
    public String mBucketName;
    public String mTargetBucketName;
    public String mTargetPrefix;

    public String getBucketName() {
        return this.mBucketName;
    }

    public String getTargetBucketName() {
        return this.mTargetBucketName;
    }

    public String getTargetPrefix() {
        return this.mTargetPrefix;
    }

    public void setBucketName(String str) {
        this.mBucketName = str;
    }

    public void setTargetBucketName(String str) {
        this.mTargetBucketName = str;
    }

    public void setTargetPrefix(String str) {
        this.mTargetPrefix = str;
    }
}
