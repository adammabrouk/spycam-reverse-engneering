package cn.jiguang.aa;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.l.d;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f8110a;

    /* renamed from: b, reason: collision with root package name */
    public String f8111b = d.g("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVv4Y6EB33Z8c96zLnz4UMIR2tR6ldXn18NaPke3N1cdFQ==");

    public a(IBinder iBinder) {
        this.f8110a = iBinder;
    }

    public String a(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f8111b);
            this.f8110a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } finally {
            try {
                return str;
            } finally {
            }
        }
        return str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
