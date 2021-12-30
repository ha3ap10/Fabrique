package ru.fabrique.pollingsystem.service;

import org.springframework.stereotype.Service;
import ru.fabrique.pollingsystem.model.Question;
import ru.fabrique.pollingsystem.model.User;
import ru.fabrique.pollingsystem.model.UserAnswers;
import ru.fabrique.pollingsystem.repository.AnswersRepository;

import java.util.Map;

@Service
public class UserAnswersService {
    private AnswersRepository answersRepository;

    public UserAnswersService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    public Map<Question, UserAnswers> saveAnswer(Map<Question, UserAnswers> userAnswersMap, User user) {
        return answersRepository.saveAnswers(user.getId(), userAnswersMap);
    }

    public Map<Question, UserAnswers> getAnswerById(Long id) {
        return answersRepository.getById(id);
    }
}
