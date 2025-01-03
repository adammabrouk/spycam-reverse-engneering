package cn.jiguang.ad;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.l.d;

/* loaded from: classes.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: cn.jiguang.ad.c$a$a, reason: collision with other inner class name */
        public static class C0132a implements c {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f8130a;

            public C0132a(IBinder iBinder) {
                this.f8130a = iBinder;
            }

            @Override // cn.jiguang.ad.c
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(d.g("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0="));
                    this.f8130a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Throwable th) {
                    try {
                        cn.jiguang.ai.a.d("ZTEOAID", "getOAID obtain exception:" + th.getMessage());
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8130a;
            }

            @Override // cn.jiguang.ad.c
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z = false;
                try {
                    obtain.writeInterfaceToken(d.g("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0="));
                    this.f8130a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                } finally {
                    try {
                        return z;
                    } finally {
                    }
                }
                return z;
            }
        }
    }

    String a();

    boolean b();
}
