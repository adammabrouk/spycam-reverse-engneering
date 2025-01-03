package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketLifecycleRequest extends OSSRequest {
    public String mBucketName;

    public String getBucketName() {
        return this.mBucketName;
    }

    public void setBucketName(String str) {
        this.mBucketName = str;
    }
}
