package com.ti.surveyserver.model;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class SurveyController {
    @PostMapping(value = "/saveShell")
    public Boolean saveSurveyShell(@RequestBody SurveyShell surveyShell){
        return false;
    }
}
