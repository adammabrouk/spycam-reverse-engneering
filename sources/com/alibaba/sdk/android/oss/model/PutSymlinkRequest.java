package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutSymlinkRequest extends OSSRequest {
    public String bucketName;
    public ObjectMetadata metadata;
    public String objectKey;
    public String targetObjectName;

    public String getBucketName() {
        return this.bucketName;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public String getTargetObjectName() {
        return this.targetObjectName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setTargetObjectName(String str) {
        this.targetObjectName = str;
    }
}
