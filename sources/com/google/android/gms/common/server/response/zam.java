package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.q.b.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public final int f10156a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10157b;

    /* renamed from: c, reason: collision with root package name */
    public final FastJsonResponse.Field<?, ?> f10158c;

    public zam(int i2, String str, FastJsonResponse.Field<?, ?> field) {
        this.f10156a = i2;
        this.f10157b = str;
        this.f10158c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.c.a.b.c.o.v.b.a(parcel);
        c.c.a.b.c.o.v.b.a(parcel, 1, this.f10156a);
        c.c.a.b.c.o.v.b.a(parcel, 2, this.f10157b, false);
        c.c.a.b.c.o.v.b.a(parcel, 3, (Parcelable) this.f10158c, i2, false);
        c.c.a.b.c.o.v.b.a(parcel, a2);
    }

    public zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.f10156a = 1;
        this.f10157b = str;
        this.f10158c = field;
    }
}
