package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.q;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.v;
import cn.jiguang.internal.ActionManager;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new v();

    /* renamed from: a, reason: collision with root package name */
    public final String f10022a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public final int f10023b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10024c;

    public Feature(String str, int i2, long j) {
        this.f10022a = str;
        this.f10023b = i2;
        this.f10024c = j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((u() != null && u().equals(feature.u())) || (u() == null && feature.u() == null)) && v() == feature.v()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return q.a(u(), Long.valueOf(v()));
    }

    public String toString() {
        q.a a2 = q.a(this);
        a2.a("name", u());
        a2.a(ActionManager.SDK_VERSION, Long.valueOf(v()));
        return a2.toString();
    }

    public String u() {
        return this.f10022a;
    }

    public long v() {
        long j = this.f10024c;
        return j == -1 ? this.f10023b : j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, u(), false);
        b.a(parcel, 2, this.f10023b);
        b.a(parcel, 3, v());
        b.a(parcel, a2);
    }
}
