package cn.jiguang.ae;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.l.d;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f8131a;

    /* renamed from: b, reason: collision with root package name */
    public String f8132b = d.g("Mpy0fkBSw1N+kug2cBPj2Z07jpK2SYpu9oSV4B2lEuO7ZdtoaGwNjuH9BjHR80mN");

    public a(IBinder iBinder) {
        this.f8131a = iBinder;
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f8132b);
            this.f8131a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                cn.jiguang.ai.a.d("ZuiAdvertisingInterface", "get Ids-o error: " + th.getMessage());
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
