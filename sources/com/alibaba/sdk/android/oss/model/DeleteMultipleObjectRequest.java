package com.alibaba.sdk.android.oss.model;

import java.util.List;

/* loaded from: classes.dex */
public class DeleteMultipleObjectRequest extends OSSRequest {
    public String bucketName;
    public boolean isQuiet;
    public List<String> objectKeys;

    public DeleteMultipleObjectRequest(String str, List<String> list, Boolean bool) {
        setBucketName(str);
        setObjectKeys(list);
        setQuiet(bool);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public List<String> getObjectKeys() {
        return this.objectKeys;
    }

    public Boolean getQuiet() {
        return Boolean.valueOf(this.isQuiet);
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setObjectKeys(List<String> list) {
        this.objectKeys = list;
    }

    public void setQuiet(Boolean bool) {
        this.isQuiet = bool.booleanValue();
    }
}
