package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.q.b.d;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new d();

    /* renamed from: a, reason: collision with root package name */
    public final int f10153a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10154b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<zam> f10155c;

    public zal(int i2, String str, ArrayList<zam> arrayList) {
        this.f10153a = i2;
        this.f10154b = str;
        this.f10155c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10153a);
        b.a(parcel, 2, this.f10154b, false);
        b.b(parcel, 3, this.f10155c, false);
        b.a(parcel, a2);
    }

    public zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.f10153a = 1;
        this.f10154b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, map.get(str2)));
            }
        }
        this.f10155c = arrayList;
    }
}
