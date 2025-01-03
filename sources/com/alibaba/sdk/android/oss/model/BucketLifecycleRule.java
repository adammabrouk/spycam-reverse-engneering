package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class BucketLifecycleRule {
    public String mArchiveDays;
    public String mArchiveExpireDate;
    public String mDays;
    public String mExpireDate;
    public String mIADays;
    public String mIAExpireDate;
    public String mIdentifier;
    public String mMultipartDays;
    public String mMultipartExpireDate;
    public String mPrefix;
    public boolean mStatus;

    public String getArchiveDays() {
        return this.mArchiveDays;
    }

    public String getArchiveExpireDate() {
        return this.mArchiveExpireDate;
    }

    public String getDays() {
        return this.mDays;
    }

    public String getExpireDate() {
        return this.mExpireDate;
    }

    public String getIADays() {
        return this.mIADays;
    }

    public String getIAExpireDate() {
        return this.mIAExpireDate;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getMultipartDays() {
        return this.mMultipartDays;
    }

    public String getMultipartExpireDate() {
        return this.mMultipartExpireDate;
    }

    public String getPrefix() {
        return this.mPrefix;
    }

    public boolean getStatus() {
        return this.mStatus;
    }

    public void setArchiveDays(String str) {
        this.mArchiveDays = str;
    }

    public void setArchiveExpireDate(String str) {
        this.mArchiveExpireDate = str;
    }

    public void setDays(String str) {
        this.mDays = str;
    }

    public void setExpireDate(String str) {
        this.mExpireDate = str;
    }

    public void setIADays(String str) {
        this.mIADays = str;
    }

    public void setIAExpireDate(String str) {
        this.mIAExpireDate = str;
    }

    public void setIdentifier(String str) {
        this.mIdentifier = str;
    }

    public void setMultipartDays(String str) {
        this.mMultipartDays = str;
    }

    public void setMultipartExpireDate(String str) {
        this.mMultipartExpireDate = str;
    }

    public void setPrefix(String str) {
        this.mPrefix = str;
    }

    public void setStatus(boolean z) {
        this.mStatus = z;
    }
}
