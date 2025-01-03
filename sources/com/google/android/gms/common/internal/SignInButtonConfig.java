package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.e0;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new e0();

    /* renamed from: a, reason: collision with root package name */
    public final int f10116a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10117b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10118c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public final Scope[] f10119d;

    public SignInButtonConfig(int i2, int i3, int i4, Scope[] scopeArr) {
        this.f10116a = i2;
        this.f10117b = i3;
        this.f10118c = i4;
        this.f10119d = scopeArr;
    }

    public int u() {
        return this.f10117b;
    }

    public int v() {
        return this.f10118c;
    }

    @Deprecated
    public Scope[] w() {
        return this.f10119d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10116a);
        b.a(parcel, 2, u());
        b.a(parcel, 3, v());
        b.a(parcel, 4, (Parcelable[]) w(), i2, false);
        b.a(parcel, a2);
    }

    public SignInButtonConfig(int i2, int i3, Scope[] scopeArr) {
        this(1, i2, i3, null);
    }
}
