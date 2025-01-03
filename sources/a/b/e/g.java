package a.b.e;

import a.b.e.j.j;
import a.b.f.g0;
import a.b.f.r;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import com.google.zxing.client.j2se.DecodeWorker;
import com.shix.shixipc.system.ContentCommon;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f274e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f275f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f276a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f277b;

    /* renamed from: c, reason: collision with root package name */
    public Context f278c;

    /* renamed from: d, reason: collision with root package name */
    public Object f279d;

    /* compiled from: SupportMenuInflater.java */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f280c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        public Object f281a;

        /* renamed from: b, reason: collision with root package name */
        public Method f282b;

        public a(Object obj, String str) {
            this.f281a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f282b = cls.getMethod(str, f280c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f282b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f282b.invoke(this.f281a, menuItem)).booleanValue();
                }
                this.f282b.invoke(this.f281a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f274e = clsArr;
        f275f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f278c = context;
        Object[] objArr = {context};
        this.f276a = objArr;
        this.f277b = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.c() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.a() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals("item") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.b(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        a(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r12 = this;
            a.b.e.g$b r0 = new a.b.e.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r4
            r6 = 0
            r7 = 0
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r8 = r4
            r7 = 0
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.d()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.c()
            if (r15 != 0) goto Lb9
            a.h.j.b r15 = r0.A
            if (r15 == 0) goto L82
            boolean r15 = r15.a()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = 1
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.a(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.b(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.a(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = 1
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.e.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    @Override // android.view.MenuInflater
    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof a.h.d.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f278c.getResources().getLayout(i2);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    public class b {
        public a.h.j.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        public Menu f283a;

        /* renamed from: b, reason: collision with root package name */
        public int f284b;

        /* renamed from: c, reason: collision with root package name */
        public int f285c;

        /* renamed from: d, reason: collision with root package name */
        public int f286d;

        /* renamed from: e, reason: collision with root package name */
        public int f287e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f288f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f289g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f290h;

        /* renamed from: i, reason: collision with root package name */
        public int f291i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.f283a = menu;
            d();
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f278c.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
            this.f284b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f285c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f286d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f287e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f288f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f289g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            g0 a2 = g0.a(g.this.f278c, attributeSet, R$styleable.MenuItem);
            this.f291i = a2.g(R$styleable.MenuItem_android_id, 0);
            this.j = (a2.d(R$styleable.MenuItem_android_menuCategory, this.f285c) & DecodeWorker.RED) | (a2.d(R$styleable.MenuItem_android_orderInCategory, this.f286d) & ContentCommon.INVALID_OPTION);
            this.k = a2.e(R$styleable.MenuItem_android_title);
            this.l = a2.e(R$styleable.MenuItem_android_titleCondensed);
            this.m = a2.g(R$styleable.MenuItem_android_icon, 0);
            this.n = a(a2.d(R$styleable.MenuItem_android_alphabeticShortcut));
            this.o = a2.d(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.p = a(a2.d(R$styleable.MenuItem_android_numericShortcut));
            this.q = a2.d(R$styleable.MenuItem_numericModifiers, 4096);
            if (a2.g(R$styleable.MenuItem_android_checkable)) {
                this.r = a2.a(R$styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.f287e;
            }
            this.s = a2.a(R$styleable.MenuItem_android_checked, false);
            this.t = a2.a(R$styleable.MenuItem_android_visible, this.f288f);
            this.u = a2.a(R$styleable.MenuItem_android_enabled, this.f289g);
            this.v = a2.d(R$styleable.MenuItem_showAsAction, -1);
            this.z = a2.d(R$styleable.MenuItem_android_onClick);
            this.w = a2.g(R$styleable.MenuItem_actionLayout, 0);
            this.x = a2.d(R$styleable.MenuItem_actionViewClass);
            String d2 = a2.d(R$styleable.MenuItem_actionProviderClass);
            this.y = d2;
            boolean z = d2 != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (a.h.j.b) a(this.y, g.f275f, g.this.f277b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = a2.e(R$styleable.MenuItem_contentDescription);
            this.C = a2.e(R$styleable.MenuItem_tooltipText);
            if (a2.g(R$styleable.MenuItem_iconTintMode)) {
                this.E = r.a(a2.d(R$styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (a2.g(R$styleable.MenuItem_iconTint)) {
                this.D = a2.a(R$styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            a2.b();
            this.f290h = false;
        }

        public boolean c() {
            return this.f290h;
        }

        public void d() {
            this.f284b = 0;
            this.f285c = 0;
            this.f286d = 0;
            this.f287e = 0;
            this.f288f = true;
            this.f289g = true;
        }

        public final char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public final void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.f278c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof a.b.e.j.i) {
                    ((a.b.e.j.i) menuItem).c(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f274e, g.this.f276a));
                z = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            a.h.j.b bVar = this.A;
            if (bVar != null) {
                a.h.j.i.a(menuItem, bVar);
            }
            a.h.j.i.a(menuItem, this.B);
            a.h.j.i.b(menuItem, this.C);
            a.h.j.i.a(menuItem, this.n, this.o);
            a.h.j.i.b(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                a.h.j.i.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                a.h.j.i.a(menuItem, colorStateList);
            }
        }

        public SubMenu b() {
            this.f290h = true;
            SubMenu addSubMenu = this.f283a.addSubMenu(this.f284b, this.f291i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public void a() {
            this.f290h = true;
            a(this.f283a.add(this.f284b, this.f291i, this.j, this.k));
        }

        public final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f278c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }

    public Object a() {
        if (this.f279d == null) {
            this.f279d = a(this.f278c);
        }
        return this.f279d;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
