package jiguang.chat.view;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jiguang.chat.R;
import jiguang.chat.utils.SharePreferenceManager;

/**
 * Created by ${chenyn} on 2017/2/20.
 */

public class MainView extends RelativeLayout {

    private Button[] mBtnList;
    private int[] mBtnListID;
    private ScrollControlViewPager mViewContainer;
    private TextView mAllContactNumber;

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initModule() {
        mBtnListID = new int[] {
                R.id.actionbar_msg_btn, R.id.actionbar_chatroom_btn,
                R.id.actionbar_contact_btn, R.id.actionbar_me_btn};
        mBtnList = new Button[mBtnListID.length];
        for (int i = 0; i < mBtnListID.length; i++) {
            mBtnList[i] = (Button) findViewById(mBtnListID[i]);
        }
        mViewContainer = (ScrollControlViewPager) findViewById(R.id.viewpager);
        mViewContainer.setOffscreenPageLimit(2);
        mBtnList[0].setTextColor(getResources().getColor(R.color.actionbar_pres_color));
        mBtnList[0].setSelected(true);
        mAllContactNumber = findViewById(R.id.all_contact_number);
        if (SharePreferenceManager.getCachedNewFriendNum() > 0) {
            mAllContactNumber.setVisibility(VISIBLE);
            mAllContactNumber.setText(String.valueOf(SharePreferenceManager.getCachedNewFriendNum()));
        } else {
            mAllContactNumber.setVisibility(GONE);
        }
    }

    public void setOnClickListener(OnClickListener onclickListener) {
        for (int i = 0; i < mBtnListID.length; i++) {
            mBtnList[i].setOnClickListener(onclickListener);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        mViewContainer.addOnPageChangeListener(onPageChangeListener);
    }

    public void setViewPagerAdapter(FragmentPagerAdapter adapter) {
        mViewContainer.setAdapter(adapter);
    }

    public void setCurrentItem(int index, boolean scroll) {
        mViewContainer.setCurrentItem(index, scroll);
    }

    public void setButtonColor(int index) {
        for (int i = 0; i < mBtnListID.length; i++) {
            if (index == i) {
                mBtnList[i].setSelected(true);
                mBtnList[i].setTextColor(getResources().getColor(R.color.actionbar_pres_color));
            } else {
                mBtnList[i].setSelected(false);
                mBtnList[i].setTextColor(getResources().getColor(R.color.action_bar_txt_color));
            }
        }
    }


}
