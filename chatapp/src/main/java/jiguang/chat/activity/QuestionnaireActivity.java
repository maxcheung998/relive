package jiguang.chat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jiguang.chat.R;

public class QuestionnaireActivity extends BaseActivity {
    private TextView mQuestionsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        initView();
    }

    private void initView() {
        initTitle(true, true, "問卷調查", "", false, "");
        mQuestionsListView = (TextView) findViewById(R.id.textView);
        mQuestionsListView.setText("Test");
    }

}
