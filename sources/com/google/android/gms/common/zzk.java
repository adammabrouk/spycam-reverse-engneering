package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.b.c.e0;
import c.c.a.b.c.o.n0;
import c.c.a.b.c.y;
import c.c.a.b.c.z;
import c.c.a.b.d.a;
import c.c.a.b.d.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new e0();

    /* renamed from: a, reason: collision with root package name */
    public final String f10168a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final y f10169b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10170c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10171d;

    public zzk(String str, @Nullable IBinder iBinder, boolean z, boolean z2) {
        this.f10168a = str;
        this.f10169b = a(iBinder);
        this.f10170c = z;
        this.f10171d = z2;
    }

    @Nullable
    public static y a(@Nullable IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            a zzb = n0.a(iBinder).zzb();
            byte[] bArr = zzb == null ? null : (byte[]) b.a(zzb);
            if (bArr != null) {
                return new z(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e2) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.c.a.b.c.o.v.b.a(parcel);
        c.c.a.b.c.o.v.b.a(parcel, 1, this.f10168a, false);
        y yVar = this.f10169b;
        if (yVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            yVar = null;
        } else {
            yVar.asBinder();
        }
        c.c.a.b.c.o.v.b.a(parcel, 2, (IBinder) yVar, false);
        c.c.a.b.c.o.v.b.a(parcel, 3, this.f10170c);
        c.c.a.b.c.o.v.b.a(parcel, 4, this.f10171d);
        c.c.a.b.c.o.v.b.a(parcel, a2);
    }

    public zzk(String str, @Nullable y yVar, boolean z, boolean z2) {
        this.f10168a = str;
        this.f10169b = yVar;
        this.f10170c = z;
        this.f10171d = z2;
    }
}
