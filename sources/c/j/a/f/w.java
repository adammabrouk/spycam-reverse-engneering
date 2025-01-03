package c.j.a.f;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ReporterCommand.java */
/* loaded from: classes.dex */
public final class w extends c.j.a.v {

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f6533c;

    /* renamed from: d, reason: collision with root package name */
    public long f6534d;

    public w() {
        super(2012);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f6533c = hashMap;
    }

    @Override // c.j.a.v
    public final void c(c.j.a.e eVar) {
        eVar.a("ReporterCommand.EXTRA_PARAMS", this.f6533c);
        eVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f6534d);
    }

    @Override // c.j.a.v
    public final void d(c.j.a.e eVar) {
        this.f6533c = (HashMap) eVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f6534d = eVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f6534d);
    }

    @Override // c.j.a.v
    public final String toString() {
        return "ReporterCommand（" + this.f6534d + ")";
    }

    public w(long j) {
        this();
        this.f6534d = j;
    }

    public final void d() {
        if (this.f6533c == null) {
            c.j.a.z.v.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.f6534d);
        sb.append(",msgId:");
        String str = this.f6533c.get("messageID");
        if (TextUtils.isEmpty(str)) {
            str = this.f6533c.get("message_id");
        }
        sb.append(str);
        c.j.a.z.v.d("ReporterCommand", sb.toString());
    }
}
