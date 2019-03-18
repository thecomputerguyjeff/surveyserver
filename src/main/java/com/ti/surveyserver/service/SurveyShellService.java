package com.ti.surveyserver.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ti.surveyserver.model.shell.SurveyShell;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public List<SurveyShell> getSurveyShellByTitle (String surveyShellTitle){
        return mongoDbSurveyShellsRepository.findAllByTitle(surveyShellTitle);
    }
    public List<SurveyShell> getSurveyShellByAuthor (String surveyShellAuthor){
        return mongoDbSurveyShellsRepository.findAllByAuthor(surveyShellAuthor);
    }

    public SurveyShell updateSurveyShell(SurveyShell surveyShell) {
        return mongoDbSurveyShellsRepository.updateShell(surveyShell);
    }
}
