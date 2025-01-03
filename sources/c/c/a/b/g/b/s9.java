package c.c.a.b.g.b;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.b.f.e.oa;
import c.c.a.b.f.e.yc;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.InAppSlotParams;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzy;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class s9 extends v5 {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f5074g = {"firebase_", "google_", "ga_"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f5075h = {"_err"};

    /* renamed from: c, reason: collision with root package name */
    public SecureRandom f5076c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicLong f5077d;

    /* renamed from: e, reason: collision with root package name */
    public int f5078e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f5079f;

    public s9(a5 a5Var) {
        super(a5Var);
        this.f5079f = null;
        this.f5077d = new AtomicLong(0L);
    }

    public static boolean h(String str) {
        c.c.a.b.c.o.r.b(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean i(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean j(String str) {
        for (String str2 : f5075h) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(String str) {
        c.c.a.b.c.o.r.a(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    public static MessageDigest x() {
        MessageDigest messageDigest;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public final Bundle a(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            c().w().a("Install referrer url isn't a hierarchical URI", e2);
            return null;
        }
    }

    public final boolean b(String str, String str2) {
        if (str2 == null) {
            c().v().a("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            c().v().a("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            c().v().a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                c().v().a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final Object c(String str, Object obj) {
        return "_ldl".equals(str) ? a(g(str), obj, true, false) : a(g(str), obj, false, false);
    }

    public final boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String s = l().s();
        F();
        return s.equals(str);
    }

    public final int e(String str) {
        if (!a("event param", str)) {
            return 3;
        }
        if (a("event param", (String[]) null, str)) {
            return !a("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    public final int f(String str) {
        if (!b("event param", str)) {
            return 3;
        }
        if (a("event param", (String[]) null, str)) {
            return !a("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    public final int g(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        return "_id".equals(str) ? RecyclerView.c0.FLAG_TMP_DETACHED : (l().a(r.m0) && "_lgclid".equals(str)) ? 100 : 36;
    }

    @Override // c.c.a.b.g.b.v5
    public final void m() {
        g();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                c().w().a("Utils falling back to Random for random id");
            }
        }
        this.f5077d.set(nextLong);
    }

    @Override // c.c.a.b.g.b.v5
    public final boolean q() {
        return true;
    }

    public final long s() {
        long andIncrement;
        long j;
        if (this.f5077d.get() != 0) {
            synchronized (this.f5077d) {
                this.f5077d.compareAndSet(-1L, 1L);
                andIncrement = this.f5077d.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f5077d) {
            long nextLong = new Random(System.nanoTime() ^ b().a()).nextLong();
            int i2 = this.f5078e + 1;
            this.f5078e = i2;
            j = nextLong + i2;
        }
        return j;
    }

    public final SecureRandom t() {
        g();
        if (this.f5076c == null) {
            this.f5076c = new SecureRandom();
        }
        return this.f5076c;
    }

    public final int u() {
        if (this.f5079f == null) {
            this.f5079f = Integer.valueOf(c.c.a.b.c.d.a().a(d()) / 1000);
        }
        return this.f5079f.intValue();
    }

    public final String v() {
        byte[] bArr = new byte[16];
        t().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final boolean w() {
        try {
            d().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final boolean c(String str) {
        g();
        if (c.c.a.b.c.t.c.b(d()).a(str) == 0) {
            return true;
        }
        c().A().a("Permission not granted", str);
        return false;
    }

    public static boolean c(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public final int b(String str) {
        if (!b("user property", str)) {
            return 6;
        }
        if (a("user property", c6.f4631a, str)) {
            return !a("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    public final boolean b(String str, String str2, int i2, Object obj) {
        int size;
        if (obj instanceof Parcelable[]) {
            size = ((Parcelable[]) obj).length;
        } else {
            if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            }
            return true;
        }
        if (size > i2) {
            c().y().a("Parameter array is too long; discarded. Value kind, name, array length", str, str2, Integer.valueOf(size));
            return false;
        }
        return true;
    }

    public static Bundle[] b(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean b(Bundle bundle, int i2) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i2);
        return true;
    }

    public final int b(String str, Object obj) {
        boolean a2;
        if ("_ldl".equals(str)) {
            a2 = a("user property referrer", str, g(str), obj);
        } else {
            a2 = a("user property", str, g(str), obj);
        }
        return a2 ? 0 : 7;
    }

    public final boolean a(String str, String str2) {
        if (str2 == null) {
            c().v().a("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            c().v().a("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            c().v().a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                c().v().a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public final boolean b(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo b2 = c.c.a.b.c.t.c.b(context).b(str, 64);
            if (b2 == null || b2.signatures == null || b2.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b2.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e2) {
            c().t().a("Package name not found", e2);
            return true;
        } catch (CertificateException e3) {
            c().t().a("Error obtaining certificate", e3);
            return true;
        }
    }

    public static Bundle b(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        return bundle2;
    }

    public final boolean a(String str, String[] strArr, String str2) {
        boolean z;
        if (str2 == null) {
            c().v().a("Name is required and can't be null. Type", str);
            return false;
        }
        c.c.a.b.c.o.r.a(str2);
        String[] strArr2 = f5074g;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (str2.startsWith(strArr2[i2])) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            c().v().a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr == null || !a(str2, strArr)) {
            return true;
        }
        c().v().a("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final boolean a(String str, int i2, String str2) {
        if (str2 == null) {
            c().v().a("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i2) {
            return true;
        }
        c().v().a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i2), str2);
        return false;
    }

    public final int a(String str) {
        if (!b(InAppSlotParams.SLOT_KEY.EVENT, str)) {
            return 2;
        }
        if (a(InAppSlotParams.SLOT_KEY.EVENT, a6.f4581a, str)) {
            return !a(InAppSlotParams.SLOT_KEY.EVENT, 40, str) ? 2 : 0;
        }
        return 13;
    }

    public static boolean a(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static ArrayList<Bundle> b(List<zzy> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzy zzyVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzyVar.f10227a);
            bundle.putString(OSSHeaders.ORIGIN, zzyVar.f10228b);
            bundle.putLong("creation_timestamp", zzyVar.f10230d);
            bundle.putString("name", zzyVar.f10229c.f10212b);
            x5.a(bundle, zzyVar.f10229c.zza());
            bundle.putBoolean("active", zzyVar.f10231e);
            String str = zzyVar.f10232f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzaq zzaqVar = zzyVar.f10233g;
            if (zzaqVar != null) {
                bundle.putString("timed_out_event_name", zzaqVar.f10207a);
                zzal zzalVar = zzyVar.f10233g.f10208b;
                if (zzalVar != null) {
                    bundle.putBundle("timed_out_event_params", zzalVar.zzb());
                }
            }
            bundle.putLong("trigger_timeout", zzyVar.f10234h);
            zzaq zzaqVar2 = zzyVar.f10235i;
            if (zzaqVar2 != null) {
                bundle.putString("triggered_event_name", zzaqVar2.f10207a);
                zzal zzalVar2 = zzyVar.f10235i.f10208b;
                if (zzalVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzalVar2.zzb());
                }
            }
            bundle.putLong("triggered_timestamp", zzyVar.f10229c.f10213c);
            bundle.putLong("time_to_live", zzyVar.j);
            zzaq zzaqVar3 = zzyVar.k;
            if (zzaqVar3 != null) {
                bundle.putString("expired_event_name", zzaqVar3.f10207a);
                zzal zzalVar3 = zzyVar.k.f10208b;
                if (zzalVar3 != null) {
                    bundle.putBundle("expired_event_params", zzalVar3.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final boolean a(String str, String str2, int i2, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i2) {
                c().y().a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    public static boolean a(Bundle bundle, int i2) {
        int i3 = 0;
        if (bundle.size() <= i2) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i3++;
            if (i3 > i2) {
                bundle.remove(str);
            }
        }
        return true;
    }

    public final void a(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int e2;
        String str4;
        int a2;
        String sb;
        if (bundle == null) {
            return;
        }
        boolean a3 = l().a(r.J0);
        int m = a3 ? 0 : l().m();
        int i2 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                e2 = z ? e(str5) : 0;
                if (e2 == 0) {
                    e2 = f(str5);
                }
            } else {
                e2 = 0;
            }
            if (e2 != 0) {
                a(bundle, e2, str5, str5, e2 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (a(bundle.get(str5))) {
                    c().y().a("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    a2 = 22;
                    str4 = str5;
                } else {
                    str4 = str5;
                    a2 = a(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (a2 != 0 && !"_ev".equals(str4)) {
                    a(bundle, a2, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (h(str4) && (!a3 || !a(str4, z5.f5225d))) {
                    int i3 = i2 + 1;
                    if (i3 > m) {
                        if (a3) {
                            sb = "Item cannot contain custom parameters";
                        } else {
                            StringBuilder sb2 = new StringBuilder(63);
                            sb2.append("Child bundles can't contain more than ");
                            sb2.append(m);
                            sb2.append(" custom params");
                            sb = sb2.toString();
                        }
                        c().v().a(sb, i().a(str2), i().a(bundle));
                        b(bundle, a3 ? 23 : 5);
                        bundle.remove(str4);
                    }
                    i2 = i3;
                }
            }
        }
    }

    public final boolean a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (k(str)) {
                return true;
            }
            if (this.f5160a.y()) {
                c().v().a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", w3.a(str));
            }
            return false;
        }
        if (oa.a() && l().a(r.p0) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (k(str2)) {
                return true;
            }
            c().v().a("Invalid admob_app_id. Analytics disabled.", w3.a(str2));
            return false;
        }
        if (this.f5160a.y()) {
            c().v().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    public static boolean a(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public final Object a(int i2, Object obj, boolean z, boolean z2) {
        Bundle a2;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            if (!c.c.a.b.f.e.d9.a() || !l().a(r.I0) || !l().a(r.H0) || !z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (a2 = a((Bundle) parcelable)) != null && !a2.isEmpty()) {
                    arrayList.add(a2);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return a(String.valueOf(obj), i2, z);
    }

    public static String a(String str, int i2, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i2) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i2))).concat("...");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0166 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Object r21, android.os.Bundle r22, java.util.List<java.lang.String> r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.s9.a(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final Object a(String str, Object obj) {
        boolean equals = "_ev".equals(str);
        int i2 = RecyclerView.c0.FLAG_TMP_DETACHED;
        if (equals) {
            return a(RecyclerView.c0.FLAG_TMP_DETACHED, obj, true, true);
        }
        if (!i(str)) {
            i2 = 100;
        }
        return a(i2, obj, false, true);
    }

    public final Bundle a(String str, String str2, Bundle bundle, List<String> list, boolean z, boolean z2) {
        Set<String> keySet;
        int e2;
        int i2;
        Bundle bundle2;
        String str3;
        int i3;
        boolean z3 = c.c.a.b.f.e.d9.a() && l().a(r.J0);
        boolean a2 = z3 ? a(str2, a6.f4583c) : z2;
        if (bundle == null) {
            return null;
        }
        Bundle bundle3 = new Bundle(bundle);
        int m = l().m();
        if (l().e(str, r.c0)) {
            keySet = new TreeSet<>(bundle.keySet());
        } else {
            keySet = bundle.keySet();
        }
        int i4 = 0;
        for (String str4 : keySet) {
            if (list == null || !list.contains(str4)) {
                e2 = z ? e(str4) : 0;
                if (e2 == 0) {
                    e2 = f(str4);
                }
            } else {
                e2 = 0;
            }
            if (e2 != 0) {
                a(bundle3, e2, str4, str4, e2 == 3 ? str4 : null);
                bundle3.remove(str4);
                i2 = m;
                bundle2 = bundle3;
            } else {
                i2 = m;
                Bundle bundle4 = bundle3;
                int a3 = a(str, str2, str4, bundle.get(str4), bundle3, list, z, a2);
                if (z3 && a3 == 17) {
                    str3 = str4;
                    bundle2 = bundle4;
                    a(bundle2, a3, str3, str3, (Object) false);
                } else {
                    str3 = str4;
                    bundle2 = bundle4;
                    if (a3 != 0 && !"_ev".equals(str3)) {
                        a(bundle2, a3, a3 == 21 ? str2 : str3, str3, bundle.get(str3));
                        bundle2.remove(str3);
                    }
                }
                if (h(str3)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    if (i5 > i3) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Event can't contain more than ");
                        sb.append(i3);
                        sb.append(" params");
                        c().v().a(sb.toString(), i().a(str2), i().a(bundle));
                        b(bundle2, 5);
                        bundle2.remove(str3);
                        i4 = i5;
                        m = i3;
                        bundle3 = bundle2;
                    } else {
                        i4 = i5;
                    }
                } else {
                    i3 = i2;
                }
                m = i3;
                bundle3 = bundle2;
            }
            bundle3 = bundle2;
            m = i2;
        }
        return bundle3;
    }

    public static void a(Bundle bundle, int i2, String str, String str2, Object obj) {
        if (b(bundle, i2)) {
            bundle.putString("_ev", a(str, 40, true));
            if (obj != null) {
                c.c.a.b.c.o.r.a(bundle);
                if (obj != null) {
                    if ((obj instanceof String) || (obj instanceof CharSequence)) {
                        bundle.putLong("_el", String.valueOf(obj).length());
                    }
                }
            }
        }
    }

    public final void a(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (c.c.a.b.f.e.d9.a() && l().a(r.I0) && l().a(r.H0) && (obj instanceof Bundle[])) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            c().y().a("Not putting event parameter. Invalid value type. name, type", i().b(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void a(int i2, String str, String str2, int i3) {
        a((String) null, i2, str, str2, i3);
    }

    public final void a(String str, int i2, String str2, String str3, int i3) {
        Bundle bundle = new Bundle();
        b(bundle, i2);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i2 == 6 || i2 == 7 || i2 == 2) {
            bundle.putLong("_el", i3);
        }
        this.f5160a.F();
        this.f5160a.u().a("auto", "_err", bundle);
    }

    public static long a(byte[] bArr) {
        c.c.a.b.c.o.r.a(bArr);
        int i2 = 0;
        c.c.a.b.c.o.r.b(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (bArr[length] & 255) << i2;
            i2 += 8;
        }
        return j;
    }

    public static boolean a(Context context, boolean z) {
        c.c.a.b.c.o.r.a(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return c(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return c(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean a(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    public static boolean a(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object a2 = a(str, bundle.get(str));
                if (a2 == null) {
                    c().y().a("Param value can't be null", i().b(str));
                } else {
                    a(bundle2, str, a2);
                }
            }
        }
        return bundle2;
    }

    public final zzaq a(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (a(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str3);
            return new zzaq(str2, new zzal(a(a(str, str2, bundle2, c.c.a.b.c.s.f.a("_o"), false, false))), str3, j);
        }
        c().t().a("Invalid conditional property event name", i().c(str2));
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0069 -> B:7:0x0076). Please report as a decompilation issue!!! */
    public final long a(Context context, String str) {
        g();
        c.c.a.b.c.o.r.a(context);
        c.c.a.b.c.o.r.b(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest x = x();
        long j = -1;
        if (x == null) {
            c().t().a("Could not get MD5 instance");
        } else {
            if (packageManager != null) {
                try {
                } catch (PackageManager.NameNotFoundException e2) {
                    c().t().a("Package name not found", e2);
                }
                if (!b(context, str)) {
                    PackageInfo b2 = c.c.a.b.c.t.c.b(context).b(d().getPackageName(), 64);
                    if (b2.signatures != null && b2.signatures.length > 0) {
                        j = a(x.digest(b2.signatures[0].toByteArray()));
                    } else {
                        c().w().a("Could not get signatures");
                    }
                }
            }
            j = 0;
        }
        return j;
    }

    public static byte[] a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static boolean a(String str, String[] strArr) {
        c.c.a.b.c.o.r.a(strArr);
        for (String str2 : strArr) {
            if (c(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public final int a(int i2) {
        return c.c.a.b.c.d.a().a(d(), c.c.a.b.c.h.f3820a);
    }

    public static long a(long j, long j2) {
        return (j + (j2 * JConstants.MIN)) / JConstants.DAY;
    }

    public final void a(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            c().w().a("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void a(yc ycVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            this.f5160a.c().w().a("Error returning string value to wrapper", e2);
        }
    }

    public final void a(yc ycVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            this.f5160a.c().w().a("Error returning long value to wrapper", e2);
        }
    }

    public final void a(yc ycVar, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i2);
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            this.f5160a.c().w().a("Error returning int value to wrapper", e2);
        }
    }

    public final void a(yc ycVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            this.f5160a.c().w().a("Error returning byte array to wrapper", e2);
        }
    }

    public final void a(yc ycVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            this.f5160a.c().w().a("Error returning boolean value to wrapper", e2);
        }
    }

    public final void a(yc ycVar, Bundle bundle) {
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            this.f5160a.c().w().a("Error returning bundle value to wrapper", e2);
        }
    }

    public static Bundle a(List<zzkn> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzkn zzknVar : list) {
            String str = zzknVar.f10215e;
            if (str != null) {
                bundle.putString(zzknVar.f10212b, str);
            } else {
                Long l = zzknVar.f10214d;
                if (l != null) {
                    bundle.putLong(zzknVar.f10212b, l.longValue());
                } else {
                    Double d2 = zzknVar.f10217g;
                    if (d2 != null) {
                        bundle.putDouble(zzknVar.f10212b, d2.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public final void a(yc ycVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            ycVar.a(bundle);
        } catch (RemoteException e2) {
            this.f5160a.c().w().a("Error returning bundle list to wrapper", e2);
        }
    }

    public final URL a(long j, String str, String str2, long j2) {
        try {
            c.c.a.b.c.o.r.b(str2);
            c.c.a.b.c.o.r.b(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j), Integer.valueOf(u())), str2, str, Long.valueOf(j2));
            if (str.equals(l().t())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            c().t().a("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public final boolean a(String str, double d2) {
        try {
            SharedPreferences.Editor edit = d().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d2));
            return edit.commit();
        } catch (Exception e2) {
            c().t().a("Failed to persist Deferred Deep Link. exception", e2);
            return false;
        }
    }

    public static long a(zzal zzalVar) {
        long j = 0;
        if (zzalVar == null) {
            return 0L;
        }
        Iterator<String> it = zzalVar.iterator();
        while (it.hasNext()) {
            if (zzalVar.b(it.next()) instanceof Parcelable[]) {
                j += ((Parcelable[]) r3).length;
            }
        }
        return j;
    }
}
