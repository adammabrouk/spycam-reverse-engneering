package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.q.c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    public final int f10123a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10124b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10125c;

    public FavaDiagnosticsEntity(int i2, String str, int i3) {
        this.f10123a = i2;
        this.f10124b = str;
        this.f10125c = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10123a);
        b.a(parcel, 2, this.f10124b, false);
        b.a(parcel, 3, this.f10125c);
        b.a(parcel, a2);
    }
}
