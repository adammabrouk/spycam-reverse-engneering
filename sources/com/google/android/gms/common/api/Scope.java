package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.l.n;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new n();

    /* renamed from: a, reason: collision with root package name */
    public final int f10030a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10031b;

    public Scope(int i2, String str) {
        r.a(str, (Object) "scopeUri must not be null or empty");
        this.f10030a = i2;
        this.f10031b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f10031b.equals(((Scope) obj).f10031b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10031b.hashCode();
    }

    public final String toString() {
        return this.f10031b;
    }

    public final String u() {
        return this.f10031b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10030a);
        b.a(parcel, 2, u(), false);
        b.a(parcel, a2);
    }

    public Scope(String str) {
        this(1, str);
    }
}
