package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.b.b.a.a.c;
import c.c.a.b.b.a.a.d;
import c.c.a.b.c.l.a;
import c.c.a.b.c.o.v.b;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d.e, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final Scope j = new Scope("profile");
    public static final Scope k;
    public static final Scope l;
    public static final Scope m;
    public static final GoogleSignInOptions n;
    public static final GoogleSignInOptions o;

    /* renamed from: a, reason: collision with root package name */
    public final int f9997a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Scope> f9998b;

    /* renamed from: c, reason: collision with root package name */
    public Account f9999c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10000d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10001e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10002f;

    /* renamed from: g, reason: collision with root package name */
    public String f10003g;

    /* renamed from: h, reason: collision with root package name */
    public String f10004h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> f10005i;

    static {
        new Scope("email");
        k = new Scope("openid");
        l = new Scope("https://www.googleapis.com/auth/games_lite");
        m = new Scope("https://www.googleapis.com/auth/games");
        a b2 = new a().b();
        b2.c();
        n = b2.a();
        a aVar = new a();
        aVar.a(l, new Scope[0]);
        o = aVar.a();
        CREATOR = new d();
        new c();
    }

    public GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i2, arrayList, account, z, z2, z3, str, str2, a(arrayList2));
    }

    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> a(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.u()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public Account e() {
        return this.f9999c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
    
        if (r3.f10003g.equals(r4.w()) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004a, code lost:
    
        if (r3.f9999c.equals(r4.e()) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L85
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.f10005i     // Catch: java.lang.ClassCastException -> L85
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L85
            if (r1 > 0) goto L85
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.f10005i     // Catch: java.lang.ClassCastException -> L85
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L85
            if (r1 <= 0) goto L18
            goto L85
        L18:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f9998b     // Catch: java.lang.ClassCastException -> L85
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L85
            java.util.ArrayList r2 = r4.v()     // Catch: java.lang.ClassCastException -> L85
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != r2) goto L85
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f9998b     // Catch: java.lang.ClassCastException -> L85
            java.util.ArrayList r2 = r4.v()     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L85
            if (r1 != 0) goto L35
            goto L85
        L35:
            android.accounts.Account r1 = r3.f9999c     // Catch: java.lang.ClassCastException -> L85
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.e()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != 0) goto L85
            goto L4c
        L40:
            android.accounts.Account r1 = r3.f9999c     // Catch: java.lang.ClassCastException -> L85
            android.accounts.Account r2 = r4.e()     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L85
            if (r1 == 0) goto L85
        L4c:
            java.lang.String r1 = r3.f10003g     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L85
            if (r1 == 0) goto L5f
            java.lang.String r1 = r4.w()     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L85
            if (r1 == 0) goto L85
            goto L6b
        L5f:
            java.lang.String r1 = r3.f10003g     // Catch: java.lang.ClassCastException -> L85
            java.lang.String r2 = r4.w()     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L85
            if (r1 == 0) goto L85
        L6b:
            boolean r1 = r3.f10002f     // Catch: java.lang.ClassCastException -> L85
            boolean r2 = r4.x()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != r2) goto L85
            boolean r1 = r3.f10000d     // Catch: java.lang.ClassCastException -> L85
            boolean r2 = r4.y()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != r2) goto L85
            boolean r1 = r3.f10001e     // Catch: java.lang.ClassCastException -> L85
            boolean r4 = r4.z()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != r4) goto L85
            r4 = 1
            return r4
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f9998b;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Scope scope = arrayList2.get(i2);
            i2++;
            arrayList.add(scope.u());
        }
        Collections.sort(arrayList);
        c.c.a.b.b.a.a.a.a aVar = new c.c.a.b.b.a.a.a.a();
        aVar.a(arrayList);
        aVar.a(this.f9999c);
        aVar.a(this.f10003g);
        aVar.a(this.f10002f);
        aVar.a(this.f10000d);
        aVar.a(this.f10001e);
        return aVar.a();
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> u() {
        return this.f10005i;
    }

    public ArrayList<Scope> v() {
        return new ArrayList<>(this.f9998b);
    }

    public String w() {
        return this.f10003g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f9997a);
        b.b(parcel, 2, v(), false);
        b.a(parcel, 3, (Parcelable) e(), i2, false);
        b.a(parcel, 4, y());
        b.a(parcel, 5, z());
        b.a(parcel, 6, x());
        b.a(parcel, 7, w(), false);
        b.a(parcel, 8, this.f10004h, false);
        b.b(parcel, 9, u(), false);
        b.a(parcel, a2);
    }

    public boolean x() {
        return this.f10002f;
    }

    public boolean y() {
        return this.f10000d;
    }

    public boolean z() {
        return this.f10001e;
    }

    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public boolean f10007b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10008c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10009d;

        /* renamed from: e, reason: collision with root package name */
        public String f10010e;

        /* renamed from: f, reason: collision with root package name */
        public Account f10011f;

        /* renamed from: g, reason: collision with root package name */
        public String f10012g;

        /* renamed from: a, reason: collision with root package name */
        public Set<Scope> f10006a = new HashSet();

        /* renamed from: h, reason: collision with root package name */
        public Map<Integer, GoogleSignInOptionsExtensionParcelable> f10013h = new HashMap();

        public final a a(Scope scope, Scope... scopeArr) {
            this.f10006a.add(scope);
            this.f10006a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final a b() {
            this.f10006a.add(GoogleSignInOptions.k);
            return this;
        }

        public final a c() {
            this.f10006a.add(GoogleSignInOptions.j);
            return this;
        }

        public final GoogleSignInOptions a() {
            if (this.f10006a.contains(GoogleSignInOptions.m) && this.f10006a.contains(GoogleSignInOptions.l)) {
                this.f10006a.remove(GoogleSignInOptions.l);
            }
            if (this.f10009d && (this.f10011f == null || !this.f10006a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f10006a), this.f10011f, this.f10009d, this.f10007b, this.f10008c, this.f10010e, this.f10012g, this.f10013h, null);
        }
    }

    public GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.f9997a = i2;
        this.f9998b = arrayList;
        this.f9999c = account;
        this.f10000d = z;
        this.f10001e = z2;
        this.f10002f = z3;
        this.f10003g = str;
        this.f10004h = str2;
        this.f10005i = new ArrayList<>(map.values());
    }

    public /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, c cVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map);
    }
}
