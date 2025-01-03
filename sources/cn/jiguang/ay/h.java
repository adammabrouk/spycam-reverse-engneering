package cn.jiguang.ay;

import com.shix.shixipc.utilcode.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class h implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public List f8524a;

    /* renamed from: b, reason: collision with root package name */
    public short f8525b;

    /* renamed from: c, reason: collision with root package name */
    public short f8526c;

    public h() {
        this.f8524a = new ArrayList(1);
        this.f8525b = (short) 0;
        this.f8526c = (short) 0;
    }

    public h(i iVar) {
        this();
        b(iVar);
    }

    private String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            stringBuffer.append("[");
            stringBuffer.append(iVar.c());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(LogUtils.PLACEHOLDER);
            }
        }
        return stringBuffer.toString();
    }

    private synchronized Iterator a(boolean z, boolean z2) {
        int i2;
        List subList;
        int size = this.f8524a.size();
        int i3 = z ? size - this.f8525b : this.f8525b;
        if (i3 == 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        if (!z) {
            i2 = size - this.f8525b;
        } else if (z2) {
            if (this.f8526c >= i3) {
                this.f8526c = (short) 0;
            }
            i2 = this.f8526c;
            this.f8526c = (short) (i2 + 1);
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList(i3);
        if (z) {
            arrayList.addAll(this.f8524a.subList(i2, i3));
            if (i2 != 0) {
                subList = this.f8524a.subList(0, i2);
            }
            return arrayList.iterator();
        }
        subList = this.f8524a.subList(i2, size);
        arrayList.addAll(subList);
        return arrayList.iterator();
    }

    private void b(i iVar) {
        if (this.f8525b == 0) {
            this.f8524a.add(iVar);
        } else {
            List list = this.f8524a;
            list.add(list.size() - this.f8525b, iVar);
        }
    }

    public synchronized Iterator a() {
        return a(true, true);
    }

    public synchronized void a(i iVar) {
        if (this.f8524a.size() == 0) {
            b(iVar);
            return;
        }
        i f2 = f();
        if (!iVar.a(f2)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (iVar.h() != f2.h()) {
            if (iVar.h() > f2.h()) {
                iVar = iVar.i();
                iVar.a(f2.h());
            } else {
                for (int i2 = 0; i2 < this.f8524a.size(); i2++) {
                    i i3 = ((i) this.f8524a.get(i2)).i();
                    i3.a(iVar.h());
                    this.f8524a.set(i2, i3);
                }
            }
        }
        if (!this.f8524a.contains(iVar)) {
            b(iVar);
        }
    }

    public g b() {
        return f().d();
    }

    public int c() {
        return f().f();
    }

    public int d() {
        return f().g();
    }

    public synchronized long e() {
        return f().h();
    }

    public synchronized i f() {
        if (this.f8524a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (i) this.f8524a.get(0);
    }

    public String toString() {
        if (this.f8524a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(b() + LogUtils.PLACEHOLDER);
        stringBuffer.append(e() + LogUtils.PLACEHOLDER);
        stringBuffer.append(a(a(true, false)));
        if (this.f8525b > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
