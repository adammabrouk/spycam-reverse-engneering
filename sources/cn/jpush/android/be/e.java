package cn.jpush.android.be;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class e extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public volatile int f9553a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f9554b;

    /* renamed from: c, reason: collision with root package name */
    public volatile SQLiteDatabase f9555c;

    /* renamed from: d, reason: collision with root package name */
    public volatile SQLiteDatabase f9556d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f9557e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f9558f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f9559g;

    /* renamed from: h, reason: collision with root package name */
    public final String f9560h;

    /* renamed from: i, reason: collision with root package name */
    public final int f9561i;
    public final SQLiteDatabase.CursorFactory j;

    public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.f9553a = 0;
        this.f9554b = 0;
        this.f9557e = new Object();
        this.f9558f = new Object();
        this.f9559g = context;
        this.f9560h = str;
        this.f9561i = i2;
        this.j = cursorFactory;
    }

    public boolean a(boolean z) {
        try {
            if (z) {
                synchronized (this.f9557e) {
                    getWritableDatabase();
                    this.f9554b++;
                }
                return true;
            }
            synchronized (this.f9558f) {
                getReadableDatabase();
                this.f9553a++;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
        return false;
    }

    public void b(boolean z) {
        boolean z2 = true;
        if (z) {
            synchronized (this.f9557e) {
                if (this.f9556d != null && this.f9556d.isOpen()) {
                    int i2 = this.f9554b - 1;
                    this.f9554b = i2;
                    if (i2 > 0) {
                        z2 = false;
                    }
                }
                if (z2) {
                    this.f9554b = 0;
                    if (this.f9556d != null) {
                        this.f9556d.close();
                    }
                    this.f9556d = null;
                }
            }
            return;
        }
        synchronized (this.f9558f) {
            if (this.f9555c != null && this.f9555c.isOpen()) {
                int i3 = this.f9553a - 1;
                this.f9553a = i3;
                if (i3 > 0) {
                    z2 = false;
                }
            }
            if (z2) {
                this.f9553a = 0;
                if (this.f9555c != null) {
                    this.f9555c.close();
                }
                this.f9555c = null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    @Deprecated
    public void close() {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        if (this.f9555c == null || !this.f9555c.isOpen()) {
            synchronized (this.f9558f) {
                if (this.f9555c == null || !this.f9555c.isOpen()) {
                    try {
                        getWritableDatabase();
                    } catch (SQLiteException unused) {
                    }
                    String path = this.f9559g.getDatabasePath(this.f9560h).getPath();
                    this.f9555c = SQLiteDatabase.openDatabase(path, this.j, 1);
                    if (this.f9555c.getVersion() != this.f9561i) {
                        throw new SQLiteException("Can't upgrade read-only database from version " + this.f9555c.getVersion() + " to " + this.f9561i + ": " + path);
                    }
                    this.f9553a = 0;
                    onOpen(this.f9555c);
                }
            }
        }
        return this.f9555c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (this.f9556d == null || !this.f9556d.isOpen()) {
            synchronized (this.f9557e) {
                if (this.f9556d == null || !this.f9556d.isOpen()) {
                    this.f9554b = 0;
                    this.f9556d = super.getWritableDatabase();
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.f9556d.enableWriteAheadLogging();
                    }
                }
            }
        }
        return this.f9556d;
    }
}
