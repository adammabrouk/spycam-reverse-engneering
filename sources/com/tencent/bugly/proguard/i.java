package com.tencent.bugly.proguard;

import androidx.recyclerview.widget.RecyclerView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f11134a;

    /* renamed from: b, reason: collision with root package name */
    public String f11135b = "GBK";

    /* compiled from: BUGLY */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f11136a;

        /* renamed from: b, reason: collision with root package name */
        public int f11137b;
    }

    public i() {
    }

    private boolean[] d(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        if (aVar.f11136a != 9) {
            throw new g("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new g("size invalid: " + a2);
        }
        boolean[] zArr = new boolean[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            zArr[i3] = a((byte) 0, 0, true) != 0;
        }
        return zArr;
    }

    private short[] e(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        if (aVar.f11136a != 9) {
            throw new g("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new g("size invalid: " + a2);
        }
        short[] sArr = new short[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            sArr[i3] = a(sArr[0], 0, true);
        }
        return sArr;
    }

    private int[] f(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        if (aVar.f11136a != 9) {
            throw new g("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new g("size invalid: " + a2);
        }
        int[] iArr = new int[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            iArr[i3] = a(iArr[0], 0, true);
        }
        return iArr;
    }

    private long[] g(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        if (aVar.f11136a != 9) {
            throw new g("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new g("size invalid: " + a2);
        }
        long[] jArr = new long[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            jArr[i3] = a(jArr[0], 0, true);
        }
        return jArr;
    }

    private float[] h(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        if (aVar.f11136a != 9) {
            throw new g("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new g("size invalid: " + a2);
        }
        float[] fArr = new float[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            fArr[i3] = a(fArr[0], 0, true);
        }
        return fArr;
    }

    private double[] i(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        if (aVar.f11136a != 9) {
            throw new g("type mismatch.");
        }
        int a2 = a(0, 0, true);
        if (a2 < 0) {
            throw new g("size invalid: " + a2);
        }
        double[] dArr = new double[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            dArr[i3] = a(dArr[0], 0, true);
        }
        return dArr;
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f11134a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f11134a = ByteBuffer.wrap(bArr);
    }

    public final String b(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        byte b2 = aVar.f11136a;
        if (b2 == 6) {
            int i3 = this.f11134a.get();
            if (i3 < 0) {
                i3 += RecyclerView.c0.FLAG_TMP_DETACHED;
            }
            byte[] bArr = new byte[i3];
            this.f11134a.get(bArr);
            try {
                return new String(bArr, this.f11135b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b2 != 7) {
            throw new g("type mismatch.");
        }
        int i4 = this.f11134a.getInt();
        if (i4 > 104857600 || i4 < 0) {
            throw new g("String too long: " + i4);
        }
        byte[] bArr2 = new byte[i4];
        this.f11134a.get(bArr2);
        try {
            return new String(bArr2, this.f11135b);
        } catch (UnsupportedEncodingException unused2) {
            return new String(bArr2);
        }
    }

    public final byte[] c(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        byte b2 = aVar.f11136a;
        if (b2 == 9) {
            int a2 = a(0, 0, true);
            if (a2 < 0) {
                throw new g("size invalid: " + a2);
            }
            byte[] bArr = new byte[a2];
            for (int i3 = 0; i3 < a2; i3++) {
                bArr[i3] = a(bArr[0], 0, true);
            }
            return bArr;
        }
        if (b2 != 13) {
            throw new g("type mismatch.");
        }
        a aVar2 = new a();
        a(aVar2, this.f11134a);
        if (aVar2.f11136a != 0) {
            throw new g("type mismatch, tag: " + i2 + ", type: " + ((int) aVar.f11136a) + ", " + ((int) aVar2.f11136a));
        }
        int a3 = a(0, 0, true);
        if (a3 >= 0) {
            byte[] bArr2 = new byte[a3];
            this.f11134a.get(bArr2);
            return bArr2;
        }
        throw new g("invalid size, tag: " + i2 + ", type: " + ((int) aVar.f11136a) + ", " + ((int) aVar2.f11136a) + ", size: " + a3);
    }

    public i(byte[] bArr) {
        this.f11134a = ByteBuffer.wrap(bArr);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.f11136a = (byte) (b2 & 15);
        int i2 = (b2 & 240) >> 4;
        aVar.f11137b = i2;
        if (i2 != 15) {
            return 1;
        }
        aVar.f11137b = byteBuffer.get();
        return 2;
    }

    public i(byte[] bArr, int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f11134a = wrap;
        wrap.position(4);
    }

    private boolean a(int i2) {
        a aVar;
        try {
            aVar = new a();
            while (true) {
                int a2 = a(aVar, this.f11134a.duplicate());
                if (i2 <= aVar.f11137b || aVar.f11136a == 11) {
                    break;
                }
                this.f11134a.position(this.f11134a.position() + a2);
                a(aVar.f11136a);
            }
        } catch (g | BufferUnderflowException unused) {
        }
        return i2 == aVar.f11137b;
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar, this.f11134a);
            a(aVar.f11136a);
        } while (aVar.f11136a != 11);
    }

    private void a(byte b2) {
        int i2 = 0;
        switch (b2) {
            case 0:
                ByteBuffer byteBuffer = this.f11134a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                ByteBuffer byteBuffer2 = this.f11134a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                ByteBuffer byteBuffer3 = this.f11134a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                ByteBuffer byteBuffer4 = this.f11134a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                ByteBuffer byteBuffer5 = this.f11134a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                ByteBuffer byteBuffer6 = this.f11134a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i3 = this.f11134a.get();
                if (i3 < 0) {
                    i3 += RecyclerView.c0.FLAG_TMP_DETACHED;
                }
                ByteBuffer byteBuffer7 = this.f11134a;
                byteBuffer7.position(byteBuffer7.position() + i3);
                return;
            case 7:
                int i4 = this.f11134a.getInt();
                ByteBuffer byteBuffer8 = this.f11134a;
                byteBuffer8.position(byteBuffer8.position() + i4);
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i2 < (a2 << 1)) {
                    a aVar = new a();
                    a(aVar, this.f11134a);
                    a(aVar.f11136a);
                    i2++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i2 < a3) {
                    a aVar2 = new a();
                    a(aVar2, this.f11134a);
                    a(aVar2.f11136a);
                    i2++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar3 = new a();
                a(aVar3, this.f11134a);
                if (aVar3.f11136a == 0) {
                    int a4 = a(0, 0, true);
                    ByteBuffer byteBuffer9 = this.f11134a;
                    byteBuffer9.position(byteBuffer9.position() + a4);
                    return;
                } else {
                    throw new g("skipField with invalid type, type value: " + ((int) b2) + ", " + ((int) aVar3.f11136a));
                }
            default:
                throw new g("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        if (aVar.f11136a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
                for (int i3 = 0; i3 < a2; i3++) {
                    tArr[i3] = a((i) t, 0, true);
                }
                return tArr;
            }
            throw new g("size invalid: " + a2);
        }
        throw new g("type mismatch.");
    }

    public final boolean a(int i2, boolean z) {
        return a((byte) 0, i2, z) != 0;
    }

    public final byte a(byte b2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return b2;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        byte b3 = aVar.f11136a;
        if (b3 == 0) {
            return this.f11134a.get();
        }
        if (b3 == 12) {
            return (byte) 0;
        }
        throw new g("type mismatch.");
    }

    public final short a(short s, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        byte b2 = aVar.f11136a;
        if (b2 == 0) {
            return this.f11134a.get();
        }
        if (b2 == 1) {
            return this.f11134a.getShort();
        }
        if (b2 == 12) {
            return (short) 0;
        }
        throw new g("type mismatch.");
    }

    public final int a(int i2, int i3, boolean z) {
        if (!a(i3)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return i2;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        byte b2 = aVar.f11136a;
        if (b2 == 0) {
            return this.f11134a.get();
        }
        if (b2 == 1) {
            return this.f11134a.getShort();
        }
        if (b2 == 2) {
            return this.f11134a.getInt();
        }
        if (b2 == 12) {
            return 0;
        }
        throw new g("type mismatch.");
    }

    public final long a(long j, int i2, boolean z) {
        int i3;
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return j;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        byte b2 = aVar.f11136a;
        if (b2 == 0) {
            i3 = this.f11134a.get();
        } else if (b2 == 1) {
            i3 = this.f11134a.getShort();
        } else {
            if (b2 != 2) {
                if (b2 == 3) {
                    return this.f11134a.getLong();
                }
                if (b2 == 12) {
                    return 0L;
                }
                throw new g("type mismatch.");
            }
            i3 = this.f11134a.getInt();
        }
        return i3;
    }

    private float a(float f2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return f2;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        byte b2 = aVar.f11136a;
        if (b2 == 4) {
            return this.f11134a.getFloat();
        }
        if (b2 == 12) {
            return 0.0f;
        }
        throw new g("type mismatch.");
    }

    private double a(double d2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return d2;
        }
        a aVar = new a();
        a(aVar, this.f11134a);
        byte b2 = aVar.f11136a;
        if (b2 == 4) {
            return this.f11134a.getFloat();
        }
        if (b2 == 5) {
            return this.f11134a.getDouble();
        }
        if (b2 == 12) {
            return 0.0d;
        }
        throw new g("type mismatch.");
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i2, boolean z) {
        return (HashMap) a(new HashMap(), map, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i2, boolean z) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (a(i2)) {
                a aVar = new a();
                a(aVar, this.f11134a);
                if (aVar.f11136a == 8) {
                    int a2 = a(0, 0, true);
                    if (a2 < 0) {
                        throw new g("size invalid: " + a2);
                    }
                    for (int i3 = 0; i3 < a2; i3++) {
                        map.put(a((i) key, 0, true), a((i) value, 1, true));
                    }
                } else {
                    throw new g("type mismatch.");
                }
            } else if (z) {
                throw new g("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i2, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i2, z);
        }
        throw new g("unable to get type of key and value.");
    }

    public final k a(k kVar, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        try {
            k kVar2 = (k) kVar.getClass().newInstance();
            a aVar = new a();
            a(aVar, this.f11134a);
            if (aVar.f11136a == 10) {
                kVar2.a(this);
                a();
                return kVar2;
            }
            throw new g("type mismatch.");
        } catch (Exception e2) {
            throw new g(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t, int i2, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i2, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a((byte) 0, i2, z) != 0);
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i2, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i2, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0L, i2, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i2, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i2, z));
        }
        if (t instanceof String) {
            return String.valueOf(b(i2, z));
        }
        if (t instanceof Map) {
            return (HashMap) a(new HashMap(), (Map) t, i2, z);
        }
        if (t instanceof List) {
            List list = (List) t;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            Object[] b2 = b(list.get(0), i2, z);
            if (b2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : b2) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        if (t instanceof k) {
            return a((k) t, i2, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                if (t instanceof boolean[]) {
                    return d(i2, z);
                }
                if (t instanceof short[]) {
                    return e(i2, z);
                }
                if (t instanceof int[]) {
                    return f(i2, z);
                }
                if (t instanceof long[]) {
                    return g(i2, z);
                }
                if (t instanceof float[]) {
                    return h(i2, z);
                }
                if (t instanceof double[]) {
                    return i(i2, z);
                }
                return a((Object[]) t, i2, z);
            }
            return c(i2, z);
        }
        throw new g("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.f11135b = str;
        return 0;
    }
}
