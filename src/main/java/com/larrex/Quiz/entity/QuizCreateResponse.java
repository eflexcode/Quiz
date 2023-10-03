package com.larrex.Quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizCreateResponse {

    private Long QuizId;
    private String message;

}
