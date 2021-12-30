package ru.fabrique.pollingsystem.service;

import org.springframework.stereotype.Service;
import ru.fabrique.pollingsystem.exceptions.InvalidCredentials;
import ru.fabrique.pollingsystem.exceptions.UnauthorizedUser;
import ru.fabrique.pollingsystem.model.Survey;
import ru.fabrique.pollingsystem.model.User;
import ru.fabrique.pollingsystem.repository.UserRepository;

import java.util.List;


@Service
public class UserService {
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Survey> getSurveys(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }

        if (!userRepository.getUser(user)) {
            throw new UnauthorizedUser("Unknown user " + user.getName());
        }
        return userRepository.getSurveys(user);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

}
