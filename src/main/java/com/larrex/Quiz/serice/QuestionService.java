package com.larrex.Quiz.serice;

import com.larrex.Quiz.entity.Question;

public interface QuestionService {

    //no need for get question and post question

    Question updateQuestion(Long QuizId,Question question);

    void deleteQuestion(Long QuizId,Long QuestionId);

}
