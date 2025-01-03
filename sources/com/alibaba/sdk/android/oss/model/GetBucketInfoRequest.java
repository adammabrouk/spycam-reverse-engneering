package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketInfoRequest extends OSSRequest {
    public String bucketName;

    public GetBucketInfoRequest(String str) {
        this.bucketName = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }
}
