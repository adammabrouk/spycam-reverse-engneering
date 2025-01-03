package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.v.b;
import c.c.a.b.g.b.r9;
import c.c.a.b.g.b.t9;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzkn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkn> CREATOR = new r9();

    /* renamed from: a, reason: collision with root package name */
    public final int f10211a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10212b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10213c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f10214d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10215e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10216f;

    /* renamed from: g, reason: collision with root package name */
    public final Double f10217g;

    public zzkn(t9 t9Var) {
        this(t9Var.f5106c, t9Var.f5107d, t9Var.f5108e, t9Var.f5105b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10211a);
        b.a(parcel, 2, this.f10212b, false);
        b.a(parcel, 3, this.f10213c);
        b.a(parcel, 4, this.f10214d, false);
        b.a(parcel, 5, (Float) null, false);
        b.a(parcel, 6, this.f10215e, false);
        b.a(parcel, 7, this.f10216f, false);
        b.a(parcel, 8, this.f10217g, false);
        b.a(parcel, a2);
    }

    public final Object zza() {
        Long l = this.f10214d;
        if (l != null) {
            return l;
        }
        Double d2 = this.f10217g;
        if (d2 != null) {
            return d2;
        }
        String str = this.f10215e;
        if (str != null) {
            return str;
        }
        return null;
    }

    public zzkn(String str, long j, Object obj, String str2) {
        r.b(str);
        this.f10211a = 2;
        this.f10212b = str;
        this.f10213c = j;
        this.f10216f = str2;
        if (obj == null) {
            this.f10214d = null;
            this.f10217g = null;
            this.f10215e = null;
            return;
        }
        if (obj instanceof Long) {
            this.f10214d = (Long) obj;
            this.f10217g = null;
            this.f10215e = null;
        } else if (obj instanceof String) {
            this.f10214d = null;
            this.f10217g = null;
            this.f10215e = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f10214d = null;
            this.f10217g = (Double) obj;
            this.f10215e = null;
        }
    }

    public zzkn(int i2, String str, long j, Long l, Float f2, String str2, String str3, Double d2) {
        this.f10211a = i2;
        this.f10212b = str;
        this.f10213c = j;
        this.f10214d = l;
        if (i2 == 1) {
            this.f10217g = f2 != null ? Double.valueOf(f2.doubleValue()) : null;
        } else {
            this.f10217g = d2;
        }
        this.f10215e = str2;
        this.f10216f = str3;
    }
}
