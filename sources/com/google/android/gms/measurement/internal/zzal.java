package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.a.b.g.b.n;
import c.c.a.b.g.b.o;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzal extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzal> CREATOR = new n();

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f10206a;

    public zzal(Bundle bundle) {
        this.f10206a = bundle;
    }

    public final Object b(String str) {
        return this.f10206a.get(str);
    }

    public final Long c(String str) {
        return Long.valueOf(this.f10206a.getLong(str));
    }

    public final Double d(String str) {
        return Double.valueOf(this.f10206a.getDouble(str));
    }

    public final String e(String str) {
        return this.f10206a.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new o(this);
    }

    public final String toString() {
        return this.f10206a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, zzb(), false);
        b.a(parcel, a2);
    }

    public final int zza() {
        return this.f10206a.size();
    }

    public final Bundle zzb() {
        return new Bundle(this.f10206a);
    }
}
