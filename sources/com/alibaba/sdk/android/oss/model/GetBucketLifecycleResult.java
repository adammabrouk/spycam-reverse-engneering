package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class GetBucketLifecycleResult extends OSSResult {
    public ArrayList<BucketLifecycleRule> mLifecycleRules;

    public void addLifecycleRule(BucketLifecycleRule bucketLifecycleRule) {
        if (this.mLifecycleRules == null) {
            this.mLifecycleRules = new ArrayList<>();
        }
        this.mLifecycleRules.add(bucketLifecycleRule);
    }

    public ArrayList<BucketLifecycleRule> getlifecycleRules() {
        return this.mLifecycleRules;
    }

    public void setLifecycleRules(ArrayList<BucketLifecycleRule> arrayList) {
        this.mLifecycleRules = arrayList;
    }
}
