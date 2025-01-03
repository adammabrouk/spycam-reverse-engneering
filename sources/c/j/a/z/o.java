package c.j.a.z;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

/* compiled from: DefaultNotifyLayoutAdapter.java */
/* loaded from: classes.dex */
public final class o implements b {

    /* renamed from: a, reason: collision with root package name */
    public Resources f6720a;

    /* renamed from: b, reason: collision with root package name */
    public String f6721b;

    @Override // c.j.a.z.b
    public final void a(Context context) {
        this.f6721b = context.getPackageName();
        this.f6720a = context.getResources();
    }

    @Override // c.j.a.z.b
    public final int b() {
        Resources resources;
        String str;
        String str2;
        if (p.f6724c) {
            resources = this.f6720a;
            str = this.f6721b;
            str2 = "notify_icon_rom30";
        } else if (p.f6723b) {
            resources = this.f6720a;
            str = this.f6721b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.f6720a;
            str = this.f6721b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // c.j.a.z.b
    public final int c() {
        return this.f6720a.getIdentifier("push_notify", "layout", this.f6721b);
    }

    @Override // c.j.a.z.b
    public final int a() {
        int i2;
        try {
            i2 = ((Integer) f0.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 > 0) {
            return this.f6720a.getColor(i2);
        }
        if (p.f6724c) {
            return -1;
        }
        if (!p.f6723b) {
            return -16777216;
        }
        if (p.f6724c) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }
}
