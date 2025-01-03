package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.q.b.c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    public final int f10150a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f10151b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10152c;

    public zak(int i2, ArrayList<zal> arrayList, String str) {
        this.f10150a = i2;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zal zalVar = arrayList.get(i3);
            String str2 = zalVar.f10154b;
            HashMap hashMap2 = new HashMap();
            int size2 = zalVar.f10155c.size();
            for (int i4 = 0; i4 < size2; i4++) {
                zam zamVar = zalVar.f10155c.get(i4);
                hashMap2.put(zamVar.f10157b, zamVar.f10158c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f10151b = hashMap;
        r.a(str);
        this.f10152c = str;
        u();
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> b(String str) {
        return this.f10151b.get(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f10151b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f10151b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    public final void u() {
        Iterator<String> it = this.f10151b.keySet().iterator();
        while (it.hasNext()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f10151b.get(it.next());
            Iterator<String> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                map.get(it2.next()).a(this);
            }
        }
    }

    public final String v() {
        return this.f10152c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10150a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f10151b.keySet()) {
            arrayList.add(new zal(str, this.f10151b.get(str)));
        }
        b.b(parcel, 2, arrayList, false);
        b.a(parcel, 3, this.f10152c, false);
        b.a(parcel, a2);
    }
}
