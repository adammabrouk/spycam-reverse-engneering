package cn.jiguang.e;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class h {
    public static <T> LinkedList<T> a(Collection<T> collection) {
        LinkedList<T> linkedList = new LinkedList<>();
        int i2 = 0;
        int size = collection != null ? collection.size() : 0;
        if (size == 0) {
            return linkedList;
        }
        if (size == 1) {
            linkedList.addAll(collection);
            return linkedList;
        }
        SecureRandom secureRandom = new SecureRandom();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            i2++;
            linkedList.add(secureRandom.nextInt(i2), it.next());
        }
        return linkedList;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(long j, long j2) {
        if (j2 <= 0) {
            throw new AssertionError();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j <= 0 || elapsedRealtime <= j || elapsedRealtime > j + j2;
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(byteArrayOutputStream);
            a(gZIPOutputStream);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            a(byteArrayOutputStream);
            a(gZIPOutputStream2);
            throw th;
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            a(byteArrayOutputStream2);
            throw th;
        }
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th2) {
            gZIPInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr2 = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    a((Closeable) byteArrayInputStream);
                    a((Closeable) gZIPInputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            a(byteArrayOutputStream);
            a((Closeable) byteArrayInputStream);
            a((Closeable) gZIPInputStream);
            throw th;
        }
    }

    public static short c(byte[] bArr) {
        int i2;
        if (bArr == null || bArr.length == 0) {
            throw new Exception("byte could not be empty");
        }
        if (bArr.length == 1) {
            i2 = bArr[0];
        } else {
            i2 = ((short) (bArr[1] & ThreadUtils.TYPE_SINGLE)) | ((short) ((bArr[0] & ThreadUtils.TYPE_SINGLE) << 8));
        }
        return (short) i2;
    }
}
