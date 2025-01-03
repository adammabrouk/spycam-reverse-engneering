package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListMultipartUploadsRequest extends OSSRequest {
    public String bucketName;
    public String delimiter;
    public String encodingType;
    public String keyMarker;
    public Integer maxUploads;
    public String prefix;
    public String uploadIdMarker;

    public ListMultipartUploadsRequest(String str) {
        this.bucketName = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public Integer getMaxUploads() {
        return this.maxUploads;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public void setMaxUploads(Integer num) {
        this.maxUploads = num;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setUploadIdMarker(String str) {
        this.uploadIdMarker = str;
    }
}
