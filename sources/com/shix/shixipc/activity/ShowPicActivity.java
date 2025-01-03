package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.g.a.b;
import com.hjq.permissions.Permission;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.ShowPicActivity;
import com.shix.shixipc.adapter.FileShowAdapter;
import com.shix.shixipc.bean.FileDateBean;
import com.shix.shixipc.bean.FileListDateBean;
import com.shix.shixipc.utilcode.FileUtils;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.PermissionXUtils;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ShowPicActivity extends BaseActivity implements View.OnClickListener {
    public static final int REQUEST_CODE = 1024;
    public static final int RP_WRITE = 2;
    public Button btnDelete;
    public Button btnEdit;
    public Button btnSelectAll;
    public String devDid;
    public String devName;
    public LinearLayout llAnim;
    public FileShowAdapter mFileShowAdapter;
    public RecyclerView mFraFilePic;
    public File mPicFile;
    public TextView tvTitle;
    public List<FileDateBean> picList = new ArrayList();
    public List<FileListDateBean> mFileListDateBeans = new ArrayList();
    public boolean isEditModel = false;
    public boolean isSeleteAll = false;
    public boolean hasRequested = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteLocalFile(List<FileListDateBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).getFileDateBeans().size() > 0) {
                for (int i3 = 0; i3 < list.get(i2).getFileDateBeans().size(); i3++) {
                    if (list.get(i2).getFileDateBeans().get(i3).isSelected()) {
                        FileUtils.delete(this.mPicFile.getAbsolutePath() + "/" + list.get(i2).getFileDateBeans().get(i3).getFileName());
                    }
                }
            }
        }
    }

    private List<FileListDateBean> fileGroup2(List<FileDateBean> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str = "";
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).getFileTime().equals(str)) {
                arrayList2.add(list.get(i2));
            } else {
                if (arrayList2.size() > 0) {
                    arrayList.add(new FileListDateBean(str, arrayList2));
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(list.get(i2));
            }
            str = list.get(i2).getFileTime();
            if (i2 == list.size() - 1) {
                arrayList.add(new FileListDateBean(str, arrayList2));
            }
        }
        return arrayList;
    }

    private void getData() {
        this.picList.clear();
        this.mFileListDateBeans.clear();
        toCheckPermission(new PermissionXUtils.OnPermissionCallback() { // from class: com.shix.shixipc.activity.ShowPicActivity.1
            @Override // com.shix.shixipc.utils.PermissionXUtils.OnPermissionCallback
            public void onResult(boolean z) {
            }
        });
        for (File file : FileUtil.listFileSortByModifyTime(this.mPicFile.getAbsolutePath())) {
            this.picList.add(new FileDateBean(file.getName(), TimeUtil.getStringDateShort2("yyyy-MM-dd", file.lastModified()), false));
        }
        this.mFileListDateBeans.addAll(fileGroup2(this.picList));
        FileShowAdapter fileShowAdapter = this.mFileShowAdapter;
        if (fileShowAdapter != null) {
            fileShowAdapter.notifyDataSetChanged();
        }
    }

    private void initAdapter() {
        getData();
        this.mFileShowAdapter = new FileShowAdapter(this, this.devDid, this.mFileListDateBeans, false);
        this.mFraFilePic.setLayoutManager(new LinearLayoutManager(this));
        this.mFraFilePic.setAdapter(this.mFileShowAdapter);
        this.mFileShowAdapter.setOnItemClickListener(new FileShowAdapter.OnItemClickListener() { // from class: c.h.a.a.t0
            @Override // com.shix.shixipc.adapter.FileShowAdapter.OnItemClickListener
            public final void onItemClick(int i2, int i3) {
                ShowPicActivity.this.a(i2, i3);
            }
        });
    }

    private void initData() {
        this.devDid = getIntent().getStringExtra("DEV_DID");
        String stringExtra = getIntent().getStringExtra("DEV_NAME");
        this.devName = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.tvTitle.setText(this.devName);
        }
        if (TextUtils.isEmpty(this.devDid)) {
            return;
        }
        this.mPicFile = new File(FileUtil.getRootDir(), "HDWiFiCam/Snapshot/" + this.devDid);
        initAdapter();
    }

    private void initView() {
        this.tvTitle = (TextView) findViewById(R.id.tv_title);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() { // from class: c.h.a.a.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShowPicActivity.this.a(view);
            }
        });
        this.mFraFilePic = (RecyclerView) findViewById(R.id.recyclerView_show_pic);
        this.llAnim = (LinearLayout) findViewById(R.id.ll_anim);
        this.btnEdit = (Button) findViewById(R.id.btn_edit);
        this.btnSelectAll = (Button) findViewById(R.id.btn_select_all);
        this.btnDelete = (Button) findViewById(R.id.btn_delete);
        this.btnEdit.setOnClickListener(this);
        this.btnSelectAll.setOnClickListener(this);
        this.btnDelete.setOnClickListener(this);
    }

    private void startActivityForResultPic(ArrayList<String> arrayList, int i2) {
        Intent intent = new Intent(this, (Class<?>) PhotoViewActivity.class);
        intent.putStringArrayListExtra("pic_file", arrayList);
        intent.putExtra("pic_index", i2);
        startActivityForResult(intent, 98);
    }

    private void toCheckPermission(PermissionXUtils.OnPermissionCallback onPermissionCallback) {
        if (Build.VERSION.SDK_INT >= 33) {
            PermissionXUtils.getInstance().initPermission(this, b.a(this), new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"}, onPermissionCallback);
        } else {
            PermissionXUtils.getInstance().initPermission(this, b.a(this), new String[]{Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE}, onPermissionCallback);
        }
    }

    public /* synthetic */ void a(View view) {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1024 || Build.VERSION.SDK_INT < 30) {
            if (i2 == 98 && i3 == -1) {
                getData();
                return;
            }
            return;
        }
        if (Environment.isExternalStorageManager()) {
            MyLogUtils.e("权限", "FragmentFile onActivityResult 申请权限 成功");
        } else {
            MyLogUtils.e("权限", "FragmentFile onActivityResult 申请权限 失败");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_delete /* 2131230845 */:
                if (this.mFileShowAdapter.deleteSize() > 0) {
                    final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
                    niftyDialogBuilder.withMessage(getString(R.string.tips_msg_delete_snapshot)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.ShowPicActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            niftyDialogBuilder.dismiss();
                        }
                    }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.ShowPicActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            niftyDialogBuilder.dismiss();
                            ShowPicActivity showPicActivity = ShowPicActivity.this;
                            showPicActivity.deleteLocalFile(showPicActivity.mFileListDateBeans);
                            ShowPicActivity.this.mFileShowAdapter.deleteDate();
                        }
                    }).show();
                    break;
                } else {
                    showToast(getString(R.string.tip_delete_snap));
                    break;
                }
            case R.id.btn_edit /* 2131230846 */:
                if (!this.isEditModel) {
                    this.btnEdit.setText(getString(R.string.done));
                    this.llAnim.setVisibility(0);
                    this.isEditModel = true;
                    this.mFileShowAdapter.updateMode(true);
                    break;
                } else {
                    this.btnEdit.setText(getString(R.string.door_white_list_edit));
                    this.llAnim.setVisibility(8);
                    this.isEditModel = false;
                    this.mFileShowAdapter.updateMode(false);
                    break;
                }
            case R.id.btn_select_all /* 2131230854 */:
                if (this.isSeleteAll) {
                    this.isSeleteAll = false;
                    this.btnSelectAll.setText(getString(R.string.main_select_all));
                } else {
                    this.isSeleteAll = true;
                    this.btnSelectAll.setText(getString(R.string.main_select_reverse));
                }
                this.mFileShowAdapter.selecteAll(this.isSeleteAll);
                break;
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_show_pic);
        initView();
        initData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public /* synthetic */ void a(int i2, int i3) {
        if (this.isEditModel) {
            this.mFileShowAdapter.selecteOne(i2, i3, !this.mFileListDateBeans.get(i2).getFileDateBeans().get(i3).isSelected());
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i4 = 0; i4 < this.mFileListDateBeans.size(); i4++) {
            for (int i5 = 0; i5 < this.mFileListDateBeans.get(i4).getFileDateBeans().size(); i5++) {
                arrayList.add(this.mPicFile.getAbsolutePath() + "/" + this.mFileListDateBeans.get(i4).getFileDateBeans().get(i5).getFileName());
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            if (arrayList.get(i7).equals(this.mPicFile.getAbsolutePath() + "/" + this.mFileListDateBeans.get(i2).getFileDateBeans().get(i3).getFileName())) {
                i6 = i7;
            }
        }
        startActivityForResultPic(arrayList, i6);
    }
}
