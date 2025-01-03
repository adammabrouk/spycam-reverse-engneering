package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.r.e;
import java.util.List;

/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new e();

    /* renamed from: a, reason: collision with root package name */
    public final int f10159a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10160b;

    /* renamed from: c, reason: collision with root package name */
    public int f10161c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10162d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10163e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10164f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10165g;

    /* renamed from: h, reason: collision with root package name */
    public final List<String> f10166h;

    /* renamed from: i, reason: collision with root package name */
    public final String f10167i;
    public final long j;
    public int k;
    public final String l;
    public final float m;
    public final long n;
    public final boolean o;
    public long p;

    public WakeLockEvent(int i2, long j, int i3, String str, int i4, List<String> list, String str2, long j2, int i5, String str3, String str4, float f2, long j3, String str5, boolean z) {
        this.f10159a = i2;
        this.f10160b = j;
        this.f10161c = i3;
        this.f10162d = str;
        this.f10163e = str3;
        this.f10164f = str5;
        this.f10165g = i4;
        this.p = -1L;
        this.f10166h = list;
        this.f10167i = str2;
        this.j = j2;
        this.k = i5;
        this.l = str4;
        this.m = f2;
        this.n = j3;
        this.o = z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int u() {
        return this.f10161c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long v() {
        return this.f10160b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long w() {
        return this.p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10159a);
        b.a(parcel, 2, v());
        b.a(parcel, 4, this.f10162d, false);
        b.a(parcel, 5, this.f10165g);
        b.a(parcel, 6, this.f10166h, false);
        b.a(parcel, 8, this.j);
        b.a(parcel, 10, this.f10163e, false);
        b.a(parcel, 11, u());
        b.a(parcel, 12, this.f10167i, false);
        b.a(parcel, 13, this.l, false);
        b.a(parcel, 14, this.k);
        b.a(parcel, 15, this.m);
        b.a(parcel, 16, this.n);
        b.a(parcel, 17, this.f10164f, false);
        b.a(parcel, 18, this.o);
        b.a(parcel, a2);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String x() {
        String str = this.f10162d;
        int i2 = this.f10165g;
        List<String> list = this.f10166h;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i3 = this.k;
        String str2 = this.f10163e;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.l;
        if (str3 == null) {
            str3 = "";
        }
        float f2 = this.m;
        String str4 = this.f10164f;
        String str5 = str4 != null ? str4 : "";
        boolean z = this.o;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    public WakeLockEvent(long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f2, long j3, String str5, boolean z) {
        this(2, j, i2, str, i3, list, str2, j2, i4, str3, str4, f2, j3, str5, z);
    }
}
