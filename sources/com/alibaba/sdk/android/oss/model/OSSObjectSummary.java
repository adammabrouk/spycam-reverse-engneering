package com.alibaba.sdk.android.oss.model;

import java.util.Date;

/* loaded from: classes.dex */
public class OSSObjectSummary {
    public String bucketName;
    public String eTag;
    public String key;
    public Date lastModified;
    public Owner owner;
    public long size;
    public String storageClass;
    public String type;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getKey() {
        return this.key;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public long getSize() {
        return this.size;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getType() {
        return this.type;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
