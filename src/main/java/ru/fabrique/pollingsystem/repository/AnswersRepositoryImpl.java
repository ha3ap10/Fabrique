package ru.fabrique.pollingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.fabrique.pollingsystem.model.Question;
import ru.fabrique.pollingsystem.model.User;
import ru.fabrique.pollingsystem.model.UserAnswers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AnswersRepositoryImpl implements AnswersRepository {
    private Map<Long, Map<Question, UserAnswers>> answersRepository = new ConcurrentHashMap<>();

    @Override
    public Map<Question, UserAnswers> saveAnswers(Long id, Map<Question, UserAnswers> userAnswersMap) {
        answersRepository.put(id, userAnswersMap);
        return userAnswersMap;
    }

    @Override
    public Map<Question, UserAnswers> getById(Long id) {
        return answersRepository.get(id);
    }
}
