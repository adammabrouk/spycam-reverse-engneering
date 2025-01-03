package com.tencent.bugly.proguard;

import androidx.recyclerview.widget.RecyclerView;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f11138a;

    /* renamed from: b, reason: collision with root package name */
    public String f11139b;

    public j(int i2) {
        this.f11139b = "GBK";
        this.f11138a = ByteBuffer.allocate(i2);
    }

    public final ByteBuffer a() {
        return this.f11138a;
    }

    public final byte[] b() {
        byte[] bArr = new byte[this.f11138a.position()];
        System.arraycopy(this.f11138a.array(), 0, bArr, 0, this.f11138a.position());
        return bArr;
    }

    private void a(int i2) {
        if (this.f11138a.remaining() < i2) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f11138a.capacity() + i2) << 1);
            allocate.put(this.f11138a.array(), 0, this.f11138a.position());
            this.f11138a = allocate;
        }
    }

    private void b(byte b2, int i2) {
        if (i2 < 15) {
            this.f11138a.put((byte) (b2 | (i2 << 4)));
        } else if (i2 < 256) {
            this.f11138a.put((byte) (b2 | 240));
            this.f11138a.put((byte) i2);
        } else {
            throw new b("tag is too large: " + i2);
        }
    }

    public j() {
        this(RecyclerView.c0.FLAG_IGNORE);
    }

    public final void a(boolean z, int i2) {
        a(z ? (byte) 1 : (byte) 0, i2);
    }

    public final void a(byte b2, int i2) {
        a(3);
        if (b2 == 0) {
            b((byte) 12, i2);
        } else {
            b((byte) 0, i2);
            this.f11138a.put(b2);
        }
    }

    public final void a(short s, int i2) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i2);
        } else {
            b((byte) 1, i2);
            this.f11138a.putShort(s);
        }
    }

    public final void a(int i2, int i3) {
        a(6);
        if (i2 >= -32768 && i2 <= 32767) {
            a((short) i2, i3);
        } else {
            b((byte) 2, i3);
            this.f11138a.putInt(i2);
        }
    }

    public final void a(long j, int i2) {
        a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            a((int) j, i2);
        } else {
            b((byte) 3, i2);
            this.f11138a.putLong(j);
        }
    }

    public final void a(String str, int i2) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f11139b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i2);
            this.f11138a.putInt(bytes.length);
            this.f11138a.put(bytes);
        } else {
            b((byte) 6, i2);
            this.f11138a.put((byte) bytes.length);
            this.f11138a.put(bytes);
        }
    }

    public final <K, V> void a(Map<K, V> map, int i2) {
        a(8);
        b((byte) 8, i2);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public final void a(byte[] bArr, int i2) {
        a(bArr.length + 8);
        b((byte) 13, i2);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f11138a.put(bArr);
    }

    public final <T> void a(Collection<T> collection, int i2) {
        a(8);
        b((byte) 9, i2);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public final void a(k kVar, int i2) {
        a(2);
        b((byte) 10, i2);
        kVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i2) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i2);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i2);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i2);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i2);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i2);
            return;
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            a(6);
            b((byte) 4, i2);
            this.f11138a.putFloat(floatValue);
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i2);
            this.f11138a.putDouble(doubleValue);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i2);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i2);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i2);
            return;
        }
        if (obj instanceof k) {
            a(2);
            b((byte) 10, i2);
            ((k) obj).a(this);
            a(2);
            b((byte) 11, 0);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i2);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i2);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a(z ? (byte) 1 : (byte) 0, 0);
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i2);
            a(sArr.length, 0);
            for (short s : sArr) {
                a(s, 0);
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i2);
            a(iArr.length, 0);
            for (int i3 : iArr) {
                a(i3, 0);
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i2);
            a(jArr.length, 0);
            for (long j : jArr) {
                a(j, 0);
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i2);
            a(fArr.length, 0);
            for (float f2 : fArr) {
                a(6);
                b((byte) 4, 0);
                this.f11138a.putFloat(f2);
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i2);
            a(dArr.length, 0);
            for (double d2 : dArr) {
                a(10);
                b((byte) 5, 0);
                this.f11138a.putDouble(d2);
            }
            return;
        }
        if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i2);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
            return;
        }
        if (obj instanceof Collection) {
            a((Collection) obj, i2);
        } else {
            throw new b("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.f11139b = str;
        return 0;
    }
}
