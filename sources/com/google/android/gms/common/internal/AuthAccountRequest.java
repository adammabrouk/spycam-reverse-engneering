package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.o.w;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new w();

    /* renamed from: a, reason: collision with root package name */
    public final int f10089a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public final IBinder f10090b;

    /* renamed from: c, reason: collision with root package name */
    public final Scope[] f10091c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f10092d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f10093e;

    /* renamed from: f, reason: collision with root package name */
    public Account f10094f;

    public AuthAccountRequest(int i2, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2, Account account) {
        this.f10089a = i2;
        this.f10090b = iBinder;
        this.f10091c = scopeArr;
        this.f10092d = num;
        this.f10093e = num2;
        this.f10094f = account;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10089a);
        b.a(parcel, 2, this.f10090b, false);
        b.a(parcel, 3, (Parcelable[]) this.f10091c, i2, false);
        b.a(parcel, 4, this.f10092d, false);
        b.a(parcel, 5, this.f10093e, false);
        b.a(parcel, 6, (Parcelable) this.f10094f, i2, false);
        b.a(parcel, a2);
    }
}
