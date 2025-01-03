package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListPartsRequest extends OSSRequest {
    public String bucketName;
    public Integer maxParts;
    public String objectKey;
    public Integer partNumberMarker;
    public String uploadId;

    public ListPartsRequest(String str, String str2, String str3) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadId(str3);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public Integer getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setMaxParts(int i2) {
        this.maxParts = Integer.valueOf(i2);
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setPartNumberMarker(Integer num) {
        this.partNumberMarker = num;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
