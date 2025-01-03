package cn.jiguang.s;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.l.d;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f9046a;

    /* renamed from: b, reason: collision with root package name */
    public String f9047b;

    public a(IBinder iBinder) {
        this.f9047b = "";
        this.f9046a = iBinder;
        this.f9047b = d.g("8lAhWp7NB89J3VIJU4lIGfGqvEuhZG7tBjI4IuOrU/y3j/vpb/c+G/Rylr/l3ZwQ");
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f9047b);
            this.f9046a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                cn.jiguang.ai.a.d("AsusAdvertisingInterface", "get ids-o e: " + th.getMessage());
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
        return this.f9046a;
    }
}
