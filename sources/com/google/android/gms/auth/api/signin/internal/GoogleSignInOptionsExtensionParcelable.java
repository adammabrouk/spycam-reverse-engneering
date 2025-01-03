package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.b.a.a.a.c;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    public final int f10014a;

    /* renamed from: b, reason: collision with root package name */
    public int f10015b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f10016c;

    public GoogleSignInOptionsExtensionParcelable(int i2, int i3, Bundle bundle) {
        this.f10014a = i2;
        this.f10015b = i3;
        this.f10016c = bundle;
    }

    public int u() {
        return this.f10015b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10014a);
        b.a(parcel, 2, u());
        b.a(parcel, 3, this.f10016c, false);
        b.a(parcel, a2);
    }
}
