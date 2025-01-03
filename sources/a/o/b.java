package a.o;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: MultiDexExtractor.java */
/* loaded from: classes.dex */
public final class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final File f1569a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1570b;

    /* renamed from: c, reason: collision with root package name */
    public final File f1571c;

    /* renamed from: d, reason: collision with root package name */
    public final RandomAccessFile f1572d;

    /* renamed from: e, reason: collision with root package name */
    public final FileChannel f1573e;

    /* renamed from: f, reason: collision with root package name */
    public final FileLock f1574f;

    /* compiled from: MultiDexExtractor.java */
    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* compiled from: MultiDexExtractor.java */
    /* renamed from: a.o.b$b, reason: collision with other inner class name */
    public static class C0046b extends File {
        public long crc;

        public C0046b(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    public b(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f1569a = file;
        this.f1571c = file2;
        this.f1570b = b(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f1572d = randomAccessFile;
        try {
            this.f1573e = randomAccessFile.getChannel();
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f1574f = this.f1573e.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                a(this.f1573e);
                throw e;
            } catch (Error e3) {
                e = e3;
                a(this.f1573e);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                a(this.f1573e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            a(this.f1572d);
            throw e5;
        }
    }

    public static long b(File file) throws IOException {
        long a2 = c.a(file);
        return a2 == -1 ? a2 - 1 : a2;
    }

    public List<? extends File> a(Context context, String str, boolean z) throws IOException {
        List<C0046b> b2;
        List<C0046b> list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f1569a.getPath() + ", " + z + ", " + str + ")");
        if (!this.f1574f.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z && !a(context, this.f1569a, this.f1570b, str)) {
            try {
                list = a(context, str);
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                b2 = b();
                a(context, str, a(this.f1569a), this.f1570b, b2);
            }
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        if (z) {
            Log.i("MultiDex", "Forced extraction must be performed.");
        } else {
            Log.i("MultiDex", "Detected that extraction must be performed.");
        }
        b2 = b();
        a(context, str, a(this.f1569a), this.f1570b, b2);
        list = b2;
        Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
        return list;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1574f.release();
        this.f1573e.close();
        this.f1572d.close();
    }

    public final List<C0046b> b() throws IOException {
        boolean z;
        String str = this.f1569a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f1569a);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i2 = 2;
            while (entry != null) {
                C0046b c0046b = new C0046b(this.f1571c, str + i2 + ".zip");
                arrayList.add(c0046b);
                Log.i("MultiDex", "Extraction is needed for file " + c0046b);
                int i3 = 0;
                boolean z2 = false;
                while (i3 < 3 && !z2) {
                    int i4 = i3 + 1;
                    a(zipFile, entry, c0046b, str);
                    try {
                        c0046b.crc = b(c0046b);
                        z = true;
                    } catch (IOException e2) {
                        Log.w("MultiDex", "Failed to read crc from " + c0046b.getAbsolutePath(), e2);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(c0046b.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(c0046b.length());
                    sb.append(" - crc: ");
                    sb.append(c0046b.crc);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        c0046b.delete();
                        if (c0046b.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + c0046b.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i3 = i4;
                }
                if (!z2) {
                    throw new IOException("Could not create zip file " + c0046b.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
                i2++;
                entry = zipFile.getEntry("classes" + i2 + ".dex");
            }
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            return arrayList;
        } finally {
        }
    }

    public final List<C0046b> a(Context context, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f1569a.getName() + ".classes";
        SharedPreferences a2 = a(context);
        int i2 = a2.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + (-1));
        int i3 = 2;
        while (i3 <= i2) {
            C0046b c0046b = new C0046b(this.f1571c, str2 + i3 + ".zip");
            if (c0046b.isFile()) {
                c0046b.crc = b(c0046b);
                long j = a2.getLong(str + "dex.crc." + i3, -1L);
                long j2 = a2.getLong(str + "dex.time." + i3, -1L);
                long lastModified = c0046b.lastModified();
                if (j2 == lastModified) {
                    String str3 = str2;
                    SharedPreferences sharedPreferences = a2;
                    if (j == c0046b.crc) {
                        arrayList.add(c0046b);
                        i3++;
                        a2 = sharedPreferences;
                        str2 = str3;
                    }
                }
                throw new IOException("Invalid extracted dex: " + c0046b + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + c0046b.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + c0046b.getPath() + "'");
        }
        return arrayList;
    }

    public static boolean a(Context context, File file, long j, String str) {
        SharedPreferences a2 = a(context);
        if (a2.getLong(str + "timestamp", -1L) == a(file)) {
            if (a2.getLong(str + "crc", -1L) == j) {
                return false;
            }
        }
        return true;
    }

    public static long a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    public static void a(Context context, String str, long j, long j2, List<C0046b> list) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (C0046b c0046b : list) {
            edit.putLong(str + "dex.crc." + i2, c0046b.crc);
            edit.putLong(str + "dex.time." + i2, c0046b.lastModified());
            i2++;
        }
        edit.commit();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public final void a() {
        File[] listFiles = this.f1571c.listFiles(new a());
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f1571c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    Log.i("MultiDex", "Renaming to " + file.getPath());
                    if (createTempFile.renameTo(file)) {
                        return;
                    }
                    throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            a(inputStream);
            createTempFile.delete();
        }
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }
}
