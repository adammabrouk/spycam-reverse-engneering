package c.k.d.p9;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.e6;
import c.k.d.h8;
import c.k.d.k9;
import c.k.d.v9;
import c.k.d.z6;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f7650a = new Object();

    public static void a(Context context, z6 z6Var) {
        if (l0.a(z6Var.e())) {
            c.k.d.j.a(context).a(new n0(context, z6Var));
        }
    }

    public static byte[] a(Context context) {
        String a2 = k9.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = c.k.d.k0.a(20);
            k9.a(context).m269a("mipush", "td_key", a2);
        }
        return a(a2);
    }

    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(c.k.d.h0.m185a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void c(Context context, z6 z6Var) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str;
        String str2;
        ?? a2 = a(context);
        try {
            try {
                byte[] b2 = e6.b(a2, h8.a(z6Var));
                if (b2 != null && b2.length >= 1) {
                    if (b2.length > 10240) {
                        str2 = "TinyData write to cache file failed case too much data content item:" + z6Var.d() + "  ts:" + System.currentTimeMillis();
                        c.k.a.a.a.c.m6a(str2);
                        v9.a((Closeable) null);
                        v9.a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(c.k.d.d.a(b2.length));
                        bufferedOutputStream3.write(b2);
                        bufferedOutputStream3.flush();
                        v9.a((Closeable) null);
                        v9.a(bufferedOutputStream3);
                        return;
                    } catch (IOException e2) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e2;
                        str = "TinyData write to cache file failed cause io exception item:" + z6Var.d();
                        a2 = bufferedOutputStream2;
                        c.k.a.a.a.c.a(str, e);
                        v9.a((Closeable) null);
                        v9.a((Closeable) a2);
                        return;
                    } catch (Exception e3) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e3;
                        str = "TinyData write to cache file  failed item:" + z6Var.d();
                        a2 = bufferedOutputStream;
                        c.k.a.a.a.c.a(str, e);
                        v9.a((Closeable) null);
                        v9.a((Closeable) a2);
                        return;
                    } catch (Throwable th) {
                        a2 = bufferedOutputStream3;
                        th = th;
                        v9.a((Closeable) null);
                        v9.a((Closeable) a2);
                        throw th;
                    }
                }
                str2 = "TinyData write to cache file failed case encryption fail item:" + z6Var.d() + "  ts:" + System.currentTimeMillis();
                c.k.a.a.a.c.m6a(str2);
                v9.a((Closeable) null);
                v9.a((Closeable) null);
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream2 = null;
            } catch (Exception e5) {
                e = e5;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                a2 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
