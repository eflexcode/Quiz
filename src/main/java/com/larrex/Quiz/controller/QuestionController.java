package com.larrex.Quiz.controller;

import com.larrex.Quiz.entity.Question;
import com.larrex.Quiz.entity.QuestionWrapper;
import com.larrex.Quiz.entity.Quiz;
import com.larrex.Quiz.serice.QuestionService;
import com.larrex.Quiz.serice.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question/")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @DeleteMapping("delete/{quizId}/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long quizId,@PathVariable Long questionId){

        questionService.deleteQuestion(quizId, questionId);

        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }

    @PutMapping("update/{quizId}")
    public ResponseEntity<Question> updateQuestion( @RequestBody Question question){

        return new ResponseEntity<Question>(questionService.updateQuestion(question), HttpStatus.OK);
    }

    @PostMapping("add/{quizId}")
    public ResponseEntity<Quiz> addQuestion(@PathVariable Long quizId, @RequestBody Question question){

        return new ResponseEntity<Quiz>(questionService.addQuestion(quizId,question), HttpStatus.OK);
    }


}
