package cn.jiguang.t;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.l.d;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f9049a;

    /* renamed from: b, reason: collision with root package name */
    public String f9050b;

    public a(IBinder iBinder) {
        this.f9050b = "";
        this.f9049a = iBinder;
        this.f9050b = d.g("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjKewmlEeKVcapnVp59DHSw2ZuSa3pDDty/LQ1R0HbmN4Tu7alH/m3nVMfORBLpozB8=");
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f9050b);
            this.f9049a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                cn.jiguang.ai.a.d("AdvertisingInterface", "getId error: " + th.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
