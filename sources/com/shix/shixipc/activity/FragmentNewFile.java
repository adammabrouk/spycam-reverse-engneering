package com.shix.shixipc.activity;

import a.h.a.a;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.g.a.b;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.adapter.FileShowAdapter;
import com.shix.shixipc.bean.FileDateBean;
import com.shix.shixipc.bean.FileListDateBean;
import com.shix.shixipc.bean.GroupInfo;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.ToastUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.PermissionXUtils;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentNewFile extends BaseFragment implements View.OnClickListener {
    public static final int ACTIVITY_RESULT_PHOTO_VIEW = 10;
    public static final String EXTRA_GIRDLST = "girdlst";
    public static final String EXTRA_POSITION = "position";
    public static final int REQUEST_CODE = 1024;
    public static final int RP_WRITE = 2;
    public Button mBack;
    public Context mContext;
    public Button mFileDelete;
    public Button mFileSelectAll;
    public FileShowAdapter mFileShowAdapter;
    public FileShowAdapter mFileShowAdapter2;
    public RecyclerView mFraFilePic;
    public RecyclerView mFraFileVideo;
    public LinearLayout mLlAnim;
    public Button mOk;
    public TextView mPicturePhone;
    public TextView mPictureRemote;
    public RelativeLayout mRelativeTop;
    public String picFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/Snapshot/" + ContentCommon.SAVEFILES + "/";
    public String videoFile = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/videohead/" + ContentCommon.SAVEFILES + "/";
    public String videoFile2 = FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/";
    public List<FileDateBean> picList = new ArrayList();
    public List<FileDateBean> videoList = new ArrayList();
    public List<FileListDateBean> mFileListDateBeans = new ArrayList();
    public List<FileListDateBean> mFileListDateBeans2 = new ArrayList();
    public boolean isVideo = false;
    public boolean isDeleteModel = false;
    public boolean isSeleteAll = false;
    public int mark = 0;
    public int sum = 0;
    public boolean hasRequested = false;

    private boolean checkHasPermission(String str) {
        return XXPermissions.isGranted(getActivity(), str);
    }

    private void deleteFile(String str) {
        if (FileUtil.fileIsExists(str)) {
            new File(str).delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteLocalFile(List<FileListDateBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).getFileDateBeans().size() > 0) {
                for (int i3 = 0; i3 < list.get(i2).getFileDateBeans().size(); i3++) {
                    if (list.get(i2).getFileDateBeans().get(i3).isSelected()) {
                        if (this.isVideo) {
                            String str = this.videoFile + list.get(i2).getFileDateBeans().get(i3).getFileName();
                            deleteFile(str);
                            String replace = str.replace("IMG_", "").replace("videohead", "video").replace("jpg", "mp4");
                            if (!FileUtil.fileIsExists(replace)) {
                                replace = replace.replace("mp4", "avi");
                            }
                            deleteFile(replace);
                        } else {
                            deleteFile(this.picFile + list.get(i2).getFileDateBeans().get(i3).getFileName());
                        }
                    }
                }
            }
        }
    }

    private GroupInfo fileGroup(List<FileDateBean> list, int i2) {
        int parseInt = Integer.parseInt(list.get(i2).getFileTime().replace("-", ""));
        if (this.mark != parseInt) {
            this.sum = 0;
        }
        GroupInfo groupInfo = new GroupInfo(parseInt, list.get(i2).getFileTime());
        groupInfo.setGroupLength(this.sum + 1);
        groupInfo.setPosition(this.sum);
        this.mark = parseInt;
        this.sum++;
        return groupInfo;
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

    private void initDate() {
        this.videoList.clear();
        this.mFileListDateBeans.clear();
        this.picList.clear();
        this.mFileListDateBeans2.clear();
        toCheckPermission(new PermissionXUtils.OnPermissionCallback() { // from class: com.shix.shixipc.activity.FragmentNewFile.1
            @Override // com.shix.shixipc.utils.PermissionXUtils.OnPermissionCallback
            public void onResult(boolean z) {
            }
        });
        for (File file : FileUtil.listFileSortByModifyTime(this.videoFile)) {
            this.videoList.add(new FileDateBean(file.getName(), TimeUtil.getStringDateShort2("yyyy-MM-dd", file.lastModified()), false));
        }
        this.mFileListDateBeans.addAll(fileGroup2(this.videoList));
        this.mFileShowAdapter.notifyDataSetChanged();
        for (File file2 : FileUtil.listFileSortByModifyTime(this.picFile)) {
            this.picList.add(new FileDateBean(file2.getName(), TimeUtil.getStringDateShort2("yyyy-MM-dd", file2.lastModified()), false));
        }
        this.mFileListDateBeans2.addAll(fileGroup2(this.picList));
        this.mFileShowAdapter2.notifyDataSetChanged();
    }

    private void initView(View view) {
        this.mRelativeTop = (RelativeLayout) view.findViewById(R.id.Relative_top);
        this.mBack = (Button) view.findViewById(R.id.back);
        this.mPicturePhone = (TextView) view.findViewById(R.id.picture_phone);
        this.mPictureRemote = (TextView) view.findViewById(R.id.picture_remote);
        this.mOk = (Button) view.findViewById(R.id.ok);
        this.mFraFilePic = (RecyclerView) view.findViewById(R.id.fra_file_pic);
        this.mFraFileVideo = (RecyclerView) view.findViewById(R.id.fra_file_video);
        this.mLlAnim = (LinearLayout) view.findViewById(R.id.ll_anim);
        this.mFileSelectAll = (Button) view.findViewById(R.id.file_select_all);
        this.mFileDelete = (Button) view.findViewById(R.id.file_delete);
        this.mPicturePhone.setOnClickListener(this);
        this.mPictureRemote.setOnClickListener(this);
        this.mOk.setOnClickListener(this);
        this.mFileSelectAll.setOnClickListener(this);
        this.mFileDelete.setOnClickListener(this);
        this.mFileShowAdapter = new FileShowAdapter(this.mContext, this.mFileListDateBeans, true);
        this.mFileShowAdapter2 = new FileShowAdapter(this.mContext, this.mFileListDateBeans2, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.mContext);
        this.mFraFilePic.setLayoutManager(linearLayoutManager);
        this.mFraFileVideo.setLayoutManager(linearLayoutManager2);
        this.mFraFilePic.setAdapter(this.mFileShowAdapter2);
        this.mFraFileVideo.setAdapter(this.mFileShowAdapter);
        this.mFileShowAdapter.setOnItemClickListener(new FileShowAdapter.OnItemClickListener() { // from class: com.shix.shixipc.activity.FragmentNewFile.2
            @Override // com.shix.shixipc.adapter.FileShowAdapter.OnItemClickListener
            public void onItemClick(int i2, int i3) {
                if (FragmentNewFile.this.isDeleteModel) {
                    FragmentNewFile.this.mFileShowAdapter.selecteOne(i2, i3, !((FileListDateBean) FragmentNewFile.this.mFileListDateBeans.get(i2)).getFileDateBeans().get(i3).isSelected());
                    return;
                }
                if (new File(FragmentNewFile.this.videoFile2, ((FileListDateBean) FragmentNewFile.this.mFileListDateBeans.get(i2)).getFileDateBeans().get(i3).getFileName().replace("IMG_", "").replace(".jpg", ".mp4")).exists()) {
                    FragmentNewFile.this.startActivityForResultVideo(i2, i3);
                } else {
                    ToastUtils.showShort(R.string.local_video_not_exist);
                }
            }
        });
        this.mFileShowAdapter2.setOnItemClickListener(new FileShowAdapter.OnItemClickListener() { // from class: com.shix.shixipc.activity.FragmentNewFile.3
            @Override // com.shix.shixipc.adapter.FileShowAdapter.OnItemClickListener
            public void onItemClick(int i2, int i3) {
                if (FragmentNewFile.this.isDeleteModel) {
                    FragmentNewFile.this.mFileShowAdapter2.selecteOne(i2, i3, !((FileListDateBean) FragmentNewFile.this.mFileListDateBeans2.get(i2)).getFileDateBeans().get(i3).isSelected());
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < FragmentNewFile.this.mFileListDateBeans2.size(); i4++) {
                    for (int i5 = 0; i5 < ((FileListDateBean) FragmentNewFile.this.mFileListDateBeans2.get(i4)).getFileDateBeans().size(); i5++) {
                        arrayList.add(FragmentNewFile.this.picFile + ((FileListDateBean) FragmentNewFile.this.mFileListDateBeans2.get(i4)).getFileDateBeans().get(i5).getFileName());
                    }
                }
                int i6 = 0;
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    if (((String) arrayList.get(i7)).equals(FragmentNewFile.this.picFile + ((FileListDateBean) FragmentNewFile.this.mFileListDateBeans2.get(i2)).getFileDateBeans().get(i3).getFileName())) {
                        i6 = i7;
                    }
                }
                FragmentNewFile.this.startActivityForResultPic(arrayList, i6);
            }
        });
        updateUI(0);
    }

    private void loadAnimation(float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mLlAnim, "translationY", this.mLlAnim.getTranslationY(), f2);
        ofFloat.setDuration(250L);
        ofFloat.start();
    }

    private void openLocalFile(String str) {
        Uri uriForFile;
        if (this.isVideo) {
            str = str.replace("IMG_", "").replace("videohead", "video").replace("jpg", "mp4");
            if (!FileUtil.fileIsExists(str)) {
                str = str.replace("mp4", "avi");
            }
        }
        String str2 = "file://" + str;
        Intent intent = new Intent("android.intent.action.VIEW");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 23) {
            uriForFile = Uri.parse(str2);
        } else if (i2 >= 29) {
            uriForFile = PlayBackTFActivity.getUriFromFile(str, this.mContext);
        } else {
            intent.setFlags(1);
            uriForFile = FileProvider.getUriForFile(this.mContext, "com.shix.lookcam.provider", new File(str));
        }
        if (str.contains(".jpg")) {
            intent.setDataAndType(uriForFile, "image/jpeg");
        } else if (str.contains(".wav")) {
            intent.setDataAndType(uriForFile, "audio/x-wav");
        } else if (str.contains(".mp4")) {
            intent.setDataAndType(uriForFile, "video/mp4");
        } else if (str.contains(".png")) {
            intent.setDataAndType(uriForFile, "image/png");
        } else {
            intent.setDataAndType(uriForFile, "*/*");
        }
        startActivity(intent);
    }

    private void showDialog(boolean z) {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(getActivity()).setTitle(getResources().getString(R.string.sd_card_permissions_title)).setMessage(getResources().getString(R.string.sd_card_permissions_content)).setNegativeButton(getResources().getString(R.string.public_bt_exit), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentNewFile.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (z) {
            negativeButton.setPositiveButton(getResources().getString(R.string.public_bt_go), new DialogInterface.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentNewFile.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    FragmentNewFile.this.toCheckPermission(new PermissionXUtils.OnPermissionCallback() { // from class: com.shix.shixipc.activity.FragmentNewFile.7.1
                        @Override // com.shix.shixipc.utils.PermissionXUtils.OnPermissionCallback
                        public void onResult(boolean z2) {
                        }
                    });
                }
            });
        }
        negativeButton.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startActivityForResultPic(ArrayList<String> arrayList, int i2) {
        Intent intent = new Intent(getActivity(), (Class<?>) PhotoViewActivity.class);
        intent.putStringArrayListExtra("pic_file", arrayList);
        intent.putExtra("pic_index", i2);
        startActivityForResult(intent, 98);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startActivityForResultVideo(int i2, int i3) {
        Intent intent = new Intent(getActivity(), (Class<?>) VideoPlayActivity.class);
        intent.putExtra("FileName", this.mFileListDateBeans.get(i2).getFileDateBeans().get(i3).getFileName());
        startActivityForResult(intent, 99);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCheckPermission(PermissionXUtils.OnPermissionCallback onPermissionCallback) {
        if (Build.VERSION.SDK_INT >= 33) {
            PermissionXUtils.getInstance().initPermission(getActivity(), b.a(this), new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"}, onPermissionCallback);
        } else {
            PermissionXUtils.getInstance().initPermission(getActivity(), b.a(this), new String[]{Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE}, onPermissionCallback);
        }
    }

    private void updateUI(int i2) {
        this.isDeleteModel = false;
        this.isSeleteAll = false;
        this.mFileSelectAll.setText(this.mContext.getString(R.string.main_select_all));
        this.mOk.setText(this.mContext.getString(R.string.door_white_list_edit));
        loadAnimation(CommonUtil.dip2px(this.mContext, 50.0f));
        if (i2 == 0) {
            this.mFraFilePic.setVisibility(0);
            this.mFraFileVideo.setVisibility(8);
            this.mFileShowAdapter2.updateMode(this.isDeleteModel);
            this.mPicturePhone.setBackgroundResource(R.drawable.video_title_bg2);
            this.mPictureRemote.setBackgroundResource(R.drawable.video_title_bg3);
            this.mPicturePhone.setTextColor(getResources().getColor(R.color.black));
            this.mPictureRemote.setTextColor(getResources().getColor(R.color.color_929294));
            this.isVideo = false;
            return;
        }
        if (i2 == 1) {
            this.mFraFilePic.setVisibility(8);
            this.mFraFileVideo.setVisibility(0);
            this.mFileShowAdapter.updateMode(this.isDeleteModel);
            this.mPictureRemote.setBackgroundResource(R.drawable.video_title_bg1);
            this.mPicturePhone.setBackgroundResource(R.drawable.video_title_bg4);
            this.mPictureRemote.setTextColor(getResources().getColor(R.color.black));
            this.mPicturePhone.setTextColor(getResources().getColor(R.color.color_929294));
            this.isVideo = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1024 && Build.VERSION.SDK_INT >= 30) {
            if (Environment.isExternalStorageManager()) {
                MyLogUtils.e("权限", "FragmentFile onActivityResult 申请权限 成功");
                return;
            } else {
                MyLogUtils.e("权限", "FragmentFile onActivityResult 申请权限 失败");
                return;
            }
        }
        if (i2 == 98 && i3 == -1) {
            initDate();
        } else if (i2 == 99 && i3 == -1) {
            initDate();
            updateUI(1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.file_delete /* 2131231015 */:
                if (!this.isVideo) {
                    if (this.mFileShowAdapter2.deleteSize() <= 0) {
                        showToast(this.mContext.getString(R.string.tip_delete_snap));
                        break;
                    }
                } else if (this.mFileShowAdapter.deleteSize() <= 0) {
                    showToast(this.mContext.getString(R.string.tip_delete_snap));
                    break;
                }
                final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this.mContext);
                niftyDialogBuilder.withMessage(getString(R.string.tips_msg_delete_snapshot)).withButton1Text(getString(R.string.btn_no)).withButton2Text(getString(R.string.btn_ok)).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentNewFile.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        niftyDialogBuilder.dismiss();
                    }
                }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.FragmentNewFile.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        niftyDialogBuilder.dismiss();
                        if (FragmentNewFile.this.isVideo) {
                            FragmentNewFile fragmentNewFile = FragmentNewFile.this;
                            fragmentNewFile.deleteLocalFile(fragmentNewFile.mFileListDateBeans);
                            FragmentNewFile.this.mFileShowAdapter.deleteDate();
                        } else {
                            FragmentNewFile fragmentNewFile2 = FragmentNewFile.this;
                            fragmentNewFile2.deleteLocalFile(fragmentNewFile2.mFileListDateBeans2);
                            FragmentNewFile.this.mFileShowAdapter2.deleteDate();
                        }
                    }
                }).show();
                break;
            case R.id.file_select_all /* 2131231016 */:
                if (this.isSeleteAll) {
                    this.isSeleteAll = false;
                    this.mFileSelectAll.setText(this.mContext.getString(R.string.main_select_all));
                } else {
                    this.isSeleteAll = true;
                    this.mFileSelectAll.setText(this.mContext.getString(R.string.main_select_reverse));
                }
                if (!this.isVideo) {
                    this.mFileShowAdapter2.selecteAll(this.isSeleteAll);
                    break;
                } else {
                    this.mFileShowAdapter.selecteAll(this.isSeleteAll);
                    break;
                }
            case R.id.ok /* 2131231273 */:
                if (!this.isDeleteModel) {
                    this.mOk.setText(this.mContext.getString(R.string.done));
                    loadAnimation(CommonUtil.dip2px(this.mContext, -50.0f));
                    this.isDeleteModel = true;
                    if (!this.isVideo) {
                        this.mFileShowAdapter2.updateMode(true);
                        break;
                    } else {
                        this.mFileShowAdapter.updateMode(true);
                        break;
                    }
                } else {
                    this.mOk.setText(this.mContext.getString(R.string.door_white_list_edit));
                    loadAnimation(CommonUtil.dip2px(this.mContext, 50.0f));
                    this.isDeleteModel = false;
                    if (!this.isVideo) {
                        this.mFileShowAdapter2.updateMode(false);
                        break;
                    } else {
                        this.mFileShowAdapter.updateMode(false);
                        break;
                    }
                }
            case R.id.picture_phone /* 2131231294 */:
                updateUI(0);
                break;
            case R.id.picture_remote /* 2131231295 */:
                updateUI(1);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_new_file, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        initDate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        MyLogUtils.e("权限", "FragmentFile 申请权限 提示");
        if (iArr.length == 0) {
            return;
        }
        if (2 != i2) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        if (iArr[0] == 0) {
            MyLogUtils.e("权限", "FragmentFile 申请权限 成功");
            return;
        }
        MyLogUtils.e("权限", "FragmentFile 申请权限 失败");
        if (iArr[0] != 0) {
            if (a.a((Activity) getActivity(), Permission.WRITE_EXTERNAL_STORAGE)) {
                showDialog(true);
            } else {
                showDialog(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isHidden()) {
            return;
        }
        initDate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
    }
}
