package com.shix.shixipc.gridview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.LruCache;
import com.shix.shixipc.utils.MyLogUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class NativeImageLoader {
    public static final String TAG = "NativeImageLoader";
    public static NativeImageLoader mInstance = new NativeImageLoader();
    public static LruCache<String, Bitmap> mMemoryCache;
    public ExecutorService mImageThreadPool = Executors.newFixedThreadPool(1);

    public interface NativeImageCallBack {
        void onImageLoader(Bitmap bitmap, String str);
    }

    public NativeImageLoader() {
        mMemoryCache = new LruCache<String, Bitmap>(((int) Runtime.getRuntime().maxMemory()) / 4) { // from class: com.shix.shixipc.gridview.NativeImageLoader.1
            @Override // android.util.LruCache
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBitmapToMemoryCache(String str, Bitmap bitmap) {
        if (getBitmapFromMemCache(str) != null || bitmap == null) {
            return;
        }
        mMemoryCache.put(str, bitmap);
    }

    private int computeScale(BitmapFactory.Options options, int i2, int i3) {
        if (i2 == 0 || i2 == 0) {
            return 1;
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i4 <= i2 && i5 <= i2) {
            return 1;
        }
        float f2 = i2;
        int round = Math.round(i4 / f2);
        int round2 = Math.round(i5 / f2);
        return round < round2 ? round : round2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap decodeThumbBitmapForFile(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = computeScale(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    private Bitmap getBitmapFromMemCache(String str) {
        Bitmap bitmap = mMemoryCache.get(str);
        if (bitmap != null) {
            MyLogUtils.i(TAG, "get image for MemCache , path = " + str);
        }
        return bitmap;
    }

    public static NativeImageLoader getInstance() {
        return mInstance;
    }

    public Bitmap loadNativeImage(String str, NativeImageCallBack nativeImageCallBack) {
        return loadNativeImage(str, null, nativeImageCallBack);
    }

    public Bitmap loadNativeImage(final String str, final Point point, final NativeImageCallBack nativeImageCallBack) {
        Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
        final Handler handler = new Handler() { // from class: com.shix.shixipc.gridview.NativeImageLoader.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                nativeImageCallBack.onImageLoader((Bitmap) message.obj, str);
            }
        };
        if (bitmapFromMemCache == null) {
            this.mImageThreadPool.execute(new Runnable() { // from class: com.shix.shixipc.gridview.NativeImageLoader.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeImageLoader nativeImageLoader = NativeImageLoader.this;
                    String str2 = str;
                    Point point2 = point;
                    int i2 = point2 == null ? 0 : point2.x;
                    Point point3 = point;
                    Bitmap decodeThumbBitmapForFile = nativeImageLoader.decodeThumbBitmapForFile(str2, i2, point3 != null ? point3.y : 0);
                    Message obtainMessage = handler.obtainMessage();
                    obtainMessage.obj = decodeThumbBitmapForFile;
                    handler.sendMessage(obtainMessage);
                    NativeImageLoader.this.addBitmapToMemoryCache(str, decodeThumbBitmapForFile);
                }
            });
        }
        return bitmapFromMemCache;
    }
}
