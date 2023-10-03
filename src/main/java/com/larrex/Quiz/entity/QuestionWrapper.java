package com.larrex.Quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWrapper {

    private Long id;
    private String title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
