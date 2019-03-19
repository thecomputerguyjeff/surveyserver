package com.ti.surveyserver.controller;

import com.ti.surveyserver.model.answers.SurveyAnswer;
import com.ti.surveyserver.service.SurveyAnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AnswerControllerTest {

    //Fake Survey Answer Service
    @Mock
    private SurveyAnswerService surveyAnswerService;

    //Where you put the fake stuff into. This is real.
    @InjectMocks
    private AnswerController answerController;

    @Test
    public void test() {
        when(surveyAnswerService.saveSurveyAnswer(any())).thenReturn(SurveyAnswer.builder().build());

        //Remember, don't use object
        SurveyAnswer actual = answerController.saveSurveyAnswers(null);
        SurveyAnswer expected = SurveyAnswer.builder().build();

        assertThat(actual).isEqualTo(expected);
        assertEquals(expected, actual);
        assertEquals("Some cool message if it fails(See if you can figure out a message in the assertThat example :)", expected, actual);
        assertTrue(expected.equals(actual));
        //see what other options there is with assertThat
        assertThat(actual).hasFieldOrProperty("shellId");
        assertThat(actual).isInstanceOf(SurveyAnswer.class);
        assertNull(null);
        assertFalse(!true);

        verify(surveyAnswerService, times(1)).saveSurveyAnswer(any());
        verifyNoMoreInteractions();

//        SurveyAnswerService mockSAS = mock(SurveyAnswerService.class);
//        ReflectionTestUtils.setField(answerController, "surveyAnswerService", mockSAS);

    }
}