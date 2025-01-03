package c.j.a.f;

import android.content.Context;
import android.text.TextUtils;
import c.j.a.z.z;

/* compiled from: BaseAppCommand.java */
/* loaded from: classes.dex */
public class b extends c.j.a.v {

    /* renamed from: c, reason: collision with root package name */
    public String f6498c;

    /* renamed from: d, reason: collision with root package name */
    public String f6499d;

    /* renamed from: e, reason: collision with root package name */
    public int f6500e;

    /* renamed from: f, reason: collision with root package name */
    public int f6501f;

    /* renamed from: g, reason: collision with root package name */
    public String f6502g;

    public b(int i2, String str) {
        super(i2);
        this.f6500e = -1;
        this.f6498c = null;
        this.f6499d = str;
    }

    public final void a(int i2) {
        this.f6501f = i2;
    }

    public final void b(String str) {
        this.f6498c = str;
    }

    @Override // c.j.a.v
    public void c(c.j.a.e eVar) {
        eVar.a("req_id", this.f6498c);
        eVar.a("package_name", this.f6499d);
        eVar.a("sdk_version", 323L);
        eVar.a("PUSH_APP_STATUS", this.f6500e);
        if (TextUtils.isEmpty(this.f6502g)) {
            return;
        }
        eVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f6502g);
    }

    public final int d() {
        return this.f6501f;
    }

    public final void e() {
        this.f6502g = null;
    }

    public final String f() {
        return this.f6498c;
    }

    @Override // c.j.a.v
    public String toString() {
        return "BaseAppCommand";
    }

    public final int a(Context context) {
        if (this.f6500e == -1) {
            String str = this.f6499d;
            if (TextUtils.isEmpty(str)) {
                c.j.a.z.v.a("BaseAppCommand", "pkg name is null");
                String a2 = a();
                if (TextUtils.isEmpty(a2)) {
                    c.j.a.z.v.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = a2;
            }
            this.f6500e = z.b(context, str);
            if (!TextUtils.isEmpty(this.f6502g)) {
                this.f6500e = 2;
            }
        }
        return this.f6500e;
    }

    @Override // c.j.a.v
    public void d(c.j.a.e eVar) {
        this.f6498c = eVar.a("req_id");
        this.f6499d = eVar.a("package_name");
        eVar.b("sdk_version", 0L);
        this.f6500e = eVar.b("PUSH_APP_STATUS", 0);
        this.f6502g = eVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }
}
