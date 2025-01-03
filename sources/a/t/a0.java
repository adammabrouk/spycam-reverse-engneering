package a.t;

import a.t.w;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class a0 extends w {
    public int M;
    public ArrayList<w> K = new ArrayList<>();
    public boolean L = true;
    public boolean N = false;
    public int O = 0;

    /* compiled from: TransitionSet.java */
    public class a extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f1741a;

        public a(a0 a0Var, w wVar) {
            this.f1741a = wVar;
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            this.f1741a.n();
            wVar.b(this);
        }
    }

    /* compiled from: TransitionSet.java */
    public static class b extends x {

        /* renamed from: a, reason: collision with root package name */
        public a0 f1742a;

        public b(a0 a0Var) {
            this.f1742a = a0Var;
        }

        @Override // a.t.x, a.t.w.f
        public void a(w wVar) {
            a0 a0Var = this.f1742a;
            if (a0Var.N) {
                return;
            }
            a0Var.o();
            this.f1742a.N = true;
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            a0 a0Var = this.f1742a;
            int i2 = a0Var.M - 1;
            a0Var.M = i2;
            if (i2 == 0) {
                a0Var.N = false;
                a0Var.a();
            }
            wVar.b(this);
        }
    }

    @Override // a.t.w
    public void c(c0 c0Var) {
        if (b(c0Var.f1753b)) {
            Iterator<w> it = this.K.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.b(c0Var.f1753b)) {
                    next.c(c0Var);
                    c0Var.f1754c.add(next);
                }
            }
        }
    }

    @Override // a.t.w
    public void cancel() {
        super.cancel();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).cancel();
        }
    }

    @Override // a.t.w
    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).e(view);
        }
    }

    @Override // a.t.w
    public void n() {
        if (this.K.isEmpty()) {
            o();
            a();
            return;
        }
        r();
        if (this.L) {
            Iterator<w> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
            return;
        }
        for (int i2 = 1; i2 < this.K.size(); i2++) {
            this.K.get(i2 - 1).a(new a(this, this.K.get(i2)));
        }
        w wVar = this.K.get(0);
        if (wVar != null) {
            wVar.n();
        }
    }

    public int q() {
        return this.K.size();
    }

    public final void r() {
        b bVar = new b(this);
        Iterator<w> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.M = this.K.size();
    }

    @Override // a.t.w
    /* renamed from: clone */
    public w mo3clone() {
        a0 a0Var = (a0) super.mo3clone();
        a0Var.K = new ArrayList<>();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            a0Var.b(this.K.get(i2).mo3clone());
        }
        return a0Var;
    }

    @Override // a.t.w
    public a0 d(View view) {
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            this.K.get(i2).d(view);
        }
        super.d(view);
        return this;
    }

    @Override // a.t.w
    public /* bridge */ /* synthetic */ w a(long j) {
        a(j);
        return this;
    }

    public a0 b(int i2) {
        if (i2 == 0) {
            this.L = true;
        } else if (i2 == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    public a0 a(w wVar) {
        b(wVar);
        long j = this.f1896c;
        if (j >= 0) {
            wVar.a(j);
        }
        if ((this.O & 1) != 0) {
            wVar.a(d());
        }
        if ((this.O & 2) != 0) {
            wVar.a(g());
        }
        if ((this.O & 4) != 0) {
            wVar.a(f());
        }
        if ((this.O & 8) != 0) {
            wVar.a(c());
        }
        return this;
    }

    public final void b(w wVar) {
        this.K.add(wVar);
        wVar.r = this;
    }

    @Override // a.t.w
    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).c(view);
        }
    }

    @Override // a.t.w
    public a0 b(long j) {
        super.b(j);
        return this;
    }

    @Override // a.t.w
    public a0 b(w.f fVar) {
        super.b(fVar);
        return this;
    }

    @Override // a.t.w
    public void b(c0 c0Var) {
        super.b(c0Var);
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).b(c0Var);
        }
    }

    public w a(int i2) {
        if (i2 < 0 || i2 >= this.K.size()) {
            return null;
        }
        return this.K.get(i2);
    }

    @Override // a.t.w
    public a0 a(long j) {
        ArrayList<w> arrayList;
        super.a(j);
        if (this.f1896c >= 0 && (arrayList = this.K) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.K.get(i2).a(j);
            }
        }
        return this;
    }

    @Override // a.t.w
    public a0 a(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<w> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.K.get(i2).a(timeInterpolator);
            }
        }
        super.a(timeInterpolator);
        return this;
    }

    @Override // a.t.w
    public a0 a(View view) {
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            this.K.get(i2).a(view);
        }
        super.a(view);
        return this;
    }

    @Override // a.t.w
    public a0 a(w.f fVar) {
        super.a(fVar);
        return this;
    }

    @Override // a.t.w
    public void a(r rVar) {
        super.a(rVar);
        this.O |= 4;
        if (this.K != null) {
            for (int i2 = 0; i2 < this.K.size(); i2++) {
                this.K.get(i2).a(rVar);
            }
        }
    }

    @Override // a.t.w
    public void a(ViewGroup viewGroup, d0 d0Var, d0 d0Var2, ArrayList<c0> arrayList, ArrayList<c0> arrayList2) {
        long h2 = h();
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = this.K.get(i2);
            if (h2 > 0 && (this.L || i2 == 0)) {
                long h3 = wVar.h();
                if (h3 > 0) {
                    wVar.b(h3 + h2);
                } else {
                    wVar.b(h2);
                }
            }
            wVar.a(viewGroup, d0Var, d0Var2, arrayList, arrayList2);
        }
    }

    @Override // a.t.w
    public void a(c0 c0Var) {
        if (b(c0Var.f1753b)) {
            Iterator<w> it = this.K.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.b(c0Var.f1753b)) {
                    next.a(c0Var);
                    c0Var.f1754c.add(next);
                }
            }
        }
    }

    @Override // a.t.w
    public void a(z zVar) {
        super.a(zVar);
        this.O |= 2;
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).a(zVar);
        }
    }

    @Override // a.t.w
    public void a(w.e eVar) {
        super.a(eVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).a(eVar);
        }
    }

    @Override // a.t.w
    public String a(String str) {
        String a2 = super.a(str);
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append(OSSUtils.NEW_LINE);
            sb.append(this.K.get(i2).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }
}
