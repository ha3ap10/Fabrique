package ru.fabrique.pollingsystem.repository;

import ru.fabrique.pollingsystem.model.Survey;
import ru.fabrique.pollingsystem.model.User;

import java.util.List;

public interface UserRepository {

    List<Survey> getSurveys(User user);
    boolean getUser(User user);
    void save(User user);

}
