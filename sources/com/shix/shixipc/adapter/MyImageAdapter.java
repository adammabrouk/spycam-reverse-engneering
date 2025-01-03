package com.shix.shixipc.adapter;

import a.x.a.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import c.a.a.e;
import com.hichip.widget.photoview.PhotoView;
import java.util.List;

/* loaded from: classes.dex */
public class MyImageAdapter extends a {
    public static final String TAG = "MyImageAdapter";
    public AppCompatActivity activity;
    public List<String> imageUrls;

    public MyImageAdapter(List<String> list, AppCompatActivity appCompatActivity) {
        this.imageUrls = list;
        this.activity = appCompatActivity;
    }

    @Override // a.x.a.a
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // a.x.a.a
    public int getCount() {
        List<String> list = this.imageUrls;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // a.x.a.a
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // a.x.a.a
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        String str = this.imageUrls.get(i2);
        PhotoView photoView = new PhotoView(this.activity);
        e.a((FragmentActivity) this.activity).a(str).a((ImageView) photoView);
        viewGroup.addView(photoView);
        photoView.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.adapter.MyImageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyImageAdapter.this.activity.finish();
            }
        });
        return photoView;
    }

    @Override // a.x.a.a
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void update(List<String> list) {
        this.imageUrls = list;
        notifyDataSetChanged();
    }
}
