package c.k.d;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class s0 implements m5 {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f7827e = false;

    /* renamed from: b, reason: collision with root package name */
    public z4 f7829b;

    /* renamed from: a, reason: collision with root package name */
    public SimpleDateFormat f7828a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: c, reason: collision with root package name */
    public a f7830c = null;

    /* renamed from: d, reason: collision with root package name */
    public a f7831d = null;

    public class a implements f5, n5 {

        /* renamed from: a, reason: collision with root package name */
        public String f7832a;

        public a(boolean z) {
            this.f7832a = z ? " RCV " : " Sent ";
        }

        @Override // c.k.d.f5
        public void a(r5 r5Var) {
            StringBuilder sb;
            String str;
            if (s0.f7827e) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(s0.this.f7828a.format(new Date()));
                sb.append(this.f7832a);
                sb.append(" PKT ");
                str = r5Var.mo336a();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(s0.this.f7828a.format(new Date()));
                sb.append(this.f7832a);
                sb.append(" PKT [");
                sb.append(r5Var.d());
                sb.append(",");
                sb.append(r5Var.c());
                str = "]";
            }
            sb.append(str);
            c.k.a.a.a.c.c(sb.toString());
        }

        @Override // c.k.d.f5
        public void a(s4 s4Var) {
            StringBuilder sb;
            String str;
            if (s0.f7827e) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(s0.this.f7828a.format(new Date()));
                sb.append(this.f7832a);
                str = s4Var.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(s0.this.f7828a.format(new Date()));
                sb.append(this.f7832a);
                sb.append(" Blob [");
                sb.append(s4Var.m461a());
                sb.append(",");
                sb.append(s4Var.a());
                sb.append(",");
                sb.append(s4Var.d());
                str = "]";
            }
            sb.append(str);
            c.k.a.a.a.c.c(sb.toString());
        }

        @Override // c.k.d.n5
        /* renamed from: a, reason: collision with other method in class */
        public boolean mo456a(r5 r5Var) {
            return true;
        }
    }

    public s0(z4 z4Var) {
        this.f7829b = null;
        this.f7829b = z4Var;
        a();
    }

    public final void a() {
        this.f7830c = new a(true);
        this.f7831d = new a(false);
        z4 z4Var = this.f7829b;
        a aVar = this.f7830c;
        z4Var.a(aVar, aVar);
        z4 z4Var2 = this.f7829b;
        a aVar2 = this.f7831d;
        z4Var2.b(aVar2, aVar2);
        new t0(this);
    }
}
