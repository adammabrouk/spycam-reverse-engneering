package a.h.a;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class g {

    /* compiled from: NotificationCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f876a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f877b;

        /* renamed from: c, reason: collision with root package name */
        public final l[] f878c;

        /* renamed from: d, reason: collision with root package name */
        public final l[] f879d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f880e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f881f;

        /* renamed from: g, reason: collision with root package name */
        public final int f882g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f883h;

        /* renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f884i;
        public CharSequence j;
        public PendingIntent k;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.a(null, "", i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.f880e;
        }

        public l[] c() {
            return this.f879d;
        }

        public Bundle d() {
            return this.f876a;
        }

        public IconCompat e() {
            int i2;
            if (this.f877b == null && (i2 = this.f884i) != 0) {
                this.f877b = IconCompat.a(null, "", i2);
            }
            return this.f877b;
        }

        public l[] f() {
            return this.f878c;
        }

        public int g() {
            return this.f882g;
        }

        public boolean h() {
            return this.f881f;
        }

        public CharSequence i() {
            return this.j;
        }

        public boolean j() {
            return this.f883h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, l[] lVarArr, l[] lVarArr2, boolean z, int i2, boolean z2, boolean z3) {
            this.f881f = true;
            this.f877b = iconCompat;
            if (iconCompat != null && iconCompat.d() == 2) {
                this.f884i = iconCompat.b();
            }
            this.j = e.d(charSequence);
            this.k = pendingIntent;
            this.f876a = bundle == null ? new Bundle() : bundle;
            this.f878c = lVarArr;
            this.f879d = lVarArr2;
            this.f880e = z;
            this.f882g = i2;
            this.f881f = z2;
            this.f883h = z3;
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f888e;

        public c a(CharSequence charSequence) {
            this.f888e = e.d(charSequence);
            return this;
        }

        @Override // a.h.a.g.f
        public String a() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // a.h.a.g.f
        public void a(a.h.a.f fVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(fVar.a()).setBigContentTitle(this.f899b).bigText(this.f888e);
                if (this.f901d) {
                    bigText.setSummaryText(this.f900c);
                }
            }
        }

        @Override // a.h.a.g.f
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f888e);
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    public static final class d {

        /* compiled from: NotificationCompat.java */
        public static class a {
            public static Notification.BubbleMetadata a(d dVar) {
                if (dVar == null) {
                    return null;
                }
                dVar.a();
                throw null;
            }
        }

        /* compiled from: NotificationCompat.java */
        public static class b {
            public static Notification.BubbleMetadata a(d dVar) {
                if (dVar == null) {
                    return null;
                }
                dVar.b();
                throw null;
            }
        }

        public static Notification.BubbleMetadata a(d dVar) {
            if (dVar == null) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                return b.a(dVar);
            }
            if (i2 == 29) {
                return a.a(dVar);
            }
            return null;
        }

        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent a() {
            throw null;
        }

        public String b() {
            throw null;
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class e {
        public boolean A;
        public boolean B;
        public String C;
        public Bundle D;
        public int E;
        public int F;
        public Notification G;
        public RemoteViews H;
        public RemoteViews I;
        public RemoteViews J;
        public String K;
        public int L;
        public String M;
        public a.h.b.b N;
        public long O;
        public int P;
        public boolean Q;
        public d R;
        public Notification S;
        public boolean T;
        public Icon U;

        @Deprecated
        public ArrayList<String> V;

        /* renamed from: a, reason: collision with root package name */
        public Context f889a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<a> f890b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<k> f891c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<a> f892d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f893e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f894f;

        /* renamed from: g, reason: collision with root package name */
        public PendingIntent f895g;

        /* renamed from: h, reason: collision with root package name */
        public PendingIntent f896h;

        /* renamed from: i, reason: collision with root package name */
        public RemoteViews f897i;
        public Bitmap j;
        public CharSequence k;
        public int l;
        public int m;
        public boolean n;
        public boolean o;
        public f p;
        public CharSequence q;
        public CharSequence r;
        public CharSequence[] s;
        public int t;
        public int u;
        public boolean v;
        public String w;
        public boolean x;
        public String y;
        public boolean z;

        public e(Context context, String str) {
            this.f890b = new ArrayList<>();
            this.f891c = new ArrayList<>();
            this.f892d = new ArrayList<>();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.f889a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        public e a(long j) {
            this.S.when = j;
            return this;
        }

        public e b(CharSequence charSequence) {
            this.f893e = d(charSequence);
            return this;
        }

        public e c(boolean z) {
            this.n = z;
            return this;
        }

        public e d(int i2) {
            this.m = i2;
            return this;
        }

        public e e(int i2) {
            this.S.icon = i2;
            return this;
        }

        public e f(int i2) {
            this.F = i2;
            return this;
        }

        public static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e a(CharSequence charSequence) {
            this.f894f = d(charSequence);
            return this;
        }

        public e b(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public e c(int i2) {
            this.l = i2;
            return this;
        }

        public e a(PendingIntent pendingIntent) {
            this.f895g = pendingIntent;
            return this;
        }

        public e b(Bitmap bitmap) {
            this.j = a(bitmap);
            return this;
        }

        public e c(CharSequence charSequence) {
            this.S.tickerText = d(charSequence);
            return this;
        }

        public final Bitmap a(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f889a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d2 = dimensionPixelSize;
            double max = Math.max(1, bitmap.getWidth());
            Double.isNaN(d2);
            Double.isNaN(max);
            double d3 = d2 / max;
            double d4 = dimensionPixelSize2;
            double max2 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d4);
            Double.isNaN(max2);
            double min = Math.min(d3, d4 / max2);
            double width = bitmap.getWidth();
            Double.isNaN(width);
            int ceil = (int) Math.ceil(width * min);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * min), true);
        }

        public e b(boolean z) {
            this.z = z;
            return this;
        }

        public e b(int i2) {
            Notification notification = this.S;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public Bundle b() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public e a(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        @Deprecated
        public e(Context context) {
            this(context, null);
        }

        public e a(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        public e a(int i2, int i3, int i4) {
            Notification notification = this.S;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            int i5 = (i3 == 0 || i4 == 0) ? 0 : 1;
            Notification notification2 = this.S;
            notification2.flags = i5 | (notification2.flags & (-2));
            return this;
        }

        public e a(boolean z) {
            a(16, z);
            return this;
        }

        public final void a(int i2, boolean z) {
            if (z) {
                Notification notification = this.S;
                notification.flags = i2 | notification.flags;
            } else {
                Notification notification2 = this.S;
                notification2.flags = (i2 ^ (-1)) & notification2.flags;
            }
        }

        public e a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f890b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public e a(f fVar) {
            if (this.p != fVar) {
                this.p = fVar;
                if (fVar != null) {
                    fVar.a(this);
                }
            }
            return this;
        }

        public e a(int i2) {
            this.E = i2;
            return this;
        }

        public e a(String str) {
            this.K = str;
            return this;
        }

        public Notification a() {
            return new h(this).b();
        }
    }

    public static Bundle a(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return i.a(notification);
        }
        return null;
    }

    /* compiled from: NotificationCompat.java */
    public static class b extends f {

        /* renamed from: e, reason: collision with root package name */
        public Bitmap f885e;

        /* renamed from: f, reason: collision with root package name */
        public IconCompat f886f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f887g;

        /* compiled from: NotificationCompat.java */
        public static class a {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            public static void a(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* compiled from: NotificationCompat.java */
        /* renamed from: a.h.a.g$b$b, reason: collision with other inner class name */
        public static class C0016b {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        public b a(Bitmap bitmap) {
            this.f886f = bitmap == null ? null : IconCompat.a(bitmap);
            this.f887g = true;
            return this;
        }

        @Override // a.h.a.g.f
        public String a() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public b b(Bitmap bitmap) {
            this.f885e = bitmap;
            return this;
        }

        @Override // a.h.a.g.f
        public void a(a.h.a.f fVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(fVar.a()).setBigContentTitle(this.f899b).bigPicture(this.f885e);
                if (this.f887g) {
                    IconCompat iconCompat = this.f886f;
                    if (iconCompat == null) {
                        a.a(bigPicture, (Bitmap) null);
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        C0016b.a(bigPicture, this.f886f.b(fVar instanceof h ? ((h) fVar).d() : null));
                    } else if (iconCompat.d() == 1) {
                        a.a(bigPicture, this.f886f.a());
                    } else {
                        a.a(bigPicture, (Bitmap) null);
                    }
                }
                if (this.f901d) {
                    a.a(bigPicture, this.f900c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public e f898a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f899b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f900c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f901d = false;

        public abstract String a();

        public abstract void a(a.h.a.f fVar);

        public void a(e eVar) {
            if (this.f898a != eVar) {
                this.f898a = eVar;
                if (eVar != null) {
                    eVar.a(this);
                }
            }
        }

        public RemoteViews b(a.h.a.f fVar) {
            return null;
        }

        public RemoteViews c(a.h.a.f fVar) {
            return null;
        }

        public RemoteViews d(a.h.a.f fVar) {
            return null;
        }

        public void a(Bundle bundle) {
            if (this.f901d) {
                bundle.putCharSequence("android.summaryText", this.f900c);
            }
            CharSequence charSequence = this.f899b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String a2 = a();
            if (a2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", a2);
            }
        }
    }
}
