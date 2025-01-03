package com.google.android.gms.common.images;

import a.e.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import c.c.a.b.f.b.d;
import com.google.android.gms.common.annotation.KeepName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class ImageManager {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f10065i = new Object();
    public static HashSet<Uri> j = new HashSet<>();

    /* renamed from: a, reason: collision with root package name */
    public final Context f10066a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f10067b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f10068c;

    /* renamed from: d, reason: collision with root package name */
    public final a f10069d;

    /* renamed from: e, reason: collision with root package name */
    public final d f10070e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<c.c.a.b.c.n.a, ImageReceiver> f10071f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<Uri, ImageReceiver> f10072g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<Uri, Long> f10073h;

    @KeepName
    public final class ImageReceiver extends ResultReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f10074a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<c.c.a.b.c.n.a> f10075b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageManager f10076c;

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i2, Bundle bundle) {
            this.f10076c.f10068c.execute(this.f10076c.new b(this.f10074a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public static final class a extends e<c.c.a.b.c.n.b, Bitmap> {
    }

    public final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f10077a;

        /* renamed from: b, reason: collision with root package name */
        public final ParcelFileDescriptor f10078b;

        public b(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f10077a = uri;
            this.f10078b = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            Bitmap bitmap;
            c.c.a.b.c.o.b.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.f10078b;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e2) {
                    String valueOf = String.valueOf(this.f10077a);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e2);
                    z2 = true;
                }
                try {
                    this.f10078b.close();
                } catch (IOException e3) {
                    Log.e("ImageManager", "closed failed", e3);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.f10067b.post(ImageManager.this.new c(this.f10077a, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.f10077a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f10080a;

        /* renamed from: b, reason: collision with root package name */
        public final Bitmap f10081b;

        /* renamed from: c, reason: collision with root package name */
        public final CountDownLatch f10082c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10083d;

        public c(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f10080a = uri;
            this.f10081b = bitmap;
            this.f10083d = z;
            this.f10082c = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.c.a.b.c.o.b.a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f10081b != null;
            if (ImageManager.this.f10069d != null) {
                if (this.f10083d) {
                    ImageManager.this.f10069d.a();
                    System.gc();
                    this.f10083d = false;
                    ImageManager.this.f10067b.post(this);
                    return;
                }
                if (z) {
                    ImageManager.this.f10069d.a(new c.c.a.b.c.n.b(this.f10080a), this.f10081b);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f10072g.remove(this.f10080a);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.f10075b;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c.c.a.b.c.n.a aVar = (c.c.a.b.c.n.a) arrayList.get(i2);
                    if (z) {
                        aVar.a(ImageManager.this.f10066a, this.f10081b, false);
                    } else {
                        ImageManager.this.f10073h.put(this.f10080a, Long.valueOf(SystemClock.elapsedRealtime()));
                        aVar.a(ImageManager.this.f10066a, ImageManager.this.f10070e, false);
                    }
                    ImageManager.this.f10071f.remove(aVar);
                }
            }
            this.f10082c.countDown();
            synchronized (ImageManager.f10065i) {
                ImageManager.j.remove(this.f10080a);
            }
        }
    }
}
