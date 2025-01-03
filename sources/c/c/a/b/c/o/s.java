package c.c.a.b.c.o;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import c.c.a.b.d.c;
import com.google.android.gms.common.internal.SignInButtonConfig;

/* loaded from: classes.dex */
public final class s extends c.c.a.b.d.c<o> {

    /* renamed from: c, reason: collision with root package name */
    public static final s f3992c = new s();

    public s() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View b(Context context, int i2, int i3) throws c.a {
        return f3992c.a(context, i2, i3);
    }

    public final View a(Context context, int i2, int i3) throws c.a {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i2, i3, null);
            return (View) c.c.a.b.d.b.a(a(context).a(c.c.a.b.d.b.a(context), signInButtonConfig));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i2);
            sb.append(" and color ");
            sb.append(i3);
            throw new c.a(sb.toString(), e2);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.c.a.b.d.c
    public final o a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof o) {
            return (o) queryLocalInterface;
        }
        return new b0(iBinder);
    }
}
