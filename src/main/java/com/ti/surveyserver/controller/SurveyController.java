package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.SurveyShell;
import com.ti.surveyserver.service.SurveyShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class SurveyController {

    @Autowired
    private SurveyShellService surveyShellService;

    @PostMapping(value = "/saveShell")
    public SurveyShell saveSurveyShell(@RequestBody SurveyShell surveyShell){
        return surveyShellService.saveSurveyShell(surveyShell);

    }
}
