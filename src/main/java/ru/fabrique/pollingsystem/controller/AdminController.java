package ru.fabrique.pollingsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.fabrique.pollingsystem.exceptions.NotFound;
import ru.fabrique.pollingsystem.model.Survey;
import ru.fabrique.pollingsystem.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/surveys")
    public List<Survey> getSurveys() {
        return adminService.getSurveys();
    }

    @GetMapping("/surveys/{id}")
    public Survey getSurveyByID(@PathVariable Long id) {
        return adminService.getSurveyByID(id);
    }

    @PostMapping("/surveys")
    public Survey save(@RequestBody Survey survey) {
        return adminService.save(survey);
    }

    @DeleteMapping("/surveys/{id}")
    public void removeById(@PathVariable Long id) {
        adminService.removeById(id);
    }



    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String resolveException(NotFound exception) {
        return exception.getMessage();
    }

}
