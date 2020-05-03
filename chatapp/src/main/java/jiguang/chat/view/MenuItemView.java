package jiguang.chat.view;

import android.view.View;
import android.widget.RelativeLayout;

import jiguang.chat.R;


public class MenuItemView {

    private View mView;
    private RelativeLayout mAddFriendLl;
    private RelativeLayout mSendMsgLl;
    private RelativeLayout mLl_saoYiSao;

    public MenuItemView(View view) {
        this.mView = view;
    }

    public void initModule() {
        mAddFriendLl = mView.findViewById(R.id.add_friend_with_confirm_ll);
        mSendMsgLl = mView.findViewById(R.id.send_message_ll);
        mLl_saoYiSao = mView.findViewById(R.id.ll_saoYiSao);
    }

    public void setListeners(View.OnClickListener listener) {

        mAddFriendLl.setOnClickListener(listener);
        mSendMsgLl.setOnClickListener(listener);
        mLl_saoYiSao.setOnClickListener(listener);
    }

    public void showAddFriendDirect() {
        mAddFriendLl.setVisibility(View.GONE);
    }

    public void showAddFriend() {
        mAddFriendLl.setVisibility(View.VISIBLE);
    }

    public void setColor() {

    }
}
