package com.larrex.Quiz.serice;

import com.larrex.Quiz.entity.*;
import com.larrex.Quiz.repository.QuizRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    QuizRepository quizRepository;

    @Override
    public QuizCreateResponse createQuiz(Quiz quiz) {

        Quiz savedQuiz = quizRepository.save(quiz);

        return new QuizCreateResponse(savedQuiz.getId(),"Quiz saved Successfully");
    }

    @Override
    public QuizWrapper getQuiz(Long id) {

        Quiz quiz = findQuizById(id);
        QuizWrapper quizWrapper = new QuizWrapper();
        quizWrapper.setId(quiz.getId());
        quizWrapper.setTitle(quiz.getTitle());
        List<QuestionWrapper> questionWrappers = new ArrayList<>();

        for (Question question : quiz.getQuestions()){

            QuestionWrapper questionWrapper = new QuestionWrapper();

            BeanUtils.copyProperties(question,questionWrapper);
           questionWrappers.add(questionWrapper);
        }

        quizWrapper.setQuestions(questionWrappers);
        return quizWrapper;
    }

    @Override
    public void update(Long id, UpdateQuiz updateQuiz) {

        Quiz quiz = findQuizById(id);
        quiz.setTitle(updateQuiz.getTitle());

        quizRepository.save(quiz);

    }

    @Override
    public void delete(Long id) {

        quizRepository.deleteById(id);

    }

    @Override
    public List<Answer> getAnswer(Long quizId) {

        Quiz quiz = findQuizById(quizId);

        List<Answer> answers = new ArrayList<>();

        for (Question question : quiz.getQuestions()){

            answers.add(new Answer(question.getTitle(),question.getRightAnswer()));

        }

        return answers;
    }

    private Quiz findQuizById(Long id){

        return  quizRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No Quiz Found With ID :"+id));

    }

}
