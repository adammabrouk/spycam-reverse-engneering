package cn.jiguang.ba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.as.d;
import cn.jiguang.e.f;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f8623a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8624b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public long f8625c = 36000000;

    /* renamed from: d, reason: collision with root package name */
    public long f8626d = 900000;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, Pair<InetAddress[], Long>> f8627e = new HashMap();

    public static class a implements Callable<InetAddress[]> {

        /* renamed from: a, reason: collision with root package name */
        public Context f8628a;

        /* renamed from: b, reason: collision with root package name */
        public String f8629b;

        /* renamed from: c, reason: collision with root package name */
        public b f8630c;

        public a(Context context, String str, b bVar) {
            this.f8628a = context;
            this.f8629b = str;
            this.f8630c = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.net.InetAddress[] call() {
            /*
                r14 = this;
                java.lang.String r0 = "DNSLoader"
                r1 = 0
                java.lang.String r2 = r14.f8629b     // Catch: java.net.UnknownHostException -> La
                java.net.InetAddress[] r2 = java.net.InetAddress.getAllByName(r2)     // Catch: java.net.UnknownHostException -> La
                goto L20
            La:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "dns resolve failed:"
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                cn.jiguang.as.d.g(r0, r2)
                r2 = r1
            L20:
                if (r2 == 0) goto Le0
                int r3 = r2.length
                if (r3 <= 0) goto Le0
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                int r5 = r2.length
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
            L34:
                r10 = 1
                if (r7 >= r5) goto L67
                r11 = r2[r7]
                r12 = 3
                if (r8 >= r12) goto L44
                boolean r13 = r11 instanceof java.net.Inet4Address
                if (r13 == 0) goto L44
                int r8 = r8 + 1
            L42:
                r13 = 1
                goto L4e
            L44:
                if (r9 >= r12) goto L4d
                boolean r13 = r11 instanceof java.net.Inet6Address
                if (r13 == 0) goto L4d
                int r9 = r9 + 1
                goto L42
            L4d:
                r13 = 0
            L4e:
                if (r13 == 0) goto L5f
                r3.add(r11)
                java.lang.String r11 = r11.getHostAddress()
                r4.append(r11)
                java.lang.String r11 = ","
                r4.append(r11)
            L5f:
                if (r8 != r12) goto L64
                if (r9 != r12) goto L64
                goto L67
            L64:
                int r7 = r7 + 1
                goto L34
            L67:
                boolean r2 = r3.isEmpty()
                if (r2 != 0) goto Le1
                java.net.InetAddress[] r1 = new java.net.InetAddress[r6]
                java.lang.Object[] r1 = r3.toArray(r1)
                java.net.InetAddress[] r1 = (java.net.InetAddress[]) r1
                long r2 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r7 = "update dns cache url="
                r5.append(r7)
                java.lang.String r7 = r14.f8629b
                r5.append(r7)
                java.lang.String r7 = " resolved="
                r5.append(r7)
                java.lang.String r7 = java.util.Arrays.toString(r1)
                r5.append(r7)
                java.lang.String r5 = r5.toString()
                cn.jiguang.as.d.c(r0, r5)
                cn.jiguang.ba.b r0 = r14.f8630c
                java.util.Map r0 = cn.jiguang.ba.b.a(r0)
                java.lang.String r5 = r14.f8629b
                android.util.Pair r7 = new android.util.Pair
                java.lang.Long r8 = java.lang.Long.valueOf(r2)
                r7.<init>(r1, r8)
                r0.put(r5, r7)
                int r0 = r4.length()     // Catch: java.lang.Throwable -> Le1
                int r0 = r0 - r10
                r4.deleteCharAt(r0)     // Catch: java.lang.Throwable -> Le1
                android.content.Context r0 = r14.f8628a     // Catch: java.lang.Throwable -> Le1
                r5 = 2
                cn.jiguang.f.a[] r5 = new cn.jiguang.f.a[r5]     // Catch: java.lang.Throwable -> Le1
                java.lang.String r7 = r14.f8629b     // Catch: java.lang.Throwable -> Le1
                cn.jiguang.f.a r7 = cn.jiguang.f.a.b(r7)     // Catch: java.lang.Throwable -> Le1
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Le1
                cn.jiguang.f.a r4 = r7.a(r4)     // Catch: java.lang.Throwable -> Le1
                r5[r6] = r4     // Catch: java.lang.Throwable -> Le1
                java.lang.String r4 = r14.f8629b     // Catch: java.lang.Throwable -> Le1
                cn.jiguang.f.a r4 = cn.jiguang.f.a.c(r4)     // Catch: java.lang.Throwable -> Le1
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> Le1
                cn.jiguang.f.a r2 = r4.a(r2)     // Catch: java.lang.Throwable -> Le1
                r5[r10] = r2     // Catch: java.lang.Throwable -> Le1
                cn.jiguang.f.b.a(r0, r5)     // Catch: java.lang.Throwable -> Le1
                goto Le1
            Le0:
                r1 = r2
            Le1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ba.b.a.call():java.net.InetAddress[]");
        }
    }

    private Pair<InetAddress[], Boolean> a(Context context, String str, long j, long j2) {
        InetAddress[] inetAddressArr;
        Pair<InetAddress[], Long> pair = this.f8627e.get(str);
        boolean z = pair == null || pair.first == null;
        long longValue = ((Long) (z ? cn.jiguang.f.b.a(context, cn.jiguang.f.a.c(str)) : pair.second)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > longValue + j) {
            return null;
        }
        if (z) {
            inetAddressArr = a(context, str);
            if (inetAddressArr != null) {
                this.f8627e.put(str, new Pair<>(inetAddressArr, Long.valueOf(longValue)));
            }
        } else {
            inetAddressArr = (InetAddress[]) pair.first;
        }
        if (inetAddressArr != null) {
            return new Pair<>(inetAddressArr, Boolean.valueOf(currentTimeMillis > longValue + j2));
        }
        return null;
    }

    public static b a() {
        if (f8623a == null) {
            synchronized (f8624b) {
                if (f8623a == null) {
                    f8623a = new b();
                }
            }
        }
        return f8623a;
    }

    private InetAddress a(String str) {
        if (f.f(str) || f.g(str)) {
            try {
                return InetAddress.getByName(str);
            } catch (UnknownHostException e2) {
                d.g("DNSLoader", "dns resolve failed:" + e2);
            }
        }
        return null;
    }

    private InetAddress[] a(Context context, String str) {
        String str2 = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.b(str));
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = str2.split(",");
        LinkedList linkedList = new LinkedList();
        for (String str3 : split) {
            InetAddress a2 = a(str3);
            if (a2 != null) {
                linkedList.add(a2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return (InetAddress[]) linkedList.toArray(new InetAddress[0]);
    }

    public InetAddress a(Context context, String str, long j, boolean z) {
        InetAddress[] b2 = b(context, str, j, z);
        if (b2 == null || b2.length <= 0) {
            return null;
        }
        return b2[0];
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public java.net.InetAddress[] b(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r11v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
}
