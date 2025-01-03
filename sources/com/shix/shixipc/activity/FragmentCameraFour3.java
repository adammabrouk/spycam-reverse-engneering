package com.shix.shixipc.activity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.activity.FragmentCameraFour3;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.utilcode.LogUtils;
import g.a.a.a;

/* loaded from: classes.dex */
public class FragmentCameraFour3 extends BaseFragment implements NUIMainActivity.PlayFramgent3Interface {
    public String did;
    public GLSurfaceView glVideo;
    public ImageButton ibAdd;
    public boolean isPause;
    public LinearLayout llFragmentFourCenter;
    public FourCameraActivity mAty;
    public Handler mHandle;
    public a myRender;

    private void initView(View view) {
        this.mAty = (FourCameraActivity) requireActivity();
        this.mHandle = new Handler();
        this.llFragmentFourCenter = (LinearLayout) view.findViewById(R.id.ll_fragment_four_center);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) view.findViewById(R.id.glVideo);
        this.glVideo = gLSurfaceView;
        a aVar = new a(gLSurfaceView);
        this.myRender = aVar;
        this.glVideo.setRenderer(aVar);
        NUIMainActivity.setPlayFramgent3Interface(this);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.ib_fragment_add);
        this.ibAdd = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentCameraFour3.this.a(view2);
            }
        });
        final TextView textView = (TextView) view.findViewById(R.id.tv_pause);
        this.glVideo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.shix.shixipc.activity.FragmentCameraFour3.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                FragmentCameraFour3.this.llFragmentFourCenter.setVisibility(0);
                if (FragmentCameraFour3.this.isPause) {
                    textView.setText(FragmentCameraFour3.this.mAty.getResources().getString(R.string.Play));
                } else {
                    textView.setText(FragmentCameraFour3.this.mAty.getResources().getString(R.string.Pause));
                }
                return false;
            }
        });
        view.findViewById(R.id.tv_disconnect).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentCameraFour3.this.b(view2);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentCameraFour3.this.c(view2);
            }
        });
    }

    private void writeSample(final byte[] bArr, final int i2, final int i3) {
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.post(new Runnable() { // from class: c.h.a.a.c0
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentCameraFour3.this.a(bArr, i2, i3);
                }
            });
        }
    }

    public /* synthetic */ void a(View view) {
        this.mAty.addCamera(3);
    }

    public /* synthetic */ void b(View view) {
        closeVideo();
        this.llFragmentFourCenter.setVisibility(8);
    }

    public /* synthetic */ void c(View view) {
        this.isPause = !this.isPause;
        this.llFragmentFourCenter.setVisibility(8);
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.PlayFramgent3Interface
    public void callbackDecVideoData(int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        if (TextUtils.isEmpty(this.did) || !DeviceUtil.INSTANCE.getDid(i2).endsWith(this.did) || this.isPause) {
            return;
        }
        writeSample(bArr, i3, i4);
    }

    public void closeVideo() {
        this.glVideo.setVisibility(8);
        this.ibAdd.setVisibility(0);
        NativeCallerTools.SDKAPICloseLiveStream(this.did);
        this.did = "";
        this.mAty.removeDevId(0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_camera_four, viewGroup, false);
        initView(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (!TextUtils.isEmpty(this.did)) {
            NativeCallerTools.SDKAPICloseLiveStream(this.did);
        }
        NUIMainActivity.setPlayFramgent3Interface(null);
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandle = null;
        }
        LogUtils.d("biniy", "onDestroyView");
        super.onDestroyView();
    }

    public void openVideo(String str) {
        this.glVideo.setVisibility(0);
        this.ibAdd.setVisibility(8);
        this.did = str;
        NativeCallerTools.SDKAPIOpenLiveStream(str, 2);
    }

    public /* synthetic */ void a(byte[] bArr, int i2, int i3) {
        this.myRender.a(bArr, i2, i3);
    }
}
