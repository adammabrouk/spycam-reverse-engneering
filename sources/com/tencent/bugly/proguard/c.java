package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, byte[]> f11116d = null;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, Object> f11117e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public i f11118f = new i();

    @Override // com.tencent.bugly.proguard.a
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public final <T> T b(String str, T t) throws b {
        HashMap<String, byte[]> hashMap = this.f11116d;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f11117e.containsKey(str)) {
                return (T) this.f11117e.get(str);
            }
            try {
                this.f11118f.a(this.f11116d.get(str));
                this.f11118f.a(this.f11034b);
                T t2 = (T) this.f11118f.a((i) t, 0, true);
                if (t2 != null) {
                    this.f11117e.put(str, t2);
                }
                return t2;
            } catch (Exception e2) {
                throw new b(e2);
            }
        }
        if (!this.f11033a.containsKey(str)) {
            return null;
        }
        if (this.f11117e.containsKey(str)) {
            return (T) this.f11117e.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f11033a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f11118f.a(bArr);
            this.f11118f.a(this.f11034b);
            T t3 = (T) this.f11118f.a((i) t, 0, true);
            this.f11117e.put(str, t3);
            return t3;
        } catch (Exception e3) {
            throw new b(e3);
        }
    }

    public void c() {
        this.f11116d = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.a
    public <T> void a(String str, T t) {
        if (this.f11116d == null) {
            super.a(str, (String) t);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        j jVar = new j();
        jVar.a(this.f11034b);
        jVar.a(t, 0);
        this.f11116d.put(str, l.a(jVar.a()));
    }

    @Override // com.tencent.bugly.proguard.a
    public byte[] a() {
        if (this.f11116d != null) {
            j jVar = new j(0);
            jVar.a(this.f11034b);
            jVar.a((Map) this.f11116d, 0);
            return l.a(jVar.a());
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.a
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f11118f.a(bArr);
            this.f11118f.a(this.f11034b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f11116d = this.f11118f.a((Map) hashMap, 0, false);
        }
    }
}
