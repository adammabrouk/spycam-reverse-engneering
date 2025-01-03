package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.a.b.f.e.d;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class zzaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaa> CREATOR = new d();

    /* renamed from: a, reason: collision with root package name */
    public final long f10186a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10187b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10188c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10189d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10190e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10191f;

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f10192g;

    public zzaa(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.f10186a = j;
        this.f10187b = j2;
        this.f10188c = z;
        this.f10189d = str;
        this.f10190e = str2;
        this.f10191f = str3;
        this.f10192g = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10186a);
        b.a(parcel, 2, this.f10187b);
        b.a(parcel, 3, this.f10188c);
        b.a(parcel, 4, this.f10189d, false);
        b.a(parcel, 5, this.f10190e, false);
        b.a(parcel, 6, this.f10191f, false);
        b.a(parcel, 7, this.f10192g, false);
        b.a(parcel, a2);
    }
}
