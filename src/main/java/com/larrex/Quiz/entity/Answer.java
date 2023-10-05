package com.larrex.Quiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class Answer {

    private String title;
    private String answer;

}
