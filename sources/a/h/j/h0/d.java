package a.h.j.h0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1186a;

    /* compiled from: AccessibilityNodeProviderCompat.java */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        public final d f1187a;

        public a(d dVar) {
            this.f1187a = dVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            a.h.j.h0.c a2 = this.f1187a.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.z();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            List<a.h.j.h0.c> a2 = this.f1187a.a(str, i2);
            if (a2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(a2.get(i3).z());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f1187a.a(i2, i3, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    public static class b extends a {
        public b(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i2) {
            a.h.j.h0.c b2 = this.f1187a.b(i2);
            if (b2 == null) {
                return null;
            }
            return b2.z();
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    public static class c extends b {
        public c(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f1187a.a(i2, a.h.j.h0.c.a(accessibilityNodeInfo), str, bundle);
        }
    }

    public d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f1186a = new c(this);
            return;
        }
        if (i2 >= 19) {
            this.f1186a = new b(this);
        } else if (i2 >= 16) {
            this.f1186a = new a(this);
        } else {
            this.f1186a = null;
        }
    }

    public a.h.j.h0.c a(int i2) {
        return null;
    }

    public Object a() {
        return this.f1186a;
    }

    public List<a.h.j.h0.c> a(String str, int i2) {
        return null;
    }

    public void a(int i2, a.h.j.h0.c cVar, String str, Bundle bundle) {
    }

    public boolean a(int i2, int i3, Bundle bundle) {
        return false;
    }

    public a.h.j.h0.c b(int i2) {
        return null;
    }

    public d(Object obj) {
        this.f1186a = obj;
    }
}
