package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.a.b.h.b.h;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zah> CREATOR = new h();

    /* renamed from: a, reason: collision with root package name */
    public final int f10240a;

    /* renamed from: b, reason: collision with root package name */
    public final ResolveAccountRequest f10241b;

    public zah(int i2, ResolveAccountRequest resolveAccountRequest) {
        this.f10240a = i2;
        this.f10241b = resolveAccountRequest;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10240a);
        b.a(parcel, 2, (Parcelable) this.f10241b, i2, false);
        b.a(parcel, a2);
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }
}
