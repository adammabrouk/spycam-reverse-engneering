package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import c.c.a.b.b.a.a.b;
import c.c.a.b.c.o.r;
import c.c.a.b.c.s.e;
import c.c.a.b.c.s.h;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    public static e n = h.d();

    /* renamed from: a, reason: collision with root package name */
    public final int f9988a;

    /* renamed from: b, reason: collision with root package name */
    public String f9989b;

    /* renamed from: c, reason: collision with root package name */
    public String f9990c;

    /* renamed from: d, reason: collision with root package name */
    public String f9991d;

    /* renamed from: e, reason: collision with root package name */
    public String f9992e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f9993f;

    /* renamed from: g, reason: collision with root package name */
    public String f9994g;

    /* renamed from: h, reason: collision with root package name */
    public long f9995h;

    /* renamed from: i, reason: collision with root package name */
    public String f9996i;
    public List<Scope> j;
    public String k;
    public String l;
    public Set<Scope> m = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f9988a = i2;
        this.f9989b = str;
        this.f9990c = str2;
        this.f9991d = str3;
        this.f9992e = str4;
        this.f9993f = uri;
        this.f9994g = str5;
        this.f9995h = j;
        this.f9996i = str6;
        this.j = list;
        this.k = str7;
        this.l = str8;
    }

    public static GoogleSignInAccount a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        long longValue = (l == null ? Long.valueOf(n.a() / 1000) : l).longValue();
        r.b(str7);
        r.a(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    public static GoogleSignInAccount b(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount a2 = a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString(FileProvider.DISPLAYNAME_FIELD, null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        a2.f9994g = jSONObject.optString("serverAuthCode", null);
        return a2;
    }

    public Uri A() {
        return this.f9993f;
    }

    public Set<Scope> B() {
        HashSet hashSet = new HashSet(this.j);
        hashSet.addAll(this.m);
        return hashSet;
    }

    public String C() {
        return this.f9994g;
    }

    public Account e() {
        if (this.f9991d == null) {
            return null;
        }
        return new Account(this.f9991d, "com.google");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f9996i.equals(this.f9996i) && googleSignInAccount.B().equals(B());
    }

    public int hashCode() {
        return ((this.f9996i.hashCode() + 527) * 31) + B().hashCode();
    }

    public String u() {
        return this.f9992e;
    }

    public String v() {
        return this.f9991d;
    }

    public String w() {
        return this.l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.c.a.b.c.o.v.b.a(parcel);
        c.c.a.b.c.o.v.b.a(parcel, 1, this.f9988a);
        c.c.a.b.c.o.v.b.a(parcel, 2, y(), false);
        c.c.a.b.c.o.v.b.a(parcel, 3, z(), false);
        c.c.a.b.c.o.v.b.a(parcel, 4, v(), false);
        c.c.a.b.c.o.v.b.a(parcel, 5, u(), false);
        c.c.a.b.c.o.v.b.a(parcel, 6, (Parcelable) A(), i2, false);
        c.c.a.b.c.o.v.b.a(parcel, 7, C(), false);
        c.c.a.b.c.o.v.b.a(parcel, 8, this.f9995h);
        c.c.a.b.c.o.v.b.a(parcel, 9, this.f9996i, false);
        c.c.a.b.c.o.v.b.b(parcel, 10, this.j, false);
        c.c.a.b.c.o.v.b.a(parcel, 11, x(), false);
        c.c.a.b.c.o.v.b.a(parcel, 12, w(), false);
        c.c.a.b.c.o.v.b.a(parcel, a2);
    }

    public String x() {
        return this.k;
    }

    public String y() {
        return this.f9989b;
    }

    public String z() {
        return this.f9990c;
    }
}
