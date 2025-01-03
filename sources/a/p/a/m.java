package a.p.a;

import a.h.j.y;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class m extends a.h.j.a {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f1687d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1688e;

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    public static class a extends a.h.j.a {

        /* renamed from: d, reason: collision with root package name */
        public final m f1689d;

        /* renamed from: e, reason: collision with root package name */
        public Map<View, a.h.j.a> f1690e = new WeakHashMap();

        public a(m mVar) {
            this.f1689d = mVar;
        }

        @Override // a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            if (this.f1689d.c() || this.f1689d.f1687d.getLayoutManager() == null) {
                super.a(view, cVar);
                return;
            }
            this.f1689d.f1687d.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, cVar);
            a.h.j.a aVar = this.f1690e.get(view);
            if (aVar != null) {
                aVar.a(view, cVar);
            } else {
                super.a(view, cVar);
            }
        }

        @Override // a.h.j.a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            a.h.j.a aVar = this.f1690e.get(view);
            if (aVar != null) {
                aVar.b(view, accessibilityEvent);
            } else {
                super.b(view, accessibilityEvent);
            }
        }

        public a.h.j.a c(View view) {
            return this.f1690e.remove(view);
        }

        public void d(View view) {
            a.h.j.a b2 = y.b(view);
            if (b2 == null || b2 == this) {
                return;
            }
            this.f1690e.put(view, b2);
        }

        @Override // a.h.j.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            a.h.j.a aVar = this.f1690e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                super.c(view, accessibilityEvent);
            }
        }

        @Override // a.h.j.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            a.h.j.a aVar = this.f1690e.get(view);
            if (aVar != null) {
                aVar.d(view, accessibilityEvent);
            } else {
                super.d(view, accessibilityEvent);
            }
        }

        @Override // a.h.j.a
        public boolean a(View view, int i2, Bundle bundle) {
            if (!this.f1689d.c() && this.f1689d.f1687d.getLayoutManager() != null) {
                a.h.j.a aVar = this.f1690e.get(view);
                if (aVar != null) {
                    if (aVar.a(view, i2, bundle)) {
                        return true;
                    }
                } else if (super.a(view, i2, bundle)) {
                    return true;
                }
                return this.f1689d.f1687d.getLayoutManager().performAccessibilityActionForItem(view, i2, bundle);
            }
            return super.a(view, i2, bundle);
        }

        @Override // a.h.j.a
        public void a(View view, int i2) {
            a.h.j.a aVar = this.f1690e.get(view);
            if (aVar != null) {
                aVar.a(view, i2);
            } else {
                super.a(view, i2);
            }
        }

        @Override // a.h.j.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            a.h.j.a aVar = this.f1690e.get(view);
            if (aVar != null) {
                return aVar.a(view, accessibilityEvent);
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // a.h.j.a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            a.h.j.a aVar = this.f1690e.get(viewGroup);
            if (aVar != null) {
                return aVar.a(viewGroup, view, accessibilityEvent);
            }
            return super.a(viewGroup, view, accessibilityEvent);
        }

        @Override // a.h.j.a
        public a.h.j.h0.d a(View view) {
            a.h.j.a aVar = this.f1690e.get(view);
            if (aVar != null) {
                return aVar.a(view);
            }
            return super.a(view);
        }
    }

    public m(RecyclerView recyclerView) {
        this.f1687d = recyclerView;
        a.h.j.a b2 = b();
        if (b2 == null || !(b2 instanceof a)) {
            this.f1688e = new a(this);
        } else {
            this.f1688e = (a) b2;
        }
    }

    @Override // a.h.j.a
    public boolean a(View view, int i2, Bundle bundle) {
        if (super.a(view, i2, bundle)) {
            return true;
        }
        if (c() || this.f1687d.getLayoutManager() == null) {
            return false;
        }
        return this.f1687d.getLayoutManager().performAccessibilityAction(i2, bundle);
    }

    @Override // a.h.j.a
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || c()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public boolean c() {
        return this.f1687d.hasPendingAdapterUpdates();
    }

    @Override // a.h.j.a
    public void a(View view, a.h.j.h0.c cVar) {
        super.a(view, cVar);
        if (c() || this.f1687d.getLayoutManager() == null) {
            return;
        }
        this.f1687d.getLayoutManager().onInitializeAccessibilityNodeInfo(cVar);
    }

    public a.h.j.a b() {
        return this.f1688e;
    }
}
