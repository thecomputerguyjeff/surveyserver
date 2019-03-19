package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.service.SurveyAnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnswerControllerTest {

    @Mock
    private SurveyAnswerService surveyAnswerService;

    @InjectMocks
    private AnswerController answerController;

    @Test
    public void test() {
        when(surveyAnswerService.saveSurveyAnswer(any())).thenReturn(SurveyAnswer.builder().build());
        assertThat(answerController.saveSurveyAnswers(null)).isEqualTo(SurveyAnswer.builder().build());
    }

}