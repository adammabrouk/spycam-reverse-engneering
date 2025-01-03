package c.g.a.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.hjq.permissions.Permission;
import com.permissionx.guolindev.R$drawable;
import com.permissionx.guolindev.R$string;
import com.permissionx.guolindev.R$style;
import f.j.b.f;
import java.util.HashSet;
import java.util.List;

/* compiled from: DefaultDialog.kt */
/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f6355a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6356b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6357c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6358d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6359e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6360f;

    /* renamed from: g, reason: collision with root package name */
    public c.g.a.d.a f6361g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, List<String> list, String str, String str2, String str3, int i2, int i3) {
        super(context, R$style.PermissionXDefaultDialog);
        f.c(context, "context");
        f.c(list, "permissions");
        f.c(str, "message");
        f.c(str2, "positiveText");
        this.f6355a = list;
        this.f6356b = str;
        this.f6357c = str2;
        this.f6358d = str3;
        this.f6359e = i2;
        this.f6360f = i3;
    }

    @Override // c.g.a.e.c
    public View a() {
        if (this.f6358d == null) {
            return null;
        }
        c.g.a.d.a aVar = this.f6361g;
        if (aVar != null) {
            return aVar.f6348c;
        }
        f.e("binding");
        throw null;
    }

    @Override // c.g.a.e.c
    public List<String> b() {
        return this.f6355a;
    }

    @Override // c.g.a.e.c
    public View c() {
        c.g.a.d.a aVar = this.f6361g;
        if (aVar == null) {
            f.e("binding");
            throw null;
        }
        Button button = aVar.f6351f;
        f.b(button, "binding.positiveBtn");
        return button;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void d() {
        String str;
        HashSet hashSet = new HashSet();
        int i2 = Build.VERSION.SDK_INT;
        for (String str2 : this.f6355a) {
            if (i2 < 29) {
                try {
                    str = getContext().getPackageManager().getPermissionInfo(str2, 0).group;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    str = null;
                }
            } else {
                str = i2 == 29 ? b.b().get(str2) : i2 == 30 ? b.c().get(str2) : i2 == 31 ? b.d().get(str2) : b.c().get(str2);
            }
            if ((b.a().contains(str2) && !hashSet.contains(str2)) || (str != null && !hashSet.contains(str))) {
                LayoutInflater layoutInflater = getLayoutInflater();
                c.g.a.d.a aVar = this.f6361g;
                if (aVar == null) {
                    f.e("binding");
                    throw null;
                }
                c.g.a.d.b a2 = c.g.a.d.b.a(layoutInflater, aVar.f6350e, false);
                f.b(a2, "inflate(layoutInflater, …permissionsLayout, false)");
                switch (str2.hashCode()) {
                    case -2078357533:
                        if (str2.equals(Permission.WRITE_SETTINGS)) {
                            a2.f6354c.setText(getContext().getString(R$string.permissionx_write_settings));
                            a2.f6353b.setImageResource(R$drawable.permissionx_ic_setting);
                            break;
                        }
                        TextView textView = a2.f6354c;
                        Context context = getContext();
                        PackageManager packageManager = getContext().getPackageManager();
                        f.a((Object) str);
                        textView.setText(context.getString(packageManager.getPermissionGroupInfo(str, 0).labelRes));
                        a2.f6353b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    case -1813079487:
                        if (str2.equals(Permission.MANAGE_EXTERNAL_STORAGE)) {
                            a2.f6354c.setText(getContext().getString(R$string.permissionx_manage_external_storage));
                            a2.f6353b.setImageResource(R$drawable.permissionx_ic_storage);
                            break;
                        }
                        TextView textView2 = a2.f6354c;
                        Context context2 = getContext();
                        PackageManager packageManager2 = getContext().getPackageManager();
                        f.a((Object) str);
                        textView2.setText(context2.getString(packageManager2.getPermissionGroupInfo(str, 0).labelRes));
                        a2.f6353b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    case -1561629405:
                        if (str2.equals(Permission.SYSTEM_ALERT_WINDOW)) {
                            a2.f6354c.setText(getContext().getString(R$string.permissionx_system_alert_window));
                            a2.f6353b.setImageResource(R$drawable.permissionx_ic_alert);
                            break;
                        }
                        TextView textView22 = a2.f6354c;
                        Context context22 = getContext();
                        PackageManager packageManager22 = getContext().getPackageManager();
                        f.a((Object) str);
                        textView22.setText(context22.getString(packageManager22.getPermissionGroupInfo(str, 0).labelRes));
                        a2.f6353b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    case 1777263169:
                        if (str2.equals(Permission.REQUEST_INSTALL_PACKAGES)) {
                            a2.f6354c.setText(getContext().getString(R$string.permissionx_request_install_packages));
                            a2.f6353b.setImageResource(R$drawable.permissionx_ic_install);
                            break;
                        }
                        TextView textView222 = a2.f6354c;
                        Context context222 = getContext();
                        PackageManager packageManager222 = getContext().getPackageManager();
                        f.a((Object) str);
                        textView222.setText(context222.getString(packageManager222.getPermissionGroupInfo(str, 0).labelRes));
                        a2.f6353b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    case 2024715147:
                        if (str2.equals(Permission.ACCESS_BACKGROUND_LOCATION)) {
                            a2.f6354c.setText(getContext().getString(R$string.permissionx_access_background_location));
                            a2.f6353b.setImageResource(R$drawable.permissionx_ic_location);
                            break;
                        }
                        TextView textView2222 = a2.f6354c;
                        Context context2222 = getContext();
                        PackageManager packageManager2222 = getContext().getPackageManager();
                        f.a((Object) str);
                        textView2222.setText(context2222.getString(packageManager2222.getPermissionGroupInfo(str, 0).labelRes));
                        a2.f6353b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                    default:
                        TextView textView22222 = a2.f6354c;
                        Context context22222 = getContext();
                        PackageManager packageManager22222 = getContext().getPackageManager();
                        f.a((Object) str);
                        textView22222.setText(context22222.getString(packageManager22222.getPermissionGroupInfo(str, 0).labelRes));
                        a2.f6353b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                        break;
                }
                if (e()) {
                    int i3 = this.f6360f;
                    if (i3 != -1) {
                        a2.f6353b.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
                    }
                } else {
                    int i4 = this.f6359e;
                    if (i4 != -1) {
                        a2.f6353b.setColorFilter(i4, PorterDuff.Mode.SRC_ATOP);
                    }
                }
                c.g.a.d.a aVar2 = this.f6361g;
                if (aVar2 == null) {
                    f.e("binding");
                    throw null;
                }
                aVar2.f6350e.addView(a2.a());
                if (str != null) {
                    str2 = str;
                }
                hashSet.add(str2);
            }
        }
    }

    public final boolean e() {
        return (getContext().getResources().getConfiguration().uiMode & 48) == 32;
    }

    public final boolean f() {
        c.g.a.d.a aVar = this.f6361g;
        if (aVar != null) {
            return aVar.f6350e.getChildCount() == 0;
        }
        f.e("binding");
        throw null;
    }

    public final void g() {
        c.g.a.d.a aVar = this.f6361g;
        if (aVar == null) {
            f.e("binding");
            throw null;
        }
        aVar.f6347b.setText(this.f6356b);
        c.g.a.d.a aVar2 = this.f6361g;
        if (aVar2 == null) {
            f.e("binding");
            throw null;
        }
        aVar2.f6351f.setText(this.f6357c);
        if (this.f6358d != null) {
            c.g.a.d.a aVar3 = this.f6361g;
            if (aVar3 == null) {
                f.e("binding");
                throw null;
            }
            aVar3.f6349d.setVisibility(0);
            c.g.a.d.a aVar4 = this.f6361g;
            if (aVar4 == null) {
                f.e("binding");
                throw null;
            }
            aVar4.f6348c.setText(this.f6358d);
        } else {
            c.g.a.d.a aVar5 = this.f6361g;
            if (aVar5 == null) {
                f.e("binding");
                throw null;
            }
            aVar5.f6349d.setVisibility(8);
        }
        if (e()) {
            int i2 = this.f6360f;
            if (i2 != -1) {
                c.g.a.d.a aVar6 = this.f6361g;
                if (aVar6 == null) {
                    f.e("binding");
                    throw null;
                }
                aVar6.f6351f.setTextColor(i2);
                c.g.a.d.a aVar7 = this.f6361g;
                if (aVar7 != null) {
                    aVar7.f6348c.setTextColor(this.f6360f);
                    return;
                } else {
                    f.e("binding");
                    throw null;
                }
            }
            return;
        }
        int i3 = this.f6359e;
        if (i3 != -1) {
            c.g.a.d.a aVar8 = this.f6361g;
            if (aVar8 == null) {
                f.e("binding");
                throw null;
            }
            aVar8.f6351f.setTextColor(i3);
            c.g.a.d.a aVar9 = this.f6361g;
            if (aVar9 != null) {
                aVar9.f6348c.setTextColor(this.f6359e);
            } else {
                f.e("binding");
                throw null;
            }
        }
    }

    public final void h() {
        int i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        if (i2 < getContext().getResources().getDisplayMetrics().heightPixels) {
            Window window = getWindow();
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            double d2 = i2;
            Double.isNaN(d2);
            attributes.width = (int) (d2 * 0.86d);
            window.setAttributes(attributes);
            return;
        }
        Window window2 = getWindow();
        if (window2 == null) {
            return;
        }
        WindowManager.LayoutParams attributes2 = window2.getAttributes();
        window2.setGravity(17);
        double d3 = i2;
        Double.isNaN(d3);
        attributes2.width = (int) (d3 * 0.6d);
        window2.setAttributes(attributes2);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.g.a.d.a a2 = c.g.a.d.a.a(getLayoutInflater());
        f.b(a2, "inflate(layoutInflater)");
        this.f6361g = a2;
        if (a2 == null) {
            f.e("binding");
            throw null;
        }
        setContentView(a2.a());
        g();
        d();
        h();
    }
}
