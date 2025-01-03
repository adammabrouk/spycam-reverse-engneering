package c.k.b.c;

import android.text.TextUtils;
import c.k.d.v9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* loaded from: classes.dex */
public class g {
    public static c.k.b.a.c a(c.k.b.a.c cVar, String str) {
        long[] m16a;
        if (cVar == null || (m16a = m16a(str)) == null) {
            return null;
        }
        cVar.f6768i = m16a[0];
        cVar.j = m16a[1];
        return cVar;
    }

    public static c.k.b.a.c a(String str) {
        c.k.b.a.c cVar = null;
        try {
            String[] m17a = m17a(str);
            if (m17a == null || m17a.length < 4 || TextUtils.isEmpty(m17a[0]) || TextUtils.isEmpty(m17a[1]) || TextUtils.isEmpty(m17a[2]) || TextUtils.isEmpty(m17a[3])) {
                return null;
            }
            cVar = c.k.b.a.c.c();
            cVar.f6769a = Integer.parseInt(m17a[0]);
            cVar.f6770b = m17a[1];
            cVar.f6771c = Integer.parseInt(m17a[2]);
            cVar.f6767h = Integer.parseInt(m17a[3]);
            return cVar;
        } catch (Exception unused) {
            c.k.a.a.a.c.c("parse per key error");
            return cVar;
        }
    }

    public static String a(c.k.b.a.c cVar) {
        return cVar.f6769a + "#" + cVar.f6770b + "#" + cVar.f6771c + "#" + cVar.f6767h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* renamed from: a, reason: collision with other method in class */
    public static HashMap<String, String> m15a(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = null;
        ?? r1 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader3.readLine();
                        if (readLine == null) {
                            break;
                        }
                        ?? split = readLine.split("%%%");
                        r1 = split.length;
                        if (r1 >= 2) {
                            r1 = 0;
                            r1 = 0;
                            if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                r1 = split[0];
                                hashMap.put(r1, split[1]);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader3;
                        c.k.a.a.a.c.a(e);
                        v9.a(bufferedReader2);
                        bufferedReader = bufferedReader2;
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        v9.a(bufferedReader);
                        throw th;
                    }
                }
                v9.a(bufferedReader3);
                bufferedReader = r1;
            } catch (Exception e3) {
                e = e3;
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d5, code lost:
    
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.b.c.g.a(android.content.Context, java.lang.String):java.util.List");
    }

    public static void a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e2;
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception e3) {
            bufferedWriter = null;
            e2 = e3;
        } catch (Throwable th2) {
            bufferedWriter = null;
            th = th2;
            v9.a(bufferedWriter);
            throw th;
        }
        try {
            try {
                for (String str2 : hashMap.keySet()) {
                    bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                    bufferedWriter.newLine();
                }
            } catch (Throwable th3) {
                th = th3;
                v9.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
            c.k.a.a.a.c.a(e2);
            v9.a(bufferedWriter);
        }
        v9.a(bufferedWriter);
    }

    public static void a(String str, c.k.b.a.d[] dVarArr) {
        RandomAccessFile randomAccessFile;
        if (dVarArr == null || dVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            v9.m513a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> m15a = m15a(str);
                for (c.k.b.a.d dVar : dVarArr) {
                    if (dVar != null) {
                        String a2 = a((c.k.b.a.c) dVar);
                        long j = ((c.k.b.a.c) dVar).f6768i;
                        long j2 = ((c.k.b.a.c) dVar).j;
                        if (!TextUtils.isEmpty(a2) && j > 0 && j2 >= 0) {
                            a(m15a, a2, j, j2);
                        }
                    }
                }
                a(str, m15a);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        e = e2;
                        c.k.a.a.a.c.a(e);
                        v9.a(randomAccessFile);
                    }
                }
            } catch (Throwable unused) {
                try {
                    c.k.a.a.a.c.c("failed to write perf to file ");
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            e = e3;
                            c.k.a.a.a.c.a(e);
                            v9.a(randomAccessFile);
                        }
                    }
                    v9.a(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            c.k.a.a.a.c.a(e4);
                        }
                    }
                    v9.a(randomAccessFile);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        v9.a(randomAccessFile);
    }

    public static void a(HashMap<String, String> hashMap, String str, long j, long j2) {
        StringBuilder sb;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
        } else {
            long[] m16a = m16a(str2);
            if (m16a == null || m16a[0] <= 0 || m16a[1] < 0) {
                sb = new StringBuilder();
            } else {
                j += m16a[0];
                j2 += m16a[1];
                sb = new StringBuilder();
            }
        }
        sb.append(j);
        sb.append("#");
        sb.append(j2);
        hashMap.put(str, sb.toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public static long[] m16a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e2) {
            c.k.a.a.a.c.a(e2);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String[] m17a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }
}
