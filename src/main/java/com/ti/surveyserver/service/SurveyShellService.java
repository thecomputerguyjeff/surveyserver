package com.ti.surveyserver.service;

import com.ti.surveyserver.model.shell.SurveyShell;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyShellService {
    @Autowired
    private MongoDbSurveyShellsRepository mongoDbSurveyShellsRepository;

    public SurveyShell saveSurveyShell(SurveyShell surveyShell) {
       return mongoDbSurveyShellsRepository.save(surveyShell);

    }

    public SurveyShell getSurveyShell(String shellId) {
        return mongoDbSurveyShellsRepository.findOneById(shellId);
    }
}
