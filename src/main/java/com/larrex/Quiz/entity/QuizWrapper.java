package com.larrex.Quiz.entity;

import lombok.Data;

import java.util.List;

@Data
public class QuizWrapper {

    private Long id;
    private String title;
    private List<QuestionWrapper> questions;

}
