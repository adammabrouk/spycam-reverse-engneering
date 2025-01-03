package a.k.a;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Writer;

/* compiled from: LogWriter.java */
/* loaded from: classes.dex */
public final class w extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final String f1476a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f1477b = new StringBuilder(RecyclerView.c0.FLAG_IGNORE);

    public w(String str) {
        this.f1476a = str;
    }

    public final void a() {
        if (this.f1477b.length() > 0) {
            Log.d(this.f1476a, this.f1477b.toString());
            StringBuilder sb = this.f1477b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                a();
            } else {
                this.f1477b.append(c2);
            }
        }
    }
}
