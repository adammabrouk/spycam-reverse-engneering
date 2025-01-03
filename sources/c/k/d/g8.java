package c.k.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class g8 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f7182a;

        public a(String str, boolean z) {
            this.f7182a = str;
        }

        public String a() {
            return this.f7182a;
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7183a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f7184b;

        public b() {
            this.f7183a = false;
            this.f7184b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f7183a) {
                throw new IllegalStateException();
            }
            this.f7183a = true;
            return this.f7184b.poll(30000L, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f7184b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class c implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        public IBinder f7185a;

        public c(IBinder iBinder) {
            this.f7185a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f7185a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f7185a;
        }
    }

    public static a a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    try {
                        IBinder a2 = bVar.a();
                        if (a2 != null) {
                            return new a(new c(a2).a(), false);
                        }
                    } finally {
                        context.unbindService(bVar);
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e3) {
            throw e3;
        }
    }
}
