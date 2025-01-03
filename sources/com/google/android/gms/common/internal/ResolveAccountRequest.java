package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.c0;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new c0();

    /* renamed from: a, reason: collision with root package name */
    public final int f10107a;

    /* renamed from: b, reason: collision with root package name */
    public final Account f10108b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10109c;

    /* renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f10110d;

    public ResolveAccountRequest(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f10107a = i2;
        this.f10108b = account;
        this.f10109c = i3;
        this.f10110d = googleSignInAccount;
    }

    public Account e() {
        return this.f10108b;
    }

    public int u() {
        return this.f10109c;
    }

    public GoogleSignInAccount v() {
        return this.f10110d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10107a);
        b.a(parcel, 2, (Parcelable) e(), i2, false);
        b.a(parcel, 3, u());
        b.a(parcel, 4, (Parcelable) v(), i2, false);
        b.a(parcel, a2);
    }

    public ResolveAccountRequest(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}
