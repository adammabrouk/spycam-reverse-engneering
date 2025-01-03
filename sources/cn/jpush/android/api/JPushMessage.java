package cn.jpush.android.api;

import java.io.Serializable;
import java.util.Set;

/* loaded from: classes.dex */
public class JPushMessage implements Serializable {
    public static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    public String f9179a;

    /* renamed from: b, reason: collision with root package name */
    public Set<String> f9180b;

    /* renamed from: c, reason: collision with root package name */
    public String f9181c;

    /* renamed from: d, reason: collision with root package name */
    public int f9182d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9183e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9184f;

    /* renamed from: g, reason: collision with root package name */
    public int f9185g;

    /* renamed from: h, reason: collision with root package name */
    public String f9186h;

    public String getAlias() {
        return this.f9179a;
    }

    public String getCheckTag() {
        return this.f9181c;
    }

    public int getErrorCode() {
        return this.f9182d;
    }

    public String getMobileNumber() {
        return this.f9186h;
    }

    public int getSequence() {
        return this.f9185g;
    }

    public boolean getTagCheckStateResult() {
        return this.f9183e;
    }

    public Set<String> getTags() {
        return this.f9180b;
    }

    public boolean isTagCheckOperator() {
        return this.f9184f;
    }

    public void setAlias(String str) {
        this.f9179a = str;
    }

    public void setCheckTag(String str) {
        this.f9181c = str;
    }

    public void setErrorCode(int i2) {
        this.f9182d = i2;
    }

    public void setMobileNumber(String str) {
        this.f9186h = str;
    }

    public void setSequence(int i2) {
        this.f9185g = i2;
    }

    public void setTagCheckOperator(boolean z) {
        this.f9184f = z;
    }

    public void setTagCheckStateResult(boolean z) {
        this.f9183e = z;
    }

    public void setTags(Set<String> set) {
        this.f9180b = set;
    }

    public String toString() {
        return "JPushMessage{alias='" + this.f9179a + "', tags=" + this.f9180b + ", checkTag='" + this.f9181c + "', errorCode=" + this.f9182d + ", tagCheckStateResult=" + this.f9183e + ", isTagCheckOperator=" + this.f9184f + ", sequence=" + this.f9185g + ", mobileNumber=" + this.f9186h + '}';
    }
}
