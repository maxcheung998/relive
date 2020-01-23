package jiguang.chat.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import jiguang.chat.database.QuestionEntity;

@Dao
public interface QuestionDao
{
    @Insert
    void insertAllQuestions(List<QuestionEntity> questions);

    //@Query("UPDATE questions SET  q_option_state = :selectState WHERE question_id = :questionId AND q_option_id =:optionId")
    //void updateQuestionWithChoice(String selectState, String questionId, String optionId);

    //@Query("SELECT q_option_state FROM questions WHERE question_id = :questionId AND q_option_id =:optionId")
    //String isChecked(String questionId, String optionId);

    @Query("SELECT * FROM questions")
    List<QuestionEntity> getAllQuestions();

    @Query("DELETE FROM questions")
    void deleteAllQuestions();
}
