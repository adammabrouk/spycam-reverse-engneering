package com.shix.shixipc.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.PhotoViewActivity;
import com.shix.shixipc.adapter.MyImageAdapter;
import com.shix.shixipc.he.SpUtil;
import com.shix.shixipc.utilcode.BarUtils;
import com.shix.shixipc.utilcode.ToastUtils;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.view.PhotoViewPager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/* loaded from: classes.dex */
public class PhotoViewActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = PhotoViewActivity.class.getSimpleName();
    public List<String> Urls;
    public MyImageAdapter adapter;
    public int currentPosition;
    public ImageButton ibPhotoMore;
    public ImageButton mPhotoBack;
    public TextView mTvImageCount;
    public PhotoViewPager mViewPager;
    public PopupWindow popupMoreView;
    public RelativeLayout rlRootPhotoView;

    private void delFile() {
        String str = this.Urls.get(this.currentPosition);
        if (FileUtil.delFile(str)) {
            this.Urls.remove(str);
            if (this.Urls.size() <= 0) {
                resultFinish();
                return;
            }
            this.adapter.update(this.Urls);
            this.mTvImageCount.setText((this.currentPosition + 1) + "/" + this.Urls.size());
        }
    }

    private void resultFinish() {
        setResult(-1, getIntent());
        finish();
    }

    private void shared() throws FileNotFoundException {
        Intent intent = new Intent();
        intent.addFlags(3);
        intent.setAction("android.intent.action.SEND");
        int i2 = getApplicationInfo().targetSdkVersion;
        File file = new File(this.Urls.get(this.currentPosition));
        intent.putExtra("android.intent.extra.STREAM", (i2 < 24 || Build.VERSION.SDK_INT < 24) ? Uri.fromFile(new File(file.getPath())) : Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null)));
        intent.setType("image/*");
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
    }

    private void shared2() {
        Uri uriForFile;
        Intent intent = new Intent("android.intent.action.SEND");
        String str = "file://" + this.Urls.get(this.currentPosition);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 23) {
            uriForFile = Uri.parse(str);
        } else if (i2 >= 29) {
            uriForFile = PlayBackTFActivity.getUriFromFile(this.Urls.get(this.currentPosition), this);
        } else {
            intent.setFlags(1);
            uriForFile = FileProvider.getUriForFile(this, "com.shix.lookcam.provider", new File(this.Urls.get(this.currentPosition)));
        }
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
    }

    private void showPopupMoreView() {
        PopupWindow popupWindow = this.popupMoreView;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.rlRootPhotoView, 80, 0, 0);
        }
    }

    public /* synthetic */ void a(View view) {
        this.popupMoreView.dismiss();
        delFile();
    }

    public /* synthetic */ void b(View view) {
        this.popupMoreView.dismiss();
        try {
            shared();
        } catch (Exception unused) {
            ToastUtils.showLong("Found not file!");
        }
    }

    public /* synthetic */ void c(View view) {
        this.popupMoreView.dismiss();
        FileUtil.save2Album(this, this.Urls.get(this.currentPosition));
    }

    public /* synthetic */ void d(View view) {
        this.popupMoreView.dismiss();
    }

    public void initData() {
        Intent intent = getIntent();
        this.Urls = intent.getStringArrayListExtra("pic_file");
        this.currentPosition = intent.getIntExtra("pic_index", 0);
        MyImageAdapter myImageAdapter = new MyImageAdapter(this.Urls, this);
        this.adapter = myImageAdapter;
        this.mViewPager.setAdapter(myImageAdapter);
        this.mViewPager.setCurrentItem(this.currentPosition, false);
        if (this.Urls != null) {
            this.mTvImageCount.setText((this.currentPosition + 1) + "/" + this.Urls.size());
            this.mViewPager.addOnPageChangeListener(new ViewPager.m() { // from class: com.shix.shixipc.activity.PhotoViewActivity.1
                @Override // androidx.viewpager.widget.ViewPager.m, androidx.viewpager.widget.ViewPager.j
                public void onPageSelected(int i2) {
                    super.onPageSelected(i2);
                    PhotoViewActivity.this.currentPosition = i2;
                    PhotoViewActivity.this.mTvImageCount.setText((PhotoViewActivity.this.currentPosition + 1) + "/" + PhotoViewActivity.this.Urls.size());
                }
            });
        }
        initPopupMore();
    }

    public void initPopupMore() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_popup_more, (ViewGroup) null);
        inflate.findViewById(R.id.tvMoreDel).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewActivity.this.a(view);
            }
        });
        inflate.findViewById(R.id.tvMoreShared).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewActivity.this.b(view);
            }
        });
        inflate.findViewById(R.id.tvMoreSave).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewActivity.this.c(view);
            }
        });
        inflate.findViewById(R.id.tvMoreCancel).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewActivity.this.d(view);
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
        inflate.setOnKeyListener(new View.OnKeyListener() { // from class: c.h.a.a.n0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return PhotoViewActivity.this.a(view, i2, keyEvent);
            }
        });
        this.popupMoreView.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: c.h.a.a.m0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                PhotoViewActivity.this.a();
            }
        });
        this.popupMoreView.setTouchInterceptor(new View.OnTouchListener() { // from class: c.h.a.a.o0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PhotoViewActivity.this.a(view, motionEvent);
            }
        });
    }

    public void initView() {
        SpUtil.INSTANCE.encode("isFileRefresh", (Object) false);
        this.rlRootPhotoView = (RelativeLayout) findViewById(R.id.rlRootPhotoView);
        this.mViewPager = (PhotoViewPager) findViewById(R.id.view_pager_photo);
        this.mTvImageCount = (TextView) findViewById(R.id.tv_image_count);
        this.ibPhotoMore = (ImageButton) findViewById(R.id.ibPhotoMore);
        this.mPhotoBack = (ImageButton) findViewById(R.id.photo_back);
        this.ibPhotoMore.setOnClickListener(this);
        this.mPhotoBack.setOnClickListener(this);
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
        setContentView(R.layout.activity_photo_view);
        BarUtils.setStatusBarVisibility((Activity) this, true);
        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.colorPrimary));
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
