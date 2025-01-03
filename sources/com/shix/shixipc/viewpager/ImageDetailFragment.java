package com.shix.shixipc.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import c.a.a.e;
import com.hichip.widget.photoview.PhotoViewAttacher;
import com.shix.lookcam.R;

/* loaded from: classes.dex */
public class ImageDetailFragment extends Fragment {
    public PhotoViewAttacher mAttacher;
    public String mImageUrl;
    public ImageView mImageView;

    public static ImageDetailFragment newInstance(String str) {
        ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        imageDetailFragment.setArguments(bundle);
        return imageDetailFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mImageUrl = getArguments() != null ? getArguments().getString("url") : null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_image_detail, viewGroup, false);
        this.mImageView = (ImageView) inflate.findViewById(R.id.image);
        e.b(getContext()).a(this.mImageUrl).a(this.mImageView);
        this.mAttacher = new PhotoViewAttacher(this.mImageView);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.mAttacher != null) {
            this.mAttacher = null;
        }
    }
}
