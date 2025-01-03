package a.b.e.j;

import a.b.a.c;
import a.b.e.j.m;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import com.alibaba.sdk.android.oss.common.OSSConstants;

/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: a, reason: collision with root package name */
    public g f367a;

    /* renamed from: b, reason: collision with root package name */
    public a.b.a.c f368b;

    /* renamed from: c, reason: collision with root package name */
    public e f369c;

    /* renamed from: d, reason: collision with root package name */
    public m.a f370d;

    public h(g gVar) {
        this.f367a = gVar;
    }

    public void a(IBinder iBinder) {
        g gVar = this.f367a;
        c.a aVar = new c.a(gVar.e());
        e eVar = new e(aVar.b(), R$layout.abc_list_menu_item_layout);
        this.f369c = eVar;
        eVar.a(this);
        this.f367a.a(this.f369c);
        aVar.a(this.f369c.a(), this);
        View i2 = gVar.i();
        if (i2 != null) {
            aVar.a(i2);
        } else {
            aVar.a(gVar.g());
            aVar.a(gVar.h());
        }
        aVar.a(this);
        a.b.a.c a2 = aVar.a();
        this.f368b = a2;
        a2.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f368b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= OSSConstants.DEFAULT_STREAM_BUFFER_SIZE;
        this.f368b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f367a.a((i) this.f369c.a().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f369c.a(this.f367a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f368b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f368b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f367a.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f367a.performShortcut(i2, keyEvent, 0);
    }

    public void a() {
        a.b.a.c cVar = this.f368b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // a.b.e.j.m.a
    public void a(g gVar, boolean z) {
        if (z || gVar == this.f367a) {
            a();
        }
        m.a aVar = this.f370d;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // a.b.e.j.m.a
    public boolean a(g gVar) {
        m.a aVar = this.f370d;
        if (aVar != null) {
            return aVar.a(gVar);
        }
        return false;
    }
}
