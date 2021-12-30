package ru.fabrique.pollingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.fabrique.pollingsystem.model.Question;
import ru.fabrique.pollingsystem.model.UserAnswers;

import java.util.Map;

@Repository
public interface AnswersRepository {
    Map<Question, UserAnswers> saveAnswers(Long id, Map<Question, UserAnswers> userAnswersMap);
    Map<Question, UserAnswers> getById(Long id);
}
