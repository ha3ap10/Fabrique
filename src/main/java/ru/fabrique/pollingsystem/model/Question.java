package ru.fabrique.pollingsystem.model;

import lombok.Data;

@Data
public class Question {
    private String text;
    private QuestionType questionType;

}
