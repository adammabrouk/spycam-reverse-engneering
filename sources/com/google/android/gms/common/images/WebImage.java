package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.n.c;
import c.c.a.b.c.o.q;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;

/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    public final int f10085a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f10086b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10087c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10088d;

    public WebImage(int i2, Uri uri, int i3, int i4) {
        this.f10085a = i2;
        this.f10086b = uri;
        this.f10087c = i3;
        this.f10088d = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (q.a(this.f10086b, webImage.f10086b) && this.f10087c == webImage.f10087c && this.f10088d == webImage.f10088d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return q.a(this.f10086b, Integer.valueOf(this.f10087c), Integer.valueOf(this.f10088d));
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f10087c), Integer.valueOf(this.f10088d), this.f10086b.toString());
    }

    public final int u() {
        return this.f10088d;
    }

    public final Uri v() {
        return this.f10086b;
    }

    public final int w() {
        return this.f10087c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10085a);
        b.a(parcel, 2, (Parcelable) v(), i2, false);
        b.a(parcel, 3, w());
        b.a(parcel, 4, u());
        b.a(parcel, a2);
    }
}
