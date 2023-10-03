package com.larrex.Quiz.serice;

import com.larrex.Quiz.entity.Question;
import com.larrex.Quiz.entity.Quiz;
import com.larrex.Quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuizRepository quizRepository;

    @Override
    public Question updateQuestion(Long quizId, Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(Long quizId, Long questionId) {

        Quiz quiz = findQuestion(quizId);


        for (int i = 0; i<=quiz.getQuestions().size(); i++){

            if (i == questionId){

                quiz.getQuestions().remove(i);

            }

        }

        quizRepository.save(quiz);

    }

    private Quiz findQuestion(Long quizId){

       return quizRepository.findById(quizId).orElseThrow(()-> new ResponseStatusException( HttpStatus.NOT_FOUND,"No quiz found with id: "+quizId));
    }
}
