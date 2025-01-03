package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.v.b;
import c.c.a.b.g.b.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new p();

    /* renamed from: a, reason: collision with root package name */
    public final String f10207a;

    /* renamed from: b, reason: collision with root package name */
    public final zzal f10208b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10209c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10210d;

    public zzaq(String str, zzal zzalVar, String str2, long j) {
        this.f10207a = str;
        this.f10208b = zzalVar;
        this.f10209c = str2;
        this.f10210d = j;
    }

    public final String toString() {
        String str = this.f10209c;
        String str2 = this.f10207a;
        String valueOf = String.valueOf(this.f10208b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, this.f10207a, false);
        b.a(parcel, 3, (Parcelable) this.f10208b, i2, false);
        b.a(parcel, 4, this.f10209c, false);
        b.a(parcel, 5, this.f10210d);
        b.a(parcel, a2);
    }

    public zzaq(zzaq zzaqVar, long j) {
        r.a(zzaqVar);
        this.f10207a = zzaqVar.f10207a;
        this.f10208b = zzaqVar.f10208b;
        this.f10209c = zzaqVar.f10209c;
        this.f10210d = j;
    }
}
