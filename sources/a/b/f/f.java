package a.b.f;

import a.b.f.x;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;

/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f473b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static f f474c;

    /* renamed from: a, reason: collision with root package name */
    public x f475a;

    /* compiled from: AppCompatDrawableManager.java */
    public class a implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f476a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        public final int[] f477b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        public final int[] f478c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d, reason: collision with root package name */
        public final int[] f479d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        public final int[] f480e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        public final int[] f481f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        public final ColorStateList a(Context context) {
            return b(context, 0);
        }

        public final ColorStateList b(Context context) {
            return b(context, b0.b(context, R$attr.colorAccent));
        }

        public final ColorStateList c(Context context) {
            return b(context, b0.b(context, R$attr.colorButtonNormal));
        }

        public final ColorStateList d(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList c2 = b0.c(context, R$attr.colorSwitchThumbNormal);
            if (c2 == null || !c2.isStateful()) {
                iArr[0] = b0.f432b;
                iArr2[0] = b0.a(context, R$attr.colorSwitchThumbNormal);
                iArr[1] = b0.f435e;
                iArr2[1] = b0.b(context, R$attr.colorControlActivated);
                iArr[2] = b0.f436f;
                iArr2[2] = b0.b(context, R$attr.colorSwitchThumbNormal);
            } else {
                iArr[0] = b0.f432b;
                iArr2[0] = c2.getColorForState(iArr[0], 0);
                iArr[1] = b0.f435e;
                iArr2[1] = b0.b(context, R$attr.colorControlActivated);
                iArr[2] = b0.f436f;
                iArr2[2] = c2.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        @Override // a.b.f.x.f
        public Drawable a(x xVar, Context context, int i2) {
            if (i2 == R$drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{xVar.b(context, R$drawable.abc_cab_background_internal_bg), xVar.b(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i2 == R$drawable.abc_ratingbar_material) {
                return b(xVar, context, R$dimen.abc_star_big);
            }
            if (i2 == R$drawable.abc_ratingbar_indicator_material) {
                return b(xVar, context, R$dimen.abc_star_medium);
            }
            if (i2 == R$drawable.abc_ratingbar_small_material) {
                return b(xVar, context, R$dimen.abc_star_small);
            }
            return null;
        }

        public final ColorStateList b(Context context, int i2) {
            int b2 = b0.b(context, R$attr.colorControlHighlight);
            return new ColorStateList(new int[][]{b0.f432b, b0.f434d, b0.f433c, b0.f436f}, new int[]{b0.a(context, R$attr.colorButtonNormal), a.h.c.a.b(b2, i2), a.h.c.a.b(b2, i2), i2});
        }

        public final void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
            if (r.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = f.f473b;
            }
            drawable.setColorFilter(f.a(i2, mode));
        }

        public final LayerDrawable b(x xVar, Context context, int i2) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
            Drawable b2 = xVar.b(context, R$drawable.abc_star_black_48dp);
            Drawable b3 = xVar.b(context, R$drawable.abc_star_half_black_48dp);
            if ((b2 instanceof BitmapDrawable) && b2.getIntrinsicWidth() == dimensionPixelSize && b2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) b2;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                b2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                b2.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((b3 instanceof BitmapDrawable) && b3.getIntrinsicWidth() == dimensionPixelSize && b3.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) b3;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                b3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                b3.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        public final boolean a(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        @Override // a.b.f.x.f
        public ColorStateList a(Context context, int i2) {
            if (i2 == R$drawable.abc_edit_text_material) {
                return a.b.b.a.a.b(context, R$color.abc_tint_edittext);
            }
            if (i2 == R$drawable.abc_switch_track_mtrl_alpha) {
                return a.b.b.a.a.b(context, R$color.abc_tint_switch_track);
            }
            if (i2 == R$drawable.abc_switch_thumb_material) {
                return d(context);
            }
            if (i2 == R$drawable.abc_btn_default_mtrl_shape) {
                return c(context);
            }
            if (i2 == R$drawable.abc_btn_borderless_material) {
                return a(context);
            }
            if (i2 == R$drawable.abc_btn_colored_material) {
                return b(context);
            }
            if (i2 != R$drawable.abc_spinner_mtrl_am_alpha && i2 != R$drawable.abc_spinner_textfield_background_material) {
                if (a(this.f477b, i2)) {
                    return b0.c(context, R$attr.colorControlNormal);
                }
                if (a(this.f480e, i2)) {
                    return a.b.b.a.a.b(context, R$color.abc_tint_default);
                }
                if (a(this.f481f, i2)) {
                    return a.b.b.a.a.b(context, R$color.abc_tint_btn_checkable);
                }
                if (i2 == R$drawable.abc_seekbar_thumb_material) {
                    return a.b.b.a.a.b(context, R$color.abc_tint_seek_thumb);
                }
                return null;
            }
            return a.b.b.a.a.b(context, R$color.abc_tint_spinner);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
        @Override // a.b.f.x.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = a.b.f.f.a()
                int[] r1 = r6.f476a
                boolean r1 = r6.a(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L17
                int r2 = androidx.appcompat.R$attr.colorControlNormal
            L14:
                r8 = -1
            L15:
                r1 = 1
                goto L44
            L17:
                int[] r1 = r6.f478c
                boolean r1 = r6.a(r1, r8)
                if (r1 == 0) goto L22
                int r2 = androidx.appcompat.R$attr.colorControlActivated
                goto L14
            L22:
                int[] r1 = r6.f479d
                boolean r1 = r6.a(r1, r8)
                if (r1 == 0) goto L2d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L14
            L2d:
                int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L3c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L15
            L3c:
                int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r8 != r1) goto L41
                goto L14
            L41:
                r8 = -1
                r1 = 0
                r2 = 0
            L44:
                if (r1 == 0) goto L61
                boolean r1 = a.b.f.r.a(r9)
                if (r1 == 0) goto L50
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L50:
                int r7 = a.b.f.b0.b(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = a.b.f.f.a(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L60
                r9.setAlpha(r8)
            L60:
                return r5
            L61:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: a.b.f.f.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // a.b.f.x.f
        public boolean b(Context context, int i2, Drawable drawable) {
            if (i2 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                a(layerDrawable.findDrawableByLayerId(R.id.background), b0.b(context, R$attr.colorControlNormal), f.f473b);
                a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), b0.b(context, R$attr.colorControlNormal), f.f473b);
                a(layerDrawable.findDrawableByLayerId(R.id.progress), b0.b(context, R$attr.colorControlActivated), f.f473b);
                return true;
            }
            if (i2 != R$drawable.abc_ratingbar_material && i2 != R$drawable.abc_ratingbar_indicator_material && i2 != R$drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(R.id.background), b0.a(context, R$attr.colorControlNormal), f.f473b);
            a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), b0.b(context, R$attr.colorControlActivated), f.f473b);
            a(layerDrawable2.findDrawableByLayerId(R.id.progress), b0.b(context, R$attr.colorControlActivated), f.f473b);
            return true;
        }

        @Override // a.b.f.x.f
        public PorterDuff.Mode a(int i2) {
            if (i2 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (f474c == null) {
                c();
            }
            fVar = f474c;
        }
        return fVar;
    }

    public static synchronized void c() {
        synchronized (f.class) {
            if (f474c == null) {
                f fVar = new f();
                f474c = fVar;
                fVar.f475a = x.a();
                f474c.f475a.a(new a());
            }
        }
    }

    public synchronized Drawable a(Context context, int i2) {
        return this.f475a.b(context, i2);
    }

    public synchronized Drawable a(Context context, int i2, boolean z) {
        return this.f475a.a(context, i2, z);
    }

    public synchronized void a(Context context) {
        this.f475a.b(context);
    }

    public synchronized ColorStateList b(Context context, int i2) {
        return this.f475a.c(context, i2);
    }

    public static void a(Drawable drawable, e0 e0Var, int[] iArr) {
        x.a(drawable, e0Var, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (f.class) {
            a2 = x.a(i2, mode);
        }
        return a2;
    }
}
