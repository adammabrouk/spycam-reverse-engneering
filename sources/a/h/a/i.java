package a.h.a;

import a.h.a.g;
import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f911a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static Field f912b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f913c;

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f911a) {
            if (f913c) {
                return null;
            }
            try {
                if (f912b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f913c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f912b = declaredField;
                }
                Bundle bundle = (Bundle) f912b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f912b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f913c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f913c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, g.a aVar) {
        IconCompat e2 = aVar.e();
        builder.addAction(e2 != null ? e2.b() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }

    public static Bundle a(g.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat e2 = aVar.e();
        bundle2.putInt("icon", e2 != null ? e2.b() : 0);
        bundle2.putCharSequence("title", aVar.i());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.h());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    public static Bundle a(l lVar) {
        new Bundle();
        lVar.a();
        throw null;
    }

    public static Bundle[] a(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[lVarArr.length];
        if (lVarArr.length <= 0) {
            return bundleArr;
        }
        a(lVarArr[0]);
        throw null;
    }
}
