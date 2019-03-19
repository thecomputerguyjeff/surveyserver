package com.ti.surveyserver.service;

import com.ti.surveyserver.model.answers.Answer;
import com.ti.surveyserver.model.answers.CompiledSurvey;
import com.ti.surveyserver.model.answers.CompiledSurveyQuestion;
import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.model.shell.Question;
import com.ti.surveyserver.repository.MongoDbSurveyAnswersRepository;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyCompilingService {
    @Autowired
    private MongoDbSurveyShellsRepository mongoDbSurveyShellsRepository;
    @Autowired
    private MongoDbSurveyAnswersRepository mongoDbSurveyAnswersRepository;

    public void placeQuestionsInCompiledSurvey(CompiledSurvey compiledSurvey, String shellId) {
        //get all questions from survey and place in compiled survey
        List<Question> surveyQuestions = mongoDbSurveyShellsRepository.findOneById(shellId).getQuestionList();
        for (Question question :
                surveyQuestions
        ) {
            CompiledSurveyQuestion compiledSurveyQuestion = new CompiledSurveyQuestion();
            compiledSurveyQuestion.setQuestion(question.getQuestion());
            compiledSurvey.getQuestions().add(compiledSurveyQuestion);
        }
    }

    public void sortAnswersIntoQuestions(CompiledSurvey compiledSurvey, String shellId) {
        List<SurveyAnswer> surveyResponses = mongoDbSurveyAnswersRepository.findAllByShellId(shellId);

        for (SurveyAnswer response :
                surveyResponses) {
            List<Answer> userAnswers = response.getUserAnswers();
            for (Answer answer :
                    userAnswers) {
                Integer questionId = answer.getQuestionId();
                CompiledSurveyQuestion compiledSurveyQuestionSample = compiledSurvey.getQuestions().get(questionId-1);
                compiledSurveyQuestionSample.getAllAnswers().add(answer.getAnswer()); //add answer to list of answers for that question
            }

        }
    }

}