package h.e0.i;

import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: classes.dex */
public interface l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f11644a = new a();

    /* compiled from: PushObserver.java */
    public class a implements l {
        @Override // h.e0.i.l
        public void a(int i2, b bVar) {
        }

        @Override // h.e0.i.l
        public boolean a(int i2, i.e eVar, int i3, boolean z) throws IOException {
            eVar.skip(i3);
            return true;
        }

        @Override // h.e0.i.l
        public boolean a(int i2, List<c> list) {
            return true;
        }

        @Override // h.e0.i.l
        public boolean a(int i2, List<c> list, boolean z) {
            return true;
        }
    }

    void a(int i2, b bVar);

    boolean a(int i2, i.e eVar, int i3, boolean z) throws IOException;

    boolean a(int i2, List<c> list);

    boolean a(int i2, List<c> list, boolean z);
}
