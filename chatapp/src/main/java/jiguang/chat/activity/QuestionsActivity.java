package jiguang.chat.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.model.Message;
import jiguang.chat.R;
import jiguang.chat.utils.DialogCreator;

public class QuestionsActivity extends BaseActivity implements View.OnClickListener {
    private JSONObject mObj;
    private JSONArray mQuestions_arr;
    private JSONArray mOption_arr;
    private int mQuestion_count;
    private TextView mQuestion_title;
    private Button mNext_question;
    private Button mQuit;
    private JSONArray mAnswer;
    private RadioGroup mRadioGP;
    private int mStart_count  = 0;
    private TextView mCounter;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        initView();
        initListener();
        StartSurvery();
        count = 0;
    }

    private void initView() {
        initTitle(true, true, "問卷", "", false, "");
        mQuestion_title = (TextView) findViewById(R.id.q_title);
        mNext_question = (Button) findViewById(R.id.qnext);
        mQuit = (Button) findViewById(R.id.buttonquit);
        mRadioGP = (RadioGroup) findViewById(R.id.answersgrp);
        mCounter = (TextView) findViewById(R.id.q_counter);
    }

    private void initListener() {
        mQuit.setOnClickListener(this);
        mNext_question.setOnClickListener(this);
    }

    private void StartSurvery(){
        try {
            mObj = new JSONObject(loadJSONFromAsset());
            mQuestions_arr = mObj.getJSONArray("questions");
            mQuestion_count = mQuestions_arr.length();
            JSONObject jsonObject = mQuestions_arr.getJSONObject(mStart_count);
            SetQuestion(jsonObject);
            Log.d("d2", String.valueOf(mQuestion_count));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void SetQuestion(JSONObject mQuestionObj) {
       // RadioGroup rg = new RadioGroup(this); //create the RadioGroup
        mRadioGP.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.HORIZONTAL
        try {
            mCounter.setText((mStart_count+1)+"/"+mQuestion_count);
            String title = mQuestionObj.getString("question");
            mQuestion_title.setText(title);
            Log.d("d5",title);
            JSONArray mQAnswerArr = mQuestionObj.getJSONArray("options");
            Log.d("d6", String.valueOf(mQAnswerArr));
            final RadioButton[] rb = new RadioButton[mQAnswerArr.length()];
            for (int i = 0; i < mQAnswerArr.length(); ++i) {
                String jsn = mQAnswerArr.get(i).toString();
                rb[i]  = new RadioButton(this);
                rb[i].setText(jsn);
                rb[i].setId(i);
                rb[i].setTextColor(ContextCompat.getColorStateList(this, R.color.radiogroup_selector));
                rb[i].setButtonTintList(ContextCompat.getColorStateList(this, R.color.gray));
                Log.d("d0", String.valueOf(rb[i]));
                mRadioGP.addView(rb[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("survery_question.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Log.d("d1",json);
        return json;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.buttonquit:
                finish();
                break;
            case R.id.qnext:
                Log.d("d8", "hi");
                int checkedRadioButtonId = mRadioGP.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1){
                    count = count + (checkedRadioButtonId);

                    RadioButton radioBtn = (RadioButton) findViewById(checkedRadioButtonId);
                    //Toast.makeText(QuestionsActivity.this, radioBtn.getText(), Toast.LENGTH_SHORT).show();
                    mStart_count++;
                    if (mStart_count < mQuestion_count){
                        try {
                            mRadioGP.clearCheck();
                            mRadioGP.removeAllViews();
                            JSONObject jsonObject = mQuestions_arr.getJSONObject(mStart_count);
                            SetQuestion(jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }else{
                        Log.d("11", String.valueOf(count));
                        String msg;
                        if (count < 8){
                            Toast.makeText(QuestionsActivity.this, "你有個正面態度，加油繼續保持下去！ ", Toast.LENGTH_LONG).show();
                            finish();
                        } else if (count <= 20){
                            //Toast.makeText(QuestionsActivity.this, "你有什麽對我說嗎？來和我一起聊天吧！", Toast.LENGTH_LONG).show();
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                            builder1.setMessage("你有什麽心事對我說嗎？不如同Relive Bot傾傾？");
                            builder1.setCancelable(true);
                            builder1.setPositiveButton(
                                    "好",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                            intent.setClass(QuestionsActivity.this, ChatbotActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });

                            builder1.setNegativeButton(
                                    "不好",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                            finish();
                                        }
                                    });

                            AlertDialog alert11 = builder1.create();
                            alert11.show();

                        } else if (count > 20) {
                            //Toast.makeText(QuestionsActivity.this, "別讓抑鬱打敗你，不如同佢傾傾？", Toast.LENGTH_LONG).show();
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                            builder1.setMessage("別讓抑鬱打敗你，不如打個電話同 OUHK SAO 社工傾一傾？");
                            builder1.setCancelable(true);
                            builder1.setPositiveButton(
                                    "好",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                            //String phone = "+85224667350";
                                            Intent intent = new Intent(Intent.ACTION_DIAL);
                                            intent.setData(Uri.parse("tel:85227686856"));
                                            startActivity(intent);
                                            finish();
                                        }
                                    });

                            builder1.setNegativeButton(
                                    "不好",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                            finish();
                                        }
                                    });

                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        }


                    }
                }else{
                    Toast.makeText(QuestionsActivity.this, "Select your answer.", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }


}
