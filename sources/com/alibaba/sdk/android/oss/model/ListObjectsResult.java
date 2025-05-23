package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ListObjectsResult extends OSSResult {
    public String bucketName;
    public String delimiter;
    public String encodingType;
    public boolean isTruncated;
    public String marker;
    public int maxKeys;
    public String nextMarker;
    public String prefix;
    public List<OSSObjectSummary> objectSummaries = new ArrayList();
    public List<String> commonPrefixes = new ArrayList();

    public void addCommonPrefix(String str) {
        this.commonPrefixes.add(str);
    }

    public void addObjectSummary(OSSObjectSummary oSSObjectSummary) {
        this.objectSummaries.add(oSSObjectSummary);
    }

    public void clearCommonPrefixes() {
        this.commonPrefixes.clear();
    }

    public void clearObjectSummaries() {
        this.objectSummaries.clear();
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public List<String> getCommonPrefixes() {
        return this.commonPrefixes;
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

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public List<OSSObjectSummary> getObjectSummaries() {
        return this.objectSummaries;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isTruncated() {
        return this.isTruncated;
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

    public void setMaxKeys(int i2) {
        this.maxKeys = i2;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }
}
