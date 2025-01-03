package c.k.b.c;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import c.k.d.e6;
import c.k.d.k0;
import c.k.d.o0;
import c.k.d.v9;
import cn.jpush.android.api.InAppSlotParams;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public Context f6795a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, ArrayList<c.k.b.a.d>> f6796b;

    public c(Context context) {
        a(context);
    }

    public static String a(c.k.b.a.d dVar) {
        return String.valueOf(dVar.f6769a);
    }

    public String a(byte[] bArr) {
        byte[] a2;
        if (bArr != null && bArr.length >= 1) {
            if (!c.k.b.b.b.a(this.f6795a).m10a().d()) {
                return k0.a(bArr);
            }
            String a3 = o0.a(this.f6795a);
            if (!TextUtils.isEmpty(a3) && (a2 = o0.a(a3)) != null && a2.length > 0) {
                try {
                    return k0.a(Base64.decode(e6.a(a2, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
                    c.k.a.a.a.c.a(e2);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x003a, code lost:
    
        c.k.a.a.a.c.d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
    
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
        r4 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> a(java.lang.String r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            byte[] r2 = new byte[r1]
            byte[] r3 = new byte[r1]
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
        L15:
            int r9 = r5.read(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4 = -1
            if (r9 != r4) goto L1d
            goto L66
        L1d:
            java.lang.String r6 = "eventData read from cache file failed because magicNumber error"
            if (r9 == r1) goto L25
        L21:
            c.k.a.a.a.c.d(r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L66
        L25:
            int r9 = c.k.d.d.a(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r7 = -573785174(0xffffffffddccbbaa, float:-1.84407149E18)
            if (r9 == r7) goto L2f
            goto L21
        L2f:
            int r9 = r5.read(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r9 != r4) goto L36
            goto L66
        L36:
            if (r9 == r1) goto L3e
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
        L3a:
            c.k.a.a.a.c.d(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L66
        L3e:
            int r9 = c.k.d.d.a(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4 = 1
            if (r9 < r4) goto L63
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 <= r4) goto L4a
            goto L63
        L4a:
            byte[] r4 = new byte[r9]     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            int r6 = r5.read(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r6 == r9) goto L55
            java.lang.String r9 = "eventData read from cache file failed cause buffer size not equal length"
            goto L3a
        L55:
            java.lang.String r9 = r8.a(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r4 != 0) goto L15
            r0.add(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L15
        L63:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            goto L3a
        L66:
            c.k.d.v9.a(r5)
            goto L79
        L6a:
            r9 = move-exception
            r4 = r5
            goto L7a
        L6d:
            r9 = move-exception
            r4 = r5
            goto L73
        L70:
            r9 = move-exception
            goto L7a
        L72:
            r9 = move-exception
        L73:
            c.k.a.a.a.c.a(r9)     // Catch: java.lang.Throwable -> L70
            c.k.d.v9.a(r4)
        L79:
            return r0
        L7a:
            c.k.d.v9.a(r4)
            goto L7f
        L7e:
            throw r9
        L7f:
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.b.c.c.a(java.lang.String):java.util.List");
    }

    @Override // c.k.b.c.e
    public void a() {
        int i2;
        RandomAccessFile randomAccessFile;
        o0.a(this.f6795a, InAppSlotParams.SLOT_KEY.EVENT, "eventUploading");
        File[] m317a = o0.m317a(this.f6795a, "eventUploading");
        if (m317a == null || m317a.length <= 0) {
            return;
        }
        int length = m317a.length;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file = null;
        while (i2 < length) {
            File file2 = m317a[i2];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        c.k.a.a.a.c.a(e2);
                    }
                }
                v9.a(randomAccessFile2);
                i2 = file == null ? i2 + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                if (file2.length() > 5242880) {
                    c.k.a.a.a.c.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                    a(file2.getName(), Formatter.formatFileSize(this.f6795a, file2.length()));
                    file2.delete();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            c.k.a.a.a.c.a(e4);
                        }
                    }
                    v9.a(randomAccessFile2);
                    if (file == null) {
                    }
                    file.delete();
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    File file3 = new File(absolutePath + ".lock");
                    try {
                        v9.m513a(file3);
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                    } catch (Exception e5) {
                        e = e5;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        a(a(absolutePath));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                c.k.a.a.a.c.a(e6);
                            }
                        }
                        v9.a(randomAccessFile);
                        file3.delete();
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                    } catch (Exception e7) {
                        e = e7;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        c.k.a.a.a.c.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e8) {
                                c.k.a.a.a.c.a(e8);
                            }
                        }
                        v9.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e9) {
                                c.k.a.a.a.c.a(e9);
                            }
                        }
                        v9.a(randomAccessFile2);
                        if (file == null) {
                            throw th;
                        }
                        file.delete();
                        throw th;
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.f6795a = context;
    }

    @Override // c.k.b.c.f
    /* renamed from: a, reason: collision with other method in class */
    public void mo13a(c.k.b.a.d dVar) {
        if ((dVar instanceof c.k.b.a.b) && this.f6796b != null) {
            c.k.b.a.b bVar = (c.k.b.a.b) dVar;
            String a2 = a((c.k.b.a.d) bVar);
            ArrayList<c.k.b.a.d> arrayList = this.f6796b.get(a2);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(bVar);
            this.f6796b.put(a2, arrayList);
        }
    }

    public final void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e2) {
                c.k.a.a.a.c.a(e2);
            }
        }
        v9.a(randomAccessFile);
    }

    public final void a(String str, String str2) {
        c.k.b.a.b a2 = c.k.b.b.b.a(this.f6795a).a(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2.b());
        a(arrayList);
    }

    public void a(List<String> list) {
        throw null;
    }

    public void a(c.k.b.a.d[] dVarArr) {
        if (dVarArr == null || dVarArr.length == 0 || dVarArr[0] == null) {
            c.k.a.a.a.c.m6a("event data write to cache file failed because data null");
            return;
        }
        do {
            dVarArr = m14a(dVarArr);
            if (dVarArr == null || dVarArr.length <= 0) {
                return;
            }
        } while (dVarArr[0] != null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public final c.k.b.a.d[] m14a(c.k.b.a.d[] dVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String b2 = b(dVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            File file = new File(b2 + ".lock");
            v9.m513a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b2), true));
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    v9.a(bufferedOutputStream2);
                    a(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileLock = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            try {
                int i2 = 0;
                for (c.k.b.a.d dVar : dVarArr) {
                    if (dVar != null) {
                        byte[] b3 = b(dVar.b());
                        if (b3 != null && b3.length >= 1 && b3.length <= 4096) {
                            if (!o0.a(this.f6795a, b2)) {
                                int length = dVarArr.length - i2;
                                c.k.b.a.d[] dVarArr2 = new c.k.b.a.d[length];
                                System.arraycopy(dVarArr, i2, dVarArr2, 0, length);
                                v9.a(bufferedOutputStream);
                                a(randomAccessFile, fileLock);
                                return dVarArr2;
                            }
                            bufferedOutputStream.write(c.k.d.d.a(-573785174));
                            bufferedOutputStream.write(c.k.d.d.a(b3.length));
                            bufferedOutputStream.write(b3);
                            bufferedOutputStream.flush();
                            i2++;
                        }
                        c.k.a.a.a.c.d("event data throw a invalid item ");
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream2 = bufferedOutputStream;
                v9.a(bufferedOutputStream2);
                a(randomAccessFile, fileLock);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            c.k.a.a.a.c.a("event data write to cache file failed cause exception", e);
            v9.a(bufferedOutputStream);
            a(randomAccessFile, fileLock);
            return null;
        }
        v9.a(bufferedOutputStream);
        a(randomAccessFile, fileLock);
        return null;
    }

    public final String b(c.k.b.a.d dVar) {
        File externalFilesDir = this.f6795a.getExternalFilesDir(InAppSlotParams.SLOT_KEY.EVENT);
        String a2 = a(dVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a2;
        for (int i2 = 0; i2 < 100; i2++) {
            String str2 = str + i2;
            if (o0.a(this.f6795a, str2)) {
                return str2;
            }
        }
        return null;
    }

    @Override // c.k.b.c.f
    public void b() {
        HashMap<String, ArrayList<c.k.b.a.d>> hashMap = this.f6796b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f6796b.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<c.k.b.a.d> arrayList = this.f6796b.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    c.k.b.a.d[] dVarArr = new c.k.b.a.d[arrayList.size()];
                    arrayList.toArray(dVarArr);
                    a(dVarArr);
                }
            }
        }
        this.f6796b.clear();
    }

    @Override // c.k.b.c.a
    public void b(HashMap<String, ArrayList<c.k.b.a.d>> hashMap) {
        this.f6796b = hashMap;
    }

    public byte[] b(String str) {
        byte[] a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!c.k.b.b.b.a(this.f6795a).m10a().d()) {
            return k0.m260a(str);
        }
        String a3 = o0.a(this.f6795a);
        byte[] m260a = k0.m260a(str);
        if (!TextUtils.isEmpty(a3) && m260a != null && m260a.length > 1 && (a2 = o0.a(a3)) != null) {
            try {
                if (a2.length > 1) {
                    return e6.b(a2, Base64.encode(m260a, 2));
                }
            } catch (Exception e2) {
                c.k.a.a.a.c.a(e2);
            }
        }
        return null;
    }
}
