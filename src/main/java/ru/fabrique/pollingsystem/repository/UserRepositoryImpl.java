package ru.fabrique.pollingsystem.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.fabrique.pollingsystem.model.Survey;
import ru.fabrique.pollingsystem.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<Long, User> users = new HashMap<>();

    @Override
    public List<Survey> getSurveys(User user) {
        return users.get(user.getId()).getSurveys();
    }

    @Override
    public boolean getUser(User user) {
        return users.containsKey(user.getId());
    }

    @Override
    public synchronized void save(User user) {
        users.put(user.getId(), user);
    }
}
