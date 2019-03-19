package com.ti.surveyserver.service;

import com.ti.surveyserver.repository.MongoDbSurveyAnswersRepository;
import com.ti.surveyserver.repository.MongoDbSurveyShellsRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SurveyCompilingServiceTest {

    @Mock
    private MongoDbSurveyAnswersRepository mongoDbSurveyAnswersRepository;

    @Mock
    private MongoDbSurveyShellsRepository mongoDbSurveyShellsRepository;

    @InjectMocks
    private SurveyCompilingService surveyCompilingService;

    public void placeQuestionsWillPlaceInQuestions() {
//        Answer sampleAns = Answer.builder().questionId(1).answer("sample 1").build();
//        SurveyAnswer surveyAnswerSample = SurveyAnswer.builder().userAnswers(Arrays.asList(sampleAns)).build();
//        when(mongoDbSurveyAnswersRepository.findAllById("1111")).thenReturn(Arrays.asList(surveyAnswerSample));

//        when(mongoDbSurveyAnswersRepository.findAllById("1111")).thenReturn(Arrays.asList(surveyAnswerSample));
//        surveyCompilingService.placeQuestionsInCompiledSurvey();
    }
}