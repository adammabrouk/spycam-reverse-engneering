package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.c.o.q;
import c.c.a.b.c.o.r;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final c.c.a.b.c.q.b.a CREATOR = new c.c.a.b.c.q.b.a();

        /* renamed from: a, reason: collision with root package name */
        public final int f10134a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10135b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10136c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10137d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f10138e;

        /* renamed from: f, reason: collision with root package name */
        public final String f10139f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10140g;

        /* renamed from: h, reason: collision with root package name */
        public final Class<? extends FastJsonResponse> f10141h;

        /* renamed from: i, reason: collision with root package name */
        public final String f10142i;
        public zak j;
        public a<I, O> k;

        public Field(int i2, int i3, boolean z, int i4, boolean z2, String str, int i5, String str2, zaa zaaVar) {
            this.f10134a = i2;
            this.f10135b = i3;
            this.f10136c = z;
            this.f10137d = i4;
            this.f10138e = z2;
            this.f10139f = str;
            this.f10140g = i5;
            if (str2 == null) {
                this.f10141h = null;
                this.f10142i = null;
            } else {
                this.f10141h = SafeParcelResponse.class;
                this.f10142i = str2;
            }
            if (zaaVar == null) {
                this.k = null;
            } else {
                this.k = (a<I, O>) zaaVar.u();
            }
        }

        public final void a(zak zakVar) {
            this.j = zakVar;
        }

        public String toString() {
            q.a a2 = q.a(this);
            a2.a("versionCode", Integer.valueOf(this.f10134a));
            a2.a("typeIn", Integer.valueOf(this.f10135b));
            a2.a("typeInArray", Boolean.valueOf(this.f10136c));
            a2.a("typeOut", Integer.valueOf(this.f10137d));
            a2.a("typeOutArray", Boolean.valueOf(this.f10138e));
            a2.a("outputFieldName", this.f10139f);
            a2.a("safeParcelFieldId", Integer.valueOf(this.f10140g));
            a2.a("concreteTypeName", v());
            Class<? extends FastJsonResponse> cls = this.f10141h;
            if (cls != null) {
                a2.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.k;
            if (aVar != null) {
                a2.a("converterName", aVar.getClass().getCanonicalName());
            }
            return a2.toString();
        }

        public int u() {
            return this.f10140g;
        }

        public final String v() {
            String str = this.f10142i;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final boolean w() {
            return this.k != null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel);
            b.a(parcel, 1, this.f10134a);
            b.a(parcel, 2, this.f10135b);
            b.a(parcel, 3, this.f10136c);
            b.a(parcel, 4, this.f10137d);
            b.a(parcel, 5, this.f10138e);
            b.a(parcel, 6, this.f10139f, false);
            b.a(parcel, 7, u());
            b.a(parcel, 8, v(), false);
            b.a(parcel, 9, (Parcelable) x(), i2, false);
            b.a(parcel, a2);
        }

        public final zaa x() {
            a<I, O> aVar = this.k;
            if (aVar == null) {
                return null;
            }
            return zaa.a(aVar);
        }

        public final Map<String, Field<?, ?>> y() {
            r.a(this.f10142i);
            r.a(this.j);
            return this.j.b(this.f10142i);
        }

        public final I a(O o) {
            return this.k.a(o);
        }
    }

    public interface a<I, O> {
        I a(O o);
    }

    public abstract Map<String, Field<?, ?>> a();

    public boolean a(Field field) {
        if (field.f10137d != 11) {
            a(field.f10139f);
            throw null;
        }
        if (field.f10138e) {
            String str = field.f10139f;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        String str2 = field.f10139f;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean a(String str);

    public String toString() {
        Map<String, Field<?, ?>> a2 = a();
        StringBuilder sb = new StringBuilder(100);
        Iterator<String> it = a2.keySet().iterator();
        if (it.hasNext()) {
            a(a2.get(it.next()));
            throw null;
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <O, I> I a(Field<I, O> field, Object obj) {
        return field.k != null ? field.a((Field<I, O>) obj) : obj;
    }
}
