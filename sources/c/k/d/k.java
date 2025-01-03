package c.k.d;

import android.content.SharedPreferences;
import c.k.d.j;

/* loaded from: classes.dex */
public class k extends j.b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7308b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7309c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f7310d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, j.a aVar, boolean z, String str) {
        super(aVar);
        this.f7310d = jVar;
        this.f7308b = z;
        this.f7309c = str;
    }

    @Override // c.k.d.j.b
    public void a() {
        super.a();
    }

    @Override // c.k.d.j.b
    public void b() {
        SharedPreferences sharedPreferences;
        if (this.f7308b) {
            return;
        }
        sharedPreferences = this.f7310d.f7270d;
        sharedPreferences.edit().putLong(this.f7309c, System.currentTimeMillis()).commit();
    }
}
