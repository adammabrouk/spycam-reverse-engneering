package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetObjectTaggingRequest extends OSSRequest {
    public String bucketName;
    public String objectKey;

    public GetObjectTaggingRequest(String str, String str2) {
        this.bucketName = str;
        this.objectKey = str2;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }
}
