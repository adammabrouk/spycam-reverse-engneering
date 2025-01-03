package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class d extends c {

    /* renamed from: f, reason: collision with root package name */
    public static HashMap<String, byte[]> f11119f;

    /* renamed from: g, reason: collision with root package name */
    public static HashMap<String, HashMap<String, byte[]>> f11120g;

    /* renamed from: e, reason: collision with root package name */
    public f f11121e;

    public d() {
        f fVar = new f();
        this.f11121e = fVar;
        fVar.f11123a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t);
        } else {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
    }

    public final void b(String str) {
        this.f11121e.f11125c = str;
    }

    @Override // com.tencent.bugly.proguard.c
    public final void c() {
        super.c();
        this.f11121e.f11123a = (short) 3;
    }

    public final void c(String str) {
        this.f11121e.f11126d = str;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final byte[] a() {
        f fVar = this.f11121e;
        if (fVar.f11123a == 2) {
            if (!fVar.f11125c.equals("")) {
                if (this.f11121e.f11126d.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (fVar.f11125c == null) {
                fVar.f11125c = "";
            }
            f fVar2 = this.f11121e;
            if (fVar2.f11126d == null) {
                fVar2.f11126d = "";
            }
        }
        j jVar = new j(0);
        jVar.a(this.f11034b);
        if (this.f11121e.f11123a == 2) {
            jVar.a((Map) this.f11033a, 0);
        } else {
            jVar.a((Map) ((c) this).f11116d, 0);
        }
        this.f11121e.f11127e = l.a(jVar.a());
        j jVar2 = new j(0);
        jVar2.a(this.f11034b);
        this.f11121e.a(jVar2);
        byte[] a2 = l.a(jVar2.a());
        int length = a2.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a2).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                i iVar = new i(bArr, 4);
                iVar.a(this.f11034b);
                this.f11121e.a(iVar);
                if (this.f11121e.f11123a == 3) {
                    i iVar2 = new i(this.f11121e.f11127e);
                    iVar2.a(this.f11034b);
                    if (f11119f == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f11119f = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((c) this).f11116d = iVar2.a((Map) f11119f, 0, false);
                    return;
                }
                i iVar3 = new i(this.f11121e.f11127e);
                iVar3.a(this.f11034b);
                if (f11120g == null) {
                    f11120g = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f11120g.put("", hashMap2);
                }
                this.f11033a = iVar3.a((Map) f11120g, 0, false);
                new HashMap();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public final void a(int i2) {
        this.f11121e.f11124b = 1;
    }
}
