package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import c.c.a.b.c.o.r;
import c.c.a.b.e.e;
import c.c.a.b.e.f;
import c.c.a.b.e.g;
import c.c.a.b.e.h;
import c.c.a.b.e.i;
import c.c.a.b.e.j;
import c.c.a.b.e.k;
import c.c.a.b.e.l;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    public static Boolean f10172b = null;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    public static i f10173c = null;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    public static k f10174d = null;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    public static String f10175e = null;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("DynamiteModule.class")
    public static int f10176f = -1;

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<c> f10177g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    public static final b.a f10178h = new c.c.a.b.e.a();

    /* renamed from: i, reason: collision with root package name */
    public static final b f10179i;
    public static final b j;
    public static final b k;

    /* renamed from: a, reason: collision with root package name */
    public final Context f10180a;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }

        public /* synthetic */ a(String str, c.c.a.b.e.a aVar) {
            this(str);
        }

        public /* synthetic */ a(String str, Throwable th, c.c.a.b.e.a aVar) {
            this(str, th);
        }
    }

    public interface b {

        public interface a {
            int a(Context context, String str);

            int a(Context context, String str, boolean z) throws a;
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b, reason: collision with other inner class name */
        public static class C0159b {

            /* renamed from: a, reason: collision with root package name */
            public int f10181a = 0;

            /* renamed from: b, reason: collision with root package name */
            public int f10182b = 0;

            /* renamed from: c, reason: collision with root package name */
            public int f10183c = 0;
        }

        C0159b a(Context context, String str, a aVar) throws a;
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Cursor f10184a;

        public c() {
        }

        public /* synthetic */ c(c.c.a.b.e.a aVar) {
            this();
        }
    }

    public static class d implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final int f10185a;

        public d(int i2, int i3) {
            this.f10185a = i2;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.b.a
        public final int a(Context context, String str) {
            return this.f10185a;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.b.a
        public final int a(Context context, String str, boolean z) {
            return 0;
        }
    }

    static {
        new c.c.a.b.e.b();
        f10179i = new c.c.a.b.e.c();
        new c.c.a.b.e.d();
        j = new e();
        k = new f();
        new g();
    }

    public DynamiteModule(Context context) {
        r.a(context);
        this.f10180a = context;
    }

    public static DynamiteModule a(Context context, b bVar, String str) throws a {
        c cVar = f10177g.get();
        c.c.a.b.e.a aVar = null;
        c cVar2 = new c(aVar);
        f10177g.set(cVar2);
        try {
            b.C0159b a2 = bVar.a(context, str, f10178h);
            int i2 = a2.f10181a;
            int i3 = a2.f10182b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            if (a2.f10183c == 0 || ((a2.f10183c == -1 && a2.f10181a == 0) || (a2.f10183c == 1 && a2.f10182b == 0))) {
                int i4 = a2.f10181a;
                int i5 = a2.f10182b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i4);
                sb2.append(" and remote version is ");
                sb2.append(i5);
                sb2.append(".");
                throw new a(sb2.toString(), aVar);
            }
            if (a2.f10183c == -1) {
                DynamiteModule c2 = c(context, str);
                Cursor cursor = cVar2.f10184a;
                if (cursor != null) {
                    cursor.close();
                }
                f10177g.set(cVar);
                return c2;
            }
            if (a2.f10183c != 1) {
                int i6 = a2.f10183c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i6);
                throw new a(sb3.toString(), aVar);
            }
            try {
                DynamiteModule a3 = a(context, str, a2.f10182b);
                Cursor cursor2 = cVar2.f10184a;
                if (cursor2 != null) {
                    cursor2.close();
                }
                f10177g.set(cVar);
                return a3;
            } catch (a e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                if (a2.f10181a == 0 || bVar.a(context, str, new d(a2.f10181a, 0)).f10183c != -1) {
                    throw new a("Remote load failed. No local fallback found.", e2, aVar);
                }
                DynamiteModule c3 = c(context, str);
                Cursor cursor3 = cVar2.f10184a;
                if (cursor3 != null) {
                    cursor3.close();
                }
                f10177g.set(cVar);
                return c3;
            }
        } catch (Throwable th) {
            Cursor cursor4 = cVar2.f10184a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f10177g.set(cVar);
            throw th;
        }
    }

    public static int b(Context context, String str, boolean z) {
        i a2 = a(context);
        if (a2 == null) {
            return 0;
        }
        try {
            if (a2.d() >= 2) {
                return a2.a(c.c.a.b.d.b.a(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return a2.b(c.c.a.b.d.b.a(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Type inference failed for: r0v0, types: [c.c.a.b.e.a] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.a {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            int r10 = r8.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r8 == 0) goto L83
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 == 0) goto L83
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 <= 0) goto L7c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.f10175e = r1     // Catch: java.lang.Throwable -> L79
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L79
            if (r1 < 0) goto L67
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.f10176f = r1     // Catch: java.lang.Throwable -> L79
        L67:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$c> r10 = com.google.android.gms.dynamite.DynamiteModule.f10177g     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$c r10 = (com.google.android.gms.dynamite.DynamiteModule.c) r10     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r10 == 0) goto L7c
            android.database.Cursor r1 = r10.f10184a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r1 != 0) goto L7c
            r10.f10184a = r8     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            goto L7d
        L79:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L7c:
            r0 = r8
        L7d:
            if (r0 == 0) goto L82
            r0.close()
        L82:
            return r9
        L83:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$a r9 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L92:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lae
        L96:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9f
        L9b:
            r8 = move-exception
            goto Lae
        L9d:
            r8 = move-exception
            r9 = r0
        L9f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto La4
            throw r8     // Catch: java.lang.Throwable -> Lac
        La4:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lac
            throw r10     // Catch: java.lang.Throwable -> Lac
        Lac:
            r8 = move-exception
            r0 = r9
        Lae:
            if (r0 == 0) goto Lb3
            r0.close()
        Lb3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.c(android.content.Context, java.lang.String, boolean):int");
    }

    public static int b(Context context, String str) {
        return a(context, str, false);
    }

    public static DynamiteModule b(Context context, String str, int i2) throws a, RemoteException {
        k kVar;
        c.c.a.b.d.a a2;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            kVar = f10174d;
        }
        c.c.a.b.e.a aVar = null;
        if (kVar != null) {
            c cVar = f10177g.get();
            if (cVar != null && cVar.f10184a != null) {
                Context applicationContext = context.getApplicationContext();
                Cursor cursor = cVar.f10184a;
                c.c.a.b.d.b.a((Object) null);
                if (a().booleanValue()) {
                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                    a2 = kVar.b(c.c.a.b.d.b.a(applicationContext), str, i2, c.c.a.b.d.b.a(cursor));
                } else {
                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                    a2 = kVar.a(c.c.a.b.d.b.a(applicationContext), str, i2, c.c.a.b.d.b.a(cursor));
                }
                Context context2 = (Context) c.c.a.b.d.b.a(a2);
                if (context2 != null) {
                    return new DynamiteModule(context2);
                }
                throw new a("Failed to get module context", aVar);
            }
            throw new a("No result cursor", aVar);
        }
        throw new a("DynamiteLoaderV2 was not cached.", aVar);
    }

    public static DynamiteModule c(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int a(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = f10172b;
                if (bool2 == null) {
                    try {
                        loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = loadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool2 = Boolean.FALSE;
                    }
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    a(classLoader);
                                } catch (a unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int c2 = c(context, str, z);
                                if (f10175e != null && !f10175e.isEmpty()) {
                                    h hVar = new h(f10175e, ClassLoader.getSystemClassLoader());
                                    a(hVar);
                                    declaredField.set(null, hVar);
                                    f10172b = Boolean.TRUE;
                                    return c2;
                                }
                                return c2;
                            } catch (a unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        bool2 = bool;
                        f10172b = bool2;
                    }
                }
                if (bool2.booleanValue()) {
                    try {
                        return c(context, str, z);
                    } catch (a e3) {
                        String valueOf2 = String.valueOf(e3.getMessage());
                        Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                return b(context, str, z);
            }
        } catch (Throwable th) {
            c.c.a.b.c.s.g.a(context, th);
            throw th;
        }
    }

    public static DynamiteModule a(Context context, String str, int i2) throws a {
        Boolean bool;
        c.c.a.b.d.a b2;
        c.c.a.b.e.a aVar = null;
        try {
            synchronized (DynamiteModule.class) {
                bool = f10172b;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    return b(context, str, i2);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                i a2 = a(context);
                if (a2 != null) {
                    if (a2.d() >= 2) {
                        b2 = a2.a(c.c.a.b.d.b.a(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        b2 = a2.b(c.c.a.b.d.b.a(context), str, i2);
                    }
                    if (c.c.a.b.d.b.a(b2) != null) {
                        return new DynamiteModule((Context) c.c.a.b.d.b.a(b2));
                    }
                    throw new a("Failed to load remote module.", aVar);
                }
                throw new a("Failed to create IDynamiteLoader.", aVar);
            }
            throw new a("Failed to determine which loading route to use.", aVar);
        } catch (RemoteException e2) {
            throw new a("Failed to load remote module.", e2, aVar);
        } catch (a e3) {
            throw e3;
        } catch (Throwable th) {
            c.c.a.b.c.s.g.a(context, th);
            throw new a("Failed to load remote module.", th, aVar);
        }
    }

    public static i a(Context context) {
        i jVar;
        synchronized (DynamiteModule.class) {
            if (f10173c != null) {
                return f10173c;
            }
            if (c.c.a.b.c.d.a().b(context) != 0) {
                return null;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    jVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof i) {
                        jVar = (i) queryLocalInterface;
                    } else {
                        jVar = new j(iBinder);
                    }
                }
                if (jVar != null) {
                    f10173c = jVar;
                    return jVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    public static Boolean a() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f10176f >= 2);
        }
        return valueOf;
    }

    @GuardedBy("DynamiteModule.class")
    public static void a(ClassLoader classLoader) throws a {
        k lVar;
        c.c.a.b.e.a aVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                lVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof k) {
                    lVar = (k) queryLocalInterface;
                } else {
                    lVar = new l(iBinder);
                }
            }
            f10174d = lVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new a("Failed to instantiate dynamite loader", e2, aVar);
        }
    }

    public final IBinder a(String str) throws a {
        try {
            return (IBinder) this.f10180a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            throw new a(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }
}
