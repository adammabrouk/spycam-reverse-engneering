package cn.jiguang.am;

import android.content.Intent;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f8205a;

    /* renamed from: b, reason: collision with root package name */
    public String f8206b;

    /* renamed from: c, reason: collision with root package name */
    public int f8207c;

    /* renamed from: d, reason: collision with root package name */
    public String f8208d;

    /* renamed from: e, reason: collision with root package name */
    public Intent f8209e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f8210f;

    /* renamed from: g, reason: collision with root package name */
    public int f8211g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f8212h;

    /* renamed from: i, reason: collision with root package name */
    public int f8213i;

    public c() {
    }

    public c(String str, String str2, int i2) {
        this.f8205a = str;
        this.f8206b = str2;
        this.f8207c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        String str = this.f8205a;
        String str2 = ((c) obj).f8205a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String toString() {
        return "JWakeTargetInfo{packageName='" + this.f8205a + "', serviceName='" + this.f8206b + "', targetVersion=" + this.f8207c + ", providerAuthority='" + this.f8208d + "', activityIntent=" + this.f8209e + ", activityIntentBackup=" + this.f8210f + ", wakeType=" + this.f8211g + ", authenType=" + this.f8212h + ", cmd=" + this.f8213i + '}';
    }
}
