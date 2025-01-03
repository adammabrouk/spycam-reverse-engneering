package c.k.d.l9;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import c.k.a.a.a.c;
import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static int f7361a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f7362b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f7363c = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f7361a);
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i2 = 0; i2 < f7363c.length - 1; i2 += 2) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(f7363c[i2]);
            sb.append(LogUtils.PLACEHOLDER);
            sb.append(f7363c[i2 + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f7362b) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e2) {
                c.a(e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
