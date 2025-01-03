package com.alibaba.sdk.android.oss.model;

import java.util.Date;

/* loaded from: classes.dex */
public class MultipartUpload {
    public Date initiated;
    public String key;
    public String storageClass;
    public String uploadId;

    public Date getInitiated() {
        return this.initiated;
    }

    public String getKey() {
        return this.key;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setInitiated(Date date) {
        this.initiated = date;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
