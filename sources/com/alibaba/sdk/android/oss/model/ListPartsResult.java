package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ListPartsResult extends OSSResult {
    public String bucketName;
    public String key;
    public String storageClass;
    public String uploadId;
    public int maxParts = 0;
    public int partNumberMarker = 0;
    public boolean isTruncated = false;
    public int nextPartNumberMarker = 0;
    public List<PartSummary> parts = new ArrayList();

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public int getMaxParts() {
        return this.maxParts;
    }

    public int getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public List<PartSummary> getParts() {
        return this.parts;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMaxParts(int i2) {
        this.maxParts = i2;
    }

    public void setNextPartNumberMarker(int i2) {
        this.nextPartNumberMarker = i2;
    }

    public void setPartNumberMarker(int i2) {
        this.partNumberMarker = i2;
    }

    public void setParts(List<PartSummary> list) {
        this.parts.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.parts.addAll(list);
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
