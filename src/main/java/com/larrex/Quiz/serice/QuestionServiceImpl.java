package com.larrex.Quiz.serice;

import com.larrex.Quiz.entity.Question;
import com.larrex.Quiz.entity.Quiz;
import com.larrex.Quiz.repository.QuestionRepository;
import com.larrex.Quiz.repository.QuizRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question updateQuestion(Question question) {

        Question oldQuestion = questionRepository.findById(question.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No question found with id: " + question.getId()));

        BeanUtils.copyProperties(question, oldQuestion);

        return questionRepository.save(oldQuestion);
    }

    @Override
    public void deleteQuestion(Long quizId, Long questionId) {

        Quiz quiz = findQuestion(quizId);

        System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee "+quiz.getQuestions().size());

        for (int i = 0; i<quiz.getQuestions().size(); i++){

            System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee "+i);

            if (i == questionId){

                quiz.getQuestions().remove(i);
                System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee "+quiz.getQuestions().size());
                quizRepository.save(quiz);

            }

//            else {
//               throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"No Question found in quiz with id: "+questionId);
//            }

        }


    }

    @Override
    public Quiz addQuestion(Long quizId, Question question) {

        Quiz quiz = findQuestion(quizId);

        quiz.getQuestions().add(question);

        quizRepository.save(quiz);

        return quiz;
    }

    private Quiz findQuestion(Long quizId) {

        return quizRepository.findById(quizId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No quiz found with id: " + quizId));
    }
}
