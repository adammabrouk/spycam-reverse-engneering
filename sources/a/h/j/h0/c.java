package a.h.j.h0;

import a.h.j.h0.f;
import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static int f1170d;

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f1171a;

    /* renamed from: b, reason: collision with root package name */
    public int f1172b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f1173c = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1174e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f1175f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f1176g;

        /* renamed from: h, reason: collision with root package name */
        public static final a f1177h;

        /* renamed from: i, reason: collision with root package name */
        public static final a f1178i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;

        /* renamed from: a, reason: collision with root package name */
        public final Object f1179a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1180b;

        /* renamed from: c, reason: collision with root package name */
        public final Class<? extends f.a> f1181c;

        /* renamed from: d, reason: collision with root package name */
        public final f f1182d;

        static {
            new a(4, null);
            new a(8, null);
            f1176g = new a(16, null);
            new a(32, null);
            new a(64, null);
            new a(RecyclerView.c0.FLAG_IGNORE, null);
            new a(RecyclerView.c0.FLAG_TMP_DETACHED, null, f.b.class);
            new a(512, null, f.b.class);
            new a(1024, null, f.c.class);
            new a(2048, null, f.c.class);
            f1177h = new a(4096, null);
            f1178i = new a(8192, null);
            new a(16384, null);
            new a(32768, null);
            new a(65536, null);
            new a(OSSConstants.DEFAULT_STREAM_BUFFER_SIZE, null, f.g.class);
            j = new a(262144, null);
            k = new a(524288, null);
            l = new a(MemoryConstants.MB, null);
            new a(2097152, null, f.h.class);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, f.e.class);
            m = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            n = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            o = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, f.C0029f.class);
            new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, f.d.class);
            new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f1179a).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f1179a).getLabel();
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f1179a;
            return obj2 == null ? aVar.f1179a == null : obj2.equals(aVar.f1179a);
        }

        public int hashCode() {
            Object obj = this.f1179a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i2, CharSequence charSequence, Class<? extends f.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        public boolean a(View view, Bundle bundle) {
            if (this.f1182d == null) {
                return false;
            }
            f.a aVar = null;
            Class<? extends f.a> cls = this.f1181c;
            if (cls != null) {
                try {
                    f.a newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        newInstance.a(bundle);
                        aVar = newInstance;
                    } catch (Exception e2) {
                        e = e2;
                        aVar = newInstance;
                        Class<? extends f.a> cls2 = this.f1181c;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? LogUtils.NULL : cls2.getName()), e);
                        return this.f1182d.a(view, aVar);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            return this.f1182d.a(view, aVar);
        }

        public a(Object obj, int i2, CharSequence charSequence, f fVar, Class<? extends f.a> cls) {
            this.f1180b = i2;
            this.f1182d = fVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f1179a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.f1179a = obj;
            }
            this.f1181c = cls;
        }

        public a a(CharSequence charSequence, f fVar) {
            return new a(null, this.f1180b, charSequence, fVar, this.f1181c);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: a.h.j.h0.c$c, reason: collision with other inner class name */
    public static class C0028c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1184a;

        public C0028c(Object obj) {
            this.f1184a = obj;
        }

        public static C0028c a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            int i6 = Build.VERSION.SDK_INT;
            return i6 >= 21 ? new C0028c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2)) : i6 >= 19 ? new C0028c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z)) : new C0028c(null);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1185a;

        public d(Object obj) {
            this.f1185a = obj;
        }

        public static d a(int i2, float f2, float f3, float f4) {
            return Build.VERSION.SDK_INT >= 19 ? new d(AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4)) : new d(null);
        }
    }

    public c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1171a = accessibilityNodeInfo;
    }

    public static c A() {
        return a(AccessibilityNodeInfo.obtain());
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static String d(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case RecyclerView.c0.FLAG_IGNORE /* 128 */:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case RecyclerView.c0.FLAG_TMP_DETACHED /* 256 */:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case OSSConstants.DEFAULT_STREAM_BUFFER_SIZE /* 131072 */:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionImeEnter:
                return "ACTION_IME_ENTER";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static c g(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f1171a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1179a);
        }
        return false;
    }

    public void c(View view, int i2) {
        this.f1173c = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1171a.setSource(view, i2);
        }
    }

    public int d() {
        return this.f1171a.getChildCount();
    }

    public void e(View view) {
        this.f1172b = -1;
        this.f1171a.setParent(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1171a;
        if (accessibilityNodeInfo == null) {
            if (cVar.f1171a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f1171a)) {
            return false;
        }
        return this.f1173c == cVar.f1173c && this.f1172b == cVar.f1172b;
    }

    public void f(View view) {
        this.f1173c = -1;
        this.f1171a.setSource(view);
    }

    public void h(boolean z) {
        this.f1171a.setFocused(z);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1171a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public CharSequence i() {
        if (!k()) {
            return this.f1171a.getText();
        }
        List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1171a.getText(), 0, this.f1171a.getText().length()));
        for (int i2 = 0; i2 < a2.size(); i2++) {
            spannableString.setSpan(new a.h.j.h0.a(a5.get(i2).intValue(), this, g().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i2).intValue(), a3.get(i2).intValue(), a4.get(i2).intValue());
        }
        return spannableString;
    }

    public void j(boolean z) {
        this.f1171a.setLongClickable(z);
    }

    public final boolean k() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public boolean l() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1171a.isAccessibilityFocused();
        }
        return false;
    }

    public boolean m() {
        return this.f1171a.isCheckable();
    }

    public boolean n() {
        return this.f1171a.isChecked();
    }

    public void o(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1171a.setVisibleToUser(z);
        }
    }

    public boolean p() {
        return this.f1171a.isEnabled();
    }

    public boolean q() {
        return this.f1171a.isFocusable();
    }

    public boolean r() {
        return this.f1171a.isFocused();
    }

    public boolean s() {
        return this.f1171a.isLongClickable();
    }

    public boolean t() {
        return this.f1171a.isPassword();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(h());
        sb.append("; className: ");
        sb.append(e());
        sb.append("; text: ");
        sb.append(i());
        sb.append("; contentDescription: ");
        sb.append(f());
        sb.append("; viewId: ");
        sb.append(j());
        sb.append("; checkable: ");
        sb.append(m());
        sb.append("; checked: ");
        sb.append(n());
        sb.append("; focusable: ");
        sb.append(q());
        sb.append("; focused: ");
        sb.append(r());
        sb.append("; selected: ");
        sb.append(v());
        sb.append("; clickable: ");
        sb.append(o());
        sb.append("; longClickable: ");
        sb.append(s());
        sb.append("; enabled: ");
        sb.append(p());
        sb.append("; password: ");
        sb.append(t());
        sb.append("; scrollable: " + u());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> b2 = b();
            for (int i2 = 0; i2 < b2.size(); i2++) {
                a aVar = b2.get(i2);
                String d2 = d(aVar.a());
                if (d2.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    d2 = aVar.b().toString();
                }
                sb.append(d2);
                if (i2 != b2.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int c2 = c();
            while (c2 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(c2);
                c2 &= numberOfTrailingZeros ^ (-1);
                sb.append(d(numberOfTrailingZeros));
                if (c2 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean u() {
        return this.f1171a.isScrollable();
    }

    public boolean v() {
        return this.f1171a.isSelected();
    }

    public boolean w() {
        return Build.VERSION.SDK_INT >= 26 ? this.f1171a.isShowingHintText() : b(4);
    }

    public boolean x() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1171a.isVisibleToUser();
        }
        return false;
    }

    public void y() {
        this.f1171a.recycle();
    }

    public AccessibilityNodeInfo z() {
        return this.f1171a;
    }

    public static c a(c cVar) {
        return a(AccessibilityNodeInfo.obtain(cVar.f1171a));
    }

    public static ClickableSpan[] j(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public void d(Rect rect) {
        this.f1171a.setBoundsInScreen(rect);
    }

    public void g(boolean z) {
        this.f1171a.setFocusable(z);
    }

    public CharSequence h() {
        return this.f1171a.getPackageName();
    }

    public void k(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1171a.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    public void m(boolean z) {
        this.f1171a.setSelected(z);
    }

    public void n(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1171a.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public void a(View view) {
        this.f1171a.addChild(view);
    }

    public void b(View view, int i2) {
        this.f1172b = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1171a.setParent(view, i2);
        }
    }

    public void d(boolean z) {
        this.f1171a.setChecked(z);
    }

    public void e(boolean z) {
        this.f1171a.setClickable(z);
    }

    public void f(boolean z) {
        this.f1171a.setEnabled(z);
    }

    public Bundle g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f1171a.getExtras();
        }
        return new Bundle();
    }

    public void h(CharSequence charSequence) {
        if (a.h.f.a.a()) {
            this.f1171a.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f1171a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void l(boolean z) {
        this.f1171a.setScrollable(z);
    }

    public boolean o() {
        return this.f1171a.isClickable();
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1183a;

        public b(Object obj) {
            this.f1183a = obj;
        }

        public static b a(int i2, int i3, boolean z, int i4) {
            int i5 = Build.VERSION.SDK_INT;
            return i5 >= 21 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4)) : i5 >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z)) : new b(null);
        }

        public static b a(int i2, int i3, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z));
            }
            return new b(null);
        }
    }

    public void a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1171a.addChild(view, i2);
        }
    }

    public int c() {
        return this.f1171a.getActions();
    }

    public final void d(View view) {
        SparseArray<WeakReference<ClickableSpan>> c2 = c(view);
        if (c2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < c2.size(); i2++) {
                if (c2.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                c2.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    public void e(CharSequence charSequence) {
        this.f1171a.setPackageName(charSequence);
    }

    public CharSequence f() {
        return this.f1171a.getContentDescription();
    }

    @Deprecated
    public void c(Rect rect) {
        this.f1171a.setBoundsInParent(rect);
    }

    public CharSequence e() {
        return this.f1171a.getClassName();
    }

    public void f(CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f1171a.setPaneTitle(charSequence);
        } else if (i2 >= 19) {
            this.f1171a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public String j() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f1171a.getViewIdResourceName();
        }
        return null;
    }

    public void a(int i2) {
        this.f1171a.addAction(i2);
    }

    public void b(Rect rect) {
        this.f1171a.getBoundsInScreen(rect);
    }

    public void c(boolean z) {
        this.f1171a.setCheckable(z);
    }

    public void g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1171a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public final List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f1171a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f1171a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final SparseArray<WeakReference<ClickableSpan>> b(View view) {
        SparseArray<WeakReference<ClickableSpan>> c2 = c(view);
        if (c2 != null) {
            return c2;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R$id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public final SparseArray<WeakReference<ClickableSpan>> c(View view) {
        return (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
    }

    public void c(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1171a.setError(charSequence);
        }
    }

    public void b(CharSequence charSequence) {
        this.f1171a.setContentDescription(charSequence);
    }

    public void c(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1171a.setMaxTextLength(i2);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1171a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0028c) obj).f1184a);
        }
    }

    public void d(CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f1171a.setHintText(charSequence);
        } else if (i2 >= 19) {
            this.f1171a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1171a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1179a);
        }
    }

    public boolean a(int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1171a.performAction(i2, bundle);
        }
        return false;
    }

    public List<a> b() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f1171a.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new a(actionList.get(i2)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void i(CharSequence charSequence) {
        this.f1171a.setText(charSequence);
    }

    public void i(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1171a.setHeading(z);
        } else {
            a(2, z);
        }
    }

    @Deprecated
    public void a(Rect rect) {
        this.f1171a.getBoundsInParent(rect);
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1171a.setAccessibilityFocused(z);
        }
    }

    public void a(CharSequence charSequence) {
        this.f1171a.setClassName(charSequence);
    }

    public void a(CharSequence charSequence, View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 26) {
            return;
        }
        a();
        d(view);
        ClickableSpan[] j = j(charSequence);
        if (j == null || j.length <= 0) {
            return;
        }
        g().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> b2 = b(view);
        for (int i3 = 0; j != null && i3 < j.length; i3++) {
            int a2 = a(j[i3], b2);
            b2.put(a2, new WeakReference<>(j[i3]));
            a(j[i3], (Spanned) charSequence, a2);
        }
    }

    public void b(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1171a.setCanOpenPopup(z);
        }
    }

    public final boolean b(int i2) {
        Bundle g2 = g();
        return g2 != null && (g2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i2) == i2;
    }

    public final int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals(sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f1170d;
        f1170d = i3 + 1;
        return i3;
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1171a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f1171a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f1171a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f1171a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    public final void a(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1171a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f1183a);
        }
    }

    public void a(d dVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1171a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) dVar.f1185a);
        }
    }

    public final void a(int i2, boolean z) {
        Bundle g2 = g();
        if (g2 != null) {
            int i3 = g2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i2 ^ (-1));
            if (!z) {
                i2 = 0;
            }
            g2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }
}
