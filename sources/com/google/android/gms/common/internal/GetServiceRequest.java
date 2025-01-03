package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.d;
import c.c.a.b.c.o.a;
import c.c.a.b.c.o.h0;
import c.c.a.b.c.o.k;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new h0();

    /* renamed from: a, reason: collision with root package name */
    public final int f10098a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10099b;

    /* renamed from: c, reason: collision with root package name */
    public int f10100c;

    /* renamed from: d, reason: collision with root package name */
    public String f10101d;

    /* renamed from: e, reason: collision with root package name */
    public IBinder f10102e;

    /* renamed from: f, reason: collision with root package name */
    public Scope[] f10103f;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f10104g;

    /* renamed from: h, reason: collision with root package name */
    public Account f10105h;

    /* renamed from: i, reason: collision with root package name */
    public Feature[] f10106i;
    public Feature[] j;
    public boolean k;

    public GetServiceRequest(int i2) {
        this.f10098a = 4;
        this.f10100c = d.f3814a;
        this.f10099b = i2;
        this.k = true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10098a);
        b.a(parcel, 2, this.f10099b);
        b.a(parcel, 3, this.f10100c);
        b.a(parcel, 4, this.f10101d, false);
        b.a(parcel, 5, this.f10102e, false);
        b.a(parcel, 6, (Parcelable[]) this.f10103f, i2, false);
        b.a(parcel, 7, this.f10104g, false);
        b.a(parcel, 8, (Parcelable) this.f10105h, i2, false);
        b.a(parcel, 10, (Parcelable[]) this.f10106i, i2, false);
        b.a(parcel, 11, (Parcelable[]) this.j, i2, false);
        b.a(parcel, 12, this.k);
        b.a(parcel, a2);
    }

    public GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z) {
        this.f10098a = i2;
        this.f10099b = i3;
        this.f10100c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f10101d = "com.google.android.gms";
        } else {
            this.f10101d = str;
        }
        if (i2 < 2) {
            this.f10105h = iBinder != null ? a.a(k.a.a(iBinder)) : null;
        } else {
            this.f10102e = iBinder;
            this.f10105h = account;
        }
        this.f10103f = scopeArr;
        this.f10104g = bundle;
        this.f10106i = featureArr;
        this.j = featureArr2;
        this.k = z;
    }
}
