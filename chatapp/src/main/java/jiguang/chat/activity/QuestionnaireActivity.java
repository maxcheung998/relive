package jiguang.chat.activity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import jiguang.chat.R;
import jiguang.chat.activity.fragment.RadioBoxesFragment;
import jiguang.chat.adapter.ViewAdapter;
import jiguang.chat.adapter.ViewPagerAdapter;
import jiguang.chat.database.AppDatabase;
import jiguang.chat.database.QuestionEntity;
import jiguang.chat.database.QuestionWithChoicesEntity;
import jiguang.chat.model.AnswerOptions;
import jiguang.chat.model.QuestionDataModel;
import jiguang.chat.model.QuestionsItem;



public class QuestionnaireActivity extends BaseActivity {
//    final ArrayList<RadioBoxesFragment> fragmentArrayList = new ArrayList<RadioBoxesFragment>();
//    List<QuestionsItem> questionsItems = new ArrayList<>();
//    private AppDatabase appDatabase;
//    //private TextView questionToolbarTitle;
//    private TextView questionPositionTV;
//    private String totalQuestions = "1";
//    private Gson gson;
//    private ViewPager questionsViewPager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_questionnaire);
//
//
//        appDatabase = AppDatabase.getAppDatabase(QuestionnaireActivity.this);
//        gson = new Gson();
//
//        if (getIntent().getExtras() != null) {
//            Bundle bundle = getIntent().getExtras();
//            parsingData(bundle);
//        }
//    }
//
//    /*This method decides how many Question-Screen(s) will be created and
//    what kind of (Multiple/Single choices) each Screen will be.*/
//    private void parsingData(Bundle bundle) {
//        QuestionDataModel questionDataModel = new QuestionDataModel();
//
//        questionDataModel = gson.fromJson(bundle.getString("json_questions"), QuestionDataModel.class);
//
//        questionsItems = questionDataModel.getData().getQuestions();
//
//        totalQuestions = String.valueOf(questionsItems.size());
//        String questionPosition = "1/" + totalQuestions;
//        setTextWithSpan(questionPosition);
//
//        preparingQuestionInsertionInDb(questionsItems);
//        preparingInsertionInDb(questionsItems);
//
//        for (int i = 0; i < questionsItems.size(); i++) {
//            QuestionsItem question = questionsItems.get(i);
//
//            if (question.getQuestionTypeName().equals("Radio")) {
//                RadioBoxesFragment radioBoxesFragment = new RadioBoxesFragment();
//                Bundle radioButtonBundle = new Bundle();
//                radioButtonBundle.putParcelable("question", question);
//                radioButtonBundle.putInt("page_position", i);
//                radioBoxesFragment.setArguments(radioButtonBundle);
//                fragmentArrayList.add(radioBoxesFragment);
//            }
//        }
//
//        questionsViewPager = (ViewPager) findViewById(R.id.pager);
//        questionsViewPager.setOffscreenPageLimit(1);
//        ViewAdapter mPagerAdapter = new ViewAdapter(getSupportFragmentManager(), fragmentArrayList);
//        questionsViewPager.setAdapter(mPagerAdapter);
//    }
//
//    public void nextQuestion() {
//        int item = questionsViewPager.getCurrentItem() + 1;
//        questionsViewPager.setCurrentItem(item);
//
//        String currentQuestionPosition = String.valueOf(item + 1);
//
//        String questionPosition = currentQuestionPosition + "/" + totalQuestions;
//        setTextWithSpan(questionPosition);
//    }
//
//    public int getTotalQuestionsSize() {
//        return questionsItems.size();
//    }
//
//    private void preparingQuestionInsertionInDb(List<QuestionsItem> questionsItems) {
//        List<QuestionEntity> questionEntities = new ArrayList<>();
//
//        for (int i = 0; i < questionsItems.size(); i++) {
//            QuestionEntity questionEntity = new QuestionEntity();
//            questionEntity.setQuestionId(questionsItems.get(i).getId());
//            questionEntity.setQuestion(questionsItems.get(i).getQuestionName());
//
//            questionEntities.add(questionEntity);
//        }
//        insertQuestionInDatabase(questionEntities);
//    }
//
//    private void insertQuestionInDatabase(List<QuestionEntity> questionEntities) {
//        Observable.just(questionEntities)
//                .map(this::insertingQuestionInDb)
//                .subscribeOn(Schedulers.io())
//                .subscribe();
//    }
//
//    /*First, clear the table, if any previous data saved in it. Otherwise, we get repeated data.*/
//    private String insertingQuestionInDb(List<QuestionEntity> questionEntities) {
//        appDatabase.getQuestionDao().deleteAllQuestions();
//        appDatabase.getQuestionDao().insertAllQuestions(questionEntities);
//        return "";
//    }
//
//    private void preparingInsertionInDb(List<QuestionsItem> questionsItems) {
//        ArrayList<QuestionWithChoicesEntity> questionWithChoicesEntities = new ArrayList<>();
//
//        for (int i = 0; i < questionsItems.size(); i++) {
//            List<AnswerOptions> answerOptions = questionsItems.get(i).getAnswerOptions();
//
//            for (int j = 0; j < answerOptions.size(); j++) {
//                QuestionWithChoicesEntity questionWithChoicesEntity = new QuestionWithChoicesEntity();
//                questionWithChoicesEntity.setQuestionId(String.valueOf(questionsItems.get(i).getId()));
//                questionWithChoicesEntity.setAnswerChoice(answerOptions.get(j).getName());
//                questionWithChoicesEntity.setAnswerChoicePosition(String.valueOf(j));
//                questionWithChoicesEntity.setAnswerChoiceId(answerOptions.get(j).getAnswerId());
//                questionWithChoicesEntity.setAnswerChoiceState("0");
//
//                questionWithChoicesEntities.add(questionWithChoicesEntity);
//            }
//        }
//
//        insertQuestionWithChoicesInDatabase(questionWithChoicesEntities);
//    }
//
//    private void insertQuestionWithChoicesInDatabase(List<QuestionWithChoicesEntity> questionWithChoicesEntities) {
//        Observable.just(questionWithChoicesEntities)
//                .map(this::insertingQuestionWithChoicesInDb)
//                .subscribeOn(Schedulers.io())
//                .subscribe();
//    }
//
//    /*First, clear the table, if any previous data saved in it. Otherwise, we get repeated data.*/
//    private String insertingQuestionWithChoicesInDb(List<QuestionWithChoicesEntity> questionWithChoicesEntities) {
//        appDatabase.getQuestionChoicesDao().deleteAllChoicesOfQuestion();
//        appDatabase.getQuestionChoicesDao().insertAllChoicesOfQuestion(questionWithChoicesEntities);
//        return "";
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (questionsViewPager.getCurrentItem() == 0) {
//            super.onBackPressed();
//        } else {
//            int item = questionsViewPager.getCurrentItem() - 1;
//            questionsViewPager.setCurrentItem(item);
//
//            String currentQuestionPosition = String.valueOf(item + 1);
//
//            String questionPosition = currentQuestionPosition + "/" + totalQuestions;
//            setTextWithSpan(questionPosition);
//        }
//    }
//
//    private void setTextWithSpan(String questionPosition) {
//        int slashPosition = questionPosition.indexOf("/");
//
//        Spannable spanText = new SpannableString(questionPosition);
//        spanText.setSpan(new RelativeSizeSpan(0.7f), slashPosition, questionPosition.length(), 0);
//        questionPositionTV.setText(spanText);
//    }
}

