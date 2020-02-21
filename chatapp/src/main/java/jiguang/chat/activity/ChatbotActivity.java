package jiguang.chat.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class ChatbotActivity extends BaseActivity implements View.OnClickListener {
    private Button mBtn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);
        initView();
        //initListener();
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://bot.dialogflow.com/3ae3fbff-c653-447b-be85-8ccc27153362");

    }

    private void initView() {
        initTitle(true, true, "Chatbot", "", false, "");
        mBtn_start = (Button) findViewById(R.id.btn_sure);
    }
    private void initListener() {
//        mBtn_start.setOnClickListener(this);
    }
//
    @Override
    public void onClick(View v) {
//        Uri uri = Uri.parse("https://bot.dialogflow.com/b2a897fa-3eb6-48ec-bcf1-dfab0e830c94");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);
//
    }
}
