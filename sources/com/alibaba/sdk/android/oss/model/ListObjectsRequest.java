package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListObjectsRequest extends OSSRequest {
    public static final int MAX_RETURNED_KEYS_LIMIT = 1000;
    public String bucketName;
    public String delimiter;
    public String encodingType;
    public String marker;
    public Integer maxKeys;
    public String prefix;

    public ListObjectsRequest() {
        this(null);
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

    public String getMarker() {
        return this.marker;
    }

    public Integer getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setMaxKeys(Integer num) {
        if (num.intValue() < 0 || num.intValue() > 1000) {
            throw new IllegalArgumentException("Maxkeys should less can not exceed 1000.");
        }
        this.maxKeys = num;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public ListObjectsRequest(String str) {
        this(str, null, null, null, null);
    }

    public ListObjectsRequest(String str, String str2, String str3, String str4, Integer num) {
        setBucketName(str);
        setPrefix(str2);
        setMarker(str3);
        setDelimiter(str4);
        if (num != null) {
            setMaxKeys(num);
        }
    }
}
