package a.h.a;

import a.h.a.g;
import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
public class h implements f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f902a;

    /* renamed from: b, reason: collision with root package name */
    public final Notification.Builder f903b;

    /* renamed from: c, reason: collision with root package name */
    public final g.e f904c;

    /* renamed from: d, reason: collision with root package name */
    public RemoteViews f905d;

    /* renamed from: e, reason: collision with root package name */
    public RemoteViews f906e;

    /* renamed from: f, reason: collision with root package name */
    public final List<Bundle> f907f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f908g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    public int f909h;

    /* renamed from: i, reason: collision with root package name */
    public RemoteViews f910i;

    public h(g.e eVar) {
        Icon icon;
        List<String> a2;
        this.f904c = eVar;
        this.f902a = eVar.f889a;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f903b = new Notification.Builder(eVar.f889a, eVar.K);
        } else {
            this.f903b = new Notification.Builder(eVar.f889a);
        }
        Notification notification = eVar.S;
        this.f903b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f897i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f893e).setContentText(eVar.f894f).setContentInfo(eVar.k).setContentIntent(eVar.f895g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f896h, (notification.flags & RecyclerView.c0.FLAG_IGNORE) != 0).setLargeIcon(eVar.j).setNumber(eVar.l).setProgress(eVar.t, eVar.u, eVar.v);
        if (Build.VERSION.SDK_INT < 21) {
            this.f903b.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f903b.setSubText(eVar.q).setUsesChronometer(eVar.o).setPriority(eVar.m);
            Iterator<g.a> it = eVar.f890b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Bundle bundle = eVar.D;
            if (bundle != null) {
                this.f908g.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.z) {
                    this.f908g.putBoolean("android.support.localOnly", true);
                }
                String str = eVar.w;
                if (str != null) {
                    this.f908g.putString("android.support.groupKey", str);
                    if (eVar.x) {
                        this.f908g.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f908g.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = eVar.y;
                if (str2 != null) {
                    this.f908g.putString("android.support.sortKey", str2);
                }
            }
            this.f905d = eVar.H;
            this.f906e = eVar.I;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f903b.setShowWhen(eVar.n);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19 && i2 < 21 && (a2 = a(a(eVar.f891c), eVar.V)) != null && !a2.isEmpty()) {
            this.f908g.putStringArray("android.people", (String[]) a2.toArray(new String[a2.size()]));
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f903b.setLocalOnly(eVar.z).setGroup(eVar.w).setGroupSummary(eVar.x).setSortKey(eVar.y);
            this.f909h = eVar.P;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f903b.setCategory(eVar.C).setColor(eVar.E).setVisibility(eVar.F).setPublicVersion(eVar.G).setSound(notification.sound, notification.audioAttributes);
            List a3 = Build.VERSION.SDK_INT < 28 ? a(a(eVar.f891c), eVar.V) : eVar.V;
            if (a3 != null && !a3.isEmpty()) {
                Iterator it2 = a3.iterator();
                while (it2.hasNext()) {
                    this.f903b.addPerson((String) it2.next());
                }
            }
            this.f910i = eVar.J;
            if (eVar.f892d.size() > 0) {
                Bundle bundle2 = eVar.b().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i3 = 0; i3 < eVar.f892d.size(); i3++) {
                    bundle4.putBundle(Integer.toString(i3), i.a(eVar.f892d.get(i3)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                eVar.b().putBundle("android.car.EXTENSIONS", bundle2);
                this.f908g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && (icon = eVar.U) != null) {
            this.f903b.setSmallIcon(icon);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f903b.setExtras(eVar.D).setRemoteInputHistory(eVar.s);
            RemoteViews remoteViews = eVar.H;
            if (remoteViews != null) {
                this.f903b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.I;
            if (remoteViews2 != null) {
                this.f903b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.J;
            if (remoteViews3 != null) {
                this.f903b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f903b.setBadgeIconType(eVar.L).setSettingsText(eVar.r).setShortcutId(eVar.M).setTimeoutAfter(eVar.O).setGroupAlertBehavior(eVar.P);
            if (eVar.B) {
                this.f903b.setColorized(eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.f903b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Iterator<k> it3 = eVar.f891c.iterator();
            while (it3.hasNext()) {
                this.f903b.addPerson(it3.next().h());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f903b.setAllowSystemGeneratedContextualActions(eVar.Q);
            this.f903b.setBubbleMetadata(g.d.a(eVar.R));
            a.h.b.b bVar = eVar.N;
            if (bVar != null) {
                bVar.a();
                throw null;
            }
        }
        if (eVar.T) {
            if (this.f904c.x) {
                this.f909h = 2;
            } else {
                this.f909h = 1;
            }
            this.f903b.setVibrate(null);
            this.f903b.setSound(null);
            int i4 = notification.defaults & (-2);
            notification.defaults = i4;
            int i5 = i4 & (-3);
            notification.defaults = i5;
            this.f903b.setDefaults(i5);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f904c.w)) {
                    this.f903b.setGroup("silent");
                }
                this.f903b.setGroupAlertBehavior(this.f909h);
            }
        }
    }

    public static List<String> a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        a.e.b bVar = new a.e.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    public Notification b() {
        Bundle a2;
        RemoteViews d2;
        RemoteViews b2;
        g.f fVar = this.f904c.p;
        if (fVar != null) {
            fVar.a(this);
        }
        RemoteViews c2 = fVar != null ? fVar.c(this) : null;
        Notification c3 = c();
        if (c2 != null) {
            c3.contentView = c2;
        } else {
            RemoteViews remoteViews = this.f904c.H;
            if (remoteViews != null) {
                c3.contentView = remoteViews;
            }
        }
        if (Build.VERSION.SDK_INT >= 16 && fVar != null && (b2 = fVar.b(this)) != null) {
            c3.bigContentView = b2;
        }
        if (Build.VERSION.SDK_INT >= 21 && fVar != null && (d2 = this.f904c.p.d(this)) != null) {
            c3.headsUpContentView = d2;
        }
        if (Build.VERSION.SDK_INT >= 16 && fVar != null && (a2 = g.a(c3)) != null) {
            fVar.a(a2);
        }
        return c3;
    }

    public Notification c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f903b.build();
        }
        if (i2 >= 24) {
            Notification build = this.f903b.build();
            if (this.f909h != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f909h == 2) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f909h == 1) {
                    a(build);
                }
            }
            return build;
        }
        if (i2 >= 21) {
            this.f903b.setExtras(this.f908g);
            Notification build2 = this.f903b.build();
            RemoteViews remoteViews = this.f905d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f906e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f910i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f909h != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f909h == 2) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f909h == 1) {
                    a(build2);
                }
            }
            return build2;
        }
        if (i2 >= 20) {
            this.f903b.setExtras(this.f908g);
            Notification build3 = this.f903b.build();
            RemoteViews remoteViews4 = this.f905d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f906e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f909h != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.f909h == 2) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f909h == 1) {
                    a(build3);
                }
            }
            return build3;
        }
        if (i2 >= 19) {
            SparseArray<Bundle> a2 = i.a(this.f907f);
            if (a2 != null) {
                this.f908g.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f903b.setExtras(this.f908g);
            Notification build4 = this.f903b.build();
            RemoteViews remoteViews6 = this.f905d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f906e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        }
        if (i2 < 16) {
            return this.f903b.getNotification();
        }
        Notification build5 = this.f903b.build();
        Bundle a3 = g.a(build5);
        Bundle bundle = new Bundle(this.f908g);
        for (String str : this.f908g.keySet()) {
            if (a3.containsKey(str)) {
                bundle.remove(str);
            }
        }
        a3.putAll(bundle);
        SparseArray<Bundle> a4 = i.a(this.f907f);
        if (a4 != null) {
            g.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
        }
        RemoteViews remoteViews8 = this.f905d;
        if (remoteViews8 != null) {
            build5.contentView = remoteViews8;
        }
        RemoteViews remoteViews9 = this.f906e;
        if (remoteViews9 != null) {
            build5.bigContentView = remoteViews9;
        }
        return build5;
    }

    public Context d() {
        return this.f902a;
    }

    public static List<String> a(List<k> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g());
        }
        return arrayList;
    }

    @Override // a.h.a.f
    public Notification.Builder a() {
        return this.f903b;
    }

    public final void a(g.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 20) {
            if (i2 >= 16) {
                this.f907f.add(i.a(this.f903b, aVar));
                return;
            }
            return;
        }
        IconCompat e2 = aVar.e();
        if (Build.VERSION.SDK_INT >= 23) {
            builder = new Notification.Action.Builder(e2 != null ? e2.g() : null, aVar.i(), aVar.a());
        } else {
            builder = new Notification.Action.Builder(e2 != null ? e2.b() : 0, aVar.i(), aVar.a());
        }
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : l.a(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(aVar.g());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            builder.setContextual(aVar.j());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        builder.addExtras(bundle);
        this.f903b.addAction(builder.build());
    }

    public final void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i2 = notification.defaults & (-2);
        notification.defaults = i2;
        notification.defaults = i2 & (-3);
    }
}
