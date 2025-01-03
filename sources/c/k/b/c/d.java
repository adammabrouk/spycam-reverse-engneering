package c.k.b.c;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.o0;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public Context f6797a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, HashMap<String, c.k.b.a.d>> f6798b;

    public d(Context context) {
        this.f6797a = context;
    }

    public static String a(c.k.b.a.d dVar) {
        return String.valueOf(dVar.f6769a) + "#" + dVar.f6770b;
    }

    @Override // c.k.b.c.e
    public void a() {
        o0.a(this.f6797a, "perf", "perfUploading");
        File[] m317a = o0.m317a(this.f6797a, "perfUploading");
        if (m317a == null || m317a.length <= 0) {
            return;
        }
        for (File file : m317a) {
            if (file != null) {
                List<String> a2 = g.a(this.f6797a, file.getAbsolutePath());
                file.delete();
                a(a2);
            }
        }
    }

    @Override // c.k.b.c.f
    /* renamed from: a */
    public void mo13a(c.k.b.a.d dVar) {
        if ((dVar instanceof c.k.b.a.c) && this.f6798b != null) {
            c.k.b.a.c cVar = (c.k.b.a.c) dVar;
            String a2 = a((c.k.b.a.d) cVar);
            String a3 = g.a(cVar);
            HashMap<String, c.k.b.a.d> hashMap = this.f6798b.get(a2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            c.k.b.a.c cVar2 = (c.k.b.a.c) hashMap.get(a3);
            if (cVar2 != null) {
                cVar.f6768i += cVar2.f6768i;
                cVar.j += cVar2.j;
            }
            hashMap.put(a3, cVar);
            this.f6798b.put(a2, hashMap);
        }
    }

    @Override // c.k.b.c.b
    public void a(HashMap<String, HashMap<String, c.k.b.a.d>> hashMap) {
        this.f6798b = hashMap;
    }

    public void a(List<String> list) {
        throw null;
    }

    public void a(c.k.b.a.d[] dVarArr) {
        String c2 = c(dVarArr[0]);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        g.a(c2, dVarArr);
    }

    public final String b(c.k.b.a.d dVar) {
        String str;
        int i2 = dVar.f6769a;
        String str2 = dVar.f6770b;
        if (i2 <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i2) + "#" + str2;
        }
        File externalFilesDir = this.f6797a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            c.k.a.a.a.c.d("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    @Override // c.k.b.c.f
    public void b() {
        HashMap<String, HashMap<String, c.k.b.a.d>> hashMap = this.f6798b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f6798b.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, c.k.b.a.d> hashMap2 = this.f6798b.get(it.next());
                if (hashMap2 != null && hashMap2.size() > 0) {
                    c.k.b.a.d[] dVarArr = new c.k.b.a.d[hashMap2.size()];
                    hashMap2.values().toArray(dVarArr);
                    a(dVarArr);
                }
            }
        }
        this.f6798b.clear();
    }

    public final String c(c.k.b.a.d dVar) {
        String b2 = b(dVar);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        for (int i2 = 0; i2 < 20; i2++) {
            String str = b2 + i2;
            if (o0.a(this.f6797a, str)) {
                return str;
            }
        }
        return null;
    }
}
