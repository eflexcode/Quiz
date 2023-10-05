package com.larrex.Quiz.serice;

import com.larrex.Quiz.entity.*;

import java.util.List;

public interface QuizService {

    QuizCreateResponse createQuiz(Quiz quiz);

    QuizWrapper getQuiz(Long id);

    void update(Long id, UpdateQuiz updateQuiz);

    void delete(Long id);

    List<Answer> getAnswer(Long quizId);

}
