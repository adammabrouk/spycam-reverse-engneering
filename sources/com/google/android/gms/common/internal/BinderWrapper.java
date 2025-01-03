package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.f0;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new f0();

    /* renamed from: a, reason: collision with root package name */
    public IBinder f10095a;

    public BinderWrapper() {
        this.f10095a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.f10095a);
    }

    public BinderWrapper(Parcel parcel) {
        this.f10095a = null;
        this.f10095a = parcel.readStrongBinder();
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, f0 f0Var) {
        this(parcel);
    }
}
