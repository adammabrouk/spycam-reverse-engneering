package c.c.a.b.c.o;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Account f3939a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Scope> f3940b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Scope> f3941c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<c.c.a.b.c.l.a<?>, b> f3942d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3943e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3944f;

    /* renamed from: g, reason: collision with root package name */
    public final c.c.a.b.h.a f3945g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f3946h;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Account f3947a;

        /* renamed from: b, reason: collision with root package name */
        public a.e.b<Scope> f3948b;

        /* renamed from: c, reason: collision with root package name */
        public Map<c.c.a.b.c.l.a<?>, b> f3949c;

        /* renamed from: e, reason: collision with root package name */
        public View f3951e;

        /* renamed from: f, reason: collision with root package name */
        public String f3952f;

        /* renamed from: g, reason: collision with root package name */
        public String f3953g;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3955i;

        /* renamed from: d, reason: collision with root package name */
        public int f3950d = 0;

        /* renamed from: h, reason: collision with root package name */
        public c.c.a.b.h.a f3954h = c.c.a.b.h.a.f5233i;

        public final a a(Account account) {
            this.f3947a = account;
            return this;
        }

        public final a b(String str) {
            this.f3952f = str;
            return this;
        }

        public final a a(Collection<Scope> collection) {
            if (this.f3948b == null) {
                this.f3948b = new a.e.b<>();
            }
            this.f3948b.addAll(collection);
            return this;
        }

        public final a a(String str) {
            this.f3953g = str;
            return this;
        }

        public final d a() {
            return new d(this.f3947a, this.f3948b, this.f3949c, this.f3950d, this.f3951e, this.f3952f, this.f3953g, this.f3954h, this.f3955i);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Scope> f3956a;
    }

    public d(Account account, Set<Scope> set, Map<c.c.a.b.c.l.a<?>, b> map, int i2, View view, String str, String str2, c.c.a.b.h.a aVar, boolean z) {
        this.f3939a = account;
        this.f3940b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f3942d = map == null ? Collections.EMPTY_MAP : map;
        this.f3943e = str;
        this.f3944f = str2;
        this.f3945g = aVar;
        HashSet hashSet = new HashSet(this.f3940b);
        Iterator<b> it = this.f3942d.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().f3956a);
        }
        this.f3941c = Collections.unmodifiableSet(hashSet);
    }

    @Nullable
    public final Account a() {
        return this.f3939a;
    }

    public final Account b() {
        Account account = this.f3939a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> c() {
        return this.f3941c;
    }

    @Nullable
    public final Integer d() {
        return this.f3946h;
    }

    @Nullable
    public final String e() {
        return this.f3944f;
    }

    @Nullable
    public final String f() {
        return this.f3943e;
    }

    public final Set<Scope> g() {
        return this.f3940b;
    }

    @Nullable
    public final c.c.a.b.h.a h() {
        return this.f3945g;
    }

    public final void a(Integer num) {
        this.f3946h = num;
    }
}
