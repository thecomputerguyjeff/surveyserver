package com.ti.surveyserver.service;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.repository.MongoDbSurveyAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyAnswerService {
    @Autowired
    private MongoDbSurveyAnswersRepository mongoDbSurveyAnswersRepository;

    public SurveyAnswer saveSurveyAnswer(SurveyAnswer surveyAnswer) {
       return mongoDbSurveyAnswersRepository.save(surveyAnswer);

    }
}