package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.shell.SurveyShell;
import com.ti.surveyserver.service.SurveyAnswerService;
import com.ti.surveyserver.service.SurveyShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")

public class SurveyController {

    @Autowired
    private SurveyShellService surveyShellService;



    //shellId is in hex
    @GetMapping(value="/getShell/{shellId}")
    public SurveyShell getSurveyShellString(@PathVariable("shellId") String shellId){
        return surveyShellService.getSurveyShell(shellId);
    }

    //This thing should return a list of SurveyShells
    @GetMapping(value = "/getShellByTitle/{surveyShellTitle}")
    public List<SurveyShell> getSurveyShell(@PathVariable String surveyShellTitle){
        return surveyShellService.getSurveyShellByTitle(surveyShellTitle);
    }

    @GetMapping(value = "/getShellByAuthor/{surveyShellAuthor}")
    public List<SurveyShell> getSurveyShellByAuthor(@PathVariable String surveyShellAuthor){
        return surveyShellService.getSurveyShellByAuthor(surveyShellAuthor);
    }

    @PostMapping(value = "/saveShell")
    public SurveyShell saveSurveyShell(@RequestBody SurveyShell surveyShell){
        return surveyShellService.saveSurveyShell(surveyShell);
    }

    @PostMapping(value = "/updateShell")
    public SurveyShell updateSurveyShell(@RequestBody SurveyShell surveyShell){
        return surveyShellService.updateSurveyShell(surveyShell);
    }
}