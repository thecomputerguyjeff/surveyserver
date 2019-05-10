package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.answers.CompiledSurvey;
import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.service.SurveyAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class AnswerController {

    @Autowired
    private SurveyAnswerService surveyAnswerService;

    @PostMapping(value = "/saveAnswers")
    public SurveyAnswer saveSurveyAnswers(@RequestBody SurveyAnswer surveyAnswer){
        return surveyAnswerService.saveSurveyAnswer(surveyAnswer);

    }
    @GetMapping(value = "/getAnswers/{shellId}")
    public CompiledSurvey getCompiledAnswers(@PathVariable String shellId) {
        return surveyAnswerService.compileSurveyAnswers(shellId);
    }
}