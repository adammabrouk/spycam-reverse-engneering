package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class PutBucketRefererRequest extends OSSRequest {
    public boolean mAllowEmpty;
    public String mBucketName;
    public ArrayList<String> mReferers;

    public String getBucketName() {
        return this.mBucketName;
    }

    public ArrayList<String> getReferers() {
        return this.mReferers;
    }

    public boolean isAllowEmpty() {
        return this.mAllowEmpty;
    }

    public void setAllowEmpty(boolean z) {
        this.mAllowEmpty = z;
    }

    public void setBucketName(String str) {
        this.mBucketName = str;
    }

    public void setReferers(ArrayList<String> arrayList) {
        this.mReferers = arrayList;
    }
}
