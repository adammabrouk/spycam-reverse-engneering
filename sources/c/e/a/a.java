package c.e.a;

import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.List;

/* compiled from: EasyAdapter.kt */
/* loaded from: classes.dex */
public abstract class a<T> extends d<T> {

    /* renamed from: f, reason: collision with root package name */
    public int f6177f;

    /* compiled from: EasyAdapter.kt */
    /* renamed from: c.e.a.a$a, reason: collision with other inner class name */
    public static final class C0118a implements b<T> {
        public C0118a() {
        }

        @Override // c.e.a.b
        public void a(e eVar, T t, int i2) {
            f.j.b.f.d(eVar, "holder");
            a.this.a(eVar, (e) t, i2);
        }

        @Override // c.e.a.b
        public boolean a(T t, int i2) {
            return true;
        }

        @Override // c.e.a.b
        public int a() {
            return a.this.h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<? extends T> list, int i2) {
        super(list);
        f.j.b.f.d(list, JThirdPlatFormInterface.KEY_DATA);
        this.f6177f = i2;
        a(new C0118a());
    }

    public abstract void a(e eVar, T t, int i2);

    public final int h() {
        return this.f6177f;
    }
}
