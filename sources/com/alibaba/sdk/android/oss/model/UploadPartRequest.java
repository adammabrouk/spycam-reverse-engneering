package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;

/* loaded from: classes.dex */
public class UploadPartRequest extends OSSRequest {
    public String bucketName;
    public String md5Digest;
    public String objectKey;
    public byte[] partContent;
    public int partNumber;
    public OSSProgressCallback<UploadPartRequest> progressCallback;
    public String uploadId;

    public UploadPartRequest() {
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getMd5Digest() {
        return this.md5Digest;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public byte[] getPartContent() {
        return this.partContent;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public OSSProgressCallback<UploadPartRequest> getProgressCallback() {
        return this.progressCallback;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setMd5Digest(String str) {
        this.md5Digest = str;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setPartContent(byte[] bArr) {
        this.partContent = bArr;
    }

    public void setPartNumber(int i2) {
        this.partNumber = i2;
    }

    public void setProgressCallback(OSSProgressCallback<UploadPartRequest> oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public UploadPartRequest(String str, String str2, String str3, int i2) {
        this.bucketName = str;
        this.objectKey = str2;
        this.uploadId = str3;
        this.partNumber = i2;
    }
}
