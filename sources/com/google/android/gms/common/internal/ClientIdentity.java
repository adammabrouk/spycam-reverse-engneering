package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.q;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.o.x;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new x();

    /* renamed from: a, reason: collision with root package name */
    public final int f10096a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10097b;

    public ClientIdentity(int i2, String str) {
        this.f10096a = i2;
        this.f10097b = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (clientIdentity.f10096a == this.f10096a && q.a(clientIdentity.f10097b, this.f10097b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f10096a;
    }

    public String toString() {
        int i2 = this.f10096a;
        String str = this.f10097b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i2);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10096a);
        b.a(parcel, 2, this.f10097b, false);
        b.a(parcel, a2);
    }
}
