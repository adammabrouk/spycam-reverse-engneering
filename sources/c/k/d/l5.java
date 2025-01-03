package c.k.d;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class l5 extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public u5 f7349a;

    /* renamed from: a, reason: collision with other field name */
    public v5 f53a;

    /* renamed from: a, reason: collision with other field name */
    public Throwable f54a;

    public l5() {
        this.f7349a = null;
        this.f53a = null;
        this.f54a = null;
    }

    public l5(u5 u5Var) {
        this.f7349a = null;
        this.f53a = null;
        this.f54a = null;
        this.f7349a = u5Var;
    }

    public l5(String str) {
        super(str);
        this.f7349a = null;
        this.f53a = null;
        this.f54a = null;
    }

    public l5(String str, Throwable th) {
        super(str);
        this.f7349a = null;
        this.f53a = null;
        this.f54a = null;
        this.f54a = th;
    }

    public l5(Throwable th) {
        this.f7349a = null;
        this.f53a = null;
        this.f54a = null;
        this.f54a = th;
    }

    public Throwable a() {
        return this.f54a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        u5 u5Var;
        v5 v5Var;
        String message = super.getMessage();
        return (message != null || (v5Var = this.f53a) == null) ? (message != null || (u5Var = this.f7349a) == null) ? message : u5Var.toString() : v5Var.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f54a != null) {
            printStream.println("Nested Exception: ");
            this.f54a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f54a != null) {
            printWriter.println("Nested Exception: ");
            this.f54a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        v5 v5Var = this.f53a;
        if (v5Var != null) {
            sb.append(v5Var);
        }
        u5 u5Var = this.f7349a;
        if (u5Var != null) {
            sb.append(u5Var);
        }
        if (this.f54a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f54a);
        }
        return sb.toString();
    }
}
