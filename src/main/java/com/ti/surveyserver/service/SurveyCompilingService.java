package com.ti.surveyserver.service;

import com.ti.surveyserver.model.answers.CompiledSurvey;
import com.ti.surveyserver.model.answers.CompiledSurveyQuestion;
import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.repository.MongoDbSurveyAnswersRepository;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyCompilingService {
    @Autowired
    private MongoDbSurveyShellsRepository mongoDbSurveyShellsRepository;
    @Autowired
    private MongoDbSurveyAnswersRepository mongoDbSurveyAnswersRepository;

    public List<CompiledSurveyQuestion> getCompiledSurveyQuestions(String shellId) {
        return mongoDbSurveyShellsRepository.findOneById(shellId).getQuestionList().stream()
                .map(q -> CompiledSurveyQuestion.builder().question(q.getQuestion()).questionType(q.getResponseType()).potentialAnswers(q.getResponseChoices()).build())
                .collect(Collectors.toList());
    }

    public CompiledSurvey sortAnswersIntoQuestions(CompiledSurvey compiledSurvey, String shellId) {
        List<SurveyAnswer> surveyResponses = mongoDbSurveyAnswersRepository.findAllByShellId(shellId);

        for(int i = 0; i < compiledSurvey.getQuestions().size(); i++) {
            List<String> answersToQuestion = new ArrayList<>();
            for (SurveyAnswer answer : surveyResponses) {
                answersToQuestion.add(answer.getUserAnswers().get(i));
            }
            compiledSurvey.getQuestions().get(i).setAllAnswers(answersToQuestion);
        }
        return  compiledSurvey;
    }
}