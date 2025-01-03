package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import c.c.a.b.c.q.a.b;
import c.c.a.b.c.q.a.c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    public final int f10126a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, Integer> f10127b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray<String> f10128c;

    public StringToIntConverter(int i2, ArrayList<zaa> arrayList) {
        this.f10126a = i2;
        this.f10127b = new HashMap<>();
        this.f10128c = new SparseArray<>();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            zaa zaaVar = arrayList.get(i3);
            i3++;
            zaa zaaVar2 = zaaVar;
            a(zaaVar2.f10130b, zaaVar2.f10131c);
        }
    }

    public final StringToIntConverter a(String str, int i2) {
        this.f10127b.put(str, Integer.valueOf(i2));
        this.f10128c.put(i2, str);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.c.a.b.c.o.v.b.a(parcel);
        c.c.a.b.c.o.v.b.a(parcel, 1, this.f10126a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f10127b.keySet()) {
            arrayList.add(new zaa(str, this.f10127b.get(str).intValue()));
        }
        c.c.a.b.c.o.v.b.b(parcel, 2, arrayList, false);
        c.c.a.b.c.o.v.b.a(parcel, a2);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final /* synthetic */ String a(Integer num) {
        String str = this.f10128c.get(num.intValue());
        return (str == null && this.f10127b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new c();

        /* renamed from: a, reason: collision with root package name */
        public final int f10129a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10130b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10131c;

        public zaa(int i2, String str, int i3) {
            this.f10129a = i2;
            this.f10130b = str;
            this.f10131c = i3;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int a2 = c.c.a.b.c.o.v.b.a(parcel);
            c.c.a.b.c.o.v.b.a(parcel, 1, this.f10129a);
            c.c.a.b.c.o.v.b.a(parcel, 2, this.f10130b, false);
            c.c.a.b.c.o.v.b.a(parcel, 3, this.f10131c);
            c.c.a.b.c.o.v.b.a(parcel, a2);
        }

        public zaa(String str, int i2) {
            this.f10129a = 1;
            this.f10130b = str;
            this.f10131c = i2;
        }
    }

    public StringToIntConverter() {
        this.f10126a = 1;
        this.f10127b = new HashMap<>();
        this.f10128c = new SparseArray<>();
    }
}
