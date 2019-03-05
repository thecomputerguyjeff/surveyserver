package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.model.shell.SurveyShell;
import com.ti.surveyserver.service.SurveyAnswerService;
import com.ti.surveyserver.service.SurveyShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api")

public class SurveyController {

    @Autowired
    private SurveyShellService surveyShellService;

    //shellId is in hex
    @GetMapping(value="/getShell/{shellId}")
    public SurveyShell getSurveyShellString(@PathVariable("shellId") String shellId){

        System.out.println(shellId);
        return surveyShellService.getSurveyShell(shellId);
    }

//  To use Integer, need to remove the e+ and change to a BigInteger
//    @GetMapping(value="/getShellIntString/{shellId}")
//    public SurveyShell getSurveyShelIntString(@PathVariable("shellId") String shellIdinInt){
//
//        BigInteger shellId = new BigInteger(shellIdinInt,10);
//        System.out.println(shellId);
//        return surveyShellService.getSurveyShell(shellId);
//    }

    @PostMapping(value = "/saveShell")
    public SurveyShell saveSurveyShell(@RequestBody SurveyShell surveyShell){
        SurveyShell theRet = surveyShellService.saveSurveyShell(surveyShell);
        return theRet;

    }

    @Autowired
    private SurveyAnswerService surveyAnswerService;

    @PostMapping(value = "/saveAnswers")
    public SurveyAnswer saveSurveyAnswers(@RequestBody SurveyAnswer surveyAnswer){
        return surveyAnswerService.saveSurveyAnswer(surveyAnswer);

    }
}
