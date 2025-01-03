package a.h.j;

import a.h.j.h0.c;
import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f1109c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f1110a;

    /* renamed from: b, reason: collision with root package name */
    public final View.AccessibilityDelegate f1111b;

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: a.h.j.a$a, reason: collision with other inner class name */
    public static final class C0026a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final a f1112a;

        public C0026a(a aVar) {
            this.f1112a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f1112a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            a.h.j.h0.d a2 = this.f1112a.a(view);
            if (a2 != null) {
                return (AccessibilityNodeProvider) a2.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1112a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            a.h.j.h0.c a2 = a.h.j.h0.c.a(accessibilityNodeInfo);
            a2.k(y.M(view));
            a2.i(y.H(view));
            a2.f(y.f(view));
            a2.h(y.z(view));
            this.f1112a.a(view, a2);
            a2.a(accessibilityNodeInfo.getText(), view);
            List<c.a> b2 = a.b(view);
            for (int i2 = 0; i2 < b2.size(); i2++) {
                a2.a(b2.get(i2));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1112a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f1112a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f1112a.a(view, i2, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.f1112a.a(view, i2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f1112a.d(view, accessibilityEvent);
        }
    }

    public a() {
        this(f1109c);
    }

    public View.AccessibilityDelegate a() {
        return this.f1111b;
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.f1110a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1110a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.f1110a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f1110a = accessibilityDelegate;
        this.f1111b = new C0026a(this);
    }

    public static List<c.a> b(View view) {
        List<c.a> list = (List) view.getTag(R$id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    public void a(View view, int i2) {
        this.f1110a.sendAccessibilityEvent(view, i2);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1110a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, a.h.j.h0.c cVar) {
        this.f1110a.onInitializeAccessibilityNodeInfo(view, cVar.z());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1110a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public a.h.j.h0.d a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f1110a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new a.h.j.h0.d(accessibilityNodeProvider);
    }

    public boolean a(View view, int i2, Bundle bundle) {
        List<c.a> b2 = b(view);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= b2.size()) {
                break;
            }
            c.a aVar = b2.get(i3);
            if (aVar.a() == i2) {
                z = aVar.a(view, bundle);
                break;
            }
            i3++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.f1110a.performAccessibilityAction(view, i2, bundle);
        }
        return (z || i2 != R$id.accessibility_action_clickable_span) ? z : a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public final boolean a(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public final boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] j = a.h.j.h0.c.j(view.createAccessibilityNodeInfo().getText());
            for (int i2 = 0; j != null && i2 < j.length; i2++) {
                if (clickableSpan.equals(j[i2])) {
                    return true;
                }
            }
        }
        return false;
    }
}
