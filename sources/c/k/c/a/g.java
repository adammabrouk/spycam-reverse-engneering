package c.k.c.a;

import android.content.Context;
import c.k.c.a.l;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6826a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6827b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6828c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l.a f6829d;

    public g(String str, String str2, String str3, l.a aVar) {
        this.f6826a = str;
        this.f6827b = str2;
        this.f6828c = str3;
        this.f6829d = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = l.f6860b;
        l.b(context, this.f6826a, this.f6827b, null, this.f6828c, this.f6829d);
    }
}
