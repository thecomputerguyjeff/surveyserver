package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.Answer;
import com.ti.surveyserver.model.SurveyShell;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import com.ti.surveyserver.service.SurveyAnswerService;
import com.ti.surveyserver.service.SurveyShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api")

public class AnswerController {

    @Autowired
    private SurveyAnswerService surveyAnswerService;

    @PostMapping(value = "/saveAnswers")
    public Answer saveAnswers(@RequestBody Answer Answers){

        return surveyAnswerService.saveAnswers(Answers);
    }



}
