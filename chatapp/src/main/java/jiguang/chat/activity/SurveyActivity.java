package jiguang.chat.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.model.Message;
import jiguang.chat.R;
import jiguang.chat.utils.DialogCreator;

public class SurveyActivity extends BaseActivity implements View.OnClickListener {
    private Button mBtn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        initView();
        initListener();
    }

    private void initView() {
        initTitle(true, true, "問卷", "", false, "");
        mBtn_start = (Button) findViewById(R.id.btn_sure);
    }
    private void initListener() {
        mBtn_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sure:
                startActivity(new Intent(this, QuestionsActivity.class));
                break;
            default:
                break;
        }
    }
}
