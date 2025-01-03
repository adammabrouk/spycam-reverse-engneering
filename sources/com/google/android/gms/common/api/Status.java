package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.l.d;
import c.c.a.b.c.l.j;
import c.c.a.b.c.l.o;
import c.c.a.b.c.o.q;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements j, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;

    /* renamed from: e, reason: collision with root package name */
    public static final Status f10032e = new Status(0);

    /* renamed from: f, reason: collision with root package name */
    public static final Status f10033f;

    /* renamed from: g, reason: collision with root package name */
    public static final Status f10034g;

    /* renamed from: a, reason: collision with root package name */
    public final int f10035a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10036b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10037c;

    /* renamed from: d, reason: collision with root package name */
    public final PendingIntent f10038d;

    static {
        new Status(14);
        new Status(8);
        f10033f = new Status(15);
        f10034g = new Status(16);
        new Status(17);
        new Status(18);
        CREATOR = new o();
    }

    public Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.f10035a = i2;
        this.f10036b = i3;
        this.f10037c = str;
        this.f10038d = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f10035a == status.f10035a && this.f10036b == status.f10036b && q.a(this.f10037c, status.f10037c) && q.a(this.f10038d, status.f10038d);
    }

    public final int hashCode() {
        return q.a(Integer.valueOf(this.f10035a), Integer.valueOf(this.f10036b), this.f10037c, this.f10038d);
    }

    @Override // c.c.a.b.c.l.j
    public final Status m() {
        return this;
    }

    public final String toString() {
        q.a a2 = q.a(this);
        a2.a("statusCode", x());
        a2.a("resolution", this.f10038d);
        return a2.toString();
    }

    public final int u() {
        return this.f10036b;
    }

    public final String v() {
        return this.f10037c;
    }

    public final boolean w() {
        return this.f10036b <= 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, u());
        b.a(parcel, 2, v(), false);
        b.a(parcel, 3, (Parcelable) this.f10038d, i2, false);
        b.a(parcel, 1000, this.f10035a);
        b.a(parcel, a2);
    }

    public final String x() {
        String str = this.f10037c;
        return str != null ? str : d.a(this.f10036b);
    }

    public Status(int i2) {
        this(i2, null);
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }
}
