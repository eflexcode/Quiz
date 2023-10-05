package com.larrex.Quiz.serice;

import com.larrex.Quiz.entity.Question;
import com.larrex.Quiz.entity.Quiz;

public interface QuestionService {

    //no need for get question and post question

    Question updateQuestion(Question question);

    void deleteQuestion(Long quizId,Long QuestionId);

    Quiz addQuestion(Long QuizId, Question question);

}
