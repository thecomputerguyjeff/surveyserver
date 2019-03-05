package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.model.shell.SurveyShell;
import com.ti.surveyserver.service.SurveyAnswerService;
import com.ti.surveyserver.service.SurveyShellService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api")

public class SurveyController {

    @Autowired
    private SurveyShellService surveyShellService;

    @Autowired
    private SurveyAnswerService surveyAnswerService;

    @PostMapping(value = "/saveShell")
    public SurveyShell saveSurveyShell(@RequestBody SurveyShell surveyShell){
        return surveyShellService.saveSurveyShell(surveyShell);

    }

    @GetMapping(value = "/retrieveShell/{shellIDToGet}")
    public SurveyShell retrieveSurveyShell(@PathVariable BigInteger shellIDToGet){

        return surveyShellService.retrieveSurveyShell(shellIDToGet);

    }

    @PostMapping(value = "/saveAnswers")
    public SurveyAnswer saveSurveyAnswer(@RequestBody SurveyAnswer surveyAnswer){
        return surveyAnswerService.saveAnswer(surveyAnswer);
    }

    @GetMapping(value = "retrieveAnswers/{IDToGet}")
    public SurveyAnswer retrieveAnswers(@PathVariable ObjectId IDToGet){

        return surveyAnswerService.retrieveAnswerShell(IDToGet);
    }
}
