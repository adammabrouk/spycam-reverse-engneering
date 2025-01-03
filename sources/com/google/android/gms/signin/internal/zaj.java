package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.a.b.h.b.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new i();

    /* renamed from: a, reason: collision with root package name */
    public final int f10242a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectionResult f10243b;

    /* renamed from: c, reason: collision with root package name */
    public final ResolveAccountResponse f10244c;

    public zaj(int i2, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f10242a = i2;
        this.f10243b = connectionResult;
        this.f10244c = resolveAccountResponse;
    }

    public final ConnectionResult u() {
        return this.f10243b;
    }

    public final ResolveAccountResponse v() {
        return this.f10244c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10242a);
        b.a(parcel, 2, (Parcelable) this.f10243b, i2, false);
        b.a(parcel, 3, (Parcelable) this.f10244c, i2, false);
        b.a(parcel, a2);
    }

    public zaj(int i2) {
        this(new ConnectionResult(8, null), null);
    }

    public zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }
}
