package com.larrex.Quiz.controller;

import com.larrex.Quiz.entity.*;
import com.larrex.Quiz.serice.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz/")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<QuizCreateResponse> createQuiz(@RequestBody Quiz quiz) {

        QuizCreateResponse quizCreateResponse = quizService.createQuiz(quiz);

        return new ResponseEntity<>(quizCreateResponse, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<QuizWrapper> getQuiz(@PathVariable("id") Long id){

        return new ResponseEntity<QuizWrapper>(quizService.getQuiz(id),HttpStatus.OK);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody UpdateQuiz updateQuiz) {

        quizService.update(id, updateQuiz);


        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {

        quizService.delete(id);


        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("answer/{quizId}")
    public ResponseEntity<List<Answer>> getAnswers(@PathVariable Long quizId){

        return new ResponseEntity<List<Answer>>(quizService.getAnswer(quizId),HttpStatus.OK);
    }

}
