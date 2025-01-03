package c.c.b.g;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class f<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f5847a;

    /* renamed from: b, reason: collision with root package name */
    public final c<T> f5848b;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public static class b implements c<Context> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends Service> f5849a;

        @Override // c.c.b.g.f.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<String> a(Context context) {
            Bundle a2 = a2(context);
            if (a2 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : a2.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(a2.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        public b(Class<? extends Service> cls) {
            this.f5849a = cls;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        public final Bundle a2(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f5849a), RecyclerView.c0.FLAG_IGNORE);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f5849a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    public interface c<T> {
        List<String> a(T t);
    }

    public f(T t, c<T> cVar) {
        this.f5847a = t;
        this.f5848b = cVar;
    }

    public static f<Context> a(Context context, Class<? extends Service> cls) {
        return new f<>(context, new b(cls));
    }

    public List<h> a() {
        return a(this.f5848b.a(this.f5847a));
    }

    public static List<h> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                Class<?> cls = Class.forName(str);
                if (!h.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
                } else {
                    arrayList.add((h) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e2) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str), e2);
            } catch (IllegalAccessException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str), e3);
            } catch (InstantiationException e4) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str), e4);
            } catch (NoSuchMethodException e5) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str), e5);
            } catch (InvocationTargetException e6) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str), e6);
            }
        }
        return arrayList;
    }
}
