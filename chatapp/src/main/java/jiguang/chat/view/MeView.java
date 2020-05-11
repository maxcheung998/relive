package jiguang.chat.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.callback.IntegerCallback;
import cn.jpush.im.android.api.model.UserInfo;
import cn.jpush.im.api.BasicCallback;
import jiguang.chat.R;
import jiguang.chat.utils.DialogCreator;
import jiguang.chat.utils.ToastUtil;
import jiguang.chat.utils.photochoose.SelectableRoundedImageView;

public class MeView extends LinearLayout {
    private Context mContext;
    private TextView mNickNameTv;
    private SelectableRoundedImageView mTakePhotoBtn;
    private RelativeLayout mSet_pwd;
    private RelativeLayout mQuestions;
    private RelativeLayout mIntroDepression;
    private RelativeLayout mIntroAnxiety;
    private RelativeLayout mChatbot;
    private RelativeLayout mAbout;
    private RelativeLayout mExit;
    private int mWidth;
    private int mHeight;
    private RelativeLayout mRl_personal;

    public MeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

    }


    public void initModule(float density, int width) {
        mTakePhotoBtn = (SelectableRoundedImageView) findViewById(R.id.take_photo_iv);
        mNickNameTv = (TextView) findViewById(R.id.nickName);
        mSet_pwd = (RelativeLayout) findViewById(R.id.setPassword);
        mQuestions = (RelativeLayout) findViewById(R.id.questions);
        mIntroDepression = (RelativeLayout) findViewById(R.id.intro_layout1);
        mIntroAnxiety = (RelativeLayout) findViewById(R.id.intro_layout2);
        mAbout = (RelativeLayout) findViewById(R.id.about);
        mExit = (RelativeLayout) findViewById(R.id.exit);
        mRl_personal = (RelativeLayout) findViewById(R.id.rl_personal);
        mChatbot = (RelativeLayout) findViewById(R.id.chatbot);
        mWidth = width;
        mHeight = (int) (190 * density);


        final Dialog dialog = DialogCreator.createLoadingDialog(mContext, mContext.getString(R.string.jmui_loading));
        dialog.show();

    }

    public void setListener(OnClickListener onClickListener) {
        mSet_pwd.setOnClickListener(onClickListener);
        mQuestions.setOnClickListener(onClickListener);
        mIntroDepression.setOnClickListener(onClickListener);
        mIntroAnxiety.setOnClickListener(onClickListener);
        mChatbot.setOnClickListener(onClickListener);
        mAbout.setOnClickListener(onClickListener);
        mExit.setOnClickListener(onClickListener);
        mRl_personal.setOnClickListener(onClickListener);

    }

    public void showPhoto(Bitmap avatarBitmap) {
        if (avatarBitmap != null) {
            mTakePhotoBtn.setImageBitmap(avatarBitmap);
        }else {
            mTakePhotoBtn.setImageResource(R.drawable.rc_default_portrait);
        }

    }

    public void showNickName(UserInfo myInfo) {
        if (!TextUtils.isEmpty(myInfo.getNickname().trim())) {
            mNickNameTv.setText(myInfo.getNickname());
        } else {
            mNickNameTv.setText(myInfo.getUserName());
        }
    }


}
