package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import c.c.a.b.f.e.s4.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class s4<MessageType extends s4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends b3<MessageType, BuilderType> {
    public static Map<Object, s4<?, ?>> zzd = new ConcurrentHashMap();
    public n7 zzb = n7.d();
    public int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static class a<T extends s4<T, ?>> extends f3<T> {
        public a(T t) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static abstract class b<MessageType extends s4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends d3<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        public final MessageType f4416a;

        /* renamed from: b, reason: collision with root package name */
        public MessageType f4417b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4418c = false;

        public b(MessageType messagetype) {
            this.f4416a = messagetype;
            this.f4417b = (MessageType) messagetype.a(e.f4422d, null, null);
        }

        @Override // c.c.a.b.f.e.d3
        public final BuilderType a(MessageType messagetype) {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            a(this.f4417b, messagetype);
            return this;
        }

        @Override // c.c.a.b.f.e.f6
        public final boolean b() {
            return s4.a(this.f4417b, false);
        }

        @Override // c.c.a.b.f.e.f6
        public final /* synthetic */ d6 c() {
            return this.f4416a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) this.f4416a.a(e.f4423e, null, null);
            bVar.a((b) H());
            return bVar;
        }

        public void g() {
            MessageType messagetype = (MessageType) this.f4417b.a(e.f4422d, null, null);
            a(messagetype, this.f4417b);
            this.f4417b = messagetype;
        }

        @Override // c.c.a.b.f.e.c6
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public MessageType H() {
            if (this.f4418c) {
                return this.f4417b;
            }
            MessageType messagetype = this.f4417b;
            p6.a().a((p6) messagetype).c(messagetype);
            this.f4418c = true;
            return this.f4417b;
        }

        @Override // c.c.a.b.f.e.c6
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final MessageType F() {
            MessageType messagetype = (MessageType) H();
            if (messagetype.b()) {
                return messagetype;
            }
            throw new l7(messagetype);
        }

        public final BuilderType b(byte[] bArr, int i2, int i3, e4 e4Var) throws c5 {
            if (this.f4418c) {
                g();
                this.f4418c = false;
            }
            try {
                p6.a().a((p6) this.f4417b).a(this.f4417b, bArr, 0, i3 + 0, new j3(e4Var));
                return this;
            } catch (c5 e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            } catch (IndexOutOfBoundsException unused) {
                throw c5.zza();
            }
        }

        public static void a(MessageType messagetype, MessageType messagetype2) {
            p6.a().a((p6) messagetype).b(messagetype, messagetype2);
        }

        @Override // c.c.a.b.f.e.d3
        public final /* synthetic */ d3 a(byte[] bArr, int i2, int i3, e4 e4Var) throws c5 {
            b(bArr, 0, i3, e4Var);
            return this;
        }

        @Override // c.c.a.b.f.e.d3
        public final /* synthetic */ d3 a(byte[] bArr, int i2, int i3) throws c5 {
            b(bArr, 0, i3, e4.a());
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static final class c implements n4<c> {
        @Override // c.c.a.b.f.e.n4
        public final e8 C() {
            throw new NoSuchMethodError();
        }

        @Override // c.c.a.b.f.e.n4
        public final boolean D() {
            throw new NoSuchMethodError();
        }

        @Override // c.c.a.b.f.e.n4
        public final boolean E() {
            throw new NoSuchMethodError();
        }

        @Override // c.c.a.b.f.e.n4
        public final c6 a(c6 c6Var, d6 d6Var) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // c.c.a.b.f.e.n4
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // c.c.a.b.f.e.n4
        public final b8 zzb() {
            throw new NoSuchMethodError();
        }

        @Override // c.c.a.b.f.e.n4
        public final i6 a(i6 i6Var, i6 i6Var2) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends s4<MessageType, BuilderType> implements f6 {
        public l4<c> zzc = l4.g();

        public final l4<c> zza() {
            if (this.zzc.b()) {
                this.zzc = (l4) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public enum e {

        /* renamed from: a, reason: collision with root package name */
        public static final int f4419a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f4420b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f4421c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f4422d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f4423e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final int f4424f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final int f4425g = 7;

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f4426h = {1, 2, 3, 4, 5, 6, 7};

        /* renamed from: i, reason: collision with root package name */
        public static final int f4427i = 1;
        public static final int j = 2;
        public static final int k = 1;
        public static final int l = 2;

        public static int[] a() {
            return (int[]) f4426h.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static class f<ContainingType extends d6, Type> extends f4<ContainingType, Type> {
    }

    public static x4 k() {
        return v4.d();
    }

    public static a5 l() {
        return r5.d();
    }

    public static <E> z4<E> m() {
        return s6.d();
    }

    public abstract Object a(int i2, Object obj, Object obj2);

    @Override // c.c.a.b.f.e.b3
    public final void a(int i2) {
        this.zzc = i2;
    }

    @Override // c.c.a.b.f.e.f6
    public final boolean b() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    @Override // c.c.a.b.f.e.f6
    public final /* synthetic */ d6 c() {
        return (s4) a(e.f4424f, (Object) null, (Object) null);
    }

    @Override // c.c.a.b.f.e.d6
    public final int e() {
        if (this.zzc == -1) {
            this.zzc = p6.a().a((p6) this).d(this);
        }
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return p6.a().a((p6) this).a(this, (s4<MessageType, BuilderType>) obj);
        }
        return false;
    }

    @Override // c.c.a.b.f.e.d6
    public final /* synthetic */ c6 f() {
        b bVar = (b) a(e.f4423e, (Object) null, (Object) null);
        bVar.a((b) this);
        return bVar;
    }

    @Override // c.c.a.b.f.e.b3
    public final int h() {
        return this.zzc;
    }

    public int hashCode() {
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int a2 = p6.a().a((p6) this).a(this);
        this.zza = a2;
        return a2;
    }

    public final <MessageType extends s4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType i() {
        return (BuilderType) a(e.f4423e, (Object) null, (Object) null);
    }

    public final BuilderType j() {
        BuilderType buildertype = (BuilderType) a(e.f4423e, (Object) null, (Object) null);
        buildertype.a(this);
        return buildertype;
    }

    public String toString() {
        return e6.a(this, super.toString());
    }

    @Override // c.c.a.b.f.e.d6
    public final void a(b4 b4Var) throws IOException {
        p6.a().a((p6) this).a((t6) this, (h8) d4.a(b4Var));
    }

    public static <T extends s4<?, ?>> T a(Class<T> cls) {
        s4<?, ?> s4Var = zzd.get(cls);
        if (s4Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                s4Var = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (s4Var == null) {
            s4Var = (T) ((s4) q7.a(cls)).a(e.f4424f, (Object) null, (Object) null);
            if (s4Var != null) {
                zzd.put(cls, s4Var);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) s4Var;
    }

    public static <T extends s4<?, ?>> void a(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    public static Object a(d6 d6Var, String str, Object[] objArr) {
        return new r6(d6Var, str, objArr);
    }

    public static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static final <T extends s4<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(e.f4419a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b2 = p6.a().a((p6) t).b(t);
        if (z) {
            t.a(e.f4420b, b2 ? t : null, null);
        }
        return b2;
    }

    public static a5 a(a5 a5Var) {
        int size = a5Var.size();
        return a5Var.zza(size == 0 ? 10 : size << 1);
    }

    public static <E> z4<E> a(z4<E> z4Var) {
        int size = z4Var.size();
        return z4Var.zza(size == 0 ? 10 : size << 1);
    }

    @Override // c.c.a.b.f.e.d6
    public final /* synthetic */ c6 a() {
        return (b) a(e.f4423e, (Object) null, (Object) null);
    }
}
