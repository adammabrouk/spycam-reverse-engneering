package com.shix.shixipc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import c.a.a.e;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.CloudPhotoViewActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utils.ActivityTaskManager;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class CloudPhotoViewActivity extends BaseActivity implements View.OnClickListener {
    public ImageButton ibPhotoMore;
    public ImageView imageView;
    public ImageButton mPhotoBack;
    public String pathTest;
    public PopupWindow popupMoreView;
    public RelativeLayout rlRootCloudPhotoView;
    public TextView textView;

    private void delFile(String str) {
        if (FileUtil.delFile(str)) {
            resultFinish();
        }
    }

    private String getFilePathByContentResolver(Context context, Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            throw new IllegalArgumentException("Query on " + uri + " returns null result.");
        }
        try {
            if (query.getCount() == 1 && query.moveToFirst()) {
                str = query.getString(query.getColumnIndexOrThrow("_data"));
            }
            return str;
        } finally {
            query.close();
        }
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    private void resultDelFinish() {
        Intent intent = new Intent();
        intent.putExtra("del", 1);
        setResult(-1, intent);
        finish();
    }

    private void resultFinish() {
        setResult(-1, getIntent());
        finish();
    }

    private synchronized Uri savePicToSDcard(Bitmap bitmap) {
        Uri uri;
        Uri uri2;
        String strDate = getStrDate();
        FileOutputStream fileOutputStream = null;
        uri2 = null;
        uri2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(FileUtil.getRootDir(), "LDDDD/pic");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, strDate + ".jpg");
                FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                try {
                    if (bitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream3)) {
                        fileOutputStream3.flush();
                    }
                    String path = file2.getPath();
                    if (Build.VERSION.SDK_INT <= 23) {
                        String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "", "");
                        MyLogUtils.d(ContentCommon.SERVER_STRING, "zhaogenghuai savepath:" + insertImage);
                        if (insertImage != null && insertImage.length() > 0) {
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            uri2 = Uri.fromFile(new File(getFilePathByContentResolver(this, Uri.parse(insertImage))));
                            intent.setData(uri2);
                            sendBroadcast(intent);
                        }
                    } else {
                        uri2 = FileProvider.getUriForFile(this, getPackageName() + ".provider", new File(path));
                    }
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream3;
                    uri = null;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    uri2 = uri;
                    return uri2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                uri = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x004f -> B:19:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void savePicToSDcard2(java.lang.String r7) {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r0 = r0.exists()
            if (r0 != 0) goto Lc
            return
        Lc:
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeFile(r7)
            java.lang.String r0 = r6.getStrDate()
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.io.File r3 = com.shix.shixipc.utils.FileUtil.getRootDir()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r4 = "HDWiFiCam/Snapshot/ALLFile"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r3 != 0) goto L33
            r2.mkdirs()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
        L33:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r3.<init>(r2, r1)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            r2 = 100
            boolean r0 = r7.compress(r0, r2, r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            if (r0 == 0) goto L4a
            r1.flush()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
        L4a:
            r1.close()     // Catch: java.io.IOException -> L4e
            goto L66
        L4e:
            r0 = move-exception
            r0.printStackTrace()
            goto L66
        L53:
            r7 = move-exception
            r0 = r1
            goto L6c
        L56:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L5e
        L5b:
            r7 = move-exception
            goto L6c
        L5d:
            r1 = move-exception
        L5e:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L66
            r0.close()     // Catch: java.io.IOException -> L4e
        L66:
            if (r7 == 0) goto L6b
            r7.recycle()
        L6b:
            return
        L6c:
            if (r0 == 0) goto L76
            r0.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r0 = move-exception
            r0.printStackTrace()
        L76:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.CloudPhotoViewActivity.savePicToSDcard2(java.lang.String):void");
    }

    private void showPopupMoreView() {
        PopupWindow popupWindow = this.popupMoreView;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.rlRootCloudPhotoView, 80, 0, 0);
        }
    }

    public /* synthetic */ void a(View view) {
        this.popupMoreView.dismiss();
        try {
            new File(this.pathTest).delete();
            FileUtil.del2Album(this, this.pathTest);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        resultDelFinish();
    }

    public /* synthetic */ void b(View view) {
        this.popupMoreView.dismiss();
        shareImage(this.pathTest);
    }

    public /* synthetic */ void c(View view) {
        this.popupMoreView.dismiss();
        savePicToSDcard2(this.pathTest);
        FileUtil.save2Album(this, this.pathTest);
    }

    public /* synthetic */ void d(View view) {
        this.popupMoreView.dismiss();
    }

    public void initData() {
        String stringExtra = getIntent().getStringExtra("pic_path");
        this.pathTest = stringExtra;
        if (TextUtils.isEmpty(stringExtra) || !new File(this.pathTest).exists()) {
            return;
        }
        this.textView.setText(this.pathTest.split("/")[r0.length - 1]);
        e.a((FragmentActivity) this).a(this.pathTest).a(this.imageView);
    }

    public void initPopupMore() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_popup_more, (ViewGroup) null);
        inflate.findViewById(R.id.tvMoreDel).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloudPhotoViewActivity.this.a(view);
            }
        });
        inflate.findViewById(R.id.tvMoreShared).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloudPhotoViewActivity.this.b(view);
            }
        });
        inflate.findViewById(R.id.tvMoreSave).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloudPhotoViewActivity.this.c(view);
            }
        });
        inflate.findViewById(R.id.tvMoreCancel).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloudPhotoViewActivity.this.d(view);
            }
        });
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
        this.popupMoreView = popupWindow;
        popupWindow.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupMoreView.setFocusable(true);
        this.popupMoreView.setInputMethodMode(1);
        this.popupMoreView.setSoftInputMode(16);
        this.popupMoreView.setOutsideTouchable(true);
        this.popupMoreView.setBackgroundDrawable(new ColorDrawable(0));
        inflate.setFocusableInTouchMode(true);
        inflate.setOnKeyListener(new View.OnKeyListener() { // from class: c.h.a.a.e
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return CloudPhotoViewActivity.this.a(view, i2, keyEvent);
            }
        });
        this.popupMoreView.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: c.h.a.a.d
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                CloudPhotoViewActivity.this.a();
            }
        });
        this.popupMoreView.setTouchInterceptor(new View.OnTouchListener() { // from class: c.h.a.a.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CloudPhotoViewActivity.this.a(view, motionEvent);
            }
        });
    }

    public void initView() {
        this.rlRootCloudPhotoView = (RelativeLayout) findViewById(R.id.rlRootCloudPhotoView);
        this.textView = (TextView) findViewById(R.id.textView);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.ibPhotoMore = (ImageButton) findViewById(R.id.ibPhotoMore);
        this.mPhotoBack = (ImageButton) findViewById(R.id.photo_back);
        this.ibPhotoMore.setOnClickListener(this);
        this.mPhotoBack.setOnClickListener(this);
        initPopupMore();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ibPhotoMore) {
            showPopupMoreView();
        } else {
            if (id != R.id.photo_back) {
                return;
            }
            resultFinish();
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cloud_photo_view);
        BarUtils.setStatusBarVisibility((Activity) this, true);
        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
        ActivityTaskManager.getInstance().putActivity("CloudPhotoViewActivity", this);
        initView();
        initData();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.getAction() != 1) {
            return super.onKeyUp(i2, keyEvent);
        }
        resultFinish();
        return true;
    }

    public void shareImage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            Uri savePicToSDcard = savePicToSDcard(BitmapFactory.decodeFile(str));
            if (Build.VERSION.SDK_INT > 23) {
                intent.setFlags(1);
            }
            intent.putExtra("android.intent.extra.STREAM", savePicToSDcard);
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ boolean a(View view, int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return false;
        }
        this.popupMoreView.dismiss();
        return false;
    }

    public /* synthetic */ void a() {
        this.popupMoreView.dismiss();
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        this.popupMoreView.dismiss();
        return false;
    }
}
