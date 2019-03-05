package com.ti.surveyserver.service;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.repository.MongoDBSurveyAnswersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SurveyAnswerService {

    @Autowired
    private MongoDBSurveyAnswersRepository mongoDBSurveyAnswersRepository;

    public SurveyAnswer saveAnswer(SurveyAnswer surveyAnswer){
        return mongoDBSurveyAnswersRepository.save(surveyAnswer);
    }

    public SurveyAnswer retrieveAnswerShell(ObjectId idToGet){
        return mongoDBSurveyAnswersRepository.findOneById(idToGet);
    }
}




