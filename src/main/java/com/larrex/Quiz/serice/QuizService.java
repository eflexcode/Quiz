package com.larrex.Quiz.serice;

import com.larrex.Quiz.entity.Quiz;
import com.larrex.Quiz.entity.QuizCreateResponse;
import com.larrex.Quiz.entity.QuizWrapper;
import com.larrex.Quiz.entity.UpdateQuiz;

public interface QuizService {

    QuizCreateResponse createQuiz(Quiz quiz);

    QuizWrapper getQuiz(Long id);

    void update(Long id, UpdateQuiz updateQuiz);

    void delete(Long id);


}
