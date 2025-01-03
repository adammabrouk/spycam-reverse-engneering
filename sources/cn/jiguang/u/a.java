package cn.jiguang.u;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.l.d;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f9053a;

    /* renamed from: b, reason: collision with root package name */
    public String f9054b = d.g("axDZqud6H+CDQBXA/yBXOryhAsxzPh1PgN4N991nACfTSsXdCfZsE70k+cjPDPVB6dhHsO0zfFF8mVkwxeVKdQ==");

    public a(IBinder iBinder) {
        this.f9053a = iBinder;
    }

    public String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken(this.f9054b);
                this.f9053a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e2) {
                cn.jiguang.ai.a.d("HuaweiAdvertisingInterface", "getIds error: " + e2.getMessage());
                obtain2.recycle();
                obtain.recycle();
                str = "";
            }
            return str;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
