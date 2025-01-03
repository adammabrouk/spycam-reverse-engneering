package a.t;

import android.view.View;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class c0 {

    /* renamed from: b, reason: collision with root package name */
    public View f1753b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f1752a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<w> f1754c = new ArrayList<>();

    @Deprecated
    public c0() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f1753b == c0Var.f1753b && this.f1752a.equals(c0Var.f1752a);
    }

    public int hashCode() {
        return (this.f1753b.hashCode() * 31) + this.f1752a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f1753b + OSSUtils.NEW_LINE) + "    values:";
        for (String str2 : this.f1752a.keySet()) {
            str = str + "    " + str2 + ": " + this.f1752a.get(str2) + OSSUtils.NEW_LINE;
        }
        return str;
    }

    public c0(View view) {
        this.f1753b = view;
    }
}
