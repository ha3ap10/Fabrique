package ru.fabrique.pollingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.fabrique.pollingsystem.model.Survey;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveysRepository {

    List<Survey> getSurveys();
    Optional<Survey> getSurveyById(Long id);
    Survey saveSurvey(Survey survey);
    void removeSurveyById(Long id);
}
