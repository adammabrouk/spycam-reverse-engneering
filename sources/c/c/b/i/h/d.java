package c.c.b.i.h;

import android.util.Base64;
import android.util.JsonWriter;
import c.c.b.i.e;
import c.c.b.i.f;
import c.c.b.i.g;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
/* loaded from: classes.dex */
public final class d implements e, g {

    /* renamed from: a, reason: collision with root package name */
    public d f5891a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5892b = true;

    /* renamed from: c, reason: collision with root package name */
    public final JsonWriter f5893c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, c.c.b.i.d<?>> f5894d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f5895e;

    public d(Writer writer, Map<Class<?>, c.c.b.i.d<?>> map, Map<Class<?>, f<?>> map2) {
        this.f5893c = new JsonWriter(writer);
        this.f5894d = map;
        this.f5895e = map2;
    }

    @Override // c.c.b.i.e
    public /* bridge */ /* synthetic */ e a(String str, int i2) throws IOException, c.c.b.i.c {
        a(str, i2);
        return this;
    }

    public final void b() throws IOException {
        if (!this.f5892b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        d dVar = this.f5891a;
        if (dVar != null) {
            dVar.b();
            this.f5891a.f5892b = false;
            this.f5891a = null;
            this.f5893c.endObject();
        }
    }

    @Override // c.c.b.i.e
    public /* bridge */ /* synthetic */ e a(String str, long j) throws IOException, c.c.b.i.c {
        a(str, j);
        return this;
    }

    @Override // c.c.b.i.e
    public /* bridge */ /* synthetic */ e a(String str, Object obj) throws IOException, c.c.b.i.c {
        a(str, obj);
        return this;
    }

    @Override // c.c.b.i.g
    public /* bridge */ /* synthetic */ g a(String str) throws IOException, c.c.b.i.c {
        a(str);
        return this;
    }

    @Override // c.c.b.i.g
    public /* bridge */ /* synthetic */ g a(boolean z) throws IOException, c.c.b.i.c {
        a(z);
        return this;
    }

    @Override // c.c.b.i.e
    public d a(String str, Object obj) throws IOException, c.c.b.i.c {
        b();
        this.f5893c.name(str);
        if (obj == null) {
            this.f5893c.nullValue();
            return this;
        }
        a(obj);
        return this;
    }

    @Override // c.c.b.i.e
    public d a(String str, int i2) throws IOException, c.c.b.i.c {
        b();
        this.f5893c.name(str);
        a(i2);
        return this;
    }

    @Override // c.c.b.i.e
    public d a(String str, long j) throws IOException, c.c.b.i.c {
        b();
        this.f5893c.name(str);
        a(j);
        return this;
    }

    @Override // c.c.b.i.g
    public d a(String str) throws IOException, c.c.b.i.c {
        b();
        this.f5893c.value(str);
        return this;
    }

    public d a(int i2) throws IOException, c.c.b.i.c {
        b();
        this.f5893c.value(i2);
        return this;
    }

    public d a(long j) throws IOException, c.c.b.i.c {
        b();
        this.f5893c.value(j);
        return this;
    }

    @Override // c.c.b.i.g
    public d a(boolean z) throws IOException, c.c.b.i.c {
        b();
        this.f5893c.value(z);
        return this;
    }

    public d a(byte[] bArr) throws IOException, c.c.b.i.c {
        b();
        if (bArr == null) {
            this.f5893c.nullValue();
        } else {
            this.f5893c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public d a(Object obj) throws IOException, c.c.b.i.c {
        if (obj == null) {
            this.f5893c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f5893c.value((Number) obj);
            return this;
        }
        int i2 = 0;
        if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                a((byte[]) obj);
                return this;
            }
            this.f5893c.beginArray();
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (i2 < length) {
                    this.f5893c.value(r7[i2]);
                    i2++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i2 < length2) {
                    a(jArr[i2]);
                    i2++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i2 < length3) {
                    this.f5893c.value(dArr[i2]);
                    i2++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i2 < length4) {
                    this.f5893c.value(zArr[i2]);
                    i2++;
                }
            } else if (obj instanceof Number[]) {
                Number[] numberArr = (Number[]) obj;
                int length5 = numberArr.length;
                while (i2 < length5) {
                    a(numberArr[i2]);
                    i2++;
                }
            } else {
                Object[] objArr = (Object[]) obj;
                int length6 = objArr.length;
                while (i2 < length6) {
                    a(objArr[i2]);
                    i2++;
                }
            }
            this.f5893c.endArray();
            return this;
        }
        if (obj instanceof Collection) {
            this.f5893c.beginArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            this.f5893c.endArray();
            return this;
        }
        if (obj instanceof Map) {
            this.f5893c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    a((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new c.c.b.i.c(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e2);
                }
            }
            this.f5893c.endObject();
            return this;
        }
        c.c.b.i.d<?> dVar = this.f5894d.get(obj.getClass());
        if (dVar != null) {
            this.f5893c.beginObject();
            dVar.a(obj, this);
            this.f5893c.endObject();
            return this;
        }
        f<?> fVar = this.f5895e.get(obj.getClass());
        if (fVar != null) {
            fVar.a(obj, this);
            return this;
        }
        if (obj instanceof Enum) {
            a(((Enum) obj).name());
            return this;
        }
        throw new c.c.b.i.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public void a() throws IOException {
        b();
        this.f5893c.flush();
    }
}
