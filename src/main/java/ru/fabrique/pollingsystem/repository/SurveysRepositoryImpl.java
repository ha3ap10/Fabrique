package ru.fabrique.pollingsystem.repository;

import org.springframework.stereotype.Repository;
import ru.fabrique.pollingsystem.model.Survey;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SurveysRepositoryImpl implements SurveysRepository {

    private final Map<Long, Survey> surveyRepository = new ConcurrentHashMap<>();

    @Override
    public List<Survey> getSurveys() {
        return new ArrayList<>(surveyRepository.values());
    }

    @Override
    public Optional<Survey> getSurveyById(Long id) {
        return Optional.ofNullable(surveyRepository.get(id));
    }

    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.put(survey.getId(), survey);
    }

    @Override
    public void removeSurveyById(Long id) {
        surveyRepository.remove(id);
    }
}
