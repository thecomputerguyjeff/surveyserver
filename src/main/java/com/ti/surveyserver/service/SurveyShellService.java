package com.ti.surveyserver.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ti.surveyserver.model.shell.SurveyShell;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ti.surveyserver.service.SurveyShellHelperService;

import java.util.List;


@Service
public class SurveyShellService {
    @Autowired
    private MongoDbSurveyShellsRepository mongoDbSurveyShellsRepository;

    @Autowired
    private SurveyShellHelperService helper;

    public SurveyShell saveSurveyShell(SurveyShell surveyShell) {
        return mongoDbSurveyShellsRepository.save(surveyShell);
    }

    public SurveyShell getSurveyShell(String shellId) {
        return mongoDbSurveyShellsRepository.findOneById(shellId);
    }


    public List<SurveyShell> getSurveyShellByTitle (String surveyShellTitle){
        List<SurveyShell> listOfShells= mongoDbSurveyShellsRepository.findAllByTitle(surveyShellTitle);//this finds all of the matches and sorts them
        return helper.pullOutMatches(listOfShells,surveyShellTitle);//this pulls out the exact ones and then adds the other ones after
    }

    public List<SurveyShell> getSurveyShellByAuthor (String surveyShellAuthor){
        return mongoDbSurveyShellsRepository.findAllByAuthor(surveyShellAuthor);
    }
}
