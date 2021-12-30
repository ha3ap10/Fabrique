package ru.fabrique.pollingsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.fabrique.pollingsystem.exceptions.InvalidCredentials;
import ru.fabrique.pollingsystem.exceptions.UnauthorizedUser;
import ru.fabrique.pollingsystem.model.*;
import ru.fabrique.pollingsystem.service.UserAnswersService;
import ru.fabrique.pollingsystem.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserAnswersService userAnswersService;

    public UserController(UserService userService, UserAnswersService userAnswersService) {
        this.userService = userService;
        this.userAnswersService = userAnswersService;
    }

    @GetMapping("/surveys")
    public List<Survey> getSurveys(@Valid User user) {
        return userService.getSurveys(user);
    }

    @GetMapping("/surveys/{id}")
    public Map<Question, UserAnswers> getById(@PathVariable Long id) {
        return userAnswersService.getAnswerById(id);
    }

    @PostMapping("/surveys/save")
    public Map<Question, UserAnswers> saveAnswer(@RequestBody Map<Question, UserAnswers> userAnswersMap, @Valid User user) {
        return userAnswersService.saveAnswer(userAnswersMap, user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resolveException(InvalidCredentials exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String resolveException(UnauthorizedUser exception) {
        return exception.getMessage();
    }
}
