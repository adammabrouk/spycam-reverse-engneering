package c.k.d;

import c.k.d.d2;
import c.k.d.d2.c;
import java.io.File;
import java.util.Date;

/* loaded from: classes.dex */
public class e2 extends d2.b {

    /* renamed from: b, reason: collision with root package name */
    public File f7087b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7088c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Date f7089d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Date f7090e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f7091f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f7092g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f7093h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d2 f7094i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(d2 d2Var, int i2, Date date, Date date2, String str, String str2, boolean z) {
        super(d2Var);
        this.f7094i = d2Var;
        this.f7088c = i2;
        this.f7089d = date;
        this.f7090e = date2;
        this.f7091f = str;
        this.f7092g = str2;
        this.f7093h = z;
    }

    @Override // c.k.d.d2.b, c.k.d.m.b
    public void b() {
        if (b.d()) {
            try {
                File file = new File(this.f7094i.f7055b.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    c2 c2Var = new c2();
                    c2Var.a(this.f7088c);
                    this.f7087b = c2Var.a(this.f7094i.f7055b, this.f7089d, this.f7090e, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // c.k.d.m.b
    public void c() {
        File file = this.f7087b;
        if (file != null && file.exists()) {
            this.f7094i.f7054a.add(this.f7094i.new c(this.f7091f, this.f7092g, this.f7087b, this.f7093h));
        }
        this.f7094i.a(0L);
    }
}
