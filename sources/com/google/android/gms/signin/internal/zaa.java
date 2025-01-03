package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.l.j;
import c.c.a.b.h.b.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable implements j {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public final int f10237a;

    /* renamed from: b, reason: collision with root package name */
    public int f10238b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f10239c;

    public zaa(int i2, int i3, Intent intent) {
        this.f10237a = i2;
        this.f10238b = i3;
        this.f10239c = intent;
    }

    @Override // c.c.a.b.c.l.j
    public final Status m() {
        return this.f10238b == 0 ? Status.f10032e : Status.f10034g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.c.a.b.c.o.v.b.a(parcel);
        c.c.a.b.c.o.v.b.a(parcel, 1, this.f10237a);
        c.c.a.b.c.o.v.b.a(parcel, 2, this.f10238b);
        c.c.a.b.c.o.v.b.a(parcel, 3, (Parcelable) this.f10239c, i2, false);
        c.c.a.b.c.o.v.b.a(parcel, a2);
    }

    public zaa() {
        this(0, null);
    }

    public zaa(int i2, Intent intent) {
        this(2, 0, null);
    }
}
