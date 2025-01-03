package com.shix.shixipc.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.shix.lookcam.R;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.ToastUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class FileUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    public static boolean copyFile(String str, OutputStream outputStream) {
        try {
            if (new File(str).exists()) {
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[1444];
                int i2 = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        fileInputStream.close();
                        outputStream.close();
                        return true;
                    }
                    i2 += read;
                    System.out.println(i2);
                    outputStream.write(bArr, 0, read);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static void del2Album(Context context, String str) {
        new File(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), ContentCommon.SDCARD_PATH), str.split("/")[r2.length - 1]).delete();
    }

    public static boolean delFile(String str) {
        File file = new File(str);
        if (fileIsExists(str)) {
            return file.delete();
        }
        return false;
    }

    public static boolean fileIsExists(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<File> getFiles(String str, List<File> list) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    getFiles(file2.getAbsolutePath(), list);
                } else if (file2.getName().endsWith("jpg")) {
                    list.add(file2);
                }
            }
        }
        return list;
    }

    public static File getRootDir() {
        return Build.VERSION.SDK_INT > 29 ? CrashApplication.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) : Environment.getExternalStorageDirectory();
    }

    public static ContentValues getVideoContentValues(File file, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(j));
        contentValues.put("date_added", Long.valueOf(j));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    public static List<File> listFileSortByModifyTime(String str) {
        List<File> files = getFiles(str, new ArrayList());
        if (files != null && files.size() > 0) {
            Collections.sort(files, new Comparator<File>() { // from class: com.shix.shixipc.utils.FileUtil.1
                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    if (file.lastModified() < file2.lastModified()) {
                        return -1;
                    }
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
            });
        }
        Collections.reverse(files);
        return files;
    }

    public static void save2Album(final Context context, String str) {
        String str2 = str.split("/")[r0.length - 1];
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), ContentCommon.SDCARD_PATH);
        OutputStream outputStream = null;
        try {
            try {
                try {
                    file.mkdirs();
                    String absolutePath = new File(file, str2).getAbsolutePath();
                    ContentValues contentValues = new ContentValues();
                    ContentResolver contentResolver = context.getContentResolver();
                    contentValues.put("_data", absolutePath);
                    contentValues.put("_display_name", str2);
                    contentValues.put("mime_type", "image/jpg");
                    contentValues.put("datetaken", System.currentTimeMillis() + "");
                    Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    if (insert != null) {
                        outputStream = contentResolver.openOutputStream(insert);
                        BitmapFactory.decodeFile(str).compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                        if (context instanceof Activity) {
                            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.shix.shixipc.utils.FileUtil.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ToastUtils.showLong(context.getResources().getString(R.string.saved_successfully));
                                }
                            });
                        }
                    }
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public static boolean saveVideoToSystemAlbum(String str, Context context) {
        try {
            Uri insert = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, getVideoContentValues(new File(str), System.currentTimeMillis()));
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) {
                try {
                    copyFile(str, context.getContentResolver().openOutputStream(insert));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", insert));
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
