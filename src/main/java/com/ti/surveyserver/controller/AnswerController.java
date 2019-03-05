package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.service.SurveyAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class AnswerController {

    @Autowired
    private SurveyAnswerService surveyAnswerService;

    @PostMapping(value = "/saveAnswers")
    public SurveyAnswer saveSurveyAnswers(@RequestBody SurveyAnswer surveyAnswer){
        return surveyAnswerService.saveSurveyAnswer(surveyAnswer);

    }


}
