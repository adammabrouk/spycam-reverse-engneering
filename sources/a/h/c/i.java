package a.h.c;

import a.h.b.d.c;
import a.h.g.f;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.viewpager.widget.ViewPager;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TypefaceCompatApi29Impl.java */
/* loaded from: classes.dex */
public class i extends j {
    @Override // a.h.c.j
    public f.b a(f.b[] bVarArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // a.h.c.j
    public Typeface a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // a.h.c.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        int i3;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            FontFamily.Builder builder = null;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : ViewPager.MIN_FLING_VELOCITY, (i2 & 2) != 0 ? 1 : 0)).build();
                }
                f.b bVar = bVarArr[i3];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(bVar.c(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor == null) {
                    i3 = openFileDescriptor == null ? i3 + 1 : 0;
                } else {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(bVar.d());
                        if (!bVar.e()) {
                            i4 = 0;
                        }
                        Font build = weight.setSlant(i4).setTtcIndex(bVar.b()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                        if (openFileDescriptor == null) {
                        }
                    } catch (Throwable th) {
                        if (openFileDescriptor != null) {
                            try {
                                openFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                openFileDescriptor.close();
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // a.h.c.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        try {
            c.C0017c[] a2 = bVar.a();
            int length = a2.length;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    break;
                }
                c.C0017c c0017c = a2[i3];
                try {
                    Font.Builder weight = new Font.Builder(resources, c0017c.b()).setWeight(c0017c.e());
                    if (!c0017c.f()) {
                        i4 = 0;
                    }
                    Font build = weight.setSlant(i4).setTtcIndex(c0017c.c()).setFontVariationSettings(c0017c.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i3++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : ViewPager.MIN_FLING_VELOCITY, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // a.h.c.j
    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
