package c.c.b.p;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class t implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final URL f6163a;

    /* renamed from: b, reason: collision with root package name */
    public c.c.a.b.j.h<Bitmap> f6164b;

    /* renamed from: c, reason: collision with root package name */
    public volatile InputStream f6165c;

    public t(URL url) {
        this.f6163a = url;
    }

    public static t b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new t(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    public final void a(Executor executor) {
        this.f6164b = c.c.a.b.j.k.a(executor, new Callable(this) { // from class: c.c.b.p.v

            /* renamed from: a, reason: collision with root package name */
            public final t f6167a;

            {
                this.f6167a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6167a.b();
            }
        });
    }

    public final byte[] c() throws IOException {
        URLConnection openConnection = this.f6163a.openConnection();
        if (openConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = openConnection.getInputStream();
        try {
            this.f6165c = inputStream;
            byte[] a2 = c.c.a.b.f.d.i.a(c.c.a.b.f.d.i.a(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                int length = a2.length;
                String valueOf = String.valueOf(this.f6163a);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                sb.append("Downloaded ");
                sb.append(length);
                sb.append(" bytes from ");
                sb.append(valueOf);
                Log.v("FirebaseMessaging", sb.toString());
            }
            if (a2.length <= 1048576) {
                return a2;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    c.c.a.b.f.d.l.a(th, th2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            c.c.a.b.f.d.j.a(this.f6165c);
        } catch (NullPointerException e2) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e2);
        }
    }

    public final c.c.a.b.j.h<Bitmap> a() {
        c.c.a.b.j.h<Bitmap> hVar = this.f6164b;
        c.c.a.b.c.o.r.a(hVar);
        return hVar;
    }

    public final Bitmap b() throws IOException {
        String valueOf = String.valueOf(this.f6163a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        byte[] c2 = c();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(c2, 0, c2.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(this.f6163a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
                Log.d("FirebaseMessaging", sb2.toString());
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(this.f6163a);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }
}
