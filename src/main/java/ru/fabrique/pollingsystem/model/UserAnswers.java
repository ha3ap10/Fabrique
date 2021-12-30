package ru.fabrique.pollingsystem.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserAnswers {
    private List<Answer> answers = new ArrayList<>();
}
