package a.b.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ActivityChooserModel.java */
/* loaded from: classes.dex */
public class c extends DataSetObservable {
    public static final String n = c.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    public final Object f438a;

    /* renamed from: b, reason: collision with root package name */
    public final List<a> f439b;

    /* renamed from: c, reason: collision with root package name */
    public final List<C0007c> f440c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f441d;

    /* renamed from: e, reason: collision with root package name */
    public final String f442e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f443f;

    /* renamed from: g, reason: collision with root package name */
    public b f444g;

    /* renamed from: h, reason: collision with root package name */
    public int f445h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f446i;
    public boolean j;
    public boolean k;
    public boolean l;
    public d m;

    /* compiled from: ActivityChooserModel.java */
    public static final class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        public final ResolveInfo f447a;

        /* renamed from: b, reason: collision with root package name */
        public float f448b;

        public a(ResolveInfo resolveInfo) {
            this.f447a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f448b) - Float.floatToIntBits(this.f448b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && Float.floatToIntBits(this.f448b) == Float.floatToIntBits(((a) obj).f448b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f448b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f447a.toString() + "; weight:" + new BigDecimal(this.f448b) + "]";
        }
    }

    /* compiled from: ActivityChooserModel.java */
    public interface b {
        void a(Intent intent, List<a> list, List<C0007c> list2);
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: a.b.f.c$c, reason: collision with other inner class name */
    public static final class C0007c {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f449a;

        /* renamed from: b, reason: collision with root package name */
        public final long f450b;

        /* renamed from: c, reason: collision with root package name */
        public final float f451c;

        public C0007c(String str, long j, float f2) {
            this(ComponentName.unflattenFromString(str), j, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0007c.class != obj.getClass()) {
                return false;
            }
            C0007c c0007c = (C0007c) obj;
            ComponentName componentName = this.f449a;
            if (componentName == null) {
                if (c0007c.f449a != null) {
                    return false;
                }
            } else if (!componentName.equals(c0007c.f449a)) {
                return false;
            }
            return this.f450b == c0007c.f450b && Float.floatToIntBits(this.f451c) == Float.floatToIntBits(c0007c.f451c);
        }

        public int hashCode() {
            ComponentName componentName = this.f449a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.f450b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.f451c);
        }

        public String toString() {
            return "[; activity:" + this.f449a + "; time:" + this.f450b + "; weight:" + new BigDecimal(this.f451c) + "]";
        }

        public C0007c(ComponentName componentName, long j, float f2) {
            this.f449a = componentName;
            this.f450b = j;
            this.f451c = f2;
        }
    }

    /* compiled from: ActivityChooserModel.java */
    public interface d {
        boolean a(c cVar, Intent intent);
    }

    /* compiled from: ActivityChooserModel.java */
    public final class e extends AsyncTask<Object, Void, Void> {
        public e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:
        
            if (r15 != null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
        
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b2, code lost:
        
            if (r15 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
        
            if (r15 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00d2, code lost:
        
            if (r15 == null) goto L30;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a.b.f.c.e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    static {
        new HashMap();
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.f438a) {
            a();
            List<a> list = this.f439b;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).f447a == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public int b() {
        int size;
        synchronized (this.f438a) {
            a();
            size = this.f439b.size();
        }
        return size;
    }

    public ResolveInfo c() {
        synchronized (this.f438a) {
            a();
            if (this.f439b.isEmpty()) {
                return null;
            }
            return this.f439b.get(0).f447a;
        }
    }

    public int d() {
        int size;
        synchronized (this.f438a) {
            a();
            size = this.f440c.size();
        }
        return size;
    }

    public final boolean e() {
        if (!this.l || this.f443f == null) {
            return false;
        }
        this.l = false;
        this.f439b.clear();
        List<ResolveInfo> queryIntentActivities = this.f441d.getPackageManager().queryIntentActivities(this.f443f, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f439b.add(new a(queryIntentActivities.get(i2)));
        }
        return true;
    }

    public final void f() {
        if (!this.j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.k) {
            this.k = false;
            if (TextUtils.isEmpty(this.f442e)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f440c), this.f442e);
        }
    }

    public final void g() {
        int size = this.f440c.size() - this.f445h;
        if (size <= 0) {
            return;
        }
        this.k = true;
        for (int i2 = 0; i2 < size; i2++) {
            this.f440c.remove(0);
        }
    }

    public final boolean h() {
        if (!this.f446i || !this.k || TextUtils.isEmpty(this.f442e)) {
            return false;
        }
        this.f446i = false;
        this.j = true;
        i();
        return true;
    }

    public final void i() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.f441d.openFileInput(this.f442e);
            try {
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i2 = 0; i2 != 1 && i2 != 2; i2 = newPullParser.next()) {
                        }
                    } catch (XmlPullParserException e2) {
                        Log.e(n, "Error reading historical recrod file: " + this.f442e, e2);
                        if (openFileInput == null) {
                            return;
                        }
                    }
                } catch (IOException e3) {
                    Log.e(n, "Error reading historical recrod file: " + this.f442e, e3);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (!"historical-records".equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<C0007c> list = this.f440c;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if (openFileInput == null) {
                            return;
                        }
                    } else if (next != 3 && next != 4) {
                        if (!"historical-record".equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new C0007c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                    }
                }
                try {
                    openFileInput.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    public final boolean j() {
        if (this.f444g == null || this.f443f == null || this.f439b.isEmpty() || this.f440c.isEmpty()) {
            return false;
        }
        this.f444g.a(this.f443f, this.f439b, Collections.unmodifiableList(this.f440c));
        return true;
    }

    public void setOnChooseActivityListener(d dVar) {
        synchronized (this.f438a) {
            this.m = dVar;
        }
    }

    public ResolveInfo b(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.f438a) {
            a();
            resolveInfo = this.f439b.get(i2).f447a;
        }
        return resolveInfo;
    }

    public void c(int i2) {
        synchronized (this.f438a) {
            a();
            a aVar = this.f439b.get(i2);
            a aVar2 = this.f439b.get(0);
            a(new C0007c(new ComponentName(aVar.f447a.activityInfo.packageName, aVar.f447a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f448b - aVar.f448b) + 5.0f : 1.0f));
        }
    }

    public Intent a(int i2) {
        synchronized (this.f438a) {
            if (this.f443f == null) {
                return null;
            }
            a();
            a aVar = this.f439b.get(i2);
            ComponentName componentName = new ComponentName(aVar.f447a.activityInfo.packageName, aVar.f447a.activityInfo.name);
            Intent intent = new Intent(this.f443f);
            intent.setComponent(componentName);
            if (this.m != null) {
                if (this.m.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new C0007c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final void a() {
        boolean e2 = e() | h();
        g();
        if (e2) {
            j();
            notifyChanged();
        }
    }

    public final boolean a(C0007c c0007c) {
        boolean add = this.f440c.add(c0007c);
        if (add) {
            this.k = true;
            g();
            f();
            j();
            notifyChanged();
        }
        return add;
    }
}
