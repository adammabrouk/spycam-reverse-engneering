package cn.jiguang.z;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.l.d;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f9075a;

    /* renamed from: b, reason: collision with root package name */
    public String f9076b;

    /* renamed from: c, reason: collision with root package name */
    public String f9077c = d.g("bFWKQsRzI9d+ktdqxw44MA==");

    /* renamed from: d, reason: collision with root package name */
    public String f9078d = d.g("vWw3rdN6/HN94yy83HO8Lw==");

    /* renamed from: e, reason: collision with root package name */
    public String f9079e = d.g("Ha7IUc4OlbRIQFpw3FJeZw==");

    /* renamed from: f, reason: collision with root package name */
    public String f9080f = d.g("qFFOesfckPwVmbfqzGl5oBCLe9WD17E04n+Ic7C9fCw=");

    public a(IBinder iBinder) {
        this.f9075a = iBinder;
    }

    private String a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f9080f);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f9075a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                cn.jiguang.ai.a.d("OppoAdvertisingInterface", "getIdByType error: " + th.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private String b(Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(this.f9076b)) {
            Signature[] signatureArr = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                cn.jiguang.ai.a.d("OppoAdvertisingInterface", "packageName: " + packageName + " getPackageInfo error: " + e2.getMessage());
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & ThreadUtils.TYPE_SINGLE) | RecyclerView.c0.FLAG_TMP_DETACHED).substring(1, 3));
                        }
                        this.f9076b = sb.toString();
                    }
                } catch (Throwable th) {
                    cn.jiguang.ai.a.d("OppoAdvertisingInterface", "package sign error: " + th.getMessage());
                }
            }
        }
        return this.f9076b;
    }

    public String a(Context context) {
        return context == null ? "" : a(context.getPackageName(), b(context), this.f9077c);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
