package com.ti.surveyserver.controller;

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

    @Autowired
    private SurveyAnswerService surveyAnswerService;

    //shellId is in hex
    @GetMapping(value="/getShell/{shellId}")
    public SurveyShell getSurveyShellString(@PathVariable("shellId") String shellId){
        return surveyShellService.getSurveyShell(shellId);
    }

    //This thing should return a list of SurveyShells
    @GetMapping(value = "/getShellByTitle/{surveyShellTitle}")
    public SurveyShell getSurveyShell(@PathVariable String surveyShellTitle){
        return surveyShellService.getSurveyShellByTitle(surveyShellTitle);
    }

    @PostMapping(value = "/saveShell")
    public SurveyShell saveSurveyShell(@RequestBody SurveyShell surveyShell){
        return surveyShellService.saveSurveyShell(surveyShell);
    }



}
