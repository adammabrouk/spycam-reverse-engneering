package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.u0;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
/* loaded from: classes.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new u0();

    /* renamed from: a, reason: collision with root package name */
    public final int f10122a;

    public zzr(int i2) {
        this.f10122a = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10122a);
        b.a(parcel, a2);
    }
}
