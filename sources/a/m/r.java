package a.m;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: SavedStateHandle.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f1528e;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f1529a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, SavedStateRegistry.b> f1530b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Object<?>> f1531c;

    /* renamed from: d, reason: collision with root package name */
    public final SavedStateRegistry.b f1532d;

    /* compiled from: SavedStateHandle.java */
    public class a implements SavedStateRegistry.b {
        public a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            for (Map.Entry entry : new HashMap(r.this.f1530b).entrySet()) {
                r.this.a((String) entry.getKey(), (String) ((SavedStateRegistry.b) entry.getValue()).a());
            }
            Set<String> keySet = r.this.f1529a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(r.this.f1529a.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        clsArr[4] = Integer.TYPE;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        clsArr[27] = Build.VERSION.SDK_INT >= 21 ? Size.class : Integer.TYPE;
        clsArr[28] = Build.VERSION.SDK_INT >= 21 ? SizeF.class : Integer.TYPE;
        f1528e = clsArr;
    }

    public r(Map<String, Object> map) {
        this.f1530b = new HashMap();
        this.f1531c = new HashMap();
        this.f1532d = new a();
        this.f1529a = new HashMap(map);
    }

    public static r a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new r();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new r(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            hashMap.put((String) parcelableArrayList.get(i2), parcelableArrayList2.get(i2));
        }
        return new r(hashMap);
    }

    public r() {
        this.f1530b = new HashMap();
        this.f1531c = new HashMap();
        this.f1532d = new a();
        this.f1529a = new HashMap();
    }

    public SavedStateRegistry.b a() {
        return this.f1532d;
    }

    public <T> void a(String str, T t) {
        a(t);
        n nVar = (n) this.f1531c.get(str);
        if (nVar != null) {
            nVar.a((n) t);
        } else {
            this.f1529a.put(str, t);
        }
    }

    public static void a(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : f1528e) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }
}
