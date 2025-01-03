package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.g0;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new g0();

    /* renamed from: a, reason: collision with root package name */
    public Bundle f10120a;

    /* renamed from: b, reason: collision with root package name */
    public Feature[] f10121b;

    public zzb(Bundle bundle, Feature[] featureArr) {
        this.f10120a = bundle;
        this.f10121b = featureArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10120a, false);
        b.a(parcel, 2, (Parcelable[]) this.f10121b, i2, false);
        b.a(parcel, a2);
    }

    public zzb() {
    }
}
