package c.c.a.a.j.t;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class k implements e {

    /* renamed from: a, reason: collision with root package name */
    public final a f3625a;

    /* renamed from: b, reason: collision with root package name */
    public final i f3626b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, m> f3627c;

    public k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    @Override // c.c.a.a.j.t.e
    public synchronized m a(String str) {
        if (this.f3627c.containsKey(str)) {
            return this.f3627c.get(str);
        }
        d a2 = this.f3625a.a(str);
        if (a2 == null) {
            return null;
        }
        m create = a2.create(this.f3626b.a(str));
        this.f3627c.put(str, create);
        return create;
    }

    public k(a aVar, i iVar) {
        this.f3627c = new HashMap();
        this.f3625a = aVar;
        this.f3626b = iVar;
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f3628a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f3629b = null;

        public a(Context context) {
            this.f3628a = context;
        }

        public static Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), RecyclerView.c0.FLAG_IGNORE);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        public d a(String str) {
            String str2 = a().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str2).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e2);
                return null;
            } catch (IllegalAccessException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e3);
                return null;
            } catch (InstantiationException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e4);
                return null;
            } catch (NoSuchMethodException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e6);
                return null;
            }
        }

        public final Map<String, String> a() {
            if (this.f3629b == null) {
                this.f3629b = a(this.f3628a);
            }
            return this.f3629b;
        }

        public final Map<String, String> a(Context context) {
            Bundle b2 = b(context);
            if (b2 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : b2.keySet()) {
                Object obj = b2.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String trim = str2.trim();
                        if (!trim.isEmpty()) {
                            hashMap.put(trim, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }
    }
}
