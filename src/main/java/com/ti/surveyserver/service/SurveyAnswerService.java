package com.ti.surveyserver.service;

import com.ti.surveyserver.model.Answer;
import com.ti.surveyserver.repository.MongoDbSurveyAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyAnswerService {
    @Autowired
    private MongoDbSurveyAnswersRepository mongoDbSurveyAnswersRepository;

    public Answer saveAnswers(Answer answer){
        return mongoDbSurveyAnswersRepository.save(answer);
    }
}
