package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.v.a;
import c.c.a.b.c.o.v.b;
import c.c.a.b.c.q.b.e;
import c.c.a.b.c.s.c;
import c.c.a.b.c.s.l;
import c.c.a.b.c.s.m;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();

    /* renamed from: a, reason: collision with root package name */
    public final int f10143a;

    /* renamed from: b, reason: collision with root package name */
    public final Parcel f10144b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10145c;

    /* renamed from: d, reason: collision with root package name */
    public final zak f10146d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10147e;

    /* renamed from: f, reason: collision with root package name */
    public int f10148f;

    /* renamed from: g, reason: collision with root package name */
    public int f10149g;

    public SafeParcelResponse(int i2, Parcel parcel, zak zakVar) {
        this.f10143a = i2;
        r.a(parcel);
        this.f10144b = parcel;
        this.f10145c = 2;
        this.f10146d = zakVar;
        if (zakVar == null) {
            this.f10147e = null;
        } else {
            this.f10147e = zakVar.v();
        }
        this.f10148f = 2;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        zak zakVar = this.f10146d;
        if (zakVar == null) {
            return null;
        }
        return zakVar.b(this.f10147e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0005, code lost:
    
        if (r0 != 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Parcel c() {
        /*
            r2 = this;
            int r0 = r2.f10148f
            if (r0 == 0) goto L8
            r1 = 1
            if (r0 == r1) goto L10
            goto L1a
        L8:
            android.os.Parcel r0 = r2.f10144b
            int r0 = c.c.a.b.c.o.v.b.a(r0)
            r2.f10149g = r0
        L10:
            android.os.Parcel r0 = r2.f10144b
            int r1 = r2.f10149g
            c.c.a.b.c.o.v.b.a(r0, r1)
            r0 = 2
            r2.f10148f = r0
        L1a:
            android.os.Parcel r0 = r2.f10144b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.c():android.os.Parcel");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        r.a(this.f10146d, "Cannot convert to JSON on client side.");
        Parcel c2 = c();
        c2.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        a(sb, this.f10146d.b(this.f10147e), c2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        zak zakVar;
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f10143a);
        b.a(parcel, 2, c(), false);
        int i3 = this.f10145c;
        if (i3 == 0) {
            zakVar = null;
        } else if (i3 == 1) {
            zakVar = this.f10146d;
        } else {
            if (i3 != 2) {
                int i4 = this.f10145c;
                StringBuilder sb = new StringBuilder(34);
                sb.append("Invalid creation type: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
            zakVar = this.f10146d;
        }
        b.a(parcel, 3, (Parcelable) zakVar, i2, false);
        b.a(parcel, a2);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final void a(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().u(), entry);
        }
        sb.append('{');
        int b2 = a.b(parcel);
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(a.a(a2));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.w()) {
                    switch (field.f10137d) {
                        case 0:
                            a(sb, field, FastJsonResponse.a(field, Integer.valueOf(a.y(parcel, a2))));
                            break;
                        case 1:
                            a(sb, field, FastJsonResponse.a(field, a.c(parcel, a2)));
                            break;
                        case 2:
                            a(sb, field, FastJsonResponse.a(field, Long.valueOf(a.A(parcel, a2))));
                            break;
                        case 3:
                            a(sb, field, FastJsonResponse.a(field, Float.valueOf(a.v(parcel, a2))));
                            break;
                        case 4:
                            a(sb, field, FastJsonResponse.a(field, Double.valueOf(a.t(parcel, a2))));
                            break;
                        case 5:
                            a(sb, field, FastJsonResponse.a(field, a.a(parcel, a2)));
                            break;
                        case 6:
                            a(sb, field, FastJsonResponse.a(field, Boolean.valueOf(a.r(parcel, a2))));
                            break;
                        case 7:
                            a(sb, field, FastJsonResponse.a(field, a.n(parcel, a2)));
                            break;
                        case 8:
                        case 9:
                            a(sb, field, FastJsonResponse.a(field, a.g(parcel, a2)));
                            break;
                        case 10:
                            Bundle f2 = a.f(parcel, a2);
                            HashMap hashMap = new HashMap();
                            for (String str2 : f2.keySet()) {
                                hashMap.put(str2, f2.getString(str2));
                            }
                            a(sb, field, FastJsonResponse.a(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i2 = field.f10137d;
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i2);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.f10138e) {
                    sb.append("[");
                    switch (field.f10137d) {
                        case 0:
                            c.c.a.b.c.s.b.a(sb, a.j(parcel, a2));
                            break;
                        case 1:
                            c.c.a.b.c.s.b.a(sb, a.d(parcel, a2));
                            break;
                        case 2:
                            c.c.a.b.c.s.b.a(sb, a.k(parcel, a2));
                            break;
                        case 3:
                            c.c.a.b.c.s.b.a(sb, a.i(parcel, a2));
                            break;
                        case 4:
                            c.c.a.b.c.s.b.a(sb, a.h(parcel, a2));
                            break;
                        case 5:
                            c.c.a.b.c.s.b.a(sb, a.b(parcel, a2));
                            break;
                        case 6:
                            c.c.a.b.c.s.b.a(sb, a.e(parcel, a2));
                            break;
                        case 7:
                            c.c.a.b.c.s.b.a(sb, a.o(parcel, a2));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] m = a.m(parcel, a2);
                            int length = m.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                if (i3 > 0) {
                                    sb.append(",");
                                }
                                m[i3].setDataPosition(0);
                                a(sb, field.y(), m[i3]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.f10137d) {
                        case 0:
                            sb.append(a.y(parcel, a2));
                            break;
                        case 1:
                            sb.append(a.c(parcel, a2));
                            break;
                        case 2:
                            sb.append(a.A(parcel, a2));
                            break;
                        case 3:
                            sb.append(a.v(parcel, a2));
                            break;
                        case 4:
                            sb.append(a.t(parcel, a2));
                            break;
                        case 5:
                            sb.append(a.a(parcel, a2));
                            break;
                        case 6:
                            sb.append(a.r(parcel, a2));
                            break;
                        case 7:
                            String n = a.n(parcel, a2);
                            sb.append("\"");
                            sb.append(l.a(n));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] g2 = a.g(parcel, a2);
                            sb.append("\"");
                            sb.append(c.a(g2));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] g3 = a.g(parcel, a2);
                            sb.append("\"");
                            sb.append(c.b(g3));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle f3 = a.f(parcel, a2);
                            Set<String> keySet = f3.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str3 : keySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\"");
                                sb.append(":");
                                sb.append("\"");
                                sb.append(l.a(f3.getString(str3)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel l = a.l(parcel, a2);
                            l.setDataPosition(0);
                            a(sb, field.y(), l);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == b2) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(b2);
        throw new a.C0090a(sb3.toString(), parcel);
    }

    public final void a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.f10136c) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                a(sb, field.f10135b, arrayList.get(i2));
            }
            sb.append("]");
            return;
        }
        a(sb, field.f10135b, obj);
    }

    public static void a(StringBuilder sb, int i2, Object obj) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(l.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(c.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(c.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                m.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
        }
    }
}
