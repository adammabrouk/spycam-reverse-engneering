package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.q.a.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f10132a;

    /* renamed from: b, reason: collision with root package name */
    public final StringToIntConverter f10133b;

    public zaa(int i2, StringToIntConverter stringToIntConverter) {
        this.f10132a = i2;
        this.f10133b = stringToIntConverter;
    }

    public static zaa a(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.a<?, ?> u() {
        StringToIntConverter stringToIntConverter = this.f10133b;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10132a);
        b.a(parcel, 2, (Parcelable) this.f10133b, i2, false);
        b.a(parcel, a2);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f10132a = 1;
        this.f10133b = stringToIntConverter;
    }
}
