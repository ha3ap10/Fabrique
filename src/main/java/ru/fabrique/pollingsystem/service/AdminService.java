package ru.fabrique.pollingsystem.service;

import org.springframework.stereotype.Service;
import ru.fabrique.pollingsystem.exceptions.NotFound;
import ru.fabrique.pollingsystem.model.Survey;
import ru.fabrique.pollingsystem.repository.SurveysRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private SurveysRepository surveysRepository;

    public AdminService(SurveysRepository surveysRepository) {
        this.surveysRepository = surveysRepository;
    }

    public List<Survey> getSurveys() {
        return surveysRepository.getSurveys()
                .stream()
                .filter(survey -> !survey.isRemoved())
                .collect(Collectors.toList());
    }

    public Survey getSurveyByID(Long id) {
        return surveysRepository.getSurveyById(id)
                .filter(survey -> !survey.isRemoved())
                .orElseThrow(NotFound::new);
    }

    public void removeById(Long id) {
        final var surveyOpt = surveysRepository.getSurveyById(id);
        if (id != 0 && surveyOpt.isPresent()) {
            getSurveyByID(id).setRemoved(true);
        }
    }

    public Survey save(Survey survey) {
        final var id = survey.getId();
        final var surveyOpt = surveysRepository.getSurveyById(id);
        if (surveyOpt.isEmpty()) {
            surveysRepository.saveSurvey(survey);
            return survey;
        } else {
            final var newSurvey = new Survey(survey.getId(),
                    survey.getName(),
                    surveyOpt.get().getDateStart(),
                    survey.getDateEnd(),
                    survey.getDescription(),
                    survey.getQuestions());
            surveysRepository.saveSurvey(newSurvey);
            return surveyOpt.get();
        }
    }
}
