package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.v.b;
import c.c.a.b.g.b.ha;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new ha();

    /* renamed from: a, reason: collision with root package name */
    public String f10227a;

    /* renamed from: b, reason: collision with root package name */
    public String f10228b;

    /* renamed from: c, reason: collision with root package name */
    public zzkn f10229c;

    /* renamed from: d, reason: collision with root package name */
    public long f10230d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10231e;

    /* renamed from: f, reason: collision with root package name */
    public String f10232f;

    /* renamed from: g, reason: collision with root package name */
    public zzaq f10233g;

    /* renamed from: h, reason: collision with root package name */
    public long f10234h;

    /* renamed from: i, reason: collision with root package name */
    public zzaq f10235i;
    public long j;
    public zzaq k;

    public zzy(zzy zzyVar) {
        r.a(zzyVar);
        this.f10227a = zzyVar.f10227a;
        this.f10228b = zzyVar.f10228b;
        this.f10229c = zzyVar.f10229c;
        this.f10230d = zzyVar.f10230d;
        this.f10231e = zzyVar.f10231e;
        this.f10232f = zzyVar.f10232f;
        this.f10233g = zzyVar.f10233g;
        this.f10234h = zzyVar.f10234h;
        this.f10235i = zzyVar.f10235i;
        this.j = zzyVar.j;
        this.k = zzyVar.k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, this.f10227a, false);
        b.a(parcel, 3, this.f10228b, false);
        b.a(parcel, 4, (Parcelable) this.f10229c, i2, false);
        b.a(parcel, 5, this.f10230d);
        b.a(parcel, 6, this.f10231e);
        b.a(parcel, 7, this.f10232f, false);
        b.a(parcel, 8, (Parcelable) this.f10233g, i2, false);
        b.a(parcel, 9, this.f10234h);
        b.a(parcel, 10, (Parcelable) this.f10235i, i2, false);
        b.a(parcel, 11, this.j);
        b.a(parcel, 12, (Parcelable) this.k, i2, false);
        b.a(parcel, a2);
    }

    public zzy(String str, String str2, zzkn zzknVar, long j, boolean z, String str3, zzaq zzaqVar, long j2, zzaq zzaqVar2, long j3, zzaq zzaqVar3) {
        this.f10227a = str;
        this.f10228b = str2;
        this.f10229c = zzknVar;
        this.f10230d = j;
        this.f10231e = z;
        this.f10232f = str3;
        this.f10233g = zzaqVar;
        this.f10234h = j2;
        this.f10235i = zzaqVar2;
        this.j = j3;
        this.k = zzaqVar3;
    }
}
