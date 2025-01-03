package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.v.b;
import c.c.a.b.g.b.y9;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new y9();

    /* renamed from: a, reason: collision with root package name */
    public final String f10218a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10219b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10220c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10221d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10222e;

    /* renamed from: f, reason: collision with root package name */
    public final long f10223f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10224g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10225h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10226i;
    public final long j;
    public final String k;
    public final long l;
    public final long m;
    public final int n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final Boolean t;
    public final long u;
    public final List<String> v;
    public final String w;

    public zzm(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j6, List<String> list, String str8) {
        r.b(str);
        this.f10218a = str;
        this.f10219b = TextUtils.isEmpty(str2) ? null : str2;
        this.f10220c = str3;
        this.j = j;
        this.f10221d = str4;
        this.f10222e = j2;
        this.f10223f = j3;
        this.f10224g = str5;
        this.f10225h = z;
        this.f10226i = z2;
        this.k = str6;
        this.l = j4;
        this.m = j5;
        this.n = i2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
        this.t = bool;
        this.u = j6;
        this.v = list;
        this.w = str8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, this.f10218a, false);
        b.a(parcel, 3, this.f10219b, false);
        b.a(parcel, 4, this.f10220c, false);
        b.a(parcel, 5, this.f10221d, false);
        b.a(parcel, 6, this.f10222e);
        b.a(parcel, 7, this.f10223f);
        b.a(parcel, 8, this.f10224g, false);
        b.a(parcel, 9, this.f10225h);
        b.a(parcel, 10, this.f10226i);
        b.a(parcel, 11, this.j);
        b.a(parcel, 12, this.k, false);
        b.a(parcel, 13, this.l);
        b.a(parcel, 14, this.m);
        b.a(parcel, 15, this.n);
        b.a(parcel, 16, this.o);
        b.a(parcel, 17, this.p);
        b.a(parcel, 18, this.q);
        b.a(parcel, 19, this.r, false);
        b.a(parcel, 21, this.t, false);
        b.a(parcel, 22, this.u);
        b.a(parcel, 23, this.v, false);
        b.a(parcel, 24, this.w, false);
        b.a(parcel, a2);
    }

    public zzm(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j6, List<String> list, String str8) {
        this.f10218a = str;
        this.f10219b = str2;
        this.f10220c = str3;
        this.j = j3;
        this.f10221d = str4;
        this.f10222e = j;
        this.f10223f = j2;
        this.f10224g = str5;
        this.f10225h = z;
        this.f10226i = z2;
        this.k = str6;
        this.l = j4;
        this.m = j5;
        this.n = i2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
        this.t = bool;
        this.u = j6;
        this.v = list;
        this.w = str8;
    }
}
