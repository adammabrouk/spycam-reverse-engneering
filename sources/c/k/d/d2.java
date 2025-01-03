package c.k.d;

import android.content.Context;
import android.content.SharedPreferences;
import c.k.d.m;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d2 {

    /* renamed from: c, reason: collision with root package name */
    public static volatile d2 f7053c;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f7054a;

    /* renamed from: b, reason: collision with root package name */
    public Context f7055b;

    public class a extends b {
        public a() {
            super(d2.this);
        }

        @Override // c.k.d.d2.b, c.k.d.m.b
        public void b() {
            d2.this.b();
        }
    }

    public class b extends m.b {

        /* renamed from: a, reason: collision with root package name */
        public long f7057a = System.currentTimeMillis();

        public b(d2 d2Var) {
        }

        public boolean a() {
            return true;
        }

        @Override // c.k.d.m.b
        public void b() {
        }

        /* renamed from: b, reason: collision with other method in class */
        public final boolean m125b() {
            return System.currentTimeMillis() - this.f7057a > 172800000;
        }
    }

    public class c extends b {

        /* renamed from: b, reason: collision with root package name */
        public String f7058b;

        /* renamed from: c, reason: collision with root package name */
        public String f7059c;

        /* renamed from: d, reason: collision with root package name */
        public File f7060d;

        /* renamed from: e, reason: collision with root package name */
        public int f7061e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f7062f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f7063g;

        public c(String str, String str2, File file, boolean z) {
            super(d2.this);
            this.f7058b = str;
            this.f7059c = str2;
            this.f7060d = file;
            this.f7063g = z;
        }

        @Override // c.k.d.d2.b
        public boolean a() {
            return e0.d(d2.this.f7055b) || (this.f7063g && e0.b(d2.this.f7055b));
        }

        @Override // c.k.d.d2.b, c.k.d.m.b
        public void b() {
            try {
                if (m126c()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", c.k.d.p9.h0.m381a());
                    hashMap.put(JThirdPlatFormInterface.KEY_TOKEN, this.f7059c);
                    hashMap.put("net", e0.m138a(d2.this.f7055b));
                    e0.a(this.f7058b, hashMap, this.f7060d, "file");
                }
                this.f7062f = true;
            } catch (IOException unused) {
            }
        }

        @Override // c.k.d.m.b
        public void c() {
            if (!this.f7062f) {
                int i2 = this.f7061e + 1;
                this.f7061e = i2;
                if (i2 < 3) {
                    d2.this.f7054a.add(this);
                }
            }
            if (this.f7062f || this.f7061e >= 3) {
                this.f7060d.delete();
            }
            d2.this.a((1 << this.f7061e) * 1000);
        }

        /* renamed from: c, reason: collision with other method in class */
        public final boolean m126c() {
            int i2;
            int i3 = 0;
            SharedPreferences sharedPreferences = d2.this.f7055b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i2 = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= JConstants.DAY) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                if (i2 > 10) {
                    return false;
                }
                i3 = i2;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i3 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                c.k.a.a.a.c.c("JSONException on put " + e2.getMessage());
            }
            return true;
        }
    }

    public d2(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f7054a = concurrentLinkedQueue;
        this.f7055b = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    public static d2 a(Context context) {
        if (f7053c == null) {
            synchronized (d2.class) {
                if (f7053c == null) {
                    f7053c = new d2(context);
                }
            }
        }
        f7053c.f7055b = context;
        return f7053c;
    }

    public void a() {
        c();
        a(0L);
    }

    public final void a(long j) {
        b peek = this.f7054a.peek();
        if (peek == null || !peek.a()) {
            return;
        }
        b(j);
    }

    public void a(String str, String str2, Date date, Date date2, int i2, boolean z) {
        this.f7054a.add(new e2(this, i2, date, date2, str, str2, z));
        b(0L);
    }

    public final void b() {
        if (c.k.d.b.b() || c.k.d.b.m77a()) {
            return;
        }
        try {
            File file = new File(this.f7055b.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    public final void b(long j) {
        if (this.f7054a.isEmpty()) {
            return;
        }
        d6.a(new f2(this), j);
    }

    public final void c() {
        while (!this.f7054a.isEmpty()) {
            b peek = this.f7054a.peek();
            if (peek != null) {
                if (!peek.m125b() && this.f7054a.size() <= 6) {
                    return;
                }
                c.k.a.a.a.c.c("remove Expired task");
                this.f7054a.remove(peek);
            }
        }
    }
}
