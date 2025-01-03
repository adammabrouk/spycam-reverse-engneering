package com.shix.shixipc.utilcode;

import a.h.b.a;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.he.Constant;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class ImageUtils {

    public enum ImageType {
        TYPE_JPG("jpg"),
        TYPE_PNG("png"),
        TYPE_GIF("gif"),
        TYPE_TIFF("tiff"),
        TYPE_BMP("bmp"),
        TYPE_WEBP("webp"),
        TYPE_ICO("ico"),
        TYPE_UNKNOWN("unknown");

        public String value;

        ImageType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public ImageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Bitmap addBorder(Bitmap bitmap, float f2, int i2, boolean z, float f3, boolean z2) {
        return addBorder(bitmap, f2, i2, z, new float[]{f3, f3, f3, f3, f3, f3, f3, f3}, z2);
    }

    public static Bitmap addCircleBorder(Bitmap bitmap, float f2, int i2) {
        return addBorder(bitmap, f2, i2, true, 0.0f, false);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, float f2, int i2, float f3) {
        return addBorder(bitmap, f2, i2, false, f3, false);
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i2, int i3, int i4) {
        return addImageWatermark(bitmap, bitmap2, i2, i3, i4, false);
    }

    public static Bitmap addReflection(Bitmap bitmap, int i2) {
        return addReflection(bitmap, i2, false);
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, int i2, int i3, float f2, float f3) {
        return addTextWatermark(bitmap, str, i2, i3, f2, f3, false);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        return bitmap2Bytes(bitmap, Bitmap.CompressFormat.PNG, 100);
    }

    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(Utils.getApp().getResources(), bitmap);
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static Drawable bytes2Drawable(byte[] bArr) {
        return bitmap2Drawable(bytes2Bitmap(bArr));
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        while (true) {
            if (i4 <= i3 && i5 <= i2) {
                return i6;
            }
            i4 >>= 1;
            i5 >>= 1;
            i6 <<= 1;
        }
    }

    public static Bitmap clip(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        return clip(bitmap, i2, i3, i4, i5, false);
    }

    public static byte[] compressByQuality(Bitmap bitmap, int i2) {
        return compressByQuality(bitmap, i2, false);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i2) {
        return compressBySampleSize(bitmap, i2, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i2, int i3) {
        return scale(bitmap, i2, i3, false);
    }

    public static Bitmap drawColor(Bitmap bitmap, int i2) {
        return drawColor(bitmap, i2, false);
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            createBitmap = Bitmap.createBitmap(1, 1, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } else {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] drawable2Bytes(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return bitmap2Bytes(drawable2Bitmap(drawable));
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f2, float f3) {
        return fastBlur(bitmap, f2, f3, false, false);
    }

    public static Bitmap getBitmap(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static ImageType getImageType(String str) {
        return getImageType(UtilsBridge.getFileByPath(str));
    }

    public static int getRotateDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int[] getSize(String str) {
        return getSize(UtilsBridge.getFileByPath(str));
    }

    public static boolean isBMP(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 66 && bArr[1] == 77;
    }

    public static boolean isEmptyBitmap(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static boolean isGIF(byte[] bArr) {
        return bArr.length >= 6 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (bArr[4] == 55 || bArr[4] == 57) && bArr[5] == 97;
    }

    public static boolean isImage(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return isImage(file.getPath());
    }

    public static boolean isJPEG(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == -1 && bArr[1] == -40;
    }

    public static boolean isPNG(byte[] bArr) {
        return bArr.length >= 8 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f2) {
        return renderScriptBlur(bitmap, f2, false);
    }

    public static Bitmap rotate(Bitmap bitmap, int i2, float f2, float f3) {
        return rotate(bitmap, i2, f2, f3, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, str, compressFormat, 100, false);
    }

    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return save2Album(bitmap, "", compressFormat, 100, false);
    }

    public static Bitmap scale(Bitmap bitmap, int i2, int i3) {
        return scale(bitmap, i2, i3, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f2, float f3) {
        return skew(bitmap, f2, f3, 0.0f, 0.0f, false);
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i2) {
        return stackBlur(bitmap, i2, false);
    }

    public static Bitmap toAlpha(Bitmap bitmap) {
        return toAlpha(bitmap, false);
    }

    public static Bitmap toGray(Bitmap bitmap) {
        return toGray(bitmap, false);
    }

    public static Bitmap toRound(Bitmap bitmap) {
        return toRound(bitmap, 0, 0, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f2) {
        return toRoundCorner(bitmap, f2, 0.0f, 0, false);
    }

    public static Bitmap view2Bitmap(View view) {
        Bitmap createBitmap;
        if (view == null) {
            return null;
        }
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null || drawingCache.isRecycled()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 == null || drawingCache2.isRecycled()) {
                createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(createBitmap));
            } else {
                createBitmap = Bitmap.createBitmap(drawingCache2);
            }
        } else {
            createBitmap = Bitmap.createBitmap(drawingCache);
        }
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return createBitmap;
    }

    public static Bitmap addBorder(Bitmap bitmap, float f2, int i2, boolean z, float[] fArr, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (!z2) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f2);
        if (z) {
            canvas.drawCircle(width / 2.0f, height / 2.0f, (Math.min(width, height) / 2.0f) - (f2 / 2.0f), paint);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            float f3 = f2 / 2.0f;
            rectF.inset(f3, f3);
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
        return bitmap;
    }

    public static Bitmap addCircleBorder(Bitmap bitmap, float f2, int i2, boolean z) {
        return addBorder(bitmap, f2, i2, true, 0.0f, z);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, float f2, int i2, float[] fArr) {
        return addBorder(bitmap, f2, i2, false, fArr, false);
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i2, int i3, int i4, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (!isEmptyBitmap(bitmap2)) {
            Paint paint = new Paint(1);
            Canvas canvas = new Canvas(copy);
            paint.setAlpha(i4);
            canvas.drawBitmap(bitmap2, i2, i3, paint);
        }
        if (z && !bitmap.isRecycled() && copy != bitmap) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap addReflection(Bitmap bitmap, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height - i2, width, i2, matrix, false);
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height + i2, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f2 = height + 0;
        canvas.drawBitmap(createBitmap, 0.0f, f2, (Paint) null);
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(0.0f, height, 0.0f, createBitmap2.getHeight() + 0, 1895825407, Constant.PPPP_STATUS_UNKNOWN, Shader.TileMode.MIRROR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f2, width, createBitmap2.getHeight(), paint);
        if (!createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
        if (z && !bitmap.isRecycled() && createBitmap2 != bitmap) {
            bitmap.recycle();
        }
        return createBitmap2;
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, float f2, int i2, float f3, float f4, boolean z) {
        if (isEmptyBitmap(bitmap) || str == null) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        Canvas canvas = new Canvas(copy);
        paint.setColor(i2);
        paint.setTextSize(f2);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f3, f4 + f2, paint);
        if (z && !bitmap.isRecycled() && copy != bitmap) {
            bitmap.recycle();
        }
        return copy;
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i2, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap clip(Bitmap bitmap, int i2, int i3, int i4, int i5, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static byte[] compressByQuality(Bitmap bitmap, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i2, int i3, boolean z) {
        return scale(bitmap, i2, i3, z);
    }

    public static Bitmap drawColor(Bitmap bitmap, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        new Canvas(bitmap).drawColor(i2, PorterDuff.Mode.DARKEN);
        return bitmap;
    }

    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i2) {
        if (drawable == null) {
            return null;
        }
        return bitmap2Bytes(drawable2Bitmap(drawable), compressFormat, i2);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f2, float f3, boolean z) {
        return fastBlur(bitmap, f2, f3, z, false);
    }

    public static Bitmap getBitmap(File file, int i2, int i3) {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x002c -> B:12:0x002f). Please report as a decompilation issue!!! */
    public static ImageType getImageType(File file) {
        FileInputStream fileInputStream;
        ImageType imageType;
        FileInputStream fileInputStream2 = null;
        try {
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (file == null) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                imageType = getImageType(fileInputStream);
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            }
            if (imageType == null) {
                fileInputStream.close();
                return null;
            }
            try {
                fileInputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return imageType;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
        }
    }

    public static int[] getSize(File file) {
        if (file == null) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f2, boolean z) {
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        RenderScript renderScript = null;
        try {
            renderScript = RenderScript.create(Utils.getApp());
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius(f2);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
            return bitmap;
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
        }
    }

    public static Bitmap rotate(Bitmap bitmap, int i2, float f2, float f3, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (i2 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i2, f2, f3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, file, compressFormat, 100, false);
    }

    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z) {
        return save2Album(bitmap, "", compressFormat, 100, z);
    }

    public static Bitmap scale(Bitmap bitmap, int i2, int i3, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        if (z && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap skew(Bitmap bitmap, float f2, float f3, boolean z) {
        return skew(bitmap, f2, f3, 0.0f, 0.0f, z);
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i2, boolean z) {
        int[] iArr;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        int i3 = i2 < 1 ? 1 : i2;
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i4 = width * height;
        int[] iArr2 = new int[i4];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3 + 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width, height)];
        int i8 = (i7 + 1) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * RecyclerView.c0.FLAG_TMP_DETACHED;
        int[] iArr7 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr7[i11] = i11 / i9;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, i7, 3);
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            Bitmap bitmap2 = copy;
            int i16 = height;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = -i3;
            int i26 = 0;
            while (i25 <= i3) {
                int i27 = i6;
                int[] iArr9 = iArr6;
                int i28 = iArr2[i14 + Math.min(i5, Math.max(i25, 0))];
                int[] iArr10 = iArr8[i25 + i3];
                iArr10[0] = (i28 & 16711680) >> 16;
                iArr10[1] = (i28 & 65280) >> 8;
                iArr10[2] = i28 & ViewfinderView.OPAQUE;
                int abs = i12 - Math.abs(i25);
                i26 += iArr10[0] * abs;
                i17 += iArr10[1] * abs;
                i18 += iArr10[2] * abs;
                if (i25 > 0) {
                    i22 += iArr10[0];
                    i23 += iArr10[1];
                    i24 += iArr10[2];
                } else {
                    i19 += iArr10[0];
                    i20 += iArr10[1];
                    i21 += iArr10[2];
                }
                i25++;
                i6 = i27;
                iArr6 = iArr9;
            }
            int i29 = i6;
            int[] iArr11 = iArr6;
            int i30 = i26;
            int i31 = i3;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i14] = iArr7[i30];
                iArr4[i14] = iArr7[i17];
                iArr5[i14] = iArr7[i18];
                int i33 = i30 - i19;
                int i34 = i17 - i20;
                int i35 = i18 - i21;
                int[] iArr12 = iArr8[((i31 - i3) + i7) % i7];
                int i36 = i19 - iArr12[0];
                int i37 = i20 - iArr12[1];
                int i38 = i21 - iArr12[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr11[i32] = Math.min(i32 + i3 + 1, i5);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i15 + iArr11[i32]];
                iArr12[0] = (i39 & 16711680) >> 16;
                iArr12[1] = (i39 & 65280) >> 8;
                iArr12[2] = i39 & ViewfinderView.OPAQUE;
                int i40 = i22 + iArr12[0];
                int i41 = i23 + iArr12[1];
                int i42 = i24 + iArr12[2];
                i30 = i33 + i40;
                i17 = i34 + i41;
                i18 = i35 + i42;
                i31 = (i31 + 1) % i7;
                int[] iArr13 = iArr8[i31 % i7];
                i19 = i36 + iArr13[0];
                i20 = i37 + iArr13[1];
                i21 = i38 + iArr13[2];
                i22 = i40 - iArr13[0];
                i23 = i41 - iArr13[1];
                i24 = i42 - iArr13[2];
                i14++;
                i32++;
                iArr7 = iArr;
            }
            i15 += width;
            i13++;
            copy = bitmap2;
            height = i16;
            i6 = i29;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i43 = i6;
        int[] iArr14 = iArr6;
        int i44 = height;
        int[] iArr15 = iArr7;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i3;
            int i47 = i7;
            int[] iArr16 = iArr2;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = i46;
            int i56 = i46 * width;
            int i57 = 0;
            int i58 = 0;
            while (i55 <= i3) {
                int i59 = width;
                int max = Math.max(0, i56) + i45;
                int[] iArr17 = iArr8[i55 + i3];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i55);
                i57 += iArr3[max] * abs2;
                i58 += iArr4[max] * abs2;
                i48 += iArr5[max] * abs2;
                if (i55 > 0) {
                    i52 += iArr17[0];
                    i53 += iArr17[1];
                    i54 += iArr17[2];
                } else {
                    i49 += iArr17[0];
                    i50 += iArr17[1];
                    i51 += iArr17[2];
                }
                int i60 = i43;
                if (i55 < i60) {
                    i56 += i59;
                }
                i55++;
                i43 = i60;
                width = i59;
            }
            int i61 = width;
            int i62 = i43;
            int i63 = i45;
            int i64 = i58;
            int i65 = i3;
            int i66 = i44;
            int i67 = i57;
            int i68 = 0;
            while (i68 < i66) {
                iArr16[i63] = (iArr16[i63] & (-16777216)) | (iArr15[i67] << 16) | (iArr15[i64] << 8) | iArr15[i48];
                int i69 = i67 - i49;
                int i70 = i64 - i50;
                int i71 = i48 - i51;
                int[] iArr18 = iArr8[((i65 - i3) + i47) % i47];
                int i72 = i49 - iArr18[0];
                int i73 = i50 - iArr18[1];
                int i74 = i51 - iArr18[2];
                int i75 = i3;
                if (i45 == 0) {
                    iArr14[i68] = Math.min(i68 + i12, i62) * i61;
                }
                int i76 = iArr14[i68] + i45;
                iArr18[0] = iArr3[i76];
                iArr18[1] = iArr4[i76];
                iArr18[2] = iArr5[i76];
                int i77 = i52 + iArr18[0];
                int i78 = i53 + iArr18[1];
                int i79 = i54 + iArr18[2];
                i67 = i69 + i77;
                i64 = i70 + i78;
                i48 = i71 + i79;
                i65 = (i65 + 1) % i47;
                int[] iArr19 = iArr8[i65];
                i49 = i72 + iArr19[0];
                i50 = i73 + iArr19[1];
                i51 = i74 + iArr19[2];
                i52 = i77 - iArr19[0];
                i53 = i78 - iArr19[1];
                i54 = i79 - iArr19[2];
                i63 += i61;
                i68++;
                i3 = i75;
            }
            i45++;
            i43 = i62;
            i44 = i66;
            i7 = i47;
            iArr2 = iArr16;
            width = i61;
        }
        int i80 = width;
        bitmap3.setPixels(iArr2, 0, i80, 0, 0, i80, i44);
        return bitmap3;
    }

    public static Bitmap toAlpha(Bitmap bitmap, Boolean bool) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap extractAlpha = bitmap.extractAlpha();
        if (bool.booleanValue() && !bitmap.isRecycled() && extractAlpha != bitmap) {
            bitmap.recycle();
        }
        return extractAlpha;
    }

    public static Bitmap toGray(Bitmap bitmap, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRound(Bitmap bitmap, boolean z) {
        return toRound(bitmap, 0, 0, z);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f2, boolean z) {
        return toRoundCorner(bitmap, f2, 0.0f, 0, z);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, float f2, int i2, float[] fArr, boolean z) {
        return addBorder(bitmap, f2, i2, false, fArr, z);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f2, float f3) {
        return scale(bitmap, f2, f3, false);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f2, float f3, boolean z, boolean z2) {
        Bitmap stackBlur;
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Paint paint = new Paint(3);
        Canvas canvas = new Canvas();
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.scale(f2, f2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        if (Build.VERSION.SDK_INT >= 17) {
            stackBlur = renderScriptBlur(createBitmap, f3, z);
        } else {
            stackBlur = stackBlur(createBitmap, (int) f3, z);
        }
        if (f2 != 1.0f && !z2) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(stackBlur, width, height, true);
            if (!stackBlur.isRecycled()) {
                stackBlur.recycle();
            }
            if (z && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
                bitmap.recycle();
            }
            return createScaledBitmap;
        }
        if (z && !bitmap.isRecycled() && stackBlur != bitmap) {
            bitmap.recycle();
        }
        return stackBlur;
    }

    public static boolean isImage(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth > 0) {
                return options.outHeight > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z) {
        return save(bitmap, str, compressFormat, 100, z);
    }

    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        return save2Album(bitmap, "", compressFormat, i2, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f2, float f3, float f4, float f5) {
        return skew(bitmap, f2, f3, f4, f5, false);
    }

    public static Bitmap toRound(Bitmap bitmap, int i2, int i3) {
        return toRound(bitmap, i2, i3, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f2, float f3, int i2) {
        return toRoundCorner(bitmap, f2, f3, i2, false);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, float f2, int i2, float f3, boolean z) {
        return addBorder(bitmap, f2, i2, false, f3, z);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f2, float f3, boolean z) {
        return scale(bitmap, f2, f3, z);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) {
        return save(bitmap, file, compressFormat, 100, z);
    }

    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2, boolean z) {
        return save2Album(bitmap, "", compressFormat, i2, z);
    }

    public static Bitmap skew(Bitmap bitmap, float f2, float f3, float f4, float f5, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setSkew(f2, f3, f4, f5);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRound(Bitmap bitmap, int i2, int i3, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        float f2 = min;
        float f3 = f2 / 2.0f;
        float f4 = width;
        float f5 = height;
        RectF rectF = new RectF(0.0f, 0.0f, f4, f5);
        rectF.inset((width - min) / 2.0f, (height - min) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.setTranslate(rectF.left, rectF.top);
        if (width != height) {
            matrix.preScale(f2 / f4, f2 / f5);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRoundRect(rectF, f3, f3, paint);
        if (i2 > 0) {
            paint.setShader(null);
            paint.setColor(i3);
            paint.setStyle(Paint.Style.STROKE);
            float f6 = i2;
            paint.setStrokeWidth(f6);
            canvas.drawCircle(f4 / 2.0f, f5 / 2.0f, f3 - (f6 / 2.0f), paint);
        }
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float[] fArr, float f2, int i2) {
        return toRoundCorner(bitmap, fArr, f2, i2, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) {
        return save(bitmap, UtilsBridge.getFileByPath(str), compressFormat, i2, false);
    }

    public static File save2Album(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save2Album(bitmap, str, compressFormat, 100, false);
    }

    public static Bitmap scale(Bitmap bitmap, float f2, float f3) {
        return scale(bitmap, f2, f3, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f2, float f3, int i2, boolean z) {
        return toRoundCorner(bitmap, new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, f3, i2, z);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i2) {
        return save(bitmap, file, compressFormat, i2, false);
    }

    public static File save2Album(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z) {
        return save2Album(bitmap, str, compressFormat, 100, z);
    }

    public static Bitmap scale(Bitmap bitmap, float f2, float f3, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float[] fArr, float f2, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        float f3 = f2 / 2.0f;
        rectF.inset(f3, f3);
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        if (f2 > 0.0f) {
            paint.setShader(null);
            paint.setColor(i2);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f2);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawPath(path, paint);
        }
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static byte[] compressByQuality(Bitmap bitmap, long j) {
        return compressByQuality(bitmap, j, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2, boolean z) {
        return save(bitmap, UtilsBridge.getFileByPath(str), compressFormat, i2, z);
    }

    public static File save2Album(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) {
        return save2Album(bitmap, str, compressFormat, i2, false);
    }

    public static byte[] compressByQuality(Bitmap bitmap, long j, boolean z) {
        byte[] byteArray;
        int i2 = 0;
        if (isEmptyBitmap(bitmap) || j <= 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.size() <= j) {
            byteArray = byteArrayOutputStream.toByteArray();
        } else {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= j) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                int i4 = 0;
                while (i2 < i3) {
                    i4 = (i2 + i3) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                    long size = byteArrayOutputStream.size();
                    if (size == j) {
                        break;
                    }
                    if (size > j) {
                        i3 = i4 - 1;
                    } else {
                        i2 = i4 + 1;
                    }
                }
                if (i3 == i4 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                }
                byteArray = byteArrayOutputStream.toByteArray();
            }
        }
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static Bitmap getBitmap(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x005a -> B:27:0x006f). Please report as a decompilation issue!!! */
    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i2, boolean z) {
        boolean z2 = false;
        if (isEmptyBitmap(bitmap)) {
            Log.e("ImageUtils", "bitmap is empty.");
            return false;
        }
        if (bitmap.isRecycled()) {
            Log.e("ImageUtils", "bitmap is recycled.");
            return false;
        }
        if (!UtilsBridge.createFileByDeleteOldFile(file)) {
            Log.e("ImageUtils", "create or delete file <" + file + "> failed.");
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        z2 = bitmap.compress(compressFormat, i2, bufferedOutputStream2);
                        if (z && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream = bufferedOutputStream2;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return z2;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File save2Album(android.graphics.Bitmap r6, java.lang.String r7, android.graphics.Bitmap.CompressFormat r8, int r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utilcode.ImageUtils.save2Album(android.graphics.Bitmap, java.lang.String, android.graphics.Bitmap$CompressFormat, int, boolean):java.io.File");
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i2, int i3) {
        return compressBySampleSize(bitmap, i2, i3, false);
    }

    public static Bitmap getBitmap(String str, int i2, int i3) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i2, int i3, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static ImageType getImageType(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[12];
            if (inputStream.read(bArr) != -1) {
                return getImageType(bArr);
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ImageType getImageType(byte[] bArr) {
        String upperCase = UtilsBridge.bytes2HexString(bArr).toUpperCase();
        if (upperCase.contains("FFD8FF")) {
            return ImageType.TYPE_JPG;
        }
        if (upperCase.contains("89504E47")) {
            return ImageType.TYPE_PNG;
        }
        if (upperCase.contains("47494638")) {
            return ImageType.TYPE_GIF;
        }
        if (!upperCase.contains("49492A00") && !upperCase.contains("4D4D002A")) {
            if (upperCase.contains("424D")) {
                return ImageType.TYPE_BMP;
            }
            if (upperCase.startsWith("52494646") && upperCase.endsWith("57454250")) {
                return ImageType.TYPE_WEBP;
            }
            if (!upperCase.contains("00000100") && !upperCase.contains("00000200")) {
                return ImageType.TYPE_UNKNOWN;
            }
            return ImageType.TYPE_ICO;
        }
        return ImageType.TYPE_TIFF;
    }

    public static Bitmap getBitmap(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap getBitmap(InputStream inputStream, int i2, int i3) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap getBitmap(byte[] bArr, int i2) {
        if (bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, i2, bArr.length);
    }

    public static Bitmap getBitmap(byte[] bArr, int i2, int i3, int i4) {
        if (bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i2, bArr.length, options);
        options.inSampleSize = calculateInSampleSize(options, i3, i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, i2, bArr.length, options);
    }

    public static Bitmap getBitmap(int i2) {
        Drawable c2 = a.c(Utils.getApp(), i2);
        if (c2 == null) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(c2.getIntrinsicWidth(), c2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        c2.setBounds(0, 0, c2.getIntrinsicWidth(), c2.getIntrinsicHeight());
        c2.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getBitmap(int i2, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources resources = Utils.getApp().getResources();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i2, options);
        options.inSampleSize = calculateInSampleSize(options, i3, i4);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i2, options);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            return null;
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor, int i2, int i3) {
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }
}
