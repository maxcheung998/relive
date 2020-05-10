package jiguang.chat.activity;

import android.os.Bundle;
import android.widget.TextView;

import jiguang.chat.R;


public class ScanResultActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scan_result);
        initTitle(true,true, "掃描結果", "", false,"");

        TextView tv_scanResult = (TextView) findViewById(R.id.tv_scanResult);

        String result = getIntent().getStringExtra("result");

        tv_scanResult.setText(result);
    }
}
