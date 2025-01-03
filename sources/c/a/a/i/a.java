package c.a.a.i;

import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final File f2950a;

    /* renamed from: b, reason: collision with root package name */
    public final File f2951b;

    /* renamed from: c, reason: collision with root package name */
    public final File f2952c;

    /* renamed from: d, reason: collision with root package name */
    public final File f2953d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2954e;

    /* renamed from: f, reason: collision with root package name */
    public long f2955f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2956g;

    /* renamed from: i, reason: collision with root package name */
    public Writer f2958i;
    public int k;

    /* renamed from: h, reason: collision with root package name */
    public long f2957h = 0;
    public final LinkedHashMap<String, c> j = new LinkedHashMap<>(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> n = new CallableC0062a();

    /* compiled from: DiskLruCache.java */
    /* renamed from: c.a.a.i.a$a, reason: collision with other inner class name */
    public class CallableC0062a implements Callable<Void> {
        public CallableC0062a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.f2958i == null) {
                    return null;
                }
                a.this.m();
                if (a.this.c()) {
                    a.this.l();
                    a.this.k = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public final c f2960a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f2961b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2962c;

        public /* synthetic */ b(a aVar, c cVar, CallableC0062a callableC0062a) {
            this(cVar);
        }

        public void c() throws IOException {
            a.this.a(this, true);
            this.f2962c = true;
        }

        public b(c cVar) {
            this.f2960a = cVar;
            this.f2961b = cVar.f2968e ? null : new boolean[a.this.f2956g];
        }

        public File a(int i2) throws IOException {
            File b2;
            synchronized (a.this) {
                if (this.f2960a.f2969f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f2960a.f2968e) {
                    this.f2961b[i2] = true;
                }
                b2 = this.f2960a.b(i2);
                if (!a.this.f2950a.exists()) {
                    a.this.f2950a.mkdirs();
                }
            }
            return b2;
        }

        public void b() {
            if (this.f2962c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f2964a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f2965b;

        /* renamed from: c, reason: collision with root package name */
        public File[] f2966c;

        /* renamed from: d, reason: collision with root package name */
        public File[] f2967d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2968e;

        /* renamed from: f, reason: collision with root package name */
        public b f2969f;

        /* renamed from: g, reason: collision with root package name */
        public long f2970g;

        public /* synthetic */ c(a aVar, String str, CallableC0062a callableC0062a) {
            this(str);
        }

        public c(String str) {
            this.f2964a = str;
            this.f2965b = new long[a.this.f2956g];
            this.f2966c = new File[a.this.f2956g];
            this.f2967d = new File[a.this.f2956g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f2956g; i2++) {
                sb.append(i2);
                this.f2966c[i2] = new File(a.this.f2950a, sb.toString());
                sb.append(".tmp");
                this.f2967d[i2] = new File(a.this.f2950a, sb.toString());
                sb.setLength(length);
            }
        }

        public final void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.f2956g) {
                a(strArr);
                throw null;
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    this.f2965b[i2] = Long.parseLong(strArr[i2]);
                } catch (NumberFormatException unused) {
                    a(strArr);
                    throw null;
                }
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f2965b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i2) {
            return this.f2967d[i2];
        }

        public final IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i2) {
            return this.f2966c[i2];
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final File[] f2972a;

        public /* synthetic */ d(a aVar, String str, long j, File[] fileArr, long[] jArr, CallableC0062a callableC0062a) {
            this(str, j, fileArr, jArr);
        }

        public File a(int i2) {
            return this.f2972a[i2];
        }

        public d(String str, long j, File[] fileArr, long[] jArr) {
            this.f2972a = fileArr;
        }
    }

    public a(File file, int i2, int i3, long j) {
        this.f2950a = file;
        this.f2954e = i2;
        this.f2951b = new File(file, "journal");
        this.f2952c = new File(file, "journal.tmp");
        this.f2953d = new File(file, "journal.bkp");
        this.f2956g = i3;
        this.f2955f = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f2958i == null) {
            return;
        }
        Iterator it = new ArrayList(this.j.values()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f2969f != null) {
                cVar.f2969f.a();
            }
        }
        m();
        this.f2958i.close();
        this.f2958i = null;
    }

    public final void g() throws IOException {
        c.a.a.i.b bVar = new c.a.a.i.b(new FileInputStream(this.f2951b), c.a.a.i.c.f2980a);
        try {
            String c2 = bVar.c();
            String c3 = bVar.c();
            String c4 = bVar.c();
            String c5 = bVar.c();
            String c6 = bVar.c();
            if (!"libcore.io.DiskLruCache".equals(c2) || !"1".equals(c3) || !Integer.toString(this.f2954e).equals(c4) || !Integer.toString(this.f2956g).equals(c5) || !"".equals(c6)) {
                throw new IOException("unexpected journal header: [" + c2 + ", " + c3 + ", " + c5 + ", " + c6 + "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    d(bVar.c());
                    i2++;
                } catch (EOFException unused) {
                    this.k = i2 - this.j.size();
                    if (bVar.b()) {
                        l();
                    } else {
                        this.f2958i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2951b, true), c.a.a.i.c.f2980a));
                    }
                    c.a.a.i.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            c.a.a.i.c.a(bVar);
            throw th;
        }
    }

    public final synchronized void l() throws IOException {
        if (this.f2958i != null) {
            this.f2958i.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2952c), c.a.a.i.c.f2980a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(OSSUtils.NEW_LINE);
            bufferedWriter.write("1");
            bufferedWriter.write(OSSUtils.NEW_LINE);
            bufferedWriter.write(Integer.toString(this.f2954e));
            bufferedWriter.write(OSSUtils.NEW_LINE);
            bufferedWriter.write(Integer.toString(this.f2956g));
            bufferedWriter.write(OSSUtils.NEW_LINE);
            bufferedWriter.write(OSSUtils.NEW_LINE);
            for (c cVar : this.j.values()) {
                if (cVar.f2969f != null) {
                    bufferedWriter.write("DIRTY " + cVar.f2964a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.f2964a + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f2951b.exists()) {
                a(this.f2951b, this.f2953d, true);
            }
            a(this.f2952c, this.f2951b, false);
            this.f2953d.delete();
            this.f2958i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2951b, true), c.a.a.i.c.f2980a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    public final void m() throws IOException {
        while (this.f2957h > this.f2955f) {
            e(this.j.entrySet().iterator().next().getKey());
        }
    }

    public b b(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized d c(String str) throws IOException {
        a();
        c cVar = this.j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f2968e) {
            return null;
        }
        for (File file : cVar.f2966c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.f2958i.append((CharSequence) "READ");
        this.f2958i.append(' ');
        this.f2958i.append((CharSequence) str);
        this.f2958i.append('\n');
        if (c()) {
            this.m.submit(this.n);
        }
        return new d(this, str, cVar.f2970g, cVar.f2966c, cVar.f2965b, null);
    }

    public final void d(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i2);
        if (indexOf2 == -1) {
            substring = str.substring(i2);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i2, indexOf2);
        }
        c cVar = this.j.get(substring);
        CallableC0062a callableC0062a = null;
        if (cVar == null) {
            cVar = new c(this, substring, callableC0062a);
            this.j.put(substring, cVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(LogUtils.PLACEHOLDER);
            cVar.f2968e = true;
            cVar.f2969f = null;
            cVar.b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            cVar.f2969f = new b(this, cVar, callableC0062a);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final void e() throws IOException {
        a(this.f2952c);
        Iterator<c> it = this.j.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.f2969f == null) {
                while (i2 < this.f2956g) {
                    this.f2957h += next.f2965b[i2];
                    i2++;
                }
            } else {
                next.f2969f = null;
                while (i2 < this.f2956g) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public void b() throws IOException {
        close();
        c.a.a.i.c.a(this.f2950a);
    }

    public static a a(File file, int i2, int i3, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j);
            if (aVar.f2951b.exists()) {
                try {
                    aVar.g();
                    aVar.e();
                    return aVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.b();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j);
            aVar2.l();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public synchronized boolean e(String str) throws IOException {
        a();
        c cVar = this.j.get(str);
        if (cVar != null && cVar.f2969f == null) {
            for (int i2 = 0; i2 < this.f2956g; i2++) {
                File a2 = cVar.a(i2);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.f2957h -= cVar.f2965b[i2];
                cVar.f2965b[i2] = 0;
            }
            this.k++;
            this.f2958i.append((CharSequence) "REMOVE");
            this.f2958i.append(' ');
            this.f2958i.append((CharSequence) str);
            this.f2958i.append('\n');
            this.j.remove(str);
            if (c()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public final boolean c() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.j.size();
    }

    public static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized b a(String str, long j) throws IOException {
        a();
        c cVar = this.j.get(str);
        CallableC0062a callableC0062a = null;
        if (j != -1 && (cVar == null || cVar.f2970g != j)) {
            return null;
        }
        if (cVar != null) {
            if (cVar.f2969f != null) {
                return null;
            }
        } else {
            cVar = new c(this, str, callableC0062a);
            this.j.put(str, cVar);
        }
        b bVar = new b(this, cVar, callableC0062a);
        cVar.f2969f = bVar;
        this.f2958i.append((CharSequence) "DIRTY");
        this.f2958i.append(' ');
        this.f2958i.append((CharSequence) str);
        this.f2958i.append('\n');
        this.f2958i.flush();
        return bVar;
    }

    public final synchronized void a(b bVar, boolean z) throws IOException {
        c cVar = bVar.f2960a;
        if (cVar.f2969f == bVar) {
            if (z && !cVar.f2968e) {
                for (int i2 = 0; i2 < this.f2956g; i2++) {
                    if (bVar.f2961b[i2]) {
                        if (!cVar.b(i2).exists()) {
                            bVar.a();
                            return;
                        }
                    } else {
                        bVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f2956g; i3++) {
                File b2 = cVar.b(i3);
                if (z) {
                    if (b2.exists()) {
                        File a2 = cVar.a(i3);
                        b2.renameTo(a2);
                        long j = cVar.f2965b[i3];
                        long length = a2.length();
                        cVar.f2965b[i3] = length;
                        this.f2957h = (this.f2957h - j) + length;
                    }
                } else {
                    a(b2);
                }
            }
            this.k++;
            cVar.f2969f = null;
            if (!(cVar.f2968e | z)) {
                this.j.remove(cVar.f2964a);
                this.f2958i.append((CharSequence) "REMOVE");
                this.f2958i.append(' ');
                this.f2958i.append((CharSequence) cVar.f2964a);
                this.f2958i.append('\n');
            } else {
                cVar.f2968e = true;
                this.f2958i.append((CharSequence) "CLEAN");
                this.f2958i.append(' ');
                this.f2958i.append((CharSequence) cVar.f2964a);
                this.f2958i.append((CharSequence) cVar.a());
                this.f2958i.append('\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    cVar.f2970g = j2;
                }
            }
            this.f2958i.flush();
            if (this.f2957h > this.f2955f || c()) {
                this.m.submit(this.n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final void a() {
        if (this.f2958i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
}
