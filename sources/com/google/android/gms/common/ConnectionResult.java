package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.q;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.u;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* renamed from: a, reason: collision with root package name */
    public final int f10018a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10019b;

    /* renamed from: c, reason: collision with root package name */
    public final PendingIntent f10020c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10021d;

    /* renamed from: e, reason: collision with root package name */
    public static final ConnectionResult f10017e = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new u();

    public ConnectionResult(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f10018a = i2;
        this.f10019b = i3;
        this.f10020c = pendingIntent;
        this.f10021d = str;
    }

    public static String zza(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f10019b == connectionResult.f10019b && q.a(this.f10020c, connectionResult.f10020c) && q.a(this.f10021d, connectionResult.f10021d);
    }

    public final int hashCode() {
        return q.a(Integer.valueOf(this.f10019b), this.f10020c, this.f10021d);
    }

    public final String toString() {
        q.a a2 = q.a(this);
        a2.a("statusCode", zza(this.f10019b));
        a2.a("resolution", this.f10020c);
        a2.a("message", this.f10021d);
        return a2.toString();
    }

    public final int u() {
        return this.f10019b;
    }

    public final String v() {
        return this.f10021d;
    }

    public final PendingIntent w() {
        return this.f10020c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10018a);
        b.a(parcel, 2, u());
        b.a(parcel, 3, (Parcelable) w(), i2, false);
        b.a(parcel, 4, v(), false);
        b.a(parcel, a2);
    }

    public final boolean x() {
        return (this.f10019b == 0 || this.f10020c == null) ? false : true;
    }

    public final boolean y() {
        return this.f10019b == 0;
    }

    public ConnectionResult(int i2) {
        this(i2, null, null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }
}
