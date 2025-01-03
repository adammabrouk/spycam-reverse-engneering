package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.d0;
import c.c.a.b.c.o.k;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new d0();

    /* renamed from: a, reason: collision with root package name */
    public final int f10111a;

    /* renamed from: b, reason: collision with root package name */
    public IBinder f10112b;

    /* renamed from: c, reason: collision with root package name */
    public ConnectionResult f10113c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10114d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10115e;

    public ResolveAccountResponse(int i2, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f10111a = i2;
        this.f10112b = iBinder;
        this.f10113c = connectionResult;
        this.f10114d = z;
        this.f10115e = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f10113c.equals(resolveAccountResponse.f10113c) && u().equals(resolveAccountResponse.u());
    }

    public k u() {
        return k.a.a(this.f10112b);
    }

    public ConnectionResult v() {
        return this.f10113c;
    }

    public boolean w() {
        return this.f10114d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10111a);
        b.a(parcel, 2, this.f10112b, false);
        b.a(parcel, 3, (Parcelable) v(), i2, false);
        b.a(parcel, 4, w());
        b.a(parcel, 5, x());
        b.a(parcel, a2);
    }

    public boolean x() {
        return this.f10115e;
    }
}
