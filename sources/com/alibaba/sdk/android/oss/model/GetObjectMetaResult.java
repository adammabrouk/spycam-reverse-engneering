package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetObjectMetaResult extends OSSResult {
    public ObjectMetadata metadata = new ObjectMetadata();

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }
}
