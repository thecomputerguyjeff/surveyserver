package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.SurveyShell;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import com.ti.surveyserver.service.SurveyShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api")

public class SurveyController {

    @Autowired
    private SurveyShellService surveyShellService;

    //@Autowired
   // private MongoDbSurveyShellsRepository mongoDbSurveyShellsRepository;

    @PostMapping(value = "/saveShell")
    public SurveyShell saveSurveyShell(@RequestBody SurveyShell surveyShell){
        return surveyShellService.saveSurveyShell(surveyShell);

    }

    @GetMapping(value = "/getShell/{surveyShellTitle}")
    public SurveyShell getSurveyShell(@PathVariable String surveyShellTitle){
        //SurveyShell surveyShell=mongoDbSurveyShellsRepository.findOneByTitle(surveyShellTitle);
        return surveyShellService.getSurveyShell(surveyShellTitle);
    }
}
