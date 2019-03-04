package com.ti.surveyserver.service;

import com.ti.surveyserver.model.SurveyShell;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SurveyShellService {
    @Autowired
    private MongoDbSurveyShellsRepository mongoDbSurveyShellsRepository;

    public SurveyShell saveSurveyShell(SurveyShell surveyShell) {
       return mongoDbSurveyShellsRepository.save(surveyShell);

    }

    public SurveyShell getSurveyShell (String surveyShellTitle){
        return mongoDbSurveyShellsRepository.findOneByTitle(surveyShellTitle);
    }
}
